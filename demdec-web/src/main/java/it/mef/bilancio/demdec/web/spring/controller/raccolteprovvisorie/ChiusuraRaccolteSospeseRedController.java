/**
 * 
 */
package it.mef.bilancio.demdec.web.spring.controller.raccolteprovvisorie;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.EserciziTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.web.sh.utils.ApplicationContextProvider;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.mef.bilancio.demdec.manager.InitManager;
import it.mef.bilancio.demdec.manager.ListManager;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentContentTO;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.RaccoltaProvvisoriaRedTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagStatoFascicoloTO;
import it.mef.bilancio.demdec.to.AnagTipoDecretoTO;
import it.mef.bilancio.demdec.to.AnagTipoFlussoTO;
import it.mef.bilancio.demdec.to.RicercaRedTO;
import it.mef.bilancio.demdec.to.SospesiRedTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.utils.MyComparatorRaccProvvRedToAnnoProtNumProt;
import it.mef.bilancio.demdec.web.spring.form.RicercaRedForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author Pietro
 *
 */
@RequestMapping(value = ConstantsRequestMapping.RICERCA_SOSPESI_RED)
public class ChiusuraRaccolteSospeseRedController extends ChiusuraRaccolteSospeseRedLiv2Controller implements WebConstants, SessionAttributes{
	
	private String startView;
	private String listaSospesiRed;
	private String documentiFascicolo;
	
	@Autowired
	private ListManager listManager;
	
	@Override
	public String startController(Context context) throws Throwable {

		context.setCurrentNode("DemDec.menu.RicercaSosp");

		List<EserciziTO> listaAnniEsercizio = getListManager().loadEserciziDemCG();
		List<AnagStatoFascicoloTO> listaStatiFascRed = getListManager().loadStatiFascicoliRed();
		List<AnagAmminDemTO> listaAmm = new ArrayList<AnagAmminDemTO>();
		List<AnagTipoFlussoTO> listAnagTipoFlusso = getListManager().loadAnagTipoFlusso();
		List<AnagUfficiTO> listaUfficiAssociatiRed = 
					getListaUfficiAssociatiRed(context);
		
		context.setDataModel(WebConstants.LIST_ANNO_ESE, listaAnniEsercizio);
		context.setDataModel(WebConstants.LIST_ANAG_STATI_FASC, listaStatiFascRed);
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, listaAmm);
		context.setDataModel(WebConstants.LIST_ANAG_TIPO_FLUSSO, listAnagTipoFlusso);
		context.setDataModel(WebConstants.LIST_ANAG_UFF, listaUfficiAssociatiRed);
		
