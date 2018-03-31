package it.almavivaitalia.bilancio.commons.web.security.filters;

import java.util.Map;

import it.almavivaitalia.bilancio.commons.utils.PropertyConfigurer;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bilancio.commons.web.security.spring.SpringCommonBeanFactory;
import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;
import it.almavivaitalia.bsn.sh.utils.TraceLogger;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedCredentialsNotFoundException;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: tano
 * Date: 27-set-2011
 * Time: 17.55.22
 * To change this template use File | Settings | File Templates.
 */
public class PreAuthenticationFilter extends AbstractPreAuthenticatedProcessingFilter {

    private String principalRequestHeader = CommonWebConstants.OAM_HEADER_NAME;
    private String credentialsRequestHeader;
    private boolean exceptionIfHeaderMissing = true;

    @SuppressWarnings("unused")
	private static final Logger _LOG = Logger.getLogger(PreAuthenticationFilter.class);

    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {

    	SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext != null && securityContext.getAuthentication() != null) {
            return securityContext.getAuthentication().getPrincipal();
        }
    	String username = null;
    	PropertyConfigurer configurer = SpringCommonBeanFactory.getPropertyConfigurer();
    	Map<String, String> valuer = configurer.getResolvedProps();
    	String flagOam = valuer.get("abilita.oam");
    	if (flagOam.equalsIgnoreCase("S")){
            username = request.getHeader(principalRequestHeader);
/*            for (;request.getHeaderNames().hasMoreElements();){
            	Object obj = request.getHeaderNames().nextElement();
            	TraceLogger.infoLog(obj.toString(), PreAuthenticationFilter.class);
            }*/
            if (username == null && exceptionIfHeaderMissing) {
                throw new PreAuthenticatedCredentialsNotFoundException(principalRequestHeader
                        + " non trovato all'interno del request header.");
            }
    	}else {
    		username = request.getParameter(principalRequestHeader);
    	}

/*        username = request.getHeader(principalRequestHeader);
        if (username == null && exceptionIfHeaderMissing) {
            throw new PreAuthenticatedCredentialsNotFoundException(principalRequestHeader
                    + " non trovato all'interno del request header.");
        }
*/       
    	Utente user = new Utente(username);
        return user;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {

        if (credentialsRequestHeader != null) {
            String credentials = request.getHeader(credentialsRequestHeader);

            return credentials;
        }

        return "N/A";
    }

    public void setPrincipalRequestHeader(String principalRequestHeader) {
        Assert.hasText(principalRequestHeader, "principalRequestHeader must not be empty or null");
        this.principalRequestHeader = principalRequestHeader;
    }

    public void setCredentialsRequestHeader(String credentialsRequestHeader) {
        Assert.hasText(credentialsRequestHeader, "credentialsRequestHeader must not be empty or null");
        this.credentialsRequestHeader = credentialsRequestHeader;
    }

    /**
     * Defines whether an exception should be raised if the principal header is missing. Defaults to <tt>true</tt>.
     *
     * @param exceptionIfHeaderMissing set to <tt>false</tt> to override the default behaviour and allow
     *          the request to proceed if no header is found.
     */
    public void setExceptionIfHeaderMissing(boolean exceptionIfHeaderMissing) {
        this.exceptionIfHeaderMissing = exceptionIfHeaderMissing;
    }
}
