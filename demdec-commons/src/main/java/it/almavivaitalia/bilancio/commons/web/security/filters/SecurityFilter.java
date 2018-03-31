package it.almavivaitalia.bilancio.commons.web.security.filters;

import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.almavivaitalia.web.sh.utils.ApplicationContextProvider;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PageMessages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;

public class SecurityFilter implements Filter {

	@SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM = 80L;
	@SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM2 = 80L;
	@SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM3 = 80L;
	@SuppressWarnings("unused")
	private static final long serialVersionUIDLOCM4 = 80L;
	/* end LOCM */

	private ArrayList<String> urlList;
	private int totalURLS;
	private ResourceBundleMessageSource messageSource;

	/**
	 * @see javax.servlet.Filter#void ()
	 */
	public void destroy() {
	}

	/**
	 * @see javax.servlet.Filter#void (javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws ServletException, IOException {

		// prendiamo la sessione utente, se esiste

		boolean allowedRequest = false;
		String url = ((HttpServletRequest) req).getServletPath();
		for (int i = 0; i < totalURLS; i++) {
			if (url.contains(urlList.get(i))) {
				allowedRequest = true;
				break;
			}
		}
		if (!allowedRequest) {
			// se non esiste la sessione l'utente non è loggato
			HttpSession session = ((HttpServletRequest) req).getSession(false);
			if (session == null || session.isNew()) {
				System.err.println("Non esiste una sessione valida");
				TraceLogger.debugLog("Non esiste una sessione valida", SecurityFilter.class);
				addError((HttpServletRequest) req, "error.invalidSession");
				((HttpServletResponse) resp)
						.sendRedirect(((HttpServletRequest) req)
								.getContextPath()
								+ CommonConstantsRequestMapping.PUBLIC_ERROR_URL);
				// req.getRequestDispatcher(ConstantsRequestMapping.PUBLIC_ERROR_URL).forward(req,
				// resp);
				return;

			} else {
				// prendiamo l'utente in sessione
				UtenteTO utente = (UtenteTO) session
						.getAttribute(CommonSessionAttributes.OBJECT_USER);
				// se l'utente non è in sessione allora non è passato per la
				// home page del SIE
				if (utente == null) {
					System.err.println("Non esiste una sessione valida per l'utente");
					TraceLogger.debugLog("Non esiste una sessione valida per l'utente", SecurityFilter.class);					
					addError((HttpServletRequest) req, "error.invalidSession");
					((HttpServletResponse) resp)
							.sendRedirect(((HttpServletRequest) req)
									.getContextPath()
									+ CommonConstantsRequestMapping.PUBLIC_ERROR_URL);
					// req.getRequestDispatcher(ConstantsRequestMapping.PUBLIC_ERROR_URL).forward(req,
					// resp);
					return;

				}
				// logger.debug("UtenteBO loggato o public url");
				// se è abilitato, proseguiamo
			}
		}
		chain.doFilter(req, resp);
		return;

	}

	/**
	 * Method init.
	 * 
	 * @param config
	 * @throws javax.servlet.ServletException
	 */

	public void init(FilterConfig config) throws ServletException {
		String urls = config.getInitParameter("avoid-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		urlList = new ArrayList<String>();
		while (token.hasMoreTokens()) {
			urlList.add(token.nextToken());
		}
		totalURLS = urlList.size();
		
		
		try
		{	
			String messageSourceBeanName = config.getInitParameter("messSource");
			ApplicationContext applicationContext =ApplicationContextProvider.getApplicationContext();
			
			if(applicationContext==null)
			{
				String mes="" +
						"SecurityFilter.class: Impossibile reperire un'istanza di ApplicationContext.\n" +
						"Verificare che il contesto di Spring abbia definito un bean istanza della classe\n it.almavivaitalia.web.sh.utils.ApplicationContextProvider.\n"+
						"Eventualmente, in un opportuno file di contesto Spring, crearne uno come di seguito:\n" +
						"<bean id=\"applicationContextProvider\" class=\"it.almavivaitalia.web.sh.utils.ApplicationContextProvider\"/>";
				System.err.println(mes);
				TraceLogger.debugLog(mes, SecurityFilter.class);
			}
			else if (	messageSourceBeanName == null || 
						messageSourceBeanName.trim().length() == 0
					)
			{
				String mes="SecurityFilter.class: messageSourceBeanName non valorizzabile.\n" +
							"Verificare che nel file web.xml sia correttamente valorizzata la proprieta' 'messSource' del bean relativo alla classe SecurityFilter. " +
							"Nel dettaglio il valore di 'messSource' deve essere il nome del bean (definito in un opportuno file di contesto Spring) " +
							"istanza della classe\n it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource";
				System.err.println(mes);
				TraceLogger.debugLog(mes, SecurityFilter.class);
			}	
			else
			{
				this.messageSource=(ResourceBundleMessageSource)applicationContext.getBean(messageSourceBeanName);				
			}
		}
		catch (Exception e)
		{
			String mes="SecurityFilter.class: Impossibile inizializzare la proprieta' messageSource.\n" +
					"Probabili cause:" +
					"1) Nel file web.xml, mancata valorizzazione della proprieta' 'messSource' del bean relativo alla classe SecurityFilter.\n" +
					"   Nel dettaglio il valore di 'messSource' deve essere il nome del bean (definito in un opportuno file di contesto\n" +
					"   Spring) istanza della classe it.almavivaitalia.bsn.sh.utils.ResourceBundleMessageSource;\n" +
					"2) In uno dei file di contesto di Spring, mancata creazione di un bean istanza della classe\n" +
					"   it.almavivaitalia.web.sh.utils.ApplicationContextProvider.\n" +
					"   Eventualmente crearne uno come di seguito:\n" +
					"   <bean id=\"applicationContextProvider\" class=\"it.almavivaitalia.web.sh.utils.ApplicationContextProvider\"/>";					;
			
			System.err.println(mes);
			TraceLogger.debugLog(mes, SecurityFilter.class);
		}
	}

	private void addError(HttpServletRequest req, String errorCode){
	   	
		if (ContextHelper.getPageMessages(req)==null)
	   	{
			ContextHelper.setSessionModel(ContextHelper.OBJECT_PAGE_MESSAGES, new PageMessages(messageSource),req);
	   	}
	   	ContextHelper.addError(req, errorCode);
	}	

}
