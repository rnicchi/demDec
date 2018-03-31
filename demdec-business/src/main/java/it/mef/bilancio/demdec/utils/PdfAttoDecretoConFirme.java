package it.mef.bilancio.demdec.utils;

import it.almavivaitalia.bsn.sh.utils.TraceLogger;
import it.mef.bilancio.demdec.to.CampoFirmaTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfReader;

public class PdfAttoDecretoConFirme {
	
	
	
	public static void main(String[] args) throws Throwable {
		
		
		List<CampoFirmaTO> listFields = new ArrayList<CampoFirmaTO>();
		
		listFields.add(new CampoFirmaTO("Firma Tecnica","Tecn_1","T",1));
		listFields.add(new CampoFirmaTO("Ispettore", "Ispettore", "T",2));
		listFields.add(new CampoFirmaTO("Ministro della Difesa", "Ministro_120", "V",3));
		listFields.add(new CampoFirmaTO("Ministro dell'Interno", "Ministro_080", "V",4));
		listFields.add(new CampoFirmaTO("Ministro degli Esteri", "Ministro_060", "V",5));
		listFields.add(new CampoFirmaTO("Ministro MEF", "MinistroMEF", "V",6));
		listFields.add(new CampoFirmaTO("Il Ragioniere Generale dello Stato", "Ragioniere", "V",7));
		listFields.add(new CampoFirmaTO("Il Capofila", "Capofila", "T",8));
		FileInputStream iSAD = new FileInputStream("c:/appoggio/prova.pdf");
		InputStream in = createAttoDecretoConFirma("TEST",iSAD,listFields);
		FileOutputStream out = new FileOutputStream("c:/appoggio/provaFirma2.pdf");
		byte[] buffer = new byte[1024];
		int len = in.read(buffer);
		while (len != -1) {
		    out.write(buffer, 0, len);
		    len = in.read(buffer);
		}
		out.close();
		in.close();
		iSAD.close();	

   		
		}

	
	public static ByteArrayInputStream  createAttoDecretoConFirma(String headerPaginaFirma, InputStream isAttoDecreto,List<CampoFirmaTO> listFields) throws Throwable {
		
		ByteArrayInputStream bIn=null;
		ByteArrayOutputStream baos= new ByteArrayOutputStream() ;
	    PdfCopyFields copy 	= new PdfCopyFields(baos);
	    
	    TraceLogger.debugLog("Inizio Elaborazione::", PdfPaginaFirma.class);
		InputStream inpStr = isAttoDecreto;
		InputStream isPaginafirme = PdfPaginaFirma.createPdfConFirma(headerPaginaFirma, listFields);
		try {
			if (inpStr != null && isPaginafirme!=null) {
					PdfReader reader = new PdfReader(inpStr);
					copy.addDocument(reader);
					System.out.println("pagine atto n. "+reader.getNumberOfPages());
					PdfReader readerPagina = new PdfReader(isPaginafirme);
					copy.addDocument(readerPagina);
					System.out.println("pagine firma n. "+readerPagina.getNumberOfPages());
					if(copy!=null){
						copy.close();
					}
					bIn = new ByteArrayInputStream(baos.toByteArray());
			}
			} catch (Throwable t) {
							throw t;
			} finally {
							if (isPaginafirme != null) {
								isPaginafirme.close();
							}
							if (baos != null) {
								baos.close();
							}
			
			}
		return bIn;
		}

}
