package it.almavivaitalia.bsn.sh.tagparser;

import it.almavivaitalia.bsn.sh.tagparser.text.TextTypes;
import it.almavivaitalia.bsn.sh.tagparser.text.html.HtmlTextTypes;

import java.util.HashMap;
import java.util.Map;

public class StringTypeDecoder {

	
	
	
	private Map<Type , Type> typeMap;
	private StringBuffer sb;
	private Parser parser;
	private Type newLineDestination;
	private StringConverter unescaper;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM7 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM8 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM9 = 2L;
	/*END LOCM*/
	
	public StringTypeDecoder() {
		super();
		this.parser=new Parser(null);
		this.typeMap=new HashMap<Type , Type>();
		
		this.typeMap.put(Types.TYPE_NONE, Types.TYPE_NONE);
	}
	public StringTypeDecoder(StringConverter unescaper) {
		super();
		this.parser=new Parser(null);
		this.typeMap=new HashMap<Type , Type>();
		this.typeMap.put(Types.TYPE_NONE, Types.TYPE_NONE);
		this.unescaper=unescaper;
	}
	
	public void addMapping(Type source, Type destination){
		parser.addType(source);
		typeMap.put(source, destination);
	}
	public void setNewLineMapping(Type newLineSource, Type newLineDestination){
		if ((newLineSource==null) || (newLineDestination==null)){
			throw new RuntimeException("Null type for newLine are not allowed !!");
		}
		this.typeMap.put(newLineSource, newLineDestination);
		parser.setNewLine(newLineSource);
		this.newLineDestination=newLineDestination;
	}
	
	private void write(Element element) throws Throwable{
		Type elementType = element.getType();
		if (elementType.equals(parser.getNewLine())){
			sb.append(newLineDestination.getMarkerStart());
		}else {
			Type type = typeMap.get(elementType);
			if (type==null){
				throw new Exception("type "+element.getType()+" not mapped !!");
			}
			sb.append(type.getMarkerStart());
			if (element.size()==0){
				if (unescaper!=null){
					sb.append(unescaper.unescape(element.getText()));
				}else {
					sb.append(element.getText());
				}
			}else {
				for(int i=0; i<element.size();i++){
					write(element.getElementAt(i));
				}
			}
			sb.append(type.getMarkerStop());
		}
	}
	
	public String decode(String text) throws Throwable{
		Element element = parser.parse(text);
		sb=new StringBuffer();
		write(element);
		return sb.toString();
	}
	
	public static void main(String[] args){
		try {

			//String str = "<b><i>italic insi<br>de bold</i></b>normal<em><strong>bold inside italic</strong></em>normal<b>only bold</b><em>only italic</em>";
			//Per eventuali prove la stringa da trasformare deve presentare i tag interni, ovvero quelli usati 
			//nella memorizzazione sul db
			String str = "1)<bold-tt><em-tt>italic inside<nl-tt/>2) bold</em-tt></bold-tt>" +
				"<p-tt>3)normal<em-tt><bold-tt>bold inside italic</bold-tt></em-tt></p-tt>normal<bold-tt>only bold</bold-tt><em-tt>only italic</em-tt>";
			System.out.println(str);
			
			StringTypeDecoder dec = new StringTypeDecoder();
			/*
			dec.addMapping(HtmlTextTypes.TYPE_BOLD, TextTypes.TYPE_BOLD);
			dec.addMapping(HtmlTextTypes.TYPE_BOLD_1, TextTypes.TYPE_BOLD);
			dec.addMapping(HtmlTextTypes.TYPE_ITALIC, TextTypes.TYPE_ITALIC);
			dec.addMapping(HtmlTextTypes.TYPE_ITALIC_1, TextTypes.TYPE_ITALIC);
			dec.addMapping(HtmlTextTypes.TYPE_PARAGRAPH, TextTypes.TYPE_PARAGRAPH);
			
			dec.setNewLineMapping(HtmlTextTypes.TYPE_NEW_LINE, TextTypes.TYPE_NEW_LINE);
			*/
			
			dec.addMapping(TextTypes.TYPE_BOLD, HtmlTextTypes.TYPE_BOLD);
			dec.addMapping(TextTypes.TYPE_ITALIC, HtmlTextTypes.TYPE_ITALIC);
			dec.addMapping(TextTypes.TYPE_PARAGRAPH, HtmlTextTypes.TYPE_PARAGRAPH);
			
			dec.setNewLineMapping(TextTypes.TYPE_NEW_LINE, HtmlTextTypes.TYPE_NEW_LINE);
			String standard = dec.decode(str);
			
			System.out.println(standard);
			

		}catch (Throwable th) {
			th.printStackTrace();
		}
	}

}