		return startView;
		
	}
	
	public void setStartView(String startView) {
		this.startView = startView;
	}
	public void setListaSospesiRed(String listaSospesiRed) {
		this.listaSospesiRed = listaSospesiRed;
	}
	public void setDocumentiFascicolo(String documentiFascicolo) {
		this.documentiFascicolo = documentiFascicolo;
	}
	


	public String ricercaSospesiRed(Context context) throws Throwable {
		
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		
		if(form.isValid()){
			//invoco il webservice
		}else {
			return startView;
		}

		context.getRequest().getSession().removeAttribute("ricercaRedTo");
		
		RicercaRedTO ricercaRedTO=new RicercaRedTO();
	
		ricercaRedTO.setIdRed(form.getIdRed());
		ricercaRedTO.setAmministrazione(form.getAmministrazione());
		ricercaRedTO.setAnnoEse(form.getAnnoEse());
		ricercaRedTO.setDataArrivoA(form.getDataArrivoA());
		ricercaRedTO.setDataArrivoDa(form.getDataArrivoDa());
		ricercaRedTO.setDataRedDa(form.getDataRedDa());
		ricercaRedTO.setDataRedA(form.getDataRedA());
		ricercaRedTO.setProtocolloRed(form.getProtocolloRed());
		ricercaRedTO.setStato(form.getStato());
		ricercaRedTO.setTipoFlusso(form.getTipoFlusso());
		ricercaRedTO.setUfficioAssociatoRed(form.getUfficioAssociatoRed());
		
		context.getRequest().getSession().setAttribute("ricercaRedTo", ricercaRedTO);
		
		ApplicationContext applContext=ApplicationContextProvider.getApplicationContext();
		InitManager inMan =(InitManager )applContext.getBean("initManager");
		ParametriInput paramInp= inMan.leggiParametriInputDemBil();
		
		ResponseDEMBILClient respClient=getRicercaRedSospesiManager().wsRicercaRed(paramInp, ricercaRedTO); 
		
		String codiceEsito=respClient.getEsitoTo().getCodice();

		if(codiceEsito.equalsIgnoreCase("OK")) {
			List<AbstractDemTO> respListTo=respClient.getListoutputTO();


			if (respListTo == null || respListTo.size() == 0) {
				context.addWarning("warning.empty");
				return startView; 
			}

	    	Collections.sort(respListTo, new MyComparatorRaccProvvRedToAnnoProtNumProt());
	    	/***/
	    	RaccoltaProvvisoriaRedTO rprTo=null;
	    	List<RaccoltaProvvisoriaRedTO> respListToNew=new ArrayList<RaccoltaProvvisoriaRedTO>();
	    	for (int i = 0; i < respListTo.size(); i++) {
	    		rprTo=(RaccoltaProvvisoriaRedTO)respListTo.get(i);
	    		if(rprTo.getCodiStatoFascicoloDocumentale()!=null){
					rprTo.setDescStatoFascicoloDocumentale(listManager.loadDescStatiFascicoliRed(rprTo.getCodiStatoFascicoloDocumentale()));
					respListToNew.add(rprTo);
				}
			}
	    	/***/
			List<AbstractDemTO> listaRedDaSospendere = new ArrayList<AbstractDemTO>();
			List<AbstractDemTO> listaRedSospesi = new ArrayList<AbstractDemTO>();

			//suddivide la lista di Raccolte Provvisorie proveniente da WS in due liste
		//	differenziaRaccolteProvvDaWS(respListTo, listaRedDaSospendere, listaRedSospesi);
			differenziaRaccolteProvvDaWS(respListToNew, listaRedDaSospendere, listaRedSospesi);

			context.setDataModel(SessionAttributes.LIST_RICERCA_RED, respListTo /* listTO */ );

			if (listaRedDaSospendere.size()>0)
				PaginatorUtil.addPaginator(context, listaRedDaSospendere, SessionAttributes.LIST_SOSPENDIBILI_RED, Paginator.PAGE_RANGE_15, SessionAttributes.PAGINATOR_SOSPENDIBILI_RED);
	        else 
	     		PaginatorUtil.removePaginator(context, SessionAttributes.LIST_SOSPENDIBILI_RED, SessionAttributes.PAGINATOR_SOSPENDIBILI_RED);

			if (listaRedSospesi.size()>0)
				PaginatorUtil.addPaginator(context, 
						listaRedSospesi, SessionAttributes.LIST_SOSPESI_RED, Paginator.PAGE_RANGE_15, SessionAttributes.PAGINATOR_SOSPESI_RED);
	        else
	     		PaginatorUtil.removePaginator(context, SessionAttributes.LIST_SOSPESI_RED, SessionAttributes.PAGINATOR_SOSPESI_RED);

			return listaSospesiRed;

		}else if (codiceEsito.equalsIgnoreCase("ERRORE_DATI_NON_PRESENTI")){
			context.addWarning("warning.empty");
			return startView;
		}else {
			context.addError("error.generic", respClient.getEsitoTo().getDescrizione()); 
			return startView;
		}
	}



	public String inserisciSospesiRed(Context context) throws Throwable {

		RicercaRedForm form= (RicercaRedForm) context.getForm();

		List<AbstractDemTO> listaRaccoltaWsTO = context.getModel(SessionAttributes.LIST_RICERCA_RED);
		List<SospesiRedTO> listaSospesiRedTO = (List<SospesiRedTO>) getRicercaRedSospesiManager().getListaSospesiRed();

		List<AbstractDemTO> listaRaccoltaTO = getListaWsFiltered(listaRaccoltaWsTO, listaSospesiRedTO); 

		//se non ci sono check selezionati, ritorno senza fare nulla
		if (form.getListaRedDaSospendere() == null
				|| form.getListaRedDaSospendere().length == 0){
			
			context.addError("errore.raccolta.null");
			return listaSospesiRed;
		}

		List<SospesiRedTO> listaRedDaSospendereTO = new ArrayList<SospesiRedTO>();
		for (String indice: form.getListaRedDaSospendere()) {
			RaccoltaProvvisoriaRedTO to = (RaccoltaProvvisoriaRedTO) listaRaccoltaTO.get(new Integer(indice));

			SospesiRedTO sospesoRedTO = new SospesiRedTO(to);
			context.valorizeAudit(sospesoRedTO, NomeFunzioneConstants.FUNZIONE_FORM_SOSPESI_RED);

			listaRedDaSospendereTO.add(sospesoRedTO);
		}

		getRicercaRedSospesiManager().saveSospesiRed(listaRedDaSospendereTO);

		List<AbstractDemTO> listaRedDaSospendere = new ArrayList<AbstractDemTO>();
		List<AbstractDemTO> listaRedSospesi = new ArrayList<AbstractDemTO>();
		//suddivide la lista di Raccolte Provvisorie proveniente da WS in due liste
		differenziaRaccolteProvvDaWS(listaRaccoltaWsTO, listaRedDaSospendere, listaRedSospesi);

		if (listaRedDaSospendere.size()>0)
			PaginatorUtil.addPaginator(context, listaRedDaSospendere, SessionAttributes.LIST_SOSPENDIBILI_RED, Paginator.PAGE_RANGE_15, SessionAttributes.PAGINATOR_SOSPENDIBILI_RED);
		else
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_SOSPENDIBILI_RED, SessionAttributes.PAGINATOR_SOSPENDIBILI_RED);

		if (listaRedSospesi.size()>0)
			PaginatorUtil.addPaginator(context, 
					listaRedSospesi, SessionAttributes.LIST_SOSPESI_RED, Paginator.PAGE_RANGE_15, SessionAttributes.PAGINATOR_SOSPESI_RED);
		else
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_SOSPESI_RED, SessionAttributes.PAGINATOR_SOSPESI_RED);
		form.setListaRedDaSospendere(new String[]{});

		context.addInfo("info.success");
		return listaSospesiRed;
	}



	public String ripristinaSospesiRed(Context context) throws Throwable {

		RicercaRedForm form= (RicercaRedForm) context.getForm();

		if (form.getListaRedSospesi() == null
				|| form.getListaRedSospesi().length == 0){
			
			context.addError("errore.raccolta.null");
			return listaSospesiRed;
		}

		List<AbstractDemTO> listaRaccoltaWsTO = context.getModel(SessionAttributes.LIST_RICERCA_RED);

		//lista id sospesi da ripristinare
		List<String> listaIdSospesiRed = Arrays.asList(form.getListaRedSospesi());
		getRicercaRedSospesiManager().deleteSospesiRed(listaIdSospesiRed);

		List<AbstractDemTO> listaRedDaSospendere = new ArrayList<AbstractDemTO>();
		List<AbstractDemTO> listaRedSospesi = new ArrayList<AbstractDemTO>();
		//suddivide la lista di Raccolte Provvisorie proveniente da WS in due liste
		differenziaRaccolteProvvDaWS(listaRaccoltaWsTO, listaRedDaSospendere, listaRedSospesi);

		if (listaRedDaSospendere.size()>0)
			PaginatorUtil.addPaginator(context, listaRedDaSospendere, SessionAttributes.LIST_SOSPENDIBILI_RED, Paginator.PAGE_RANGE_15, SessionAttributes.PAGINATOR_SOSPENDIBILI_RED);
		else
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_SOSPENDIBILI_RED, SessionAttributes.PAGINATOR_SOSPENDIBILI_RED);

		if (listaRedSospesi.size()>0)
			PaginatorUtil.addPaginator(context, 
					listaRedSospesi, SessionAttributes.LIST_SOSPESI_RED, Paginator.PAGE_RANGE_15, SessionAttributes.PAGINATOR_SOSPESI_RED);
		else
			PaginatorUtil.removePaginator(context, SessionAttributes.LIST_SOSPESI_RED, SessionAttributes.PAGINATOR_SOSPESI_RED);
		form.setListaRedSospesi(new String[]{});

		return listaSospesiRed;
	}



	/******metodo per visualizzare i metadati di un fascicolo*****/

	public void modaleDettaglioFascicolo(Context context) throws IOException {

		RicercaRedForm form= (RicercaRedForm) context.getForm();

		boolean LISTA_SUPERIORE = form.getIdRed().startsWith("sup")? true: false;
		String idFascicolo=form.getIdRed();
		Integer idLista=new Integer(idFascicolo.substring(3));

//		List<AbstractDemTO>  listaDettFascWs=context.getModel(SessionAttributes.LIST_RICERCA_RED);
		List<AbstractDemTO>  listaSospendibili=context.getModel(SessionAttributes.LIST_SOSPENDIBILI_RED);
		List<AbstractDemTO>  listaSospesi=context.getModel(SessionAttributes.LIST_SOSPESI_RED);

		List<RaccoltaProvvisoriaRedTO> listaDettFasc=new ArrayList<RaccoltaProvvisoriaRedTO>();

		//recupera il dato della Raccolta selezionata da lista superiore o inferiore
		if (LISTA_SUPERIORE)
		    listaDettFasc.add((RaccoltaProvvisoriaRedTO)listaSospendibili.get(idLista));
		else
		    listaDettFasc.add((RaccoltaProvvisoriaRedTO)listaSospesi.get(idLista));

	    ObjectMapper mapper = new ObjectMapper();

	    context.getResponse().setContentType("application/json");   
	   
	    mapper.writeValue(context.getResponse().getOutputStream(), listaDettFasc);
	}

	
	public String apriDocumentiFascicolo(Context context) throws Throwable{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");

		RicercaRedForm form= (RicercaRedForm) context.getForm();
		List<RaccoltaProvvisoriaRedTO> listaRaccolteProvv=context.getModel(SessionAttributes.LIST_RICERCA_RED);
		String idFascicoloRaccoltaProvvisoria = getParameter(context, "idRed");

		RaccoltaProvvisoriaRedTO rprto = null;
		for (int i=0; i<listaRaccolteProvv.size(); i++) {
			if (idFascicoloRaccoltaProvvisoria.equals(((RaccoltaProvvisoriaRedTO)listaRaccolteProvv.get(i)).getIdFascicoloRaccoltaProvvisoria())) {	
				rprto = (RaccoltaProvvisoriaRedTO)listaRaccolteProvv.get(i);
			    break;
			}
		}
		
		String numDataProtocollo=rprto.getProtocollo().getNumeroProtocollo()+"/"+sdf.format(rprto.getProtocollo().getData());
		context.setDataModel("numDataProtocollo", numDataProtocollo);
		
		context.setDataModel(WebConstants.ID_FASC_RACC_PROVV, idFascicoloRaccoltaProvvisoria);

		ApplicationContext applContext=ApplicationContextProvider.getApplicationContext();
		InitManager inMan =(InitManager )applContext.getBean("initManager");
		ParametriInput paramInp= inMan.leggiParametriInputDemBil();
		
		ResponseDEMBILClient resp= getRicercaRedSospesiManager().wsDocumentiFascicolo(paramInp, rprto);
		RaccoltaProvvisoriaRedTO rp=(RaccoltaProvvisoriaRedTO)resp.getOutputTO();
		DocumentTO docTo=null;
		List<DocumentTO> listDocTO=new ArrayList<DocumentTO> ();
	
		
		String codiceEsito=resp.getEsitoTo().getCodice();
		
		if(codiceEsito.equalsIgnoreCase("OK")) { 
			for (int i = 0; i < rp.getDocumenti().size(); i++) {
				docTo=(DocumentTO)  rp.getDocumenti().get(i);
				docTo.setAmministrazione(rp.getAmministrazione());
				listDocTO.add(docTo);
			}
			
			List<TipoDocumentoTO> listTipoDocumentoIG=getListManager().loadTipoDocumentoIG();
			
			String[] listaTipoAlleg=new String[ rp.getDocumenti().size()];//inserire la dimensione della lista che arriva dal servizio web
			for (int j = 0; j < listaTipoAlleg.length; j++) {
				listaTipoAlleg[j]="tipoAllegati"+j;
			}
			
			form.setListaTipoAllegati(listaTipoAlleg);
			
			List<AnagTipoDecretoTO> listaTipiDecreti=getListManager().loadAnagTipoDecreto();
			context.setDataModel(WebConstants.LIST_TIPI_DECRETI, listaTipiDecreti );
			context.setDataModel(WebConstants.LIST_TIPO_ALLEGATI, listTipoDocumentoIG);
	
			List<EserciziTO> listEsercizi=getListManager().loadEserciziDemCG();
			context.setDataModel(WebConstants.LIST_ANNO_ESE, listEsercizi );
			
			context.setDataModel(WebConstants.LIST_DOC_FASC_SOSP, listDocTO );
	
			
			if( listDocTO.size()>0) {
			    	PaginatorUtil.addPaginator(listDocTO, SessionAttributes.LIST_DOCUMENTI_FASCICOLO_SOSP, Paginator.PAGE_RANGE_15, context); 
			}else {
				  	PaginatorUtil.removePaginator(context, SessionAttributes.LIST_DOCUMENTI_FASCICOLO_SOSP);
				  	ContextHelper.addWarning(context.getRequest(),"warning.noRecord.trovati");    
			}
		}
		else{
			context.addError("error.generic", resp.getEsitoTo().getDescrizione());
			return listaSospesiRed;
		}
		
		return documentiFascicolo;
	}

	@Override
	public String onCaricaAmministrazioni(Context context) throws Throwable {
		RicercaRedForm form= (RicercaRedForm) context.getForm();
		String annoEsercizio=form.getAnnoEse();
		//String protocolloRed=form.getProtocolloRed();
		Utente ut=getUtenteInSessione();
		String idProfilo=ut.getProfiloInUso().getId().toString();
		List<AnagAmminDemTO> listaAmm=null;
		
		if (form.isValid()){
		    //listaAmm=getListManager().getAmminDemByAnnoEseUtenteAndProfilo(annoEsercizio, ut.getUtente().getId().toString(), ut.getProfiloInUso().getId().toString());
			if(idProfilo.equals(PROFILO_DIRIGENTE_UFFICIO) || idProfilo.equals(PROFILO_BILANCISTA)){
				listaAmm=getListManager().getAmminDemByAnnoEseUtenteAndProfilo(annoEsercizio, ut.getUtente().getId().toString(), ut.getProfiloInUso().getId().toString());
			}else{
				 listaAmm=getListManager().getAmminDemByAnnoEse(annoEsercizio);
			}
			
			context.setDataModel(WebConstants.LIST_AMMIN_DEM, listaAmm);
			form.setAnnoEse(annoEsercizio);
		}
		return startView;
	}


	public  String  backToList(Context context) throws Throwable {

		return listaSospesiRed;
	}


	public String pulisciRicercaSospesiRed(Context context) throws Throwable {

		RicercaRedForm form = (RicercaRedForm) context.getForm();		

		form.clean();

		return startView;
	}
	
