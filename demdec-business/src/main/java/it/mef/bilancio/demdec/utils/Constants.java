package it.mef.bilancio.demdec.utils;

public interface Constants {

//	public final static String CODI_NO_AMMIN="000";
//	public final static String DESC_NO_AMMIN="Nessuna Amministrazione";
	
	public final static String CREAZIONE_GESTIONE_FAD_CHIAMANTE_DEMDEC="DEMDEC";
	public final static String CREAZIONE_GESTIONE_FAD_CHIAMANTE_NSBF="NSBF";
	
	public final static String DESC_DOC_CORTE = "999";
	public final static String CODI_MULTI_AMMIN="999";
	public final static String DESC_MULTI_AMMIN="Multi-Amminsitrazione";
	public final static Integer CODI_TITOLO_DEFAULT=999;

	public final static String CODI_MULTI_CDR="999";
	public final static String DESC_MULTI_CDR="Multi Cdr";
	
	public final static String CODI_NO_CDR="";
	public final static String DESC_NO_CDR="Nessun Cdr";
	
	public final static String CODI_MULTI_RAG="9999";
	public final static String DESC_MULTI_RAG="Multi Rag";
	
	public final static Integer VISIBILE_CDC_NON_VISIBILE=0;
	public final static Integer STATO_FASCICOLO_APERTO=0;
	public final static Integer STATO_FASCICOLO_IN_FIRMA=2;
	public final static Integer STATO_FASCICOLO_FIRMA_SOSPESA=3;
	public final static Integer STATO_FASCICOLO_FIRMATO=4;
	public final static Integer STATO_FASCICOLO_CHIUSO_SOSPESO=5;
	public final static Integer STATO_FASCICOLO_6=6;
	public final static Integer STATO_FASCICOLO_ANNULLATO=8;
	public final static Integer STATO_DOCUMENTO_INSERIMENTO=0;
	public final static Integer STATO_DOCUMENTO_FIRMATO=4;
	public final static String  UFFICIO_CREATORE_COORDINAMENTO="2";
	public final static String  PADDING_CHAR="0";
	public final static String  DATE_SEPARATOR= "/";
	public final static Integer LUNGHEZZA_MINIMA_PIN_FIRMA=6;
	public final static String  TIPO_ATTO_DECRETO= "AD01";
	public final static String  TIPO_ALLEGATI_DECRETO= "AD02";
	public final static Integer LUNGHEZZA_MASSIMA_DESCR_TIPOLOGIA_DECRETO = 80;
	public final static Integer LUNGHEZZA_MASSIMA_DESCR_MODELLO_ITER = 80;
	
	//Parametri input DA TABELLA DOCCONVERTER ADLIB
	
		public final static String DOCCONVERTER_FLAG_TEST="DOCCONV_FLAG_TEST";  
		public final static String DOCCONVERTER_URL_WS="DOCCONV_URL_WS";  
		public final static String DOCCONVERTER_URL_TEST_WS="DOCCONV_URL_TEST_WS";  
		public final static String DOCCONVERTER_TIME_OUT="DOCCONV_TIME_OUT"; 
		public final static String DOCCONVERTER_UTENTE_WS="DOCCONV_UTENTE_WS"; 
		public final static String DOCCONVERTER_PASS_WS="DOCCONV_PASS_WS"; 
		
		public final static String DOCCONVERTER_TIPO_UTENTE_WS="DOCCONV_TIPO_UTENTE_WS"; 
		public final static String DOCCONVERTER_ACTOR_WS="DOCCONV_ACTOR_WS"; 
		public final static String DOCCONVERTER_APPLICATION_WS="DOCCONV_APPLICATION_WS"; 
		public final static String DOCCONVERTER_CLIENT_WS="DOCCONV_CLIENT_WS"; 
		public final static String DOCCONVERTER_ORG_ID="DOCCONV_ORG_ID"; 
		public final static String DOCCONVERTER_SERVIZIO_WS="DOCCONV_SERVIZIO_WS"; 
		

