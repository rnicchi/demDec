package it.almavivaitalia.web.sh.taglib.displaytable;


import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getFormattedNumber;

import java.math.BigDecimal;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.DisplaytagColumnDecorator;
import org.displaytag.exception.DecoratorException;
import org.displaytag.properties.MediaTypeEnum;
public class IntegerAmountDecorator implements DisplaytagColumnDecorator{

	@Override
	public Object decorate(Object columnValue, PageContext pageContext, MediaTypeEnum media) throws DecoratorException {
		String res=null;
		try {			
			res = getFormattedNumber((BigDecimal)columnValue, 0);			
		}catch (Throwable e) {
			throw new DecoratorException(IntegerAmountDecorator.class, e.getMessage(), e);
		}
		return res;
	}

}
