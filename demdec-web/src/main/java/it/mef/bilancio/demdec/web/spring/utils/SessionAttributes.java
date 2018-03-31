package it.mef.bilancio.demdec.web.spring.utils;

import it.almavivaitalia.bilancio.commons.web.utils.CommonSessionAttributes;

public interface SessionAttributes extends CommonSessionAttributes {
	public final static String CLASS_NAME = "it.mef.bilancio.demdec.web.spring.utils.ConstantsRequestMapping";
// ESERCIZI //
	public final static String STAT_TIPO_ESE_GESTIONE 				="G";
	public final static String ESERCIZIO_NUOVA_GESTIONE			="__ENG__";
	public final static String FENG="_FENG_"; 
	public final static String STAT_TIPO_ESE_FORMAZIONE 			="F";
	public final static String STAT_STATUS_ENG_ESE_PROVVISORIO		="1";
	public final static String ESERCIZIO_BILANCIO_FORMAZIONE	="__EBF__";
    public final static String FEBF="_FEBF_";
    public final static String STAT_TIPO_ESE_CONSUNTIVO 			="C";
    public final static String ESERCIZIO_VECCHIA_GESTIONE		="__EVG__";
    public final static String FEVG="_FEVG_";
    
    public static final String OPEN_DETT_FAD = "__OPEN_DETT_FAD__";
    public static final String OPEN_DETT_RED = "__OPEN_DETT_RED__";
    public static final String OPEN_DETT_PATR = "__OPEN_DETT_PATR__";
	
	public final static String _FORM_CACHED_="_FORM_CACHED_";
	
	public final static String LIST_SENT_MSG = "messaggiInviati";
	public final static String LIST_AD_TO_SIGN = "AdToSign";
	public final static String LIST_AD_SIGNED = "SignedAd";
	public static final String LIST_MY_SIGNED_AD = "mySignedAd";
	public final static String LIST_RICERCA_RED = "listaRicercaRed";
	
	public final static String LIST_TIPI_FIRMA = "tipiFirma";
	public final static String LIST_DELEGANTI = "deleganti";
	public static final String LIST_DELEGATI = "delegati";
	public static final String LIST_DELEGHE = "deleghe";
	public static final String LIST_DELEGATI_ATTIVI = "delegatiAttivi";
	

	//ricerca Sospesi Red
	public final static String LIST_SOSPENDIBILI_RED = "listaRedDaSospendere";
	public final static String LIST_SOSPESI_RED = "listaRedSospesi";
	public final static String PAGINATOR_SOSPENDIBILI_RED = "paginatorRedDaSospendere";
	public final static String PAGINATOR_SOSPESI_RED = "paginatorRedSospesi";

	public static final String LIST_ANNO_ESE = "__LIST_ANNO_ESE__";
	public static final String LIST_AMMIN_DEM = "__LIST_AMMIN_DEM__";
	public static final String CURRENT_LIST_AMMIN_DEM = "__CURRENT_LIST_AMMIN_DEM__";
	public static final String LIST_ANAG_MODELLI_ITER = "__LIST_ANAG_MODELLI_ITER__";
	public static final String LIST_ANAG_UFF = "__LIST_ANAG_UFF__";
	public static final String LIST_ANAG_STATI_FASC = "__LIST_ANAG_STATI_FASC__";
	public static final String LIST_ANAG_STATI_FASC_MODIFICA = "__LIST_ANAG_STATI_FASC_MODIFICA__";
	public static final String LIST_RACC_PROVV = "__LIST_RACC_PROVV__";
	public static final String LIST_TIPI_DECRETI = "__LIST_TIPI_DECRETI__";
	public static final String LIST_TIPO_ALLEGATI = "__LIST_TIPO_ALLEGATI__";
	public static final String LIST_TIPOLOGIA_DECRETO="__LIST_TIPOOGIA_DECRETO__";
	public static final String LIST_ANAG_CDR_DEM="__LIST_ANAG_CDR_DEM__";
	public static final String LIST_DOCUMENTI_FASCICOLO = "__LIST_DOCUMENTI_FASCICOLO__";
	public static final String LIST_DOCUMENTI_FASCICOLO_SOSP = "__LIST_DOCUMENTI_FASCICOLO_SOSP__";
	public static final String LIST_ROWS = "__LIST_ROWS__";
	public static final String LIST_FASCICOLI_FAD 				= "__LIST_FASCICOLI_FAD__";
	public static final String LIST_DOCUMENTI_FAD 				= "__LIST_DOCUMENTI_FAD__";
	public static final String LIST_TESTI_PERS="__LIST_TESTI_PERS__";
	public static final String LETTERA_SELEZIONATA		= "__LETTERA_SELEZIONATA__";
	
	public static final String FASCICOLO_PER_TAGLIATELLA		= "__FASCICOLO_PER_TAGLIATELLA__";
	