		public final static String DOCCONVERTER_CONST_ACTOR_WS="http://mef.gov.it/servizi/Common/HeaderAccessoApplicativo"; 
		public final static String DOCCONVERTER_CONST_APPLICATION_WS="DEMDEC"; 
		public final static String DOCCONVERTER_CONST_CLIENT_WS="DEMDEC"; 
		public final static String DOCCONVERTER_CONST_ORG_ID="DEMBIL"; 
		public final static String DOCCONVERTER_CONST_SERVIZIO_WS="DEMDEC"; 
		public final static String DOCCONVERTER_CONST_TIPO_UTENTE_WS="SYS"; 
		public final static String DOCCONVERTER_CONST_MUST_UNDERSTAND_WS="true"; 
	
	
		//Parametri input DA TABELLA DOCCONVERTER ADOBE
		
		public final static String DOCCONVERTER_ADOBE_FLAG_TEST="ADOBE_FLAG_TEST";  
		public final static String DOCCONVERTER_ADOBE_URL_WS="ADOBE_URL_WS";  
		public final static String DOCCONVERTER_ADOBE_URL_TEST_WS="ADOBE_URL_TEST_WS";  
		public final static String DOCCONVERTER_ADOBE_TIME_OUT="ADOBE_TIME_OUT"; 
		public final static String DOCCONVERTER_ADOBE_UTENTE_WS="ADOBE_UTENTE_WS"; 
		public final static String DOCCONVERTER_ADOBE_PASS_WS="ADOBE_PASS_WS"; 
		
	//Parametri input DA TABELLA DEMBIL
	
	public final static String DEMBIL_FLAG_TEST="DEMBIL_FLAG_TEST";  
	public final static String DEMBIL_URL_WS="DEMBIL_URL_WS";  
	public final static String DEMBIL_URL_TEST_WS="DEMBIL_URL_TEST_WS";  
	public final static String DEMBIL_TIME_OUT="DEMBIL_TIME_OUT"; 
	public final static String DEMBIL_UTENTE_WS="DEMBIL_UTENTE_WS"; 
	public final static String DEMBIL_PASS_WS="DEMBIL_PASS_WS"; 

	
	public final static String DEMBIL_TIPO_UTENTE_WS="DEMBIL_TIPO_UTENTE_WS"; 
	public final static String DEMBIL_ACTOR_WS="DEMBIL_ACTOR_WS"; 
	public final static String DEMBIL_APPLICATION_WS="DEMBIL_APPLICATION_WS"; 
	public final static String DEMBIL_CLIENT_WS="DEMDEC"; 
//	public final static String DEMBIL_ORG_ID="DEMBIL_ORG_ID"; 
	public final static String DEMBIL_SERVIZIO_WS="DEMBIL_SERVIZIO_WS"; 
	

//	public final static String DEMBIL_CONST_ACTOR_WS="http://mef.gov.it/servizi/Common/HeaderAccessoApplicativo"; 
	public final static String DEMBIL_CONST_APPLICATION_WS="DEMDEC"; 
	public final static String DEMBIL_CONST_CLIENT_WS="DEMDEC"; 
	public final static String DEMBIL_CONST_ORG_ID="DEMBIL"; 
	public final static String DEMBIL_CONST_SERVIZIO_WS="DEMDEC"; 
	public final static String DEMBIL_CONST_TIPO_UTENTE_WS="SYS"; 
	public final static String DEMBIL_CONST_MUST_UNDERSTAND_WS="true"; 
	
	


	
	
	//COSTANTI DEMBIL
	
	public final static String DECRETO_NORMATIVO_EXISTS= "err.decreto.normativo.exists";
	public final static String DECRETO_EXISTS= "err.decreto.exists";
	public final static String FAD_EXISTS="err.fad.exists";
	public final static String PATR_EXISTS= "err.decreto.patrimonio.exists";
	
	
	
	
	public final static String STATO_FAD_APERTO="APERTO";
	public final static String STATO_FAD_CHIUSO="CHIUSO";
	public final static String STATO_FAD_IN_ELABORAZIONE="IN_ELABORAZIONE";
	public final static String STATO_FAD_INSERITO="INSERITO";
	public final static String STATO_FAD_ANNULLATO="ANNULLATO";
	
	//COSTANTI MAIL PEC
	public static final int FLAG_PEC=1;
	public static final int FLAG_NO_PEC=0;
	public static final String STATO_MESSAGGIO_INVIATO = "IN";
	public static final String MAIL_FORM = "MAIL_FORM";
	public static final String TAB_SERV_PEC_USERNAME = "PEC_USERNAME";
	public static final String TAB_SERV_PEC_PWD = "PEC_PASSWORD";
	public static final String TAB_SERV_PEC_HOST_OUT= "PEC_HOST_OUT";
	public static final String TAB_SERV_PEC_HOST_IN= "PEC_HOST_IN";
	public static final String TAB_SERV_PEC_PORT = "PEC_PORT";
	public static final String TAB_SERV_PEC_PROTOCOL = "PEC_PROTOCOL";
	
