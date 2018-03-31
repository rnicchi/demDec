package it.almavivaitalia.bilancio.commons.web.spring.controller;

import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;
import it.almavivaitalia.web.sh.utils.Context;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping (value=CommonConstantsRequestMapping.PUBLIC_ERROR_URL)
public class ErrorController extends  AbstractCommonFormController{

	@Override
	public String startController(Context context) throws Throwable {
		return "errorView";
	}
}
