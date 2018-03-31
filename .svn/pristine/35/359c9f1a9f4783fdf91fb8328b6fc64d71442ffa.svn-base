package it.almavivaitalia.bsn.sh.tagparser.text.html;

import it.almavivaitalia.bsn.sh.tagparser.StringTypeDecoder;
import it.almavivaitalia.bsn.sh.tagparser.text.TextTypes;

public class Html2TextDecoder extends StringTypeDecoder{

	
	
	
	
	
	public Html2TextDecoder() {
		super(new HtmlUnescaper());
		addMapping(HtmlTextTypes.TYPE_BOLD, TextTypes.TYPE_BOLD);
		addMapping(HtmlTextTypes.TYPE_BOLD_1, TextTypes.TYPE_BOLD);
		addMapping(HtmlTextTypes.TYPE_ITALIC, TextTypes.TYPE_ITALIC);
		addMapping(HtmlTextTypes.TYPE_ITALIC_1, TextTypes.TYPE_ITALIC);
		addMapping(HtmlTextTypes.TYPE_PARAGRAPH, TextTypes.TYPE_PARAGRAPH);
		setNewLineMapping(HtmlTextTypes.TYPE_NEW_LINE, TextTypes.TYPE_NEW_LINE);
	}
	

	public static void main(String[] args){
		try {

			String str = "<b><i>ita&nbsp;lic in&lt;si<br>de bold</i></b>normal<em><strong>bold inside italic</strong></em>normal<b>only bold</b><em>only italic</em>";
			//String str = "1)<bold-tt><em-tt>italic inside<nl-tt/>2) bold</em-tt></bold-tt>" +
			//	"<p-tt>3)normal<em-tt><bold-tt>bold inside italic</bold-tt></em-tt></p-tt>normal<bold-tt>only bold</bold-tt><em-tt>only italic</em-tt>";
			System.out.println(str);
			
			Html2TextDecoder dec = new Html2TextDecoder();
			
			String standard = dec.decode(str);
			
			System.out.println(standard);
			

		}catch (Throwable th) {
			th.printStackTrace();
		}
	}

}