	public static final String TAB_SERV_MAIL_USERNAME = "MAIL_USERNAME";
	public static final String TAB_SERV_MAIL_PWD = "MAIL_PASSWORD";
	public static final String TAB_SERV_MAIL_HOST_OUT= "MAIL_HOST_OUT";
	public static final String TAB_SERV_MAIL_HOST_IN= "MAIL_HOST_IN";
	public static final String TAB_SERV_MAIL_PORT = "MAIL_PORT";
	public static final String TAB_SERV_MAIL_PROTOCOL = "MAIL_PROTOCOL";
	
	public static final Integer TAB_SERV_NUM_AGG = 78;
	
	
	//COSTANTI ITER FIRMA
	public static final String STATO_FIRMA_DA_FIRMARE = "0";
	public static final String STATO_FIRMA_IN_FIRMA = "1";
	public static final String STATO_FIRMA_FIRMATO = "2";
	public static final String STATO_FIRMA_SOSPESA = "3";
	public static final int HAVE_PEC = 1;
	public static final int HAVE_PEO = 0;
	public static final int ERROR_WS_DOWNLOAD_DOCUMENT = 777;
	public static final int ERROR_WS_FIRMA_DOCUMENT = 888;
	public static final int ERROR_WS_UPLOAD_DOCUMENT = 999;
	
	//COSTANTI ERRORE CREAZIONE MESSAGGIO MAIL
	public static final int ERROR_EMPTY_RECIPIENT_TYPE_TO = 100;
	
	public static final String TAB_SERV_PKBOX_HANDLER = "PKBOX_HANDLER";
	public static final String TAB_SERV_PKBOX_SECURE_PIN = "PKBOX_SECURE_PIN";
	public static final String TAB_SERV_PKBOX_PROVIDER = "PKBOX_PROVIDER";
	public static final String TAB_SERV_PKBOX_OPT_PROPERTIES = "PKBOX_OPT_PROPERTIES";
	
	
	//COSTANTI SIGLA
	public static final String SIGLA = "S";
	//COSTANTI VERIFICA
	public static final String VERIFICA = "V";
	//COSTANTI BOLLINATURA
	public static final String BOLLINATURA = "B";
	//COSTANTI FIRMA
	public static final String FIRMA = "F";
	
	//COSTANTI TAG FIRMA
	public static final String TAG_UFFICIO  = "UFF";
	public static final String TAG_MINISTRO = "MIN";
	public static final String TAG_RAGIONIERE = "RAG";
	public static final String TAG_TEST_VISIBILE = "Visibile_1";
	public static final String TAG_TEST_INVISIBILE = "Invisibile_1";
	
	public static final Integer METODO_FIRMA_CON_PIN_TAG_VISIBILE = 0;
	public static final Integer METODO_FIRMA_AUTOMATICA_TAG_INVISIBILE = 1;
	public static final Integer METODO_FIRMA_AUTOMATICA_TAG_VISIBILE = 2;
	
	public static final String TAB_SERV_METODO_FIRMA = "METODO_FIRME";
	public static final String OLD_METODO_FIRMA = "OLD";
		
	public static final String TAB_SERV_SERVIZIO_PDF = "SERVIZIO_PDF";
	public static final String ADOBE = "ADOBE";
	public static final String ADLIBE = "ADLIBE";
	public static final String ID_FIRMA_TECNICA = "ID_FIRMA_TECNICA";
	public static final String SCRIVI_FILE = "SCRIVI_FILE";

	//  tipo Fascicolo
	public static final String FASCICOLO_FAD = "FAD";
	public static final String FASCICOLO_RED = "RED";

	
	
	/* DA RENDE Forse eliminare*/
	
	public static final  String TAG_FIRMA_TEC1="Firmatecnica_RGS";

	
	public static final  String HEADER_PAGINA_FIRMA="HEADER";

	/* DA RENDE Forse eliminare*/

	
	