	public static final String DOCUMENTI_FAD_PAGINATOR 			= "__DOCUMENTI_FAD_PAGINATOR__";
	public static final String LIST_SOTTO_FASCICOLI_FAD 		= "__LIST_SOTTO_FASCICOLI_FAD__";
	public static final String LIST_SOTTO_FASCICOLI_RED 		= "__LIST_SOTTO_FASCICOLI_RED__";
	public static final String SOTTO_FASCICOLI_FAD_PAGINATOR 	= "__SOTTO_FASCICOLI_FAD_PAGINATOR__";
	public static final String SOTTO_FASCICOLI_RED_PAGINATOR 	= "__SOTTO_FASCICOLI_RED_PAGINATOR__";
	public static final String LIST_DOCUMENTI_RED 				= "__LIST_DOCUMENTI_RED__";
	public static final String SOTTO_FASCICOLO_RED				= "__SOTTO_FASCICOLO_RED__";
	public static final String SOTTO_FASCICOLO_PAT				= "__SOTTO_FASCICOLO_PAT__";
	public static final String DOCUMENTO_RED 					= "__DOCUMENTO_RED__";
	public static final String DOCUMENTO_FAD 					= "__DOCUMENTO_FAD__";
	public static final String DOCUMENTO_PAT 					= "__DOCUMENTO_PAT__";
	public static final String DOCUMENTI_RED_PAGINATOR 			= "__DOCUMENTI_RED_PAGINATOR__";
	public static final String LIST_SOTTO_FASCICOLI_PAT 		= "__LIST_SOTTO_FASCICOLI_PAT__";
	public static final String SOTTO_FASCICOLI_PAT_PAGINATOR 	= "__SOTTO_FASCICOLI_PAT_PAGINATOR__";
	public static final String LIST_DOCUMENTI_PAT 				= "__LIST_DOCUMENTI_PAT__";
	public static final String DOCUMENTI_PAT_PAGINATOR 			= "__DOCUMENTI_PAT_PAGINATOR__";
	public static final String FASCICOLO_SELEZIONATO			= "__FASCICOLO_SELEZIONATO__";
	public static final String LIST_ANAG_TIPOLOGIA_DECRETO		= "__LIST_ANAG_TIPOLOGIA_DECRETO__";
	public static final String LIST_TIPOLOGIA_TAGLIA			= "__LIST_TIPOLOGIA_TAGLIA__";
	public static final String LIST_ITER_FIRMA					= "__LIST_ITER_FIRMA__";
	public static final String LIST_ANAG_FIRMATARI				= "__LIST_ANAG_FIRMATARI__";
	public static final String LIST_FASCICOLI_FAD_CDC			= "__LIST_FASCICOLI_FAD_CDC__";
	public static final String CODI_PIN_FIRMA			= "__CODI_PIN_FIRMA__";
    // Cronologico //    
    public final static String SHOW_CAP_PG="__SHOW_CAP_PG__";
    public final static String SHOW_AUTOR="__SHOW_AUTOR__";
    public final static String SHOW_PL="__SHOW_PL__";
    public final static String SHOW_PARTITA="__SHOW_PARTITA__";
    public final static String SHOW_STRUMENTO="__SHOW_STRUMENTO__";
    public final static String SHOW_SOTTO_STRUMENTO="__SHOW_SOTTO_STRUMENTO__";
    public final static String SHOW_BUTTON_FILTRI="__SHOW_BUTTON_FILTRI__";
    public final static String SHOW_LABEL_FILTRI = "__SHOW_LABEL_FILTRI__";
    public final static String OBJECT_CRONOLOGICO = "__OBJECT_CRONOLOGICO__";
    public final static String LIST_TRANSAZIONI="__LIST_TRANSAZIONI__";
    public final static String LIST_VALORI="__LIST_VALORI__";
    public final static String INT_SEL_ROW="__INT_SEL_ROW__";
    public static final String CRONOLOGICO_VIEW_LIST="__CRONOLOGICO_VIEW_LIST__";
    public final static String LIST_TIPO_SUB_AUT 	= "__LIST_TIPO_SUB_AUT__";
    public final static String OBJECT_FORM_CRONO 	= "__OBJECT_FORM_CRONO__";
    // Fine Cronologico //
    public final static String LIST_UTENTI 	= "__LIST_UTENTI__";
    public final static String LIST_PROFILI 	= "__LIST_PROFILI__";
    public final static String LIST_FUNZIONI 	= "__LIST_FUNZIONI__";
    public final static String LIST_DECRETI_MONITORAGGIO_FIRMA 	= "__LIST_DECRETI_MON_FIRMA__";
    public final static String LIST_ITER_FIRMA_DECRETO = "__LIST_ITER_FIRMA_DECRETO__";
    public final static String ITER_INVIATO_A_FIRME = "iterInviatoAFirme";
    public final static String LIST_DECRETI_LETTERE_PRE_REG = "__LIST_DECRETI_LETTERE_PRE_REG__";
    public final static String LIST_LETTERE_PRE_REG = "__LIST_LETTERE_PRE_REG__";
    public final static String LIST_PROFILI_FIRMATARI= "__LIST_PROFILI_FIRMATARI__";
    public final static String LIST_LETTERE_TO_SIGN = "listLettereToSign";
    public final static String LIST_LETTERE_SIGNED = "signedLettere";
    public static final String FASCICOLO_PEC_PARTECIPAZIONE			= "__FASCICOLO_PEC_PARTECIPAZIONE__";
    public static final String NOME_FILE_ATTO_DECRETO			= "__NOME_FILE_ATTO_DECRETO__";
    public static final String FUNZIONE_ORIGINE			= "__FUNZIONE_ORIGINE__";
	
}
