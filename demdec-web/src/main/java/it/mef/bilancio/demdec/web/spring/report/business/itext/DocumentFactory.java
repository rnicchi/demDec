package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.PageSize;
//import it.consip.fgen.core.constants.ICoreConstants;
//import it.consip.fgen.core.report.business.itext.dto.*;
//import it.consip.fgen.core.report.business.itext.model.*;
//import it.consip.fgen.core.report.business.itext.util.ReportITextConstants;
//import it.consip.pat.common.model.ReportBollettino;

import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.RiepilogoAdDemTO;
import it.mef.bilancio.demdec.web.spring.form.PredTagliatellaForm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class DocumentFactory {
					//ITextReportDTO dto
	 public static AccessibleDocument getAccessibleDocument(ITextReportDTO dto) {

	        AccessibleDocument accessibleDocument = null;

	        /*
	        discriminiamo le varie tipologie di documenti (discriminazioni dovute principalmente al tipo di tabella/e contenuta all'interno)
	         */
	        if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_01)) {
	            accessibleDocument = new AccessibleDocumentType01();
	        } 
	        /*
	        else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_02)) {
	            accessibleDocument = new AccessibleDocumentType02();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_03)) {
	            accessibleDocument = new AccessibleDocumentType03();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_04)) {
	            accessibleDocument = new AccessibleDocumentType04();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_05)) {
	            accessibleDocument = new AccessibleDocumentType05();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_06)) {
	            accessibleDocument = new AccessibleDocumentType06();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_07)) {
	            accessibleDocument = new AccessibleDocumentType07();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_08)) {
	            accessibleDocument = new AccessibleDocumentType08();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_09)) {
	            accessibleDocument = new AccessibleDocumentType09();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_D1)) {
	            accessibleDocument = new AccessibleDocumentTypeD1();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_G1)) {
	            accessibleDocument = new AccessibleDocumentTypeG1();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_G2)) {
	            accessibleDocument = new AccessibleDocumentTypeG2();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_G3)) {
	            accessibleDocument = new AccessibleDocumentTypeG3();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_G4)) {
	            accessibleDocument = new AccessibleDocumentTypeG4();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_G5)) {
	            accessibleDocument = new AccessibleDocumentTypeG5();
	        } else if (dto.getDocumentType().equals(ICoreConstants.ACCESIBLE_DOCUMENT_TYPE_G6)) {
	            accessibleDocument = new AccessibleDocumentTypeG6();
	        } else {
	            accessibleDocument = new AccessibleDocumentType01();
	        }
	       
	      ////  info principali
	        */
	        accessibleDocument.setPageSize(PageSize.A4.rotate());
	        accessibleDocument.setTitle(String.format(dto.getDocumentType().startsWith(ICoreConstants.ACCESIBLE_DOCUMENT_CHART_TYPE_PREFIX) ? ReportITextConstants.CHART_TITLE :ReportITextConstants.DOCUMENT_TITLE , dto.getNumeroTavola()));
	        accessibleDocument.setHeaderFirstPart(replacePlaceholders(dto.getHeaderFirstPart(), dto.getAnnoEsercizioConsuntivo()));
	        accessibleDocument.setHeaderSecondPart(dto.getHeaderSecondPart() == null ? "" : dto.getHeaderSecondPart());
	        accessibleDocument.setNote(dto.getNote());
	        accessibleDocument.setPathImage(dto.getPathImage() == null ? "" : dto.getPathImage());
	        /*
	        calcoliamo i relativeColumnWidths
	         */
	      
	        /*String[] relativeColumnWidthsString = dto.getRelativeColumnWidths().split(ReportITextConstants.SPLIT_CHARACTER);
	        float[] relativeColumnWidths = new float[relativeColumnWidthsString.length];
	        for (int i = 0; i < relativeColumnWidthsString.length; i++) {
	            try {
	                relativeColumnWidths[i] = Float.parseFloat(relativeColumnWidthsString[i]);
	            } catch (NumberFormatException e) {
	                relativeColumnWidths[i] = 1f;
	            }
	        }
	        */
	       /// String relativeColumnWidths = dto.getRelativeColumnWidths();
	        
	      //  accessibleDocument.setRelativeColumnWidths(Float.parseFloat(relativeColumnWidths));
	        /*
	        margini del documento
	         */
	        String[] margins = dto.getDocumentMargins().split(ReportITextConstants.SPLIT_CHARACTER);
	        Map<String, Float> documentMargins = new HashMap<String, Float>();
	        documentMargins.put(ReportITextConstants.TOP_MARGIN_KEY, new Float(margins[0]));
	        documentMargins.put(ReportITextConstants.BOTTOM_MARGIN_KEY, new Float(margins[1]));
	        documentMargins.put(ReportITextConstants.LEFT_MARGIN_KEY, new Float(margins[2]));
	        documentMargins.put(ReportITextConstants.RIGHT_MARGIN_KEY, new Float(margins[3]));
	        accessibleDocument.setDocumentMargins(documentMargins);
	        /*
	         calcoliamo l'altezza minima delle celle della tabella
	          */
	        accessibleDocument.setMinHeightHeaderCell(new Float(dto.getMinHeightHeaderCell()));
	        accessibleDocument.setMinHeightCommonCell(new Float(dto.getMinHeightCommonCell()));
	        /*
	        ampiezza dell'intervallo fra due valori della scala, nel caso di istogrammi
	         */
	        accessibleDocument.setTickUnit(dto.getTickUnit() == null ? 0.0 : new Double(dto.getTickUnit()));
	        /*
	        popoliamo le tabelle
	         */
	        accessibleDocument.generateTable(dto);

	        return accessibleDocument;
	    }


	    private static String replacePlaceholders(String header, String annoEsercizioConsuntivo) {
	        header = header.replaceAll(ReportITextConstants.ANNO_CONSUNTIVO, annoEsercizioConsuntivo);
	        header = header.replaceAll(ReportITextConstants.ANNO_CONSUNTIVO_MENO_UNO, new Integer(new Integer(annoEsercizioConsuntivo) - 1).toString());
	        header = header.replaceAll(ReportITextConstants.ANNO_CONSUNTIVO_MENO_DUE, new Integer(new Integer(annoEsercizioConsuntivo) - 2).toString());
	        header = header.replaceAll(ReportITextConstants.ANNO_CONSUNTIVO_MENO_TRE, new Integer(new Integer(annoEsercizioConsuntivo) - 3).toString());
	        header = header.replaceAll(ReportITextConstants.ANNO_CONSUNTIVO_MENO_QUATTRO, new Integer(new Integer(annoEsercizioConsuntivo) - 4).toString());
	        return header;
	    
	    }
	    
}