	/* COSTANTI SOSPESI RED INIZIO*/
	 public static final String SOSPESI_RED_CHIUSURA = "C";
	 public static final String SOSPESI_RED_APERTURA = "A";
	 
	/* COSTANTI SOSPESI RED FINE*/

	 /* COSTANTI DOCUMENTI FAD - STAT DOCUMENTO INIZIO*/
	 public static final String DOC_FAD_STAT_DOCUMENTO_ZERO = "0";
	 public static final String DOC_FAD_STAT_DOCUMENTO_DUE = "2";
	 public static final String DOC_FAD_STAT_DOCUMENTO_TRE = "3";
	 public static final String DOC_FAD_STAT_DOCUMENTO_QUATTRO = "4";
	 /* COSTANTI DOCUMENTI FAD - STATO DOCUMENTO FINE*/
	 
	 public static final String USER_NSBF_AMM = "R_NSBF_AMM";
	 
	 public static final String FUNZIONE_SOSPENSIONE_DECRETO = "SOSPENSIONE DECRETO";
	 public static final String FUNZIONE_RIAPERTURA_DECRETO = "RIAPERTURA DECRETO";
	 public static final String FUNZIONE_REVOCA_RICHIESTA_SOSPENSIONE = "REVOCA RICHIESTA SOSPENSIONE";
	 
	 public static final String FUNZIONE_SOSPENSIONE_FIRME = "sospensioneFirme";
	 public static final String FUNZIONE_REVOCA_SOSPENSIONE_FIRME = "revocaSospensioneFirme";
	 //UPLOAD
	 public static final String NOT_ALLOWED = "notAllowed";
	 public static final String BAD_FILE = "badFile";
	 
	 //Abilitazione Mail
	
	 public static final int DESTINATARIO_MAIL_ABILITATO = 1;
	 public static final int DESTINATARIO_MAIL_DISABILITATO = 0;
	 public static final String FUNZIONE_ABILITATA_INVIO_EMAIL = "S";
	 public static final String FUNZIONE_ABILITATA_INVIO_PEC = "S";
	 public static final String FUNZIONE_DISABILITATA_INVIO_PEC = "N";
	 public static final String FUNZIONE_ABILITATA_INVIO_PEO = "S";
	 public static final String FUNZIONE_DISABILITATA_INVIO_PEO = "N";
	 
	 //testFirma
	 public static final String TAB_SERV_FILEPATH_TEST_FIRME = "FILEPATH_TEST_FIRME";
	 
	 public static final String CODI_TIPO_LETTERA_PREREGISTRAZIONE = "L-IGB";
	 
	 public static final String CODI_SEZIONE_CORPO_LETTERA_PREREGISTRAZIONE = "08-COR";
	 
	 public final static Short RAGIONERIA_NON_SIGNIFICATIVA= 9999;
	 
	 public static final String UFFICIO_I = "1";
	 public static final String UFFICIO_II = "2";
	 public static final String DOC_PRINCIPALE = "PRINCIPALE";
	 public static final String DOC_ALLEGATO = "ALLEGATO";
	 
	 //Costanti Lettera Preregistrazione
	 public static final String LOGO = "LOGO";
	 public static final String DIP_RGS="DIPARTIMENTO DELLA RAGIONERIA GENERALE DELLO STATO";
	 public static final String SEZIONE_1="01-INT";
	 public static final String SEZIONE_2="02-DAT";
	 public static final String SEZIONE_3="03-IND";
	 public static final String SEZIONE_4="04-IND";
	 public static final String SEZIONE_5="05-PRO";
	 public static final String SEZIONE_6="06-PRO";
	 public static final String SEZIONE_7="07-OGG";
	 public static final String SEZIONE_8="08-COR";
	 public static final String SEZIONE_9="09-NOT";
	 public static final String ISP_BIL="Ispettorato Generale del Bilancio";
	 public static final String UFF_CENTR_BIL="All'UFFICIO CENTRALE DEL BILANCIO";
	 public static final String PROTOCOLLO="Rif. Prot. Entrata N.";
	 public static final String LETTERA_STANDARD="0";
	 public static final String LETTERA_PERSONALIZZATA="1";
	 public static final String LETTERA_INVIATA_ALLA_FIRMA="2";
	 public static final String LETTERA_FIRMATA="3";
	 public static final String PEC_LETTERA_INVIATA="4";
}
