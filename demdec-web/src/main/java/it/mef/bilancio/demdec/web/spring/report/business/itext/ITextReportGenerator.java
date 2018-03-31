package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
//import it.consip.fgen.core.report.business.itext.model.AccessibleDocument;
//import it.consip.pat.common.exceptions.BusinessException;

import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class ITextReportGenerator {
	
	 public static byte[] generateITextReport(AccessibleDocument accessibleDocument) throws Exception   {// throws BusinessException
	        try {
	/*
	Apertura del documento e configurazioni iniziali
	 */
	            Document document = new Document(accessibleDocument.getPageSize());
	            	            
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

	            writer.setTagged();
	            writer.setViewerPreferences(PdfWriter.DisplayDocTitle);
	            writer.createXmpMetadata();
	            writer.getExtraCatalog().put(PdfName.LANG, new PdfString(Locale.ITALY.getLanguage()));

	            document.addTitle(accessibleDocument.getTitle());
	            document.open();

	            /*
	               passiamo alla scrittura(+ tag) dei componenti del documento
	                */
	            PdfContentByte cb = writer.getDirectContent();

	            PdfStructureTreeRoot rootElement = writer.getStructureTreeRoot();
	            PdfStructureElement documentElement = new PdfStructureElement(rootElement, PdfName.DOCUMENT);
	            
	            
	          //  String path = accessibleDocument.getTables().get(0).getCellList().get(0).getAlternativeText();

	          
	         //   float yPos = accessibleDocument.writeHeader(cb, documentElement);
	            accessibleDocument.writeHeader(cb, documentElement);
	            
	            float yPos;
	            
	            //**********INIZIO INSERIMENTO IMMAGINE************
	            
	            String path;
	         //   if(!accessibleDocument.getPathImage().equals(""))
	         //   {
	            	path = accessibleDocument.getPathImage();
	            	
	            	Image logo = null;
					try {
						logo = Image.getInstance(path);
					} catch (BadElementException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 	 	    logo.scalePercent(80); 	 	  
			 	 	    logo.setAbsolutePosition(250, 480);
			 	 	    logo.scaleToFit(400, 100);
			 	
			 	        PdfStructureElement divElement = new PdfStructureElement(documentElement, PdfName.DIV);
			 	        PdfStructureElement spanElement = new PdfStructureElement(divElement, PdfName.SPAN);
			 	        cb.beginMarkedContentSequence(spanElement);
			 	        PdfDictionary dict = new PdfDictionary();
			 	        dict.put(PdfName.ALT, new PdfString("Logo della Ragioneria Generale dello Stato"));
			 	        cb.beginMarkedContentSequence(PdfName.SPAN, dict, true);
			 	        //cb.addTemplate(template, documentMargins.get(ReportITextConstants.LEFT_MARGIN_KEY), documentMargins.get(ReportITextConstants.BOTTOM_MARGIN_KEY));
			 	        cb.addImage(logo);
			 	        cb.endMarkedContentSequence();
			 	        cb.endMarkedContentSequence();	 	    

		          yPos = 480;
	         //   }
		          
		        //**********FINE INSERIMENTO IMMAGINE************
	            
	            yPos = accessibleDocument.writeTable(document, cb, documentElement, yPos);
	            yPos = accessibleDocument.writeNote(cb, documentElement, yPos);
	            document.close();
	            return outputStream.toByteArray();
	            
	        } catch (Exception e) {
	           // throw new BusinessException(e);
	        	throw new Exception(e);
	        }

	    }

}
