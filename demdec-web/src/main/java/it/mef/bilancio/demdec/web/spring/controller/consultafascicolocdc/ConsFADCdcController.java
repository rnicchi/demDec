package it.mef.bilancio.demdec.web.spring.controller.consultafascicolocdc;

import it.almavivaitalia.bilancio.commons.to.AnagAmminDemTO;
import it.almavivaitalia.bilancio.commons.to.AnagUfficiTO;
import it.almavivaitalia.bilancio.commons.to.UtenteTO;
import it.almavivaitalia.bsn.sh.paginator.Paginator;
import it.almavivaitalia.bsn.sh.utils.PaginatorUtil;
import it.almavivaitalia.bsn.sh.utils.ParseUtil;
import it.almavivaitalia.bsn.sh.utils.StringUtil;
import it.almavivaitalia.web.sh.utils.Context;
import it.almavivaitalia.web.sh.utils.ContextHelper;
import it.mef.bilancio.demdec.manager.ConsFADCdcManager;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloSipatrTO;
import it.mef.bilancio.demdec.to.AbstractDemTO;
import it.mef.bilancio.demdec.to.AnagTipologiaDecretoTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.to.TipoDocumentoTO;
import it.mef.bilancio.demdec.web.spring.form.ConsFADCdcForm;
import it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping;
import it.mef.bilancio.demdec.web.spring.utils.FileUtil;
import it.mef.bilancio.demdec.web.spring.utils.NomeFunzioneConstants;
import it.mef.bilancio.demdec.web.spring.utils.SessionAttributes;
import it.mef.bilancio.demdec.web.spring.utils.WebConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



