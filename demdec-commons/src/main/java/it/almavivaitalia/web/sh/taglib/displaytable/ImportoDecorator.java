package it.almavivaitalia.web.sh.taglib.displaytable;


import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getNumberFormat;

import java.math.BigDecimal;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
public class ImportoDecorator implements DisplaytagColumnDecorator{

	@Override
	public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
		String res=null;
		try {
			res = getNumberFormat((BigDecimal)columnValue);
		}catch (Throwable e) {
			throw new DecoratorException(ImportoDecorator.class, e.getMessage(), e);
		}
		return res;
	}

}
