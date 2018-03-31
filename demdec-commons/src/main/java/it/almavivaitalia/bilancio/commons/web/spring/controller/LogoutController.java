package it.almavivaitalia.bilancio.commons.web.spring.controller;




import static it.almavivaitalia.bsn.sh.utils.StringUtil.isEmpty;
import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.almavivaitalia.web.sh.utils.PageMessages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value=CommonConstantsRequestMapping.LOGOUT_URL)

public class LogoutController extends  AbstractCommonFormAdminController{


	@Override
	public String startController(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable {
		String view = null;
		HttpSession session = request.getSession(false);
		PageMessages pageMessages = new PageMessages(getMessageSource());
		ContextHelper.setRequestModel(OBJECT_PAGE_MESSAGES, pageMessages,request);
		ContextHelper.addInfo(request,"info.logout.success");
		//String appCodeSrc=(String)session.getAttribute(CommonSessionAttributes.APPLICATION_CODE_SRC);
		String appCode=request.getParameter(CommonSessionAttributes.APPLICATION_CODE);
		
		//appCodeSrc è valorizzata quando l'applicazione viene invocata da un'altra applicazione
		//se in request è presente appCode significa che l'utente ha cliccato sulle briciole di pane dell'app chiamante
		//sbfj per sempio
		//sbfj  >  FORMAZIONE
		
		//se in request NON è presente appCode significa che l'utente ha cliccato sul link LOGOUT
		
		if(!isEmpty(session) && isEmpty(appCode)){						
			request.getSession().invalidate();
			view= 	REDIRECT + 
					LOGAOUT_OAM_URL;
		}else if(!isEmpty(session) && !isEmpty(appCode)){						
			//RICHIAMO REDIRECT CONTROLLER
			view= 	REDIRECT + 
					REDIRECT_URL;

			//PARAMETRI
			view+=CommonSessionAttributes.P_INTERROGATIVO;
			
			//METODO
			view+=
					COMMAND_BUTTON_PREFIX_GET+
					CommonSessionAttributes.RETURN_METHOD_NAME_OF_REDIRECT_CONTROLLER;
			
			if(!isEmpty(appCode)){
				view+=
						CommonSessionAttributes.E_COMMERCIALE+
						CommonSessionAttributes.APPLICATION_CODE+
						CommonSessionAttributes.UGUALE+
						appCode;
			}		
			
		} else{
			view= 	REDIRECT + 
					LOGAOUT_OAM_URL;
		}
		
		return view;
	}
	@Override
	protected boolean checkEnabled(HttpServletRequest request) throws Throwable {
		return true;
	}
}


	
	