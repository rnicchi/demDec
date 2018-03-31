package it.almavivaitalia.bsn.sh.tagparser.text.html;

import it.almavivaitalia.bsn.sh.tagparser.StringTypeDecoder;
import it.almavivaitalia.bsn.sh.tagparser.text.TextTypes;

public class Text2HtmlDecoder extends StringTypeDecoder{

	
	
	
	
	
	public Text2HtmlDecoder() {
		super(new HtmlEscaper());
		addMapping(TextTypes.TYPE_BOLD, HtmlTextTypes.TYPE_BOLD_1);
		addMapping(TextTypes.TYPE_ITALIC, HtmlTextTypes.TYPE_ITALIC);
		addMapping(TextTypes.TYPE_PARAGRAPH, HtmlTextTypes.TYPE_PARAGRAPH_1);
		setNewLineMapping(TextTypes.TYPE_NEW_LINE, HtmlTextTypes.TYPE_NEW_LINE);
}
	

	public static void main(String[] args){
		try {

			//String str = "<b><i>ita&nbsp;lic in&lt;si<br>de bold</i></b>normal<em><strong>bold inside italic</strong></em>normal<b>only bold</b><em>only italic</em>";
			//Per eventuali prove la stringa da trasformare deve presentare i tag interni, ovvero quelli usati 
			//nella memorizzazione sul db
			String str = "1)<bold-tt><em-tt>itali<tag></tag>c inside<nl-tt/>2) bold</em-tt></bold-tt>" +
			"<p-tt>3)normal<em-tt><bold-tt>bold inside italic</bold-tt></em-tt></p-tt>normal<bold-tt>only bold</bold-tt><em-tt>only italic</em-tt>";
			System.out.println(str);
			
			Text2HtmlDecoder dec = new Text2HtmlDecoder();
			
			String standard = dec.decode(str);
			
			System.out.println(standard);
			

		}catch (Throwable th) {
			th.printStackTrace();
		}
	}

}
