package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.LettereIgbBO;
import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBO;
import it.almavivaitalia.bilancio.commons.bo.LettereTestiPersBOId;
import it.almavivaitalia.bilancio.commons.manager.CronologicoManager;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriTO;
import it.mef.bilancio.demdec.manager.LetterePreRegManager;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.LettereTestiPersTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class LetterePreRegManagerImpl extends LetterePreRegParentManagerImpl  implements LetterePreRegManager{

	@Autowired
	private CronologicoManager cronologicoManager;
	
	//siamo nel caso di inserimento
	@Override
	public void inserisciDatiPersELettera(LettereIgbTO lettera, String tipoLettera, FascicoliTO fascicolo, List<LettereTestiPersTO> listLetterePers,  Long idAmm, String dest/*desc amm*/, 
			String realPath) throws Throwable{
		LettereIgbBO letteraNew=salvaLettera(lettera, null);
		lettera.setId(letteraNew.getId());
		salvaDatiPers(listLetterePers, letteraNew.getId() );
		creaPdfESalvaLettera( lettera,  fascicolo, tipoLettera,   idAmm,  dest/*desc amm*/, realPath);
	}
	
	
	//siamo nel caso di modifica
	@Override
	public void modificaDatiPersELettera(LettereIgbTO lettera, String tipoLettera, FascicoliTO fascicolo, List<LettereTestiPersTO> listLetterePers,  Long idAmm, String dest/*desc amm*/, 
			String realPath) throws Throwable{
		salvaDatiPers(listLetterePers, lettera.getId() );
		creaPdfESalvaLettera( lettera,  fascicolo, tipoLettera,   idAmm,  dest/*desc amm*/, realPath);
	}
	
	
	private void creaPdfESalvaLettera(LettereIgbTO lettera, FascicoliTO fascicolo, String tipoLettera,  Long idAmm, String dest/*desc amm*/, 
			String realPath) throws Throwable{
		
		List<LettereTestiPersTO> listLetterePers=leggiDatiPers(lettera, tipoLettera);
		byte[] bytes=createPdf(new Integer(0), fascicolo.getEserciziDem().getId().toString()/* "2015"*/, fascicolo.getNumeNumDecreto(), "Tit prova", idAmm, dest, 
				new Long[5], listLetterePers, realPath);
		
		Blob blob = Hibernate.createBlob(bytes);
		salvaLettera( lettera,   blob);
	}
		
	
	private List<LettereTestiPersTO> leggiDatiPers( LettereIgbTO lettera, String tipoLettera) throws Throwable { 
		List<LettereTestiPersBO> boList = lettereTestiPersDao.findTestoPersByIdLettera(new Long(lettera.getId().toString()), tipoLettera);
		return getDozerDriver().mapList(boList, LettereTestiPersTO.class, "LettereTestiPers");
	}
	
	
	
	private void salvaDatiPers( List<LettereTestiPersTO> listLetterePers, BigDecimal sequIdLettera) throws Throwable {
		LettereTestiPersBO boLettPers=null;
		LettereTestiPersBOId boId=null;
		for (LettereTestiPersTO lettereTestiPersTO : listLetterePers) {
			boId=new LettereTestiPersBOId(sequIdLettera, lettereTestiPersTO.getId().getCodiTipoLettera(),
					lettereTestiPersTO.getId().getCodiSezione(), new Short(lettereTestiPersTO.getId().getNumeRiga()));
			
			 boLettPers=lettereTestiPersDao.loadById(LettereTestiPersBO.class,boId);
			 if(boLettPers!=null){
				 boLettPers.setTextContenuto(lettereTestiPersTO.getTextContenuto());
				 boLettPers.setRowUpdatedDttm(lettereTestiPersTO.getRowUpdatedDttm());
				 boLettPers.setRowUpdatedForm(lettereTestiPersTO.getRowUpdatedForm());
				 boLettPers.setRowUpdatedUser(lettereTestiPersTO.getRowUpdatedUser());
			 }else {
				 boLettPers=new LettereTestiPersBO();
				 boLettPers=getDozerDriver().map(lettereTestiPersTO, LettereTestiPersBO.class, "LettereTestiPers");
				 boLettPers.getId().setFkSequIdLettereIgb(sequIdLettera);
				 copyAllAudit(lettereTestiPersTO, boLettPers);
			 }
			 lettereTestiPersDao.saveOrUpdate(boLettPers);
		}
	}
	
	
	
	private byte[] createPdf( Integer numProt, String annoEse, Integer numDefBil, String titolo, Long idAmm, String descAmm, 
			Long[] arrayFascicoli,List<LettereTestiPersTO> testiLettere, String pathImages)
    		throws DocumentException, IOException {
		
			Rectangle rect = new Rectangle( 595, 792);
			Document document=new Document(rect);
	        
	        ByteArrayOutputStream byteArray= new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document,  byteArray);
	 	    
	 	    String path = pathImages+"logoMinEcon.jpg";
	 	    String path2 = pathImages+"logoMinEcon2.jpg";

	 	    Image logo = Image.getInstance(path);
	 	    Image logo2 = Image.getInstance(path2);
	      
	        document.open();	    	  
	        
	        Font mioFont9 = new Font(FontFamily.TIMES_ROMAN, 9, Font.NORMAL);
	        Font mioFont10 = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
//	        Font mioFont11 = new Font(FontFamily.TIMES_ROMAN, 11, Font.NORMAL);
	        Font mioFont12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	        
	        
	        PdfPTable table = new PdfPTable(21);
	        table.setComplete(true);
	        table.setTotalWidth(100);
	        table.setWidthPercentage(100);
	        
	        Paragraph paragraphVuoto=new Paragraph("",  mioFont10);
	       
	        PdfPCell cellLogo1 = new PdfPCell(logo, false);	    	        
	        cellLogo1.setHorizontalAlignment(Element.ALIGN_CENTER); 
	        cellLogo1.setVerticalAlignment(Element.ALIGN_TOP);
	        cellLogo1.setBorder(Rectangle.NO_BORDER);
	        cellLogo1.setColspan(11);
        	
	        table.addCell(cellLogo1);
        	
//        	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        	Date date = new Date();
        
        //	String luogoData="\n"+"Roma, "+ dateFormat.format(date);
        	String luogoData="";
        	PdfPCell cellLuogoData = new PdfPCell(new Paragraph(luogoData,  mioFont12));
        	cellLuogoData.setBorder(Rectangle.NO_BORDER);
        	cellLuogoData.setVerticalAlignment(Element.ALIGN_TOP);
        	cellLuogoData.setColspan(9);
        	
        	Paragraph paragraphVuoto2=new Paragraph("",  mioFont10);
	        PdfPCell cellaVuota2 = new PdfPCell(paragraphVuoto2);
	        cellaVuota2.setBorder(Rectangle.NO_BORDER);
        	table.addCell(cellaVuota2);
        	
        	table.addCell(cellLuogoData);
        	
         	PdfPCell cellSubLogo = new PdfPCell(logo2);	    	        
         	cellSubLogo.setHorizontalAlignment(Element.ALIGN_CENTER);
         	cellSubLogo.setVerticalAlignment(Element.ALIGN_TOP);
         	cellSubLogo.setBorder(Rectangle.NO_BORDER);
         	cellSubLogo.setColspan(11);
         	cellSubLogo.addElement(logo2);
         	
            Paragraph paragraph1=new Paragraph(testiLettere.get(1).getTextContenuto()+"\n", mioFont9); 
            paragraph1.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragraph12=new Paragraph(testiLettere.get(2).getTextContenuto()+"\n", mioFont9); 
            paragraph12.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph paragraph13=new Paragraph(testiLettere.get(3).getTextContenuto()+"\n", mioFont9);
            paragraph13.setAlignment(Element.ALIGN_CENTER);
            
           
         //   Paragraph paragraph14=new Paragraph("\n      Rif. Prot. Entrata N. "+ numProt.toString()+"\n      "+testiLettere.get(8).getTextContenuto(), mioFont12); 
            Paragraph paragraph14=new Paragraph("\n      "+testiLettere.get(7).getTextContenuto()+"\n      "+testiLettere.get(8).getTextContenuto(), mioFont12); 
            paragraph14.setAlignment(Element.ALIGN_LEFT);     
            
            cellSubLogo.addElement(paragraph1);
            cellSubLogo.addElement(paragraph12);
            cellSubLogo.addElement(paragraph13);
            cellSubLogo.addElement(paragraph14);
            
    	       
	       Paragraph paragraphDest=new Paragraph(testiLettere.get(5).getTextContenuto()+"\n\n",  mioFont12);
	        
	        Paragraph paragraphCdr=new Paragraph("",  mioFont10);  
	        paragraphCdr.setSpacingBefore(2);
	        
            PdfPCell cellaDest = new PdfPCell(paragraphDest);
              cellaDest.setBorder(Rectangle.NO_BORDER);
             cellaDest.addElement(paragraphDest);     
            cellaDest.addElement(paragraphCdr);    
            cellaDest.setColspan(9);
            cellaDest.setVerticalAlignment(Element.ALIGN_TOP);
            
//            String fasc=(arrayFascicoli.length>1)?"fascicoli":"fascicolo";
//    	       String listaFasc="";
//    	       
//    	       for (int j = 0; j < arrayFascicoli.length; j++) {
//    	    	   listaFasc+=arrayFascicoli[j];	    	    	  
//    	    	   if(j!=(arrayFascicoli.length-1)){
//    	    		   listaFasc+=", ";	    	    		   
//    	    	   }
//			   }
    	       
    	       Paragraph paragraph20=new Paragraph(testiLettere.get(6).getTextContenuto(),  mioFont12);  	
    	       Paragraph paragraph21=new Paragraph("",  mioFont9); 
    	        paragraph21.add(""+"\n");
    	        paragraph21.setAlignment(Element.ALIGN_JUSTIFIED);
    	        cellaDest.addElement(paragraph20);
    	        cellaDest.addElement(paragraph21);
	        
	        table.addCell(cellSubLogo);
	        
	        Paragraph paragraphVuoto5=new Paragraph("",  mioFont10);
	        PdfPCell cellaVuota5 = new PdfPCell(paragraphVuoto5);
	        cellaVuota5.setBorder(Rectangle.NO_BORDER);
	        table.addCell(cellaVuota5);
	        table.addCell(cellaDest);
	        
	        Paragraph paragraph2=new Paragraph("",  mioFont10);
	        PdfPCell cell4 = new PdfPCell(paragraph2);
	       
	        cell4.addElement(paragraphVuoto);
	         cell4.setBorder(Rectangle.NO_BORDER);
	         cell4.setColspan(11);

	        PdfPTable table2 = new PdfPTable(18);
	  
	        table2.setWidthPercentage(84);
    
//	        String numDefBilString=numDefBil!=null?numDefBil.toString():"";
	        
	        String oggetto0=" \n\n\n OGGETTO: ";
	        
	        Paragraph paragraph30=new Paragraph(oggetto0, mioFont12);
	        paragraph30.setAlignment(0);

	        PdfPCell cell50 = new PdfPCell(paragraph30);
	        
	        cell50.addElement(paragraph30);
	        cell50.setColspan(3);
	        cell50.setBorder(Rectangle.NO_BORDER);
	        cell50.setVerticalAlignment(Element.ALIGN_TOP);
	        table2.addCell(cell50);
        
	        String oggetto=" \n\n\n"+testiLettere.get(9).getTextContenuto();
	        // String oggetto=" \n\n\n"+"OGGETTO: Reiscrizione residui passivi perenti agli effetti amministrativi. Anno $ANNO Decreto M.T. n. $NUMERO, concernente un prelevamento dal fondo speciale per la riassegnazione dei residui passivi della spesa di $TIT.".replace("$ANNO", annoEse).replace("$NUMERO", numDefBilString).replace("$TIT", titolo).substring(9);

	        Paragraph paragraph3=new Paragraph(oggetto, mioFont12);
	        paragraph3.setAlignment(Element.ALIGN_JUSTIFIED);
	       
	        PdfPCell cell5 = new PdfPCell(paragraph3);
	        
	        cell5.addElement(paragraph3);
	        cell5.setColspan(15);
	        cell5.setBorder(Rectangle.NO_BORDER);
	        cell50.setVerticalAlignment(Element.ALIGN_TOP);
	        table2.addCell(cell5);
	      
	        
	        
	        
	        
	        String testo0="\n\n             "+testiLettere.get(10).getTextContenuto();
	        String testo=null;
	        String testo1=null;
	        	    
	        if(idAmm!=null && idAmm.compareTo(new Long("9"))==0){		    	        
	        	testo=testo0.replace("codesto", "questo");
	        }else{
	        	testo=testo0;
	        }
	        
	        if(arrayFascicoli.length==1){		    	        
	        	testo1=testo.replace("nei fascicoli", "nel fascicolo");
	        }else{
	        	testo1=testo;
	        }
    	        
	        PdfPTable table3=new PdfPTable(18);
	        table3.setWidthPercentage(84);
	        
	        Paragraph paragraph40=new Paragraph(" ", mioFont12); 
	        PdfPCell cell60 = new PdfPCell(paragraph40);
	        cell60.setBorder(Rectangle.NO_BORDER);
	        cell60.setVerticalAlignment(Element.ALIGN_TOP);
	        table3.addCell(cell60);
	        
	        Paragraph paragraph4=new Paragraph(testo1, mioFont12); 
	        paragraph4.setAlignment(Element.ALIGN_JUSTIFIED);
	      
	        PdfPCell cell6 = new PdfPCell(paragraph4);
	       
	        cell6.addElement(paragraph4);
	        cell6.setColspan(17);
	        cell6.setBorder(Rectangle.NO_BORDER);
	        cell6.setVerticalAlignment(Element.ALIGN_TOP);
	        table3.addCell(cell6);
	        
	        
	        /***NOTE***/
	        PdfPTable table4 = new PdfPTable(18);
	        table4.setWidthPercentage(84);
	        String note0=" \n\n\n NOTE: ";
	        Paragraph paragraph50=new Paragraph(note0, mioFont12);
	        paragraph50.setAlignment(0);
	        PdfPCell cell70 = new PdfPCell(paragraph50);
	        cell70.addElement(paragraph50);
	        cell70.setColspan(3);
	        cell70.setBorder(Rectangle.NO_BORDER);
	        cell70.setVerticalAlignment(Element.ALIGN_TOP);
	        table4.addCell(cell70);
	       String note=" \n\n\n"+(testiLettere.get(11).getTextContenuto()==null?"":testiLettere.get(11).getTextContenuto());
	       //   String note=" \n\n\n"+"Prova note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note note ";
	        Paragraph paragraph5=new Paragraph(note, mioFont12);
	        paragraph5.setAlignment(Element.ALIGN_JUSTIFIED);
	        PdfPCell cell7 = new PdfPCell(paragraph5);
	        cell7.addElement(paragraph5);
	        cell7.setColspan(15);
	        cell7.setBorder(Rectangle.NO_BORDER);
	        cell70.setVerticalAlignment(Element.ALIGN_TOP);
	        table4.addCell(cell7);
	        /***fine NOTE***/
	        
	      
	        document.add(table);
	        document.add(table2);
	        document.add(table3);
	        document.add(table4);
	        
	        PdfFormField prot = PdfFormField.createSignature(writer);
	        prot.setWidget(new Rectangle(400, 750, 500, 780), PdfAnnotation.HIGHLIGHT_INVERT);
	        prot.setFieldName("Protocollo");
	        prot.setFlags(PdfAnnotation.FLAGS_PRINT);
	        prot.setPage();
	        prot.setMKBorderColor(BaseColor.BLACK);
	        prot.setMKBackgroundColor(BaseColor.WHITE);
	        PdfAppearance tpProt = PdfAppearance.createAppearance(writer, 100, 30);
	        tpProt.rectangle(0.5f, 0.5f, 99.5f, 29.5f);
	        tpProt.stroke();
	        prot.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, tpProt);
	        writer.addAnnotation(prot);
	        
	        PdfFormField field = PdfFormField.createSignature(writer);
	        field.setWidget(new Rectangle(50, 20, 300, 50), PdfAnnotation.HIGHLIGHT_INVERT);
	        field.setFieldName("Dirigente");
	        field.setFlags(PdfAnnotation.FLAGS_PRINT);
	        field.setPage();
	        field.setMKBorderColor(BaseColor.BLACK);
	        field.setMKBackgroundColor(BaseColor.WHITE);
	        PdfAppearance tp = PdfAppearance.createAppearance(writer, 250, 30);
	        tp.rectangle(0.5f, 0.5f, 249.5f, 29.5f);
	        tp.stroke();
	        field.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, tp);
	        writer.addAnnotation(field);
	        
	        document.close();

	       byte[] pdfBytes= byteArray.toByteArray();	    	       
	       return pdfBytes;
	
	        
	    }

	
	
		private LettereIgbBO salvaLettera(LettereIgbTO lettera,  Blob binaIntLettera) throws Throwable {
			
			 LettereIgbBO bo=getDozerDriver().map(lettera, LettereIgbBO.class, "LettereIgb");
				
				LettereIgbBO old = lettereIgbDao.findByUK(bo.getFascicoli().getId(), bo.getAnagAmminDem().getId().getFkAnnoEse(), bo.getAnagAmminDem().getId().getNumeStp(), bo.getAnagAmminDem().getId().getNumeApp());
				
				LettereIgbBO boNew=null;
				//BigDecimal sequIdLettera=null;
				if(old == null){
				
					/**la funzione generaId torna null se si sta facendo il primo inserimento, quindi in quel caso  inserisco manualmente il valore 1**/
					bo.setId((BigDecimal) lettereIgbDao.generaId(LettereIgbBO.class));
					if(bo.getId()==null){
						bo.setId(new BigDecimal(1));
					}
					bo.setBinaIntLettera(binaIntLettera);
					copyAllAudit(lettera, bo);
					boNew=(LettereIgbBO)lettereIgbDao.saveOrUpdate(bo);
					
					
					/*	List<CronoValoriTO> listCronoValori=new ArrayList<CronoValoriTO>();
					// Richiamo cronologico
					cronologicoManager.salvaCronologico(
											null,//old
											boNew,//new
											null,
											listCronoValori,
											CroTransTO.CRO_TRANS_INSERISCI_LETTERA_PREREGISTRAZIONE,
											lettera.getRowUpdatedForm(), 
											lettera.getRowUpdatedUser());	*/
					
					return boNew;
					
					
				}else{
					old.setBinaIntLettera(binaIntLettera);
					copyAllAudit(lettera, old);
					lettereIgbDao.update(old);
					
					/*	List<CronoValoriTO> listCronoValori=new ArrayList<CronoValoriTO>();
					// Richiamo cronologico
					cronologicoManager.salvaCronologico(
											null,//old
											boNew,//new
											null,
											listCronoValori,
											CroTransTO.CRO_TRANS_INSERISCI_LETTERA_PREREGISTRAZIONE,
											lettera.getRowUpdatedForm(), 
											lettera.getRowUpdatedUser());	*/
					return old;
				}
				
					
				
				
		}
	
	

	
	@Override
	public void aggiornaLettere(LettereIgbTO lettera, Blob binaIntLettera, List<LettereTestiPersTO> listLetterePers) throws Throwable {			
		LettereIgbBO bo=getDozerDriver().map(lettera, LettereIgbBO.class, "LettereIgb");
		
		LettereIgbBO old = lettereIgbDao.findByUK(bo.getFascicoli().getId(), bo.getAnagAmminDem().getId().getFkAnnoEse(), bo.getAnagAmminDem().getId().getNumeStp(), bo.getAnagAmminDem().getId().getNumeApp());
		
		LettereIgbBO boNew=null;
		BigDecimal sequIdLettera=null;
		if(old == null){
		
			/**la funzione generaId torna null se si sta facendo il primo inserimento, quindi in quel caso  inserisco manualmente il valore 1**/
			bo.setId((BigDecimal) lettereIgbDao.generaId(LettereIgbBO.class));
			if(bo.getId()==null){
				bo.setId(new BigDecimal(1));
			}
			
			bo.setBinaIntLettera(binaIntLettera);
			copyAllAudit(lettera, bo);
			boNew=(LettereIgbBO)lettereIgbDao.saveOrUpdate(bo);
			
		}else{
			
			old.setBinaIntLettera(binaIntLettera);
			copyAllAudit(lettera, old);
			lettereIgbDao.update(old);
			
		}
		if (boNew!=null){
			sequIdLettera=boNew.getId();
		}else{
			sequIdLettera=old.getId();
		}
		
		LettereTestiPersBO boLettPers=null;
		for (LettereTestiPersTO lettereTestiPersTO : listLetterePers) {
			 boLettPers=new LettereTestiPersBO();
			 boLettPers=getDozerDriver().map(lettereTestiPersTO, LettereTestiPersBO.class, "LettereTestiPers");
			 boLettPers.getId().setFkSequIdLettereIgb(sequIdLettera);
			 copyAllAudit(lettereTestiPersTO, boLettPers);
			 lettereTestiPersDao.saveOrUpdate(boLettPers);
		}
		
		
	}
	 

    
		@Override
		public List<LettereIgbTO> findLettereByIdDecreto(Long idDecreto)  throws Throwable {
		 	return getDozerDriver().mapList(lettereIgbDao.findLettereByIdDecreto(idDecreto), LettereIgbTO.class, "LettereIgb");
		    
	    }
	
		
	
		@Override
	    public List<LettereIgbTO> findByLettera(LettereIgbTO lettera) throws Throwable{
			
			LettereIgbBO bo=getDozerDriver().map(lettera, LettereIgbBO.class, "LettereIgb");
			List<LettereIgbBO> listBo=lettereIgbDao.findByLettera(bo);
			//il dozer va in errore a causa del campo blob
			List<LettereIgbTO>  toList=getDozerDriver().mapList(listBo, LettereIgbTO.class, "LettereIgb");
			//List<LettereIgbTO>  toList=new ArrayList<LettereIgbTO>();
//			LettereIgbTO to=null;
//			for (int i = 0; i < listBo.size(); i++) {
//				to=new LettereIgbTO();
//				to.setAnagAmminDem(getDozerDriver().map(listBo.get(i).getAnagAmminDem(), AnagAmminDemTO.class, "AnagAmminDem"));
//				to.setFascicoli(getDozerDriver().map(listBo.get(i).getFascicoli(), FascicoliTO.class, "FascicoliFad"));
//				to.setId(listBo.get(i).getId());
//				to.setDataLettera(listBo.get(i).getDataLettera());
//				to.setStatusLettera(listBo.get(i).getStatusLettera());
//				toList.add(to);
//			}
//			
			return toList;
	    }


		@Override
		public void deleteLettera(LettereIgbTO lettera, String tipoLettera) throws Throwable {
			LettereTestiPersBO lettPersBo=null;
			
			 List<LettereTestiPersBO> lettPersBoList=lettereTestiPersDao.findTestoPersByIdLettera(new Long(lettera.getId().toString()), tipoLettera);
			for (int i = 0; i < lettPersBoList.size(); i++) {
				lettPersBo=lettPersBoList.get(i);
				lettereTestiPersDao.delete(lettPersBo);
			}
			LettereIgbBO bo=lettereIgbDao.loadById(LettereIgbBO.class, lettera.getId());
			lettereIgbDao.delete(bo);
			
		}

		@Override
		public void invioAllefirme(List<LettereIgbTO> listaLettere, String user, String nomeFunzione) throws Throwable {
			for (int i = 0; i < listaLettere.size(); i++) {
				aggiornaStatusLettera(listaLettere.get(i).getId(), "2", user, nomeFunzione);
			}
		}


		@Override
		public String findDestinatariMailPec(BigDecimal id) throws Throwable {
			
			 String flagSemaforo=lettereIgbDao.getFlagSemaforoIpa();
			 String destinatari= null;
			 if(flagSemaforo.equalsIgnoreCase("N")){
			    destinatari= lettereIgbDao.findDestinatariMailPec(id);
			 }
			return destinatari;
		}


		@Override
		public List<LettereIgbTO> findLettereByStatus(String status) throws Throwable {
			List<LettereIgbTO> toList=getDozerDriver().mapList(lettereIgbDao.findLettereByStatus(status), LettereIgbTO.class, "LettereIgb");
			return toList;
		}
		
		
		@Override
		public LettereIgbBO aggiornaStatusLettera(BigDecimal idLettera, String status, String user, String funzione) throws Throwable {
			LettereIgbBO boNew=null;
			LettereIgbBO bo=lettereIgbDao.loadById(LettereIgbBO.class, idLettera);
			if(bo==null){
				return null;
			}else {
				bo.setRowUpdatedDttm(Calendar.getInstance().getTime());
				bo.setRowUpdatedForm(funzione);
				bo.setRowUpdatedUser(user);
				bo.setStatusLettera(status);
				boNew=(LettereIgbBO)lettereIgbDao.saveOrUpdate(bo);
			}
			return boNew;
			
			
		}


		
}
