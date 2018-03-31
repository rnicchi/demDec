package it.mef.bilancio.demdec.manager.impl;

import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagAmminDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBO;
import it.almavivaitalia.bilancio.commons.bo.AnagRagionerieDemBOId;
import it.almavivaitalia.bilancio.commons.bo.AnagTipoRiepilogoBO;
import it.almavivaitalia.bilancio.commons.bo.DescDocumentoBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiBOId;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBO;
import it.almavivaitalia.bilancio.commons.bo.DocumentiRedBOId;
import it.almavivaitalia.bilancio.commons.bo.FascicoliBO;
import it.almavivaitalia.bilancio.commons.bo.RiepilogoDatiAnagBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBO;
import it.almavivaitalia.bilancio.commons.bo.SottoFascicoliRedBOId;
import it.almavivaitalia.bilancio.commons.bo.TipoDocumentoBO;
import it.almavivaitalia.bilancio.commons.to.CroTransTO;
import it.almavivaitalia.bilancio.commons.to.CronoValoriTO;
import it.almavivaitalia.bilancio.commons.to.EmailUtenteTO;
import it.almavivaitalia.bilancio.commons.web.security.Utente;
import it.almavivaitalia.bsn.sh.utils.DateUtil;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.EsitoOperazione_type;
import it.mef.bilancio.demdec.dao.AnagAmminDemDao;
import it.mef.bilancio.demdec.dao.AnagStatoFascicoloDao;
import it.mef.bilancio.demdec.dao.AnagTipoRiepilogoDao;
import it.mef.bilancio.demdec.dao.DescDocumentoDao;
import it.mef.bilancio.demdec.dao.DocumentiRedDao;
import it.mef.bilancio.demdec.dao.SottoFascicoliRedDao;
import it.mef.bilancio.demdec.dao.TipoDocumentoDao;
import it.mef.bilancio.demdec.manager.GestioneFadManager;
import it.mef.bilancio.demdec.servizi.client.DEMBILConstants;
import it.mef.bilancio.demdec.servizi.client.InterfacciaAttoDecretoDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ParametriInput;
import it.mef.bilancio.demdec.servizi.client.RequestDEMBILClient;
import it.mef.bilancio.demdec.servizi.client.ResponseDEMBILClient;
import it.mef.bilancio.demdec.servizi.to.DocumentTO;
import it.mef.bilancio.demdec.servizi.to.EsitoTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloAttoDecretoTO;
import it.mef.bilancio.demdec.servizi.to.FascicoloSipatrTO;
import it.mef.bilancio.demdec.to.AmminRagDemTO;
import it.mef.bilancio.demdec.to.DocumentiRedTO;
import it.mef.bilancio.demdec.to.DocumentiTO;
import it.mef.bilancio.demdec.to.FascicoliFadSearhTO;
import it.mef.bilancio.demdec.to.FascicoliTO;
import it.mef.bilancio.demdec.to.LettereIgbTO;
import it.mef.bilancio.demdec.to.RiepilogoDatiAnagTO;
import it.mef.bilancio.demdec.to.SottoFascicoliRedTO;
import it.mef.bilancio.demdec.utils.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class GestioneFadManagerImpl extends GestioneFad2ManagerImpl implements
		GestioneFadManager {

	@Autowired
	private AnagStatoFascicoloDao anagStatoFascicoloDao;

	@Autowired
	private SottoFascicoliRedDao sottofascicoloRedDao;

	@Autowired
	private DocumentiRedDao documentiRedDao;

	@Autowired
	private AnagAmminDemDao anagAmminDemDao;

	@Autowired
	private TipoDocumentoDao tipoDocumentoDao;
	
	@Autowired
	private DescDocumentoDao descDocumentoDao;
	
	@Autowired
	private AnagTipoRiepilogoDao anagTipoRiepilogoDao;

	@Override
	public List<FascicoliTO> getFascicoliFad(FascicoliFadSearhTO to) throws Throwable {
		List<FascicoliTO> ret = getDozerDriver().mapList(getFascicoloDao().findFascicoliFad(to), FascicoliTO.class, "FascicoliFad");
		return ret;

	}

	@Override
	public List<FascicoliTO> getFascicoliGestioneFad(FascicoliFadSearhTO to) throws Throwable {
		List<FascicoliTO> ret = getDozerDriver().mapList(getFascicoloDao().findFascicoliGestioneFad(to), FascicoliTO.class, "FascicoliFad");
		/*
		 * for (int i=0; i < ret.size(); i++){ ret.get(i).aggiornaEstremiStr();
		 * }
		 */
		return ret;

	}
	
	@Override
	public List<FascicoliTO> getFascicoliFadPecPartecipazione(FascicoliFadSearhTO to) throws Throwable {
		List<FascicoliTO> ret = getDozerDriver().mapList(getFascicoloDao().findFascicoliFadPecPartecipazione(to), FascicoliTO.class, "FascicoliFad");
		return ret;

	}

	@Override
	public FascicoliTO getFascicoloFad(Long idFad) throws Throwable {
		FascicoliBO bo = getFascicoloDao().loadById(idFad);
		for (DocumentiBO doc : bo.getDocumentiList()) {
			if (doc.getStatConversione().equalsIgnoreCase("0")) {
				ParametriInput paramInput = leggiParametriInputDemBil();
				RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(paramInput);
				requestDEMBILClient.setIdFascicolo(bo.getCodiGuidFascicolo());
				requestDEMBILClient.setIdDocumento(doc.getCodiGuidDocumentoOrig());
				InterfacciaAttoDecretoDEMBILClient client = new InterfacciaAttoDecretoDEMBILClient();
				String esito = client.getEsitoOperazione(requestDEMBILClient);
				// DocumentTO docResp = (DocumentTO)resp.getOutputTO();
				if (esito.equalsIgnoreCase(EsitoOperazione_type.COMPLETA.getValue())) {
					doc.setStatConversione("OK");
					doc.setStatEsitoConversione(EsitoOperazione_type.COMPLETA.getValue());
				} else if (esito.equalsIgnoreCase(EsitoOperazione_type.ERRORE.getValue())) {
					doc.setStatConversione("KO");
					doc.setStatEsitoConversione(EsitoOperazione_type.ERRORE.getValue());
				} else if (esito.equalsIgnoreCase(EsitoOperazione_type.NONCONVERTIBILE.getValue())) {
					doc.setStatConversione("NA");
					doc.setStatEsitoConversione(EsitoOperazione_type.NONCONVERTIBILE.getValue());
				}
			}
		}
		FascicoliTO to = getDozerDriver().map(bo, FascicoliTO.class, "FascicoloFad");


/*		Integer statoFascicolo = null;
		for (int i = 0; to.getSottoFascicoliRedList().size() > i; i++) {
			statoFascicolo = to.getSottoFascicoliRedList().get(i).getStatStato();
			to.getSottoFascicoliRedList().get(i).setDescStato(anagStatoFascicoloDao.loadDecStatiFascicoloFad(statoFascicolo.toString()));

			// AGGIORNA IL CAMPO DECODIFICA DELLO STATO DEL DOCUMENTO
			for (int x = 0; to.getSottoFascicoliRedList().get(i).getDocumentiRedList().size() > x; x++) {
				to.getSottoFascicoliRedList().get(i).getDocumentiRedList().get(x).setDescStatoDocumento(anagStatoFascicoloDao.loadDecStatiFascicoloFad(to.getSottoFascicoliRedList().get(i).getDocumentiRedList().get(x).getStatDocumento().toString()));
			}
		}*/
		return to;
	}

	@Override
	public ResponseDEMBILClient getFascicoliPatrimonio(String guidFascicolo)
			throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		RequestDEMBILClient requestClient = new RequestDEMBILClient(parametri);
		requestClient.setIdFascicolo(guidFascicolo);
		InterfacciaAttoDecretoDEMBILClient interfaccia = new InterfacciaAttoDecretoDEMBILClient();
		return interfaccia.getFascicoloAttoAllFascicoliSipatr(requestClient);

	}


	@Override
	public EsitoTO modificaAllegatoFAD(FascicoliTO to) throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		InterfacciaAttoDecretoDEMBILClient interfaccia = new InterfacciaAttoDecretoDEMBILClient();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(
				parametri);
		requestDEMBILClient.setIdFascicolo(to.getCodiGuidFascicolo());
		EsitoTO esitoTo = null;

		if (to.getSottoFascicoliRedList() != null
				&& to.getSottoFascicoliRedList().size() > 0) {
			SottoFascicoliRedTO sottoFascTO = to.getSottoFascicoliRedList()
					.get(0);
			if (sottoFascTO.getDocumentiRedList() != null
					&& sottoFascTO.getDocumentiRedList().size() > 0) {
				DocumentiRedTO documentoRedTO = sottoFascTO
						.getDocumentiRedList().get(0);
				requestDEMBILClient.setInputTO(documentoRedTO);
				ResponseDEMBILClient resp = interfaccia
						.modifyMetadatiDocumentoFascicoloAllegatoDecretoIGB(requestDEMBILClient);
				esitoTo = resp.getEsitoTo();
				// PER TEST
				// esitoTo.setCodice("OK");

				if (esitoTo.getCodice().equals(DEMBILConstants.ESITO_OK)) {
					// MODIFICA D_DOCUMENTI_RED
					DocumentiRedBOId boId = new DocumentiRedBOId();
					boId.setFkNumeIdFascicolo(documentoRedTO.getId()
							.getFkNumeIdFascicolo());
					boId.setCodiGuidDocumento(documentoRedTO.getId()
							.getCodiGuidDocumento());
					DocumentiRedBO bo = getDocumentiRedDao().loadById(
							DocumentiRedBO.class, boId);
					DocumentiRedBO old = getDozerDriver().map(bo,
							DocumentiRedBO.class, "DocumentiRedBOBO");
					// Modifico il BO mettendoci i valori passati nel TO
					bo.setFlagVisibilitaCdc01(to.getSottoFascicoliRedList()
							.get(0).getDocumentiRedList().get(0)
							.getFlagVisibilitaCdc01());
					// TipoDocumentoBO tDocBo =
					// getDozerDriver().map(to.getSottoFascicoliRedList().get(0).getDocumentiRedList().get(0).getTipoDocumento(),
					// TipoDocumentoBO.class, "TipoDocumento");
					// bo.setTipoDocumento(tDocBo);

					DescDocumentoBO descDocBo = getDozerDriver().map(
							to.getSottoFascicoliRedList().get(0)
									.getDocumentiRedList().get(0)
									.getDescDocumento(), DescDocumentoBO.class,
							"DescDocumento");
					bo.setDescDocumento(descDocBo);

					// campi di audit
					bo.setRowUpdatedUser(to.getRowUpdatedUser());
					bo.setRowUpdatedDttm(to.getRowUpdatedDttm());
					bo.setRowUpdatedForm(to.getRowUpdatedForm());
					bo.setDataAggiornamento(to.getRowUpdatedDttm());

					bo.getSottoFascicoliRed().setDataAggiornamento(
							to.getRowUpdatedDttm());
					bo.getSottoFascicoliRed().setRowUpdatedDttm(
							to.getRowUpdatedDttm());
					bo.getSottoFascicoliRed().setRowUpdatedUser(
							to.getRowUpdatedUser());
					bo.getSottoFascicoliRed().setRowUpdatedForm(
							to.getRowUpdatedForm());

					bo.getSottoFascicoliRed().getFascicoli()
							.setDataModificaFascicolo(to.getRowUpdatedDttm());
					bo.getSottoFascicoliRed().getFascicoli()
							.setRowUpdatedDttm(to.getRowUpdatedDttm());
					bo.getSottoFascicoliRed().getFascicoli()
							.setRowUpdatedUser(to.getRowUpdatedUser());
					bo.getSottoFascicoliRed().getFascicoli()
							.setRowUpdatedForm(to.getRowUpdatedForm());
					bo.getSottoFascicoliRed().getFascicoli()
							.setDescUtenteModifica(to.getRowUpdatedUser());

					if (bo != null) {
						getDocumentiRedDao().saveOrUpdate(bo);

						// Richiamo cronologico
						getCronologicoManager()
								.salvaCronologico(
										old,// old
										bo,// new
										null,
										null,
										CroTransTO.CRO_TRANS_MODIFICA_METADATI_DOCUMENTI_RED,
										to.getRowUpdatedForm(),
										to.getRowUpdatedUser());

					}

				}

			}
		}
		return esitoTo;
	}

	@Override
	public EsitoTO modificaDocumentoFAD(FascicoliTO to) throws Throwable {

		ParametriInput parametri = leggiParametriInputDemBil();
		InterfacciaAttoDecretoDEMBILClient interfaccia = new InterfacciaAttoDecretoDEMBILClient();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(parametri);
		requestDEMBILClient.setIdFascicolo(to.getCodiGuidFascicolo());
		EsitoTO esitoTo = null;

		if (to.getDocumentiList() != null && to.getDocumentiList().size() > 0) {
			DocumentiTO documentoTO = to.getDocumentiList().get(0);
			// documentoTO.setFlagVisibilitaCdc01(1); non serve più -- viene
			// impostato a seconda dei casi

			requestDEMBILClient.setInputTO(documentoTO);
			ResponseDEMBILClient resp = interfaccia.modifyMetadatiDocumentoFascicoloAttoDecreto(requestDEMBILClient);
			esitoTo = resp.getEsitoTo();

			if (esitoTo.getCodice().equals(DEMBILConstants.ESITO_OK)) {

				// MODIFICA D_DOCUMENTI
				DocumentiBOId boId = new DocumentiBOId();
				boId.setFkNumeIdFascicolo(documentoTO.getId().getFkNumeIdFascicolo());
				boId.setNumeIdDocumento(documentoTO.getId().getNumeIdDocumento());

				DocumentiBO old = getDocumentiDao().loadById(DocumentiBO.class, boId);
				DocumentiBO bo = getDocumentiDao().loadById(DocumentiBO.class, boId);
				// Modifico il BO mettendoci i valori passati nel TO
				bo.setFlagVisibilitaCdc01(documentoTO.getFlagVisibilitaCdc01());

				// CT - Controllo amministrazione selezionata
				if (documentoTO.getAnagAmminDem() == null) {
					bo.setAnagAmminDem(null);
					bo.setAnagRagionerieDem(null);
				} else {
					AnagAmminDemBO ammBo = getDozerDriver().map(documentoTO.getAnagAmminDem(), AnagAmminDemBO.class, "AnagAmmin");
					bo.setAnagAmminDem(ammBo);
					AmminRagDemTO ragTo = getDozerDriver().map(getAmminRagDemDao().findAmminRagDemByAnagAmminDemTO(documentoTO.getAnagAmminDem()), AmminRagDemTO.class, "AmmRag");

					AnagRagionerieDemBOId ragBoId = new AnagRagionerieDemBOId();
					ragBoId.setFkAnnoEse(ragTo.getId().getAnnoEse());
					ragBoId.setNumeRag(Short.parseShort(ragTo.getId().getNumeRag()));
					AnagRagionerieDemBO ragBo = getAnagRagionerieDemDao().loadById(AnagRagionerieDemBO.class, ragBoId);
					bo.setAnagRagionerieDem(ragBo);
				}

				bo.setDescFilename(documentoTO.getDescFilename());
				bo.setTextDescrizione(documentoTO.getTextDescrizione());

				// Set descDocumento
				DescDocumentoBO descDocumentoBO = new DescDocumentoBO();
				descDocumentoBO.setId(documentoTO.getDescDocumento().getId());
				bo.setDescDocumento(descDocumentoBO);

				// campi di audit
				bo.setRowUpdatedUser(to.getRowUpdatedUser());
				bo.setRowUpdatedDttm(to.getRowUpdatedDttm());
				bo.setRowUpdatedForm(to.getRowUpdatedForm());

				bo.setDataAggiornamento(to.getRowUpdatedDttm());
				bo.setFkCodiUtenteAgg(to.getRowUpdatedUser());

				bo.getFascicoli().setDataModificaFascicolo(to.getRowUpdatedDttm());
				bo.getFascicoli().setRowUpdatedDttm(to.getRowUpdatedDttm());
				bo.getFascicoli().setRowUpdatedUser(to.getRowUpdatedUser());
				bo.getFascicoli().setRowUpdatedForm(to.getRowUpdatedForm());
				bo.getFascicoli().setDescUtenteModifica(to.getRowUpdatedUser());

				if (bo != null) {
					getDocumentiDao().saveOrUpdate(bo);

					// *********************
					/* PER IL CRONOLOGICO */

					List<CronoValoriTO> listCronoValori = new ArrayList<CronoValoriTO>();

					// Richiamo cronologico
					getCronologicoManager().salvaCronologico(
									old,// old
									bo,// new
									null,
									listCronoValori,
									CroTransTO.CRO_TRANS_MODIFICA_METADATI_DOCUMENTO_FAD,
									to.getRowUpdatedForm(),
									to.getRowUpdatedUser());

					// *********************
				}
			}

		}

		return esitoTo;
	}


	@Override
	public EsitoTO trasportoVariazioniFascicolo(FascicoliTO src, FascicoliTO dest) throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		InterfacciaAttoDecretoDEMBILClient interfaccia = new InterfacciaAttoDecretoDEMBILClient();
		RequestDEMBILClient requestDEMBILClient = new RequestDEMBILClient(parametri);
		requestDEMBILClient.setIdFascicolo(src.getCodiGuidFascicolo());
		requestDEMBILClient.setIdFascicoloDestinazione(dest.getCodiGuidFascicolo());

		ResponseDEMBILClient response = interfaccia.copyFascicoloAttoDecreto(requestDEMBILClient);

		if (!response.getEsitoTo().getCodice().equals(DEMBILConstants.ESITO_OK)) {
			return response.getEsitoTo();
		}

		FascicoloAttoDecretoTO fascicoloResponse = (FascicoloAttoDecretoTO) response.getOutputTO();

		// FascicoliBO fascicoloOld = getFascicoloDao().loadById(src.getId());
		FascicoliBO fascicoloNew = getFascicoloDao().loadById(dest.getId());

		// String codiRedPrec = "";

		FascicoliBO fascicoloBo = getFascicoloDao().loadById(src.getId());
		fascicoloBo.setRowUpdatedDttm(Calendar.getInstance().getTime());
		fascicoloBo.setRowUpdatedUser(Constants.USER_NSBF_AMM);
		fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_ANNULLATO);

		getFascicoloDao().saveOrUpdate(fascicoloBo);

		if (fascicoloResponse.getAllegatiDecretoIGB() != null) {
			for (DocumentTO document : fascicoloResponse.getAllegatiDecretoIGB()) {
				// AMMINISTRAZIONE
				AnagAmminDemBO anagAmmDemBo;
				AnagAmminDemBOId anagAmmDemBoId = new AnagAmminDemBOId();
				anagAmmDemBoId.setFkAnnoEse(fascicoloResponse.getMetadati().getAnnoDec().shortValue());
				anagAmmDemBoId.setNumeStp(Integer.parseInt(document.getAmministrazione().getCode().substring(0, 2)));
				anagAmmDemBoId.setNumeApp(Integer.parseInt(document.getAmministrazione().getCode().substring(2)));

				anagAmmDemBo = anagAmminDemDao.loadById(anagAmmDemBoId);

				// RAGIONERIA
				AnagRagionerieDemBO ragBo = null;
				if (fascicoloResponse.getMetadati().getUcbRts() != null) {
					// ragBo=new AnagRagionerieDemBO();
					AnagRagionerieDemBOId ragBoId = new AnagRagionerieDemBOId(fascicoloResponse.getMetadati().getAnnoDec().shortValue(),
							Short.parseShort(fascicoloResponse.getMetadati().getUcbRts().getCode()));

					ragBo = getAnagRagionerieDemDao().loadById(ragBoId);

				}
				SottoFascicoliRedBOId boId = new SottoFascicoliRedBOId(document.getCodiIdRed(), dest.getId());
				SottoFascicoliRedBO sottofascicoloRed = sottofascicoloRedDao.loadById(boId);
				if (sottofascicoloRed == null) {
					sottofascicoloRed = new SottoFascicoliRedBO();
					sottofascicoloRed.setId(boId);
					sottofascicoloRed.setRowCreatedDttm(Calendar.getInstance().getTime());
					sottofascicoloRed.setRowCreatedUser(dest.getRowUpdatedUser() != null ? dest.getRowUpdatedUser() : dest.getRowCreatedUser());
					sottofascicoloRed.setRowCreatedForm(dest.getRowUpdatedForm() != null ? dest.getRowUpdatedForm() : dest.getRowCreatedForm());

					sottofascicoloRed.setFascicoli(fascicoloNew);
					sottofascicoloRed.setCodiGuidFascicolo(fascicoloNew.getCodiGuidFascicolo());
					sottofascicoloRed.setStatStato(0);

					sottofascicoloRed.setAnagAmminDem(anagAmmDemBo);
					sottofascicoloRed.setAnagRagionerieDem(ragBo);
					sottofascicoloRed.setNumeRag(ragBo != null ? ragBo.getId().getNumeRag().intValue() : null);

					if (document.getProtocolloRed() != null) {
						sottofascicoloRed.setCodiAooProtocollo(document.getProtocolloRed().getAoo());
						sottofascicoloRed.setNumeProtocollo(document.getProtocolloRed().getNumeroProtocollo());
						sottofascicoloRed.setDescTipoProtocollo(document.getProtocolloRed().getTipo());
						sottofascicoloRed.setDataProtocollo(document.getProtocolloRed().getData());
					}
					sottofascicoloRed.setCodiGuidSFascicolo(document.getIdSottoFascicolo());

					sottofascicoloRed.setDataRed(fascicoloResponse.getDataAggiornamentoFascicoloIGB() != null ? fascicoloResponse.getDataAggiornamentoFascicoloIGB().getTime() : null);
					sottofascicoloRed.setDescUtenteAss(document.getUtenteCreatore().getDescription());
					sottofascicoloRed.setDescUfficioAss(document.getUfficioCreatoreRed().getDescription());

					// TODO da controllare
					sottofascicoloRed.setDescOggettoRed(document.getDescrizione());
					sottofascicoloRed.setDataRed(fascicoloResponse.getDataCreazione());

					sottofascicoloRed.setDescTipoFlusso(document.getTipoFlusso());
					sottofascicoloRed.setDataArrivo(fascicoloResponse.getDataCreazione());

				} else {
					sottofascicoloRed.setRowUpdatedDttm(Calendar.getInstance().getTime());
					sottofascicoloRed.setRowUpdatedUser(dest.getRowUpdatedUser() != null ? dest.getRowUpdatedUser() : dest.getRowCreatedUser());
					sottofascicoloRed.setRowUpdatedForm(dest.getRowUpdatedForm() != null ? dest.getRowUpdatedForm() : dest.getRowCreatedForm());
				}

				sottofascicoloRedDao.saveOrUpdate(sottofascicoloRed);

				// Documento
				DocumentiRedBOId idDocRed = new DocumentiRedBOId();
				idDocRed.setFkNumeIdFascicolo(fascicoloNew.getId());
				idDocRed.setCodiGuidDocumento(document.getIdDocumento());
				DocumentiRedBO documentoRed = documentiRedDao.loadById(idDocRed);

				if (documentoRed == null) {
					documentoRed = new DocumentiRedBO();
					documentoRed.setId(idDocRed);
					documentoRed.setRowCreatedDttm(Calendar.getInstance().getTime());
					documentoRed.setRowCreatedUser(dest.getRowUpdatedUser() != null ? dest.getRowUpdatedUser() : dest.getRowCreatedUser());
					documentoRed.setRowCreatedForm(dest.getRowUpdatedForm() != null ? dest.getRowUpdatedForm() : dest.getRowCreatedForm());
				} else {
					documentoRed.setRowUpdatedDttm(Calendar.getInstance().getTime());
					documentoRed.setRowUpdatedUser(dest.getRowUpdatedUser() != null ? dest.getRowUpdatedUser() : dest.getRowCreatedUser());
					documentoRed.setRowUpdatedForm(dest.getRowUpdatedForm() != null ? dest.getRowUpdatedForm() : dest.getRowCreatedForm());
				}

				documentoRed.setCodiIdRed(document.getCodiIdRed());

				documentoRed.setCodiGuidDocumentoTrasf(document.getDocumentoFileOperazione()!=null?document.getDocumentoFileOperazione().getIdDocumento():null);
				// Da controllare
				documentoRed.setCodiGuidDocOrigProv(document.getIdDocumentoRaccoltaProvvisoria());

				TipoDocumentoBO tipoDoc = tipoDocumentoDao.loadById(document.getTipoDocumento().getCode());
				documentoRed.setTipoDocumento(tipoDoc);

				documentoRed.setStatDocumento(0);

				documentoRed.setAnagAmminDem(anagAmmDemBo);

				documentoRed.setAnagRagionerieDem(ragBo);
				if (ragBo != null) {
					documentoRed.setNumeRag(ragBo.getId().getNumeRag().intValue());
				}

				documentoRed.setFlagVisibilitaCdc01(0);
				documentoRed.setDescFilename(document.getDocumentoContent().getFileName());
				documentoRed.setCodiHash(document.getDocumentoContent().getHash().toString());
				documentoRed.setDescTipoFlusso(document.getTipoFlusso());
				if (document.getProtocollo() != null) {
					documentoRed.setCodiProtocollo(document.getProtocollo().getDescrizioneProtocollo());
				}
				documentoRed.setDataArrivo(DateUtil.getDate(document.getDataDocumento()));
				documentoRed.setDataDocumento(DateUtil.getDate(document.getDataDocumento()));
				documentoRed.setFlagVisibilitaCdc01(document.getCondivisibile()?1:0);
// non presente				documentoRed.setDataAggiornamento(DateUtil.getDate(document.ge));

				documentoRed.setCodiMimeTypeOrig(document.getDocumentoContent().getMimeType());
				List<DescDocumentoBO> descDoc = descDocumentoDao.loadByTipoDocumentoDescrizione(tipoDoc.getId(), document.getDescrizione());
				documentoRed.setDescDocumento(descDoc!=null && descDoc.size()>0?descDoc.get(0):null);

				documentiRedDao.saveOrUpdate(documentoRed);

			}
		}

		documentiRedDao.deleteByFascicolo(src.getId());
		sottofascicoloRedDao.deleteByNumeIdFascicolo(src.getId());

		return response.getEsitoTo();
	}

	@Override
	public EsitoTO sospensioneFascicolo(FascicoliTO src) throws Throwable {

		EsitoTO esito = new EsitoTO();
		FascicoliBO fascicoloBo = getFascicoloDao().loadById(src.getId());

		if (fascicoloBo != null) {
			// Set dello stato a chiuso/sospeso(5)
			fascicoloBo.setStatStato(Constants.STATO_FASCICOLO_CHIUSO_SOSPESO);
			fascicoloBo.setRowUpdatedDttm(new Date());
			fascicoloBo.setRowUpdatedUser(Constants.USER_NSBF_AMM);
			getFascicoloDao().saveOrUpdate(fascicoloBo);

			// ChangeStatoFascicolo
			esito = changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(), Constants.STATO_FAD_CHIUSO);

			// Controllo esito
			if (esito.getCodice().equals(DEMBILConstants.ESITO_OK)) {

				// Invio email PEC
				List<EmailUtenteTO> addressEmailList = getUtenteDao().findEmailUserPecRichSospensioneByIdFascicolo(src.getId());
				Utente utente = new Utente(Constants.USER_NSBF_AMM);

				for (EmailUtenteTO address : addressEmailList) {
					getMailManager().invioPecDaFunzione(Constants.FUNZIONE_SOSPENSIONE_DECRETO, utente, address.getEmailUtente());
				}
			}
		} else {
		}

		return esito;
		// return changeStatoFascicoloAttoDecreto(src.getCodiGuidFascicolo(),
		// Constants.STATO_FAD_CHIUSO);
	}

	@Override
	public List<DocumentTO> getDocumentiPatrimonio(String guidFascicoloFad,	String guidFascicoloSipatr) throws Throwable {
		ParametriInput parametri = leggiParametriInputDemBil();
		RequestDEMBILClient requestClient = new RequestDEMBILClient(parametri);
		requestClient.setIdFascicolo(guidFascicoloFad);
		requestClient.setIdSottofascicolo(guidFascicoloSipatr);
		FascicoloSipatrTO to = new FascicoloSipatrTO();
		to.setIdFascicoloFAD(guidFascicoloFad);
		to.setIdFascicoloSipatr(guidFascicoloSipatr);
		requestClient.setInputTO(to);
		InterfacciaAttoDecretoDEMBILClient interfaccia = new InterfacciaAttoDecretoDEMBILClient();
		return ((FascicoloSipatrTO) interfaccia.getFascicoloSipatr(
				requestClient).getOutputTO()).getDocumenti();
	}

	@Override
	public List<FascicoliTO> findFascicoliFadByAnno(String anno) throws Throwable {

		List<FascicoliBO> boList = getFascicoloDao().findFascicoliFadByAnno(anno);

		return getDozerDriver().mapList(boList, FascicoliTO.class, "FascicoliFad");

	}

	public EsitoTO rielaborazioneFascicolo(FascicoliTO src, FascicoliTO dest, Integer tipoElaborazione) throws Throwable {

		EsitoTO esitoTO;
		switch (tipoElaborazione) {
		case 1:
			esitoTO = riaperturaFascicolo(src);
			break;

		case 2:
			esitoTO = sospensioneFascicolo(src);
			break;

		case 3:
			esitoTO = revocaSospensioneFascicolo(src);
			break;

		case 4:
			esitoTO = trasportoVariazioniFascicolo(src, dest);
			break;

		default:
			esitoTO = new EsitoTO(DEMBILConstants.ESITO_KO, "Errore durante l'eleborazione, elaborazione non trovata");
			break;
		}

		return esitoTO;
	}
	
	public RiepilogoDatiAnagBO findFascicoloAggiornato(long id) throws Throwable
	{
		RiepilogoDatiAnagBO fascAggiornato = getFascicoloDao().findFascicoloAggiornato(id);
	
		return fascAggiornato;
	}
	
	public RiepilogoDatiAnagTO findFascicoloAggiornatoTO(long id) throws Throwable
	{
		RiepilogoDatiAnagTO fascAggiornatoTO = null;
		
		RiepilogoDatiAnagBO fascAggiornatoBO = getFascicoloDao().findFascicoloAggiornato(id);
		
		if(fascAggiornatoBO != null)
		{
			fascAggiornatoTO = getDozerDriver().map(fascAggiornatoBO, RiepilogoDatiAnagTO.class, "RiepilogoDatiAnag");
			
			fascAggiornatoTO.setBinaIntReport(fascAggiornatoBO.getBinaIntReport());//Blob escluso da RiepilogoDatiAnag.xml per dozer
		}
		
		return fascAggiornatoTO;
	}
	
	public RiepilogoDatiAnagBO saveAggiornamentoFascicolo(RiepilogoDatiAnagBO bo) throws Throwable
	{
		
		RiepilogoDatiAnagBO fascAggiornato = getFascicoloDao().saveAggiornamentoFascicolo(bo);
		
		return fascAggiornato;
	}
	
	public RiepilogoDatiAnagTO saveAggiornamentoFascicoloTO(RiepilogoDatiAnagTO to) throws Throwable
	{
		AnagTipoRiepilogoBO tipo = anagTipoRiepilogoDao.loadById(to.getAnagTipoRiepilogo().getId());
				
				//findAnagTipoRiepilogoBOById(to.getAnagTipoRiepilogo().getId());
		
		RiepilogoDatiAnagBO fascAggiornatoBo = getFascicoloDao().saveAggiornamentoFascicoloTO(to, tipo);
		
		RiepilogoDatiAnagTO fascAggiornatoTo = getDozerDriver().map(fascAggiornatoBo, RiepilogoDatiAnagTO.class, "RiepilogoDatiAnag");
		
		fascAggiornatoTo.setBinaIntReport(to.getBinaIntReport());// il blob è escluso dal dozer
		
		return fascAggiornatoTo;
	}

	@Override
	public void invioAlFad(List<LettereIgbTO> listaLettere, String user, String nomeFunzione) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
