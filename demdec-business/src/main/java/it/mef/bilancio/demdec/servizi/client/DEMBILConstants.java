package it.mef.bilancio.demdec.servizi.client;

import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.EsitoOperazione_type;
import it.gov.mef.demdec.servizi.dembil.interfacciadocumentaledembiltypes_1.Esito_type;

import java.util.HashMap;

public interface DEMBILConstants {
	
	
	public final static String ESITO_OK="OK";
	public final static String DESC_ESITO_OK="Operazione Effettuata";
	
	public final static String ESITO_KO="KO";
	public final static String DESC_ESITO_KO="Operazione non Effettuata: errore nella costruzione della chiamata a DEMBIL";
	public final static String DESC_ESITO_KO_NO_DETAIL_DEMBIL="Operazione non Effettuata: errore generico restituito da DEMBIL";
	public final static String ESITO_KO_ERR="KO_ERR";
	public final static String ERRORE_DATI_NON_PRESENTI="ERRORE_DATI_NON_PRESENTI";
	public final static String ERRORE_NON_AUTORIZZATO="ERRORE_NON_AUTORIZZATO";
	public final static String ERRORE_DATI_NON_DI_COMPETENZA="ERRORE_DATI_NON_DI_COMPETENZA";
	public final static String ERRORE_ELABORAZIONE="ERRORE_ELABORAZIONE";

	public final static HashMap<String, String> ERRORI = new HashMap<String, String>(){
		{
			put(Esito_type.OK.getValue(), DESC_ESITO_OK);
			put(ESITO_KO,DESC_ESITO_KO);
			put(Esito_type.ERRORE_DATI_NON_PRESENTI.getValue(),"Dati non Presenti");
			put(Esito_type.ERRORE_DATI_NON_DI_COMPETENZA.getValue(),"Operazione non Effettuata: dati non di competenza");
			put(Esito_type.ERRORE_NON_AUTORIZZATO.getValue(),"Operazione non Effettuata: non si dispone dell'autorizzazione all'operazione richiesta");
			put(Esito_type.ERRORE_ELABORAZIONE.getValue(),"Operazione non Effettuata: errore del server");
		}
	};
	
	public final static String CODI_FAUL_GENERICO_DEMBIL="KO";
	public final static String DESC_FAUL_GENERICO_DEMBIL="Errore generico del servizio documentale DEMBIL";
	


	public final static String TIPO_ESTRAZIONE_NONE="NONE";
	public final static String TIPO_ESTRAZIONE_DATA="DATA";
	public final static String TIPO_ESTRAZIONE_METADATA="METADATA";

	
	public final static String TIPO_OP_DOC_NONE="NONE";
	public final static String TIPO_OP_DOC_CONVERSIONE="CONVERSIONE";
	public final static String TIPO_OP_DOC_FIRMA_AUTOMATICA="FIRMA_AUTOMATICA";
	public final static String TIPO_OP_DOC_FIRMA_IMM="FIRMA_IMMAGINE";
	public final static String TIPO_OP_DOC_TIMBRO="TIMBRO";

	
	
	public final static String TIPO_PROTOCOLLO_INGRESSO="INGRESSO";
	public final static String TIPO_PROTOCOLLO_USCITA="USCITA";
	public final static String TIPO_PROTOCOLLO_ALL="ALL";
	

	public final static boolean FLAG_ATTIVO_VISIBILITA_ALTRI_SIST=true;
	public final static boolean FLAG_ATTIVO_NO_VISIBILITA_ALTRI_SIST=false;

	public final static boolean FLAG_DAINVIARE_VISIBILITA_CORTE=true;
	public final static boolean FLAG_DAINVIARE_NO_VISIBILITA_CORTE=false;
	
	public final static boolean FLAG_CONDIVISIBILE_VISIBILITA_DOC_DOPO_INVIO_FASCICOLO=true;
	public final static boolean FLAG_CONDIVISIBILE_NO_VISIBILITA_DOC_DOPO_INVIO_FASCICOLO=false;

}
