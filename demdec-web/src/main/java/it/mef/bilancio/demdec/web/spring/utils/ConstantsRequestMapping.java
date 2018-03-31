package it.mef.bilancio.demdec.web.spring.utils;

import it.almavivaitalia.bilancio.commons.web.utils.CommonConstantsRequestMapping;

/*
 * Qui vengono definite le costanti per il mapping dei 
 * controllers specifici dell'applicazione
 */

public interface ConstantsRequestMapping extends CommonConstantsRequestMapping {
	public final static String SBSJ=REDIRECT_URL;
	public final static String DLS = REDIRECT_URL;
	public final static String UPLOAD_DEC= "/private/uploadDec.do";
	public final static String RICERCA_RACCOLTE_PROVVISORIE= "/private/ricercaRed.do";
	public final static String RICERCA_RED_MODALI= "/private/ricercaRedModali.do";
	
	public final static String MAIL = "/private/mail.do";
	public final static String LISTA_MSG_INVIATI = "/private/listaMsgInviati.do";
	
	public final static String INT_CRONOLOGICO = "/private/intCronologico.do";
	
	public final static String RIELABORAZIONE_FASCICOLO = "/private/rielaborazioneFascicolo.do";
	
	public final static String PROVA= "/private/prova.do";
	public final static String RICERCA_FASCICOLO_DECRETO= "/private/ricercaFascicolo.do";

	public final static String FIRMA_DOCUMENTI = "/private/firmaDocumenti.do";
	public final static String SIGLA_DOCUMENTI = "/private/siglaDocumenti.do";
	public final static String VERIFICA_DOCUMENTI = "/private/verificaDocumenti.do";
	public final static String BOLLINA_DOCUMENTI = "/private/bollinaDocumenti.do";
	public final static String TEST_FIRME = "/private/testFirme.do";


	public final static String CONSULTA_FASCICOLO_F_A_D = "/private/consultaFascicoloFAD.do";
	public final static String GESTIONE_FASCICOLO_F_A_D = "/private/gestioneFascicoloFAD.do";
	public final static String MODALI_FAD = "/private/modaliFad.do";
	public final static String MODALI_DOCUMENTI_RED = "/private/modaliDocumentiRed.do";
	public final static String MODALI_DOCUMENTI_FAD = "/private/modaliDocumentiFad.do";
	public final static String MODALI__ANTEPRIMA_DOCUMENTI = "/private/modaliAnteprimaDocumenti.do";
	public final static String MODALI_DOCUMENTI_PAT = "/private/modaliDocumentiPat.do";
	public final static String RICERCA_SOSPESI_RED= "/private/ricercaSospesiRed.do";
	public final static String RICERCA_SOSPESI_RED_MODALI= "/private/ricercaSospesiRedModali.do";
	public final static String CREA_FASCICOLO_F_A_D = "/private/creaFascicoloFAD.do";   
	public final static String INVIO_ALLE_FIRME= "/private/invioAlleFirme.do";
	public final static String GESTIONE_TIPOLOGIA_DECRETO= "/private/gestioneTipologiaDecreto.do";
	public final static String INVIO_ALLE_FIRME_MODALI= "/private/invioAlleFirmeModali.do";
	public final static String SOSPENSIONE_FIRME= "/private/sospensioneFirme.do";
	public final static String SOSPENSIONE_FIRME_MODALI= "/private/sospensioneFirmeModali.do";
	public final static String CREA_PIN= "/private/creaPin.do";
	public final static String REVOCA_SOSPENSIONE_FIRME= "/private/revocaSospensioneFirme.do";
	public final static String REVOCA_SOSPENSIONE_FIRME_MODALI= "/private/revocaSospensioneFirmeModali.do";
	public final static String GESTIONE_WORKFLOW_FIRME= "/private/gestioneWorkflowFirme.do";
	public final static String CONSULTA_FASCICOLO_CDC= "/private/consultaFascicoloCdc.do";
	public final static String CONSULTA_FASCICOLO_CDC_MODALI= "/private/consultaFascicoloCdcModali.do";
	public final static String ABILITA_MAIL= "/private/abilitaMail.do";
	public final static String GESTIONE_UTENTI= "/private/gestioneUtenti.do";
	public final static String GESTIONE_PROFILO_UTENTE= "/private/gestioneProfiloUtente.do";
	
	public final static String GESTIONE_PROFILI= "/private/gestioneProfili.do";
	
	public final static String MONITORAGGIO_FIRMA = "/private/monitoraggioFirma.do";
	public final static String PRED_LETTERE_PRE_REG= "/private/predLetterePreReg.do";
	public final static String PREDISPOSIZIONE_TAGLIATELLA= "/private/predisposizioneTagliatella.do";
	public final static String INVIO_PEC_PARTECIPAZIONE= "/private/invioPecPartecipazione.do";
	public final static String MOD_LETTERE_PRE_REG= "/private/modLetterePreReg.do";
	public final static String GEST_WORKFLOW_FIRME_MODALI= "/private/gestWorkflowFirmeModali.do";
	public final static String GEST_TIPOLOGIA_DECRETO_MODALI= "/private/gestTipologiaDecretoModali.do";
	
	public final static String DELEGA = "/private/delega.do";
	public final static String MODALI_GESTIONE_UTENTI= "/private/modaliGestioneUtenti.do";
	public final static String FIRMA_LETTERE_PRE_REG= "/private/firmaLetterePreReg.do";
}
