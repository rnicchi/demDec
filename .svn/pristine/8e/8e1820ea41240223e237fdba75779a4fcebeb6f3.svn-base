package it.almavivaitalia.bsn.sh.tagparser.text.pdf;

import it.almavivaitalia.bsn.sh.tagparser.Element;
import it.almavivaitalia.bsn.sh.tagparser.Parser;
import it.almavivaitalia.bsn.sh.tagparser.Type;
import it.almavivaitalia.bsn.sh.tagparser.Types;
import it.almavivaitalia.bsn.sh.tagparser.text.TextTypes;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

public class PdfTextualUtility implements PDFConstants{

	
	
	private Font baseFont;
	private Font italicBold;
	private Font bold;
	private Font italic;
	private String text;
	private static Parser parser;
	
	/*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM2 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM3 = 2L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM4 = 0L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM5 = 1L;
	@SuppressWarnings("unused") private static final long serialVersionLOCM6 = 2L;
	/*END LOCM*/
	
	static {
		parser = new Parser(TextTypes.TYPE_NEW_LINE);
		//aggiuungere tutti i tag che si vogliono trattare,
		//escluso quello per l'accapo
		parser.addType(TextTypes.TYPE_BOLD);
		parser.addType(TextTypes.TYPE_ITALIC);
		parser.addType(TextTypes.TYPE_PARAGRAPH);
		
		
	}
	
	
	
	public PdfTextualUtility(String text, Font baseFont) {
		super();
		this.text = text;
		
		this.baseFont = baseFont;
		bold=FontFactory.getFont(baseFont.getFamilyname(), baseFont.getSize(), Font.BOLD, baseFont.getColor());
		italicBold=FontFactory.getFont(baseFont.getFamilyname(), baseFont.getSize(), Font.BOLDITALIC, baseFont.getColor());
		italic=FontFactory.getFont(baseFont.getFamilyname(), baseFont.getSize(), Font.ITALIC, baseFont.getColor());
	}
	
	//private static Font decodeFont(Type type, Type mainType, Font mainFont){
	private Font decodeFont(Type type, Type mainType, Font mainFont){
		if (type.equals(TextTypes.TYPE_BOLD)){
			if (mainType.equals(TextTypes.TYPE_ITALIC)){
				return italicBold;
			}else {
				return bold;
			}
		}else if (type.equals(TextTypes.TYPE_ITALIC)){
			if (mainType.equals(TextTypes.TYPE_BOLD)){
				return italicBold;
			}else {
				return italic;
			}
		}else{
			return mainFont;
		}
	}
	
	private Phrase create(Element element, Type mainType, Font mainFont){
		Phrase el=null;
		Type type =element.getType();
		Font font = decodeFont(type, mainType, mainFont);
		
		if (type.equals(TextTypes.TYPE_NEW_LINE)){
			el = new Phrase("\n", font);
		}else {
			if (element.size()==0){
					el = new Phrase(element.getText(),
							 font);
			}else {
				el = new Phrase("", font);
				if (type.equals(TextTypes.TYPE_PARAGRAPH)){
					el.add(new Phrase("\n\n", font));
				}
				for(int i=0; i<element.size();i++){
					el.add(create(element.getElementAt(i), type, font));
				}
				if (type.equals(TextTypes.TYPE_PARAGRAPH)){
					el.add(new Phrase("\n\n", font));
				}
			}
		}
		return el;
	}
	
	public Phrase decode() throws Throwable{
		Element element = parser.parse(text);
		return create(element, Types.TYPE_NONE, baseFont );
	}
	
	
	
	
	
	public static void main(String[] args){
		try {
			
			
			
			//String str = "<+bold><+italic>italic <+nl>inside bold<-italic><-bold>normal<+italic><+bold>bold inside italic<-bold><-italic>normal<+bold>only bold<-bold><+italic>only italic<-italic>";
			
			//String str = "AA<+bold> BB <+italic> CC <-italic> DD <-bold> EE";
			//String str = "a <br> b <BR> c";
			
			String str = "1)<bold-tt><em-tt>italic inside<nl-tt/>2) bold</em-tt></bold-tt>" +
			"<p-tt>3)normal<em-tt><bold-tt>bold inside italic</bold-tt></em-tt></p-tt>normal<bold-tt>only bold</bold-tt><em-tt>only italic</em-tt>";
			
			System.out.println(str);
			
			
			
		
			
			
	      	Document document = new Document(PageSize.A4.rotate(), 60, 60, 40, 40);
	      	FileOutputStream file = new FileOutputStream("C:\\prova.pdf");
	    

	      	PdfWriter.getInstance(document, file);
	      	
	      	document.open();
	      	
	      	
	      	Paragraph par = new Paragraph ("");
	      	par.setIndentationLeft(30);

	      	Font baseFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL, new Color(0, 0, 0));
	      	
	      	PdfTextualUtility pdfTxtUtility = new PdfTextualUtility(str, baseFont);
	      	par.add(pdfTxtUtility.decode());
	      	document.add(par);

	      	document.close();
	      	
	      
			

		}catch (Throwable th) {
			th.printStackTrace();
		}
	}
	
}