//@Controller
@RequestMapping(value = ConstantsRequestMapping.CONSULTA_FASCICOLO_CDC)
//@PreAuthorize("hasRole('"+NomeFunzioneConstants.CONSULTAZIONE_CDC+"')")
public class ConsFADCdcController extends ConsFADCdcParentController implements WebConstants, SessionAttributes{
	
	
	@Autowired
	private ConsFADCdcManager consFadCdcManager;


	
	public String  onSalvaDatiProtEntrataCdc(Context context) throws Throwable {
		ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		FascicoliTO fascicoloTo =context.getModel(FASCICOLO_SELEZIONATO);
		
		if(!form.isValid()){
			return getFascicoloFadView();
		}
		
		fascicoloTo.setNumeProtRicezioneCdc(form.getNumeProtEntrataMod());
		
		try{
			fascicoloTo.setDataRicezioneCdc(sdf.parse(form.getDataProtEntrataMod()));
		}catch(ParseException exc){
			fascicoloTo.setDataRicezioneCdc(sdf2.parse(form.getDataProtEntrataMod()));
		}
		
		fascicoloTo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloTo.setRowUpdatedForm(NomeFunzioneConstants.CONSULTAZIONE_CDC);
		fascicoloTo.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER, context.getRequest())).getCodiUtente());
		
		boolean res=consFadCdcManager.salvaDatiProtEntrataCdc(fascicoloTo);
		
		if(res){
			context.addInfo("info.update.success");
		}
		else{
			context.addWarning("warning.noupdate");
		}
		
		return getFascicoloFadView();
	}
	
	
	public String  onSalvaDatiProtUscitaCdc(Context context) throws Throwable {
		ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		FascicoliTO fascicoloTo =context.getModel(FASCICOLO_SELEZIONATO);
		
		if(!form.isValid()){
			return getFascicoloFadView();
		}
		
		fascicoloTo.setNumeProtRegistrazioneCdc(form.getNumeProtUscitaMod());
		
		try{
			fascicoloTo.setDataRegistrazioneCdc(sdf.parse(form.getDataProtUscitaMod()));
		}catch(ParseException exc){
			fascicoloTo.setDataRegistrazioneCdc(sdf2.parse(form.getDataProtUscitaMod()));
		}
		
		fascicoloTo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloTo.setRowUpdatedForm(NomeFunzioneConstants.CONSULTAZIONE_CDC);
		fascicoloTo.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER, context.getRequest())).getCodiUtente());
		
		boolean res=consFadCdcManager.salvaDatiProtUscitaCdc(fascicoloTo);
		
		if(res){
			context.addInfo("info.update.success");
		}
		else{
			context.addWarning("warning.noupdate");
		}
		
		return getFascicoloFadView();
	}
	
	
	public String  onSalvaDatiRegistrazioneCdc(Context context) throws Throwable {
		ConsFADCdcForm form= (ConsFADCdcForm) context.getForm();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
		FascicoliTO fascicoloTo =context.getModel(FASCICOLO_SELEZIONATO);
		
		if(!form.isValid()){
			return getFascicoloFadView();
		}
		
		fascicoloTo.setNumeRgistrazioneCdc(Long.valueOf(form.getNumeRegistrazioneCdc()));
		
		fascicoloTo.setNumeUfficioCdc(Integer.valueOf(form.getNumeUfficioCdc()));
		
		try{
			fascicoloTo.setDataRegistrazioneCdc(sdf.parse(form.getDataRegistrazioneCdc()));
		}catch(ParseException exc){
			fascicoloTo.setDataRegistrazioneCdc(sdf2.parse(form.getDataRegistrazioneCdc()));
		}
		
		fascicoloTo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloTo.setRowUpdatedForm(NomeFunzioneConstants.CONSULTAZIONE_CDC);
		fascicoloTo.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER, context.getRequest())).getCodiUtente());
		
		boolean res=consFadCdcManager.salvaDatiRegistrazioneCdc(fascicoloTo);
		
		if(res){
			context.addInfo("info.update.success");
		}
		else{
			context.addWarning("warning.noupdate");
		}
		
		return getFascicoloFadView();
	}
	
	
	public String  onSalvaDataPresaCaricoCdc(Context context) throws Throwable {
		FascicoliTO fascicoloTo =context.getModel(FASCICOLO_SELEZIONATO);
		
		fascicoloTo.setDataPresaCaricoCdc(Calendar.getInstance().getTime());
	
		fascicoloTo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloTo.setRowUpdatedForm(NomeFunzioneConstants.CONSULTAZIONE_CDC);
		fascicoloTo.setRowUpdatedUser(((UtenteTO) ContextHelper.getModel(OBJECT_USER, context.getRequest())).getCodiUtente());
		
		boolean res=consFadCdcManager.salvaDataPresaCaricoCdc(fascicoloTo);
		
		if(res){
			context.addInfo("info.update.success");
		}
		else{
			context.addWarning("warning.noupdate");
		}
		
		return getFascicoloFadView();
	}
	
	
	
	public String onApriFascicoloFadCdc(Context context) throws Throwable{
		PaginatorUtil.removePaginator(context, LIST_SOTTO_FASCICOLI_RED, SOTTO_FASCICOLI_RED_PAGINATOR);
		PaginatorUtil.removePaginator(context, LIST_SOTTO_FASCICOLI_PAT, SOTTO_FASCICOLI_PAT_PAGINATOR);
		ConsFADCdcForm form = context.getForm();
		//GestioneFascicoloFadForm form = (GestioneFascicoloFadForm)context.getForm();
		//ConsultaFascicoloFadForm formPadre = context.getForm();
		//GestioneFascicoloFadForm form = (GestioneFascicoloFadForm)formPadre;
		String idFad = getParameter(context, "idFad");
		if (idFad==null){
			if(context.getModel(WebConstants.ID_FAD_APERTO)==null){
				context.addError("error.generic" );
			}else{
				idFad=(String)context.getModel(WebConstants.ID_FAD_APERTO);
			}
		}else{
			context.setDataModel(WebConstants.ID_FAD_APERTO, idFad);
		}
		List<FascicoliTO> listTo = new ArrayList<FascicoliTO>();
		FascicoliTO to = getGestioneFadManager().getFascicoloFad(ParseUtil.getLong(idFad));
		
		/** recupero i documenti del fad **/
		List<DocumentiTO> documentiList =getConsFADCdcManager().getDocumentiByIdFadFlgVisCdc(Long.valueOf(idFad), Long.parseLong(""+1));
		
		for (DocumentiTO documentiTO : documentiList) {//TODO verificare con il dozer
			documentiTO.setFascicoli(null);
		}
		
		to.setDocumentiList(documentiList);
		
		listTo.add(to);
		context.setDataModel(FASCICOLO_SELEZIONATO, to);
		///////////////
		// TIPOLOGIA //
		///////////////
		List<AnagTipologiaDecretoTO> listaTipologiaCurr = new ArrayList<AnagTipologiaDecretoTO>();
		List<AnagTipologiaDecretoTO> listaTipologia = getListManager().tipologiaDecretoList(Integer.parseInt(to.getAnagTipoDecreto().getId()));
		for (AnagTipologiaDecretoTO elem : listaTipologia){
			if (elem.getId().equals(to.getAnagTipologiaDecreto().getId())){
				listaTipologiaCurr.add(elem);
			}
		}
		context.setDataModel(LIST_TIPOLOGIA_DECRETO, listaTipologiaCurr);
		/////////////////////
		// AMMINISTRAZIONE //
		/////////////////////
		// MI IMPOSTO NELLA LISTA SELEZIONATE LA LISTA DELLE AMINISTRAZIONI DAL TO SELEZIONATO
		List<AnagAmminDemTO> listaAmmSelected=to.getAnagAmminDemList();
		List<AnagAmminDemTO> listaAmmSelRow=new ArrayList<AnagAmminDemTO>();
		for(int y=0; y<listaAmmSelected.size(); y++){
			AnagAmminDemTO elem = listaAmmSelected.get(y);
			elem.setRowIndex(y);
			listaAmmSelRow.add(elem);
		}
		context.setDataModel(WebConstants.LIST_SELECTED_AMMS, listaAmmSelRow);
		// ORA DEVO IMPOSTARMI GLI INDICI GIUSTI DELLE SELEZIONATE
		// PER FARE CIO' MI CARICO LA LISTA DELLE AMMINISTRAZIONI
		String annoEsercizio=form.getAnnoDecreto()==null?to.getEserciziDem().getId().toString():form.getAnnoDecreto();
		List<AnagAmminDemTO> listaAmm=getListManager().getAmminDemCentraliByAnnoEse(annoEsercizio);
        // E MI RICAVO GLI ID DALLA LISTA AMMINISTRAZIONI CERCANDO QUELLI SELEZIONATI
		String[] indexes = new String[listaAmmSelected.size()];
		for (int i = 0; i<listaAmmSelected.size(); i++){
			for (int x = 0; x<listaAmm.size(); x++){
				if(listaAmm.get(x).getDescAmm().equals(listaAmmSelected.get(i).getDescAmm())){
					indexes[i] = StringUtil.getString(x+1);
				}
			}
        }
		form.setAmmRows(indexes);
		context.setDataModel(WebConstants.LIST_ROWS, indexes);
		
		/////////////
		// UFFICIO //
		/////////////
		List<AnagUfficiTO> listaUfficiCurr = new ArrayList<AnagUfficiTO>();
		List<AnagUfficiTO> listaUffici = getListManager().loadAnagUfficiAttivi();
		for (AnagUfficiTO uff : listaUffici){
			if (uff.getId().equals(to.getUfficioCapofila().getId())){
				listaUfficiCurr.add(uff);
			}
		}
		context.setDataModel(SessionAttributes.LIST_ANAG_UFF, listaUfficiCurr); 
		//context.setDataModel(SessionAttributes.LIST_TIPOLOGIA_DECRETO, to.getAnagTipologiaDecreto());
		//context.setDataModel(SessionAttributes.LIST_ANAG_UFF, to.getUfficioCapofila());
		
		List<SottoFascicoliRedTO> listaSfRed=getConsFADCdcManager().getSottoFascicoliRedByIdFad(Long.valueOf(idFad));
		
		List<SottoFascicoliRedTO> listaSfRedToView=new ArrayList<SottoFascicoliRedTO>();
		
		List<DocumentiRedTO> listaDocRedToView=null;
		
		for (SottoFascicoliRedTO sottoFascicoliRedTO : listaSfRed) {
			//SottoFascicoliRedTO sfRedTo=null;
			listaDocRedToView=new ArrayList<DocumentiRedTO>();
			for (DocumentiRedTO docRedTO : sottoFascicoliRedTO.getDocumentiRedList()) {
				if(  docRedTO.getFlagVisibilitaCdc01().compareTo(new Integer(1))==0){
					listaDocRedToView.add(docRedTO);
				}
			}
			sottoFascicoliRedTO.setDocumentiRedList(listaDocRedToView);
			if(listaDocRedToView.size()>0){
				listaSfRedToView.add(sottoFascicoliRedTO);
				sottoFascicoliRedTO.setDescStato(getListManager().loadDescStatiFascicoliRed(sottoFascicoliRedTO.getStatStato().toString()));
			}
		}
		
		//Imposto i campi editabili della form
		form.setAmministrazione(to.getAmministrazione());
		//form.setAmministrazioneMod(to.getAmministrazione());
		form.setAnnoDecreto(to.getEserciziDem().getId().toString());
		form.setNumeDecreto(to.getNumeNumDecreto().toString());
		form.setDescDecreto(to.getDescDecreto());
		form.setNumePat(to.getNumePatrimonio()==null?null:to.getNumePatrimonio().toString());
		//form.setNumePatMod(to.getNumePatrimonio()==null?null:to.getNumePatrimonio().toString());
		form.setStato(to.getStatStato().toString());
		String descStato=getListManager().loadDecStatiFascicoliFad(to.getStatStato().toString());
		form.setDescStato(descStato);
		to.setDescStato(descStato);
		form.setTipoDecreto(to.getAnagTipoDecreto().getId());
		form.setDecTipoDecreto(to.getAnagTipoDecreto().getDescSigla());
		form.setTipologiaDecreto(to.getAnagTipologiaDecreto().getId().toString());
		//form.setTipologiaDecretoMod(to.getAnagTipologiaDecreto().getId().toString());
		form.setUfficio(to.getUfficioCapofila().getId().toString());
		//form.setUfficioMod(to.getUfficioCapofila().getId().toString());
		form.setUfficioCreatore(to.getUfficioCreatore().getDescUfficio());
		form.setDataCreazione(to.getDataCreazioneFascicoloFormatted());
		form.setCreatoDa(to.getDescUtenteCreatore());
		form.setDataModifica(to.getDataModificaFascicoloFormatted());
		form.setModificatoDa(to.getDescUtenteModifica());
		form.setDataInvioCdc(to.getDataInvioCdcFormatted());
		form.setNumeProtEntrata(to.getNumeProtRicezioneCdc());
		form.setDataProtEntrata(to.getDataRicezioneCdcFormatted());
		form.setNumeProtUscita(to.getNumeProtRegistrazioneCdc());
		form.setDataProtUscita(to.getDataRegistrazioneCdcFormatted());
		form.setDataPresaInCarico(to.getDataPresaCaricoCdcFormatted());
		//
		List<AbstractDemTO> fascicoliPat = new ArrayList<AbstractDemTO>();
		if(to.getNumePatrimonio()!=null){
			fascicoliPat = getGestioneFadManager().getFascicoliPatrimonio(to.getCodiGuidFascicolo()).getListoutputTO();
		}
		
		
		
		/** simulazione **/   //TODO togliere
	/*	List<FascicoloSipatrTO> toList=new ArrayList<FascicoloSipatrTO>();
		FascicoloSipatrTO toMock=new FascicoloSipatrTO();
		toMock.setAmministrazione(new CodeDescriptionTO("","amm prova pat"));
		toMock.setDescrizione("descr prova pat");
		toMock.setRagioneria(new CodeDescriptionTO("","ragionerai prova pat"));
		toMock.setDataCreazione("11/11/2005");
		toMock.setIdentificativoSIPATR("ident. sipatr prova");
		toMock.setTitolo("titolo sipatr prova");
		toMock.setStatoFascicoloDocumentale("stato fascic documentale sipatr prova");
		toMock.setStatoFascicoloSIPATR("statoFascicoloSIPATR sipatr prova");
		toMock.setSistemaProduttore("sistemaProduttore sipatr prova");
		
		fascicoliPat=new ArrayList<AbstractDemTO>();
		fascicoliPat.add(toMock);
		
		to.setNumePatrimonio(new Short("5"));*/
		/** fine simulazione **/
		
		
		
		
		if (!StringUtil.isEmpty(listTo.get(0))){
			PaginatorUtil.addPaginator(context, listTo, LIST_SOTTO_FASCICOLI_FAD, Paginator.PAGE_RANGE_15, SOTTO_FASCICOLI_FAD_PAGINATOR);
		}
		if (!StringUtil.isEmpty(to.getSottoFascicoliRedList())){
			PaginatorUtil.addPaginator(context, listaSfRedToView, LIST_SOTTO_FASCICOLI_RED, Paginator.PAGE_RANGE_15, SOTTO_FASCICOLI_RED_PAGINATOR);
		}
		if (to.getNumePatrimonio()!=null&&!StringUtil.isEmpty(fascicoliPat)){
			PaginatorUtil.addPaginator(context, fascicoliPat, LIST_SOTTO_FASCICOLI_PAT, Paginator.PAGE_RANGE_15, SOTTO_FASCICOLI_PAT_PAGINATOR);
		}
		return getFascicoloFadView();
	}
	
	
	
	public String onApriDocumentiFadCdc(Context context) throws Throwable{
		PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_FAD,DOCUMENTI_FAD_PAGINATOR);
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		
//		Short eseGest=null;
//		List<EserciziTO> eseList=listManager.loadEserciziDemCG();
//		
//		for (EserciziTO eserciziTO : eseList) {
//			if(eserciziTO.getStatTipoEse().equals(CommonSessionAttributes.STAT_TIPO_ESE_GEST)){
//				eseGest=eserciziTO.getId();
//			}
//		}
		
		context.setDataModel(WebConstants.LIST_TIPO_DOC, getListManager().loadTipoDocumentoAD());
		context.setDataModel(WebConstants.LIST_AMMIN_DEM, getListManager().getAmminDemCentraliByAnnoEse(to.getEserciziDem().getId().toString()));
		
		
		if (!StringUtil.isEmpty(to.getDocumentiList())){
			PaginatorUtil.addPaginator(context, to.getDocumentiList(), LIST_DOCUMENTI_FAD, Paginator.PAGE_RANGE_15, DOCUMENTI_FAD_PAGINATOR);
			return getDocumentiFadView();
		}
		context.addWarning("warning.empty");
		return getDocumentiFadView();
	}
	
	public String onScaricaPdfFadCdc(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentiTO doc = null;
		String rowNum = context.getCommandParameter("scaricaPdfFadCdc");
		List<DocumentiTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_FAD);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum)-1);
		}
		res = getDocumentiManager().wsDownloadDocumentoFascicoloAttoDecreto(doc.getCodiGuidFascicolo(), doc.getCodiGuidDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return getDocumentiFadView();
		}

		return null;
	}
	
	public String onScaricaOrigFadCdc(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentiTO doc = null;
		String rowNum = context.getCommandParameter("scaricaOrigFadCdc");
		List<DocumentiTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_FAD);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum)-1);
		}
		res = getDocumentiManager().wsDownloadDocumentoFascicoloAttoDecreto(doc.getCodiGuidFascicolo(), doc.getCodiGuidDocumentoOrig()!=null?doc.getCodiGuidDocumentoOrig():doc.getCodiGuidDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return getDocumentiFadView();
		}

		return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public String onApriDocumentiFascicoloRedCdc(Context context) throws Throwable{
		PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_RED, DOCUMENTI_RED_PAGINATOR);
