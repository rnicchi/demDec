package it.mef.bilancio.demdec.web.spring.utils;

import it.almavivaitalia.bilancio.commons.web.utils.CommonWebConstants;

public interface WebConstants extends CommonWebConstants {
	/* EXPORT PDF E EXCEL */
	public final static String FIELD_FORMATTER_PATH = "it/mef/bilancio/demdec/export/";
	public final static String SEPARATORE_STAMPA = "_";
	
	/* MENU */
	public final static String MENU_APPLICATION_EXAMPLE = "applicationExample";
	/* FINE MENU */
	
	public static final String ROW_INDEX_SELECTED_CEDENTE 		= "ROW_INDEX_SELECTED_CEDENTE";
	public static final String ROW_INDEX_SELECTED_RICEVENTE 	= "ROW_INDEX_SELECTED_RICEVENTE";
	public static final String PARAMETER_NAME_OPEN_CEDENTE  	= "openCedente";
	public static final String PARAMETER_NAME_DELETE_CEDENTE  	= "deleteCedente";
	public static final String PARAMETER_NAME_OPEN_RICEVENTE  	= "openRicevente";
	public static final String PARAMETER_NAME_DELETE_RICEVENTE 	= "deleteRicevente";
	public static final String PARAMETER_NAME_SEARCH_RICEVENTI 	= "searchRiceventi";
	public static final Integer VOCE_MENU_RIM_VERT = 2832;
	public static final Integer VOCE_MENU_RIM_ORIZ = 2833;
	public static final Integer VOCE_MENU_COM_STANZ = 2831;
	public static final Short CODI_TRAN_AGG_BIL = Short.parseShort("510");
	public static final Short CODI_TRAN_REVOCA_BIL = Short.parseShort("511");
	public static final Short CODI_TRAN_COM_STANZ = Short.parseShort("262");
	public static final String LIST_ANNO_ESE = "listAnnoEse";
	public static final String LIST_AMMIN_DEM = "listAmminDem";
	public static final String LIST_ANAG_UFF = "listAnagUffici";
	public static final String LIST_ANAG_STATI_FASC = "listAnagStatiFascicoli";
	public static final String LIST_RACC_PROVV = "listRaccolteProvvisorie";
	public static final String LIST_TIPI_DECRETI = "listTipiDecreti";
	public static final String LIST_TIPO_ALLEGATI = "listTipoAllegati";
	public static final String LIST_TIPO_ALLEGATI_RP01 = "listTipoAllegatiRp01";
	public static final String LIST_TIPO_ALLEGATI_RP02 = "listTipoAllegatiRp02";
	public static final String LIST_DOCUMENTI_FASCICOLO = "listDocumentiFascicolo";
	public static final String LIST_DOC_FASC = "listDocFasc";
	public static final String LIST_DOC_FASC_SOSP = "listDocFascSosp";
	public static final String ID_FASC_RACC_PROVV = "idFascRaccProvv";	
	public static final String FASC_RACC_PROVV_SELECTED = "__FASC_RACC_PROVV_SELECTED__";	
	public static final String LIST_FIRMATARI = "listFirmatari";
	public static final String LIST_ROWS = "__LIST_ROWS__";
	public static final String LIST_SELECTED_AMMS = "__LIST_SELECTED_AMMS__";
	public static final String ROW_INDEX_SELECTED_AMMS = "__ROW_INDEX_SELECTED_AMMS__";
	public static final String LIST_CDR = "__LIST_CDR__";
	public static final String LIST_ROWS_CDR = "__LIST_ROWS_CDR__";
	public static final String INDEXES_SELECTED_CDR = "__INDEXES_SELECTED_CDR__";
	public static final String ROW_INDEX_SELECTED_CDR = "__ROW_INDEX_SELECTED_CDR__";
	public static final String TITOLO_MODALE_DETTAGLIO="titoloModaleDettaglio";
	public static final String LIST_TIPO_DEC = "__LIST_TIPO_DEC __";
	public static final String LIST_ANNO_DEC = "__LIST_ANNO_DEC __";
	public static final String LIST_TIPOLOGIA_DEC = "__LIST_TIPOLOGIA_DEC __";
	public static final String AMM_PRECEDENTE = "__AMM_PRECEDENTE__";
	public static final String LIST_SELECTED_CDRS = "__LIST_SELECTED_CDRS__";
	public static final String LIST_TIPO_DOC = "__LIST_TIPO_DOC __";
	public static final String LIST_TIPO_DOC_RED = "__LIST_TIPO_DOC_RED__";
	public static final String LIST_VISIBILITA_CDC = "__LIST_VISIBILITA_CDC__";
	public static final String TIPO = "__TIPO__";
	public static final String ANNO = "__ANNO__";
	public static final String NUMERO = "__NUMERO__";
	public static final String GUID_FASCICOLO = "__GUID_FASCICOLO__";
	public static final String GUID_DOCUMENTO = "__GUID_DOCUMENTO__";
	public static final String NUME_ID_FASCICOLO = "__NUME_ID_FASCICOLO__";
	public static final String NUME_ID_DOCUMENTO = "__NUME_ID_DOCUMENTO__";
	public static final String LIST_ANAG_TIPO_FLUSSO = "listAnagTipoFlusso";
	public static final String DOCUMENTO_INVIO_A_FIRME = "documentoInvioAFirme";
	public static final String NOME_DOCUMENTO_INVIO_A_FIRME = "__NOME_DOCUMENTO_INVIO_A_FIRME__";
	public static final String CHK_MODIFICA_FAD = "__CHK_MODIFICA_FAD__";
	public static final String CHK_MODIFICA_VISIBILITA = "__CHK_MODIFICA_VISIBILITA__";
	public static final String CHK_NORMATIVO = "__CHK_NORMATIVO__";
	public static final String ID_FAD_APERTO = "__ID_FAD_APERTO__";
	public final static String DETTAGLIO_CRONOLOGICO = "apriDettaglioCrono";
	public final static String LIST_PROFILI = "listProfili";
	public final static String LIST_UFFICI = "listUffici";
	public final static String LIST_PROF_UFF_AMM = "listProfiliUfficiAmm";
	public final static String LIST_ALL_ACT = "listAllAction";
	public final static String LIST_ACT = "listAction";
	public final static String LIST_PROF_ACT = "listProfiliAction";
	
	public final static String LIST_DECRETI_RIELABORAZIONE = "listDecretiRielaborazione";
	public final static String LIST_DECRETI_APERTI = "listDecretiAperti";
	
	public final static String LIST_DESC_DOCUMENTI = "listDescDocumenti";
	public final static String DOCUMENTO_PER_VISIBILITA = "docPerVisibilita";
	public final static String LIST_VISIBILITA_DESC_DOCUMENTI = "listVisibilitaDocumenti";
	public final static String LIST_TIPO_OPERAZIONE = "listTipoOperazione";
	
	public final static String UFFICIO_II = "2";
	public final static String PROFILO_DIRIGENTE_UFFICIO = "2";
	public final static String PROFILO_BILANCISTA= "9";
	public final static String ASSOCIA_PROFILO= "__ASSOCIA_PROFILO__";
	
}