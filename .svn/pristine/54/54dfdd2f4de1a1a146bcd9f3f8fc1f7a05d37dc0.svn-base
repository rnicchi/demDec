package it.almavivaitalia.web.sh.spring.controller;

import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.spring.controller.AbstractFormController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
@Controller
public abstract class AbstractFormAdminController extends AbstractFormController{
	
	@Override
	public String startController(Context context) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected String executeActionMethod(String methodName, HttpServletRequest request, HttpServletResponse response, Context context)throws Throwable{

		Method method=null;
		try {
			method=getClass().getMethod(methodName, new Class[]{HttpServletRequest.class,HttpServletResponse.class, Context.class});
		}catch (Exception e) {
			return super.executeActionMethod(methodName,request,response,context);
			//throw new Exception("No method found with name "+methodName);
		}
		String res = null;
		try {
			res = (String)method.invoke(this, new Object[]{request,response,context});
		}catch (InvocationTargetException e) {
			throw(e.getTargetException());
		}	
		
		return res;
	}

	
	public abstract String startController(HttpServletRequest request, HttpServletResponse response, Context context) throws Throwable;
}
