package it.almavivaitalia.bsn.sh.tagparser.text.html;

import it.almavivaitalia.bsn.sh.tagparser.StringConverter;

import org.apache.commons.lang.StringEscapeUtils;

public class HtmlUnescaper implements StringConverter{

	@Override
	public String unescape(String str) {
		if (str!=null){
			return StringEscapeUtils.unescapeHtml(str);
		}else {
			return str;
		}
	}

}