//		ConsultaFascicoloFadForm form = context.getForm();
		String rowNum = getParameter(context, "rowNum");
		if (rowNum==null){
			context.addError("error.generic" );
		}
		SottoFascicoliRedTO to = ((List<SottoFascicoliRedTO>)context.getModel(LIST_SOTTO_FASCICOLI_RED)).get(Integer.parseInt(rowNum)-1);
		context.setDataModel(SessionAttributes.SOTTO_FASCICOLO_RED, to);
		if (!StringUtil.isEmpty(to.getDocumentiRedList())){
			List<TipoDocumentoTO> listTipoDocumentoIG=getListManager().loadTipoDocumentoIG();
			context.setDataModel(WebConstants.LIST_TIPO_ALLEGATI, listTipoDocumentoIG);
			PaginatorUtil.addPaginator(context, to.getDocumentiRedList(), LIST_DOCUMENTI_RED, Paginator.PAGE_RANGE_15, DOCUMENTI_RED_PAGINATOR);
			return getDocumentiRedView();
		}
		context.addWarning("warning.empty");
		return getFascicoloFadView();
	}
	
	public String onScaricaOrigRedCdc(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentiRedTO doc = null;
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		String rowNum = context.getCommandParameter("scaricaOrigRedCdc");
		List<DocumentiRedTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_RED);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum)-1);
		}
		res = getDocumentiManager().wsDownloadDocumentoFascicoloAllegatoIGB(to.getCodiGuidFascicolo(), doc.getId().getCodiGuidDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return getDocumentiRedView();
		}

		return null;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public String onApriDocumentiFascicoloPatCdc(Context context) throws Throwable{
		PaginatorUtil.removePaginator(context, LIST_DOCUMENTI_PAT, DOCUMENTI_PAT_PAGINATOR);
//		ConsultaFascicoloFadForm form = context.getForm();
		String rowNum = getParameter(context, "rowNum");
		if (rowNum==null){
			context.addError("error.generic" );
		}
		FascicoliTO toFad = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		FascicoloSipatrTO to = ((List<FascicoloSipatrTO>)context.getModel(LIST_SOTTO_FASCICOLI_PAT)).get(Integer.parseInt(rowNum)-1);
		List<DocumentTO> docList = getGestioneFadManager().getDocumentiPatrimonio(toFad.getCodiGuidFascicolo(),to.getIdFascicoloSipatr());//TODO scommentare
		
		/**simulazione**/ //TODO togliere
	/*	List<DocumentTO> docList=new ArrayList<DocumentTO>();
		DocumentTO docTo=new DocumentTO();
		docTo.setIdFascicolo(to.getIdFascicoloSipatr());
		docTo.setIdSottoFascicolo("8d135734-fdfb-442f-9af4-4989061f03d8");
		docTo.setDescrizione("descr file patr prova");
		docTo.setAmministrazione(new CodeDescriptionTO("","desc amm doc patr prova"));
		docTo.setUcbRts(new CodeDescriptionTO("","desc ucb/Rts patr prova"));
		docTo.setProtocollo(new ProtocolloTO(new java.util.Date(), "", "5000"));
		docTo.setDataCreazione("23/08/1985");
		docTo.setSistemaProduttore("Sistema Produttore doc patr prova");
		docTo.setDataDocumento("20/02/1992");
		docTo.setTipoDocumento(new CodeDescriptionTO("","tipo doc patr prova"));
		docTo.setDescDocumento(new CodeDescriptionTO("","descr doc patr prova"));
		docList.add(docTo);*/
		/**fine simulazione**/
		
		if (!StringUtil.isEmpty(docList)){
			PaginatorUtil.addPaginator(context, docList, LIST_DOCUMENTI_PAT, Paginator.PAGE_RANGE_15, DOCUMENTI_PAT_PAGINATOR);
			return getDocumentiPatView();
		}
		context.addWarning("warning.empty");
		return getFascicoloFadView();
	}
	
	
	
	public String onScaricaOrigPatCdc(Context context) throws Throwable{
		ResponseDEMBILClient res = null;
		DocumentTO doc = null;
		FascicoliTO to = (FascicoliTO)context.getModel(FASCICOLO_SELEZIONATO);
		String rowNum = context.getCommandParameter("scaricaOrigPatCdc");
		List<DocumentTO> listDocAttoDecreto = context.getModel(LIST_DOCUMENTI_PAT);
		
		if(!listDocAttoDecreto.isEmpty() && rowNum != null && rowNum != "" ){
			doc = listDocAttoDecreto.get(Integer.parseInt(rowNum)-1);
		}
		res = getDocumentiManager().wsDownloadDocumentoFascicoloSIPATRAttoDecreto(to.getCodiGuidFascicolo(), doc.getIdSottoFascicolo(), doc.getIdDocumento());
		
		if(res.getEsitoTo().getCodice().equalsIgnoreCase("OK")){
			FileUtil.downloadFromResponseWs(res, context);
			
		}else{
			context.addError("error.ws.download.fascicolo.atto.decreto", res.getEsitoTo().getDescrizione());
			return getDocumentiPatView();
		}

		return null;
	}
	
	public String onBackFromDocFad(Context context)throws Throwable{
		context.setDataModel(OPEN_DETT_FAD, "FAD");
		context.removeDataModel(OPEN_DETT_RED);
		context.removeDataModel(OPEN_DETT_PATR);
		return this.onApriFascicoloFadCdc(context);
	}

	public String onBackFromDocRed(Context context)throws Throwable{
		context.removeDataModel(OPEN_DETT_FAD);
		context.setDataModel(OPEN_DETT_RED, "RED");
		context.removeDataModel(OPEN_DETT_PATR);
		return this.onApriFascicoloFadCdc(context);
	}

	public String onBackFromDocPatr(Context context)throws Throwable{
		context.removeDataModel(OPEN_DETT_FAD);
		context.removeDataModel(OPEN_DETT_RED);
		context.setDataModel(OPEN_DETT_PATR, "PATR");
		return this.onApriFascicoloFadCdc(context);
	}
	
//	public String onNuovaRicercaCdc(Context context)throws Throwable{
//		ConsFADCdcForm form = context.getForm();
//		form.reset();
//		context.removeDataModel(LIST_TIPOLOGIA_DECRETO);
//		context.removeDataModel(SessionAttributes.LIST_AMMIN_DEM);
//		context.removeDataModel(LIST_ANAG_CDR_DEM);
//		return getStartView();
//	}
//	
//	public String onBackToFadSearchCdc(Context context)throws Throwable{
//		context.removeDataModel(FASCICOLO_SELEZIONATO);
//		return getAfterRicercaView();
//	}
//	
//	public String onBack(Context context)throws Throwable{
//		return getFascicoloFadView();
//	}
	
}