@Override
public String download(Context context)  throws   Throwable{
		
		List<DocumentTO> listDocFscSosp=context.getModel(WebConstants.LIST_DOC_FASC_SOSP);
		String tipoDownload=context.getRequest().getParameter("tipoDownl");
		//String rigaDocumento=context.getRequest().getParameter("rigaDoc");
		String idDocumento=context.getRequest().getParameter("idDocumento");
		
			DocumentTO to=recuperaDocumentTo(listDocFscSosp, idDocumento, tipoDownload);
				
				
		ApplicationContext applContext=ApplicationContextProvider.getApplicationContext();
		InitManager inMan =(InitManager )applContext.getBean("initManager");
		ParametriInput paramInp= inMan.leggiParametriInputDemBil();
		
		String idDoc=tipoDownload.equals("1")?to.getIdDocumento():to.getIdDocumentoRaccoltaProvvisoria();
		ResponseDEMBILClient respClient=getRicercaRedSospesiManager().wsDownloadDocumento(paramInp, to.getIdFascicolo(), idDoc);
	
		String codiceEsito=respClient.getEsitoTo().getCodice();
		
		String type=null;
		DocumentContentTO docContent=null;
		if(codiceEsito.equalsIgnoreCase("OK")) {
			docContent=(DocumentContentTO)respClient.getOutputTO();
					
		}else {
			context.addError("error.generic", respClient.getEsitoTo().getDescrizione()); 
			return documentiFascicolo;
		}
		
		type=docContent.getMimeType();
	
		context.getResponse().setContentType(type);		
		context.getResponse().setHeader("Content-Disposition","attachment;filename="+docContent.getFileName());
 	
		ServletOutputStream out;	
		out = context.getResponse().getOutputStream();
		out.write(docContent.getContent());

		out.flush();
		out.close();
		
		return null;
 
	}





}