package it.mef.bilancio.demdec.web.spring.report.business.itext;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public interface ICoreConstants {

	public static final String STATO_PREVISIONI_ENTRATE = "00";

//  Costanti per Interrogazione Posta Patrimoniale
    public static final String ANNO_AVVIO               = "2002";
    public static final String CODI_SEC_1               = "DA AA BA BA BA";
    public static final String CODI_SEC_AA              = "AA";
    public static final String CODI_SEC_BA              = "BA";
    public static final String CODI_SEC_CA              = "CA";
    public static final String CODI_SEC_DA              = "DA";
    public static final String CODI_SEC_FA              = "FA";
    public static final String CODI_SEC_GA              = "GA";
    public static final String CODI_SEC_PASSIVITA       = "DA";
    public static final String WTIT1                    = "1";
    public static final String WTIT2                    = "2";
    public static final String WTIT3                    = "3";
    public static final String WTIT4                    = "4";
    public static final String CODI_TIPO_MOV_ECO        = "E";
    public static final String CODI_TIPO_MOV_PRE        = "P";
    public static final String AMM_00                   = "00";
    public static final int APPENDICE_AMM_00            = 0;

    public static final String CODI_TRASFERIMENTO_AUMENTO = "1";
    public static final String CODI_TRASFERIMENTO_AUMENTO_AUMENTO = "2";
    public static final String CODI_TRASFERIMENTO_DIMINUZIONE = "3";
    public static final String CODI_TRASFERIMENTO_DIMINUZIONE_DIMINUZIONE = "4";

    public static final String CODI_CC = "CC";
    public static final String CODI_CR = "CR";

    public static final String CAUSALE_SPESE_TITOLO = "A10";
    public static final String CAUSALE_ENTRATE_TITOLO = "D10";
    public static final String CAUSALE_SPESE_RESIDUE = "A11";
    public static final String CAUSALE_ENTRATE_RESIDUE = "D11";
    public static final String CAUSALE_SPESE_RESIDUE_MOB = "A20";
    public static final String CAUSALE_ENTRATE_RESIDUE_MOB = "D20";
    public static final String CAUSALE_TRASFERIMENTI_AUMENTI = "A21";
    public static final String CAUSALE_TRASFERIMENTI_DIMINUZIONI = "D21";
    public static final String CAUSALE_SOPRAVVENIENZA = "A31";
    public static final String CAUSALE_INSUSSISTENZE = "D31";
    public static final String CAUSALE_PRODOTTI = "A45";
    public static final String CAUSALE_DOTAZIONI = "D45";
    public static final String CAUSALE_PRODOTTI_MOB = "A30";
    public static final String CAUSALE_DOTAZIONI_MOB = "D30";
    public static final String CAUSALE_CONSISTENZA_INIZIALE = "A41";
    public static final String CAUSALE_CONSISTENZA_FINALE = "D41";
    public static final String CAUSALE_LIKE_A = "A%";
    public static final String CAUSALE_LIKE_A5 = "A5%";
    public static final String CAUSALE_LIKE_A6 = "A6%";
    public static final String CAUSALE_LIKE_A7 = "A7%";
    public static final String CAUSALE_LIKE_D = "D%";
    public static final String CAUSALE_LIKE_D5 = "D5%";
    public static final String CAUSALE_LIKE_D6 = "D6%";
    public static final String CAUSALE_LIKE_D7 = "D7%";
    public static final String CAUSALE_A20 = "A20";
    public static final String CAUSALE_A21 = "A21";
    public static final String CAUSALE_A22 = "A22";
    public static final String CAUSALE_A23 = "A23";
    public static final String CAUSALE_A24 = "A24";
    public static final String CAUSALE_A25 = "A25";
    public static final String CAUSALE_A30 = "A30";
    public static final String CAUSALE_A42 = "A42";
    public static final String CAUSALE_A64 = "A64";
    public static final String CAUSALE_D20 = "D20";
    public static final String CAUSALE_D21 = "D21";
    public static final String CAUSALE_D22 = "D22";
    public static final String CAUSALE_D23 = "D23";
    public static final String CAUSALE_D24 = "D24";
    public static final String CAUSALE_D25 = "D25";
    public static final String CAUSALE_D30 = "D30";
    public static final String CAUSALE_D42 = "D42";
    public static final String CAUSALE_D64 = "D64";
    public static final String CODI_TIPO_CAUSALE_M = "M";

    public static final String CAMPO_CONSISTENZA_INIZIALE = "impoConsIns";
    public static final String CAMPO_SPESE_TITOLO1 = "impoAumTit1";
    public static final String CAMPO_SPESE_TITOLO2 = "impoAumTit2";
    public static final String CAMPO_SPESE_TITOLO3 = "impoAumTit3";
    public static final String CAMPO_SPESE_RESIDUE =  "impoAumRes";
    public static final String CAMPO_TRASFERIMENTI_AUMENTI = "impoAumTra";
    public static final String CAMPO_SOPRAVVENIENZA = "impoSprovv";
    public static final String CAMPO_ENTRATE_TITOLO1 = "impoDimTit1";
    public static final String CAMPO_ENTRATE_TITOLO2 = "impoDimTit2";
    public static final String CAMPO_ENTRATE_TITOLO3 = "impoDimTit3";
    public static final String CAMPO_ENTRATE_TITOLO4 = "impoDimTit4";
    public static final String CAMPO_ENTRATE_RESIDUE = "impoDimRes";
    public static final String CAMPO_TRASFERIMENTI_DIMINUZIONI = "impoDimTra";
    public static final String CAMPO_INSUSSISTENZA = "impoInsuss";
    public static final String CAMPO_CONDISTENZA_FINALE = "impoConsFin";
    public static final String CAMPO_A10_I = "impoA10I";
    public static final String CAMPO_A10_II = "impoA10II";
    public static final String CAMPO_A10_III = "impoA10III";
    public static final String CAMPO_IMPO = "impo";
    public static final String CAMPO_D10_I = "impoD10I";
    public static final String CAMPO_D10_II = "impoD10II";
    public static final String CAMPO_D10_III = "impoD10III";
    public static final String CAMPO_IMPORTO = "importo";

    public static final String CODI_AMM_02 = "02";
    public static final String CODI_AMM_10 = "10";
    public static final String CODI_AMM_12 = "12";

    public static final List<String> CAUSALE_TRASF_AUM_LIST = Arrays.asList("A20", "A21", "A22", "A23", "A24", "A25", "A30");
    public static final List<String> CAUSALE_TRASF_DIM_LIST = Arrays.asList("D20", "D21", "D22", "D23", "D24", "D25", "D30");
    public static final List<String> CAUSALE_TRASF_AUM_MOB_LIST = Arrays.asList("A41", "A42");
    public static final List<String> CAUSALE_TRASF_DIM_MOB_LIST = Arrays.asList("D41", "D42");
    public static final List<String> CAUSALE_INV_SOPRA_LIST = Arrays.asList("A60","A61","A62");
    public static final List<String> CAUSALE_INV_ALTRE_LIST = Arrays.asList("A63","A64","A65","A66");
    public static final List<String> CAUSALE_INV_INSU_LIST = Arrays.asList("D60","D61","D62");
    public static final String CAUSALE_INV_ALTRE = "A99";
    public final static String IMPORTO_AUM_RET ="IMPO_AUM_RET";
    public final static String IMPORTO_DIM_RET ="IMPO_DIM_RET";
    public final static String IMPO_CONS_FIN ="IMPO_CONS_FIN";
    public final static String IMPO_CONS_INI ="IMPO_CONS_INI";

    public final static String IMPO_UTILIZZO_FONDO = "UTILIZZO FONDO";
    public final static String IMPO_ALTRI_TRASFERIMENTI = "ALTRI TRASFERIMENTI";
    public final static String IMPO_ACCERTATI_AUM = "Accertamenti di Bilancio (Aumento)";
    public final static String IMPO_ACCERTATI_DIM = "Accertamenti di Bilancio (Diminuzione)";


    public final static int BEX_POSTA_CHIUSA = 0;
    public final static int BEX_DATI_PATRIMONIALI_NON_PRESENTI=1;
    public final static int BEX_PROGRESSIVO_NON_SIGNIFICATIVO = 2;
    
    public final static String IMPO_AUM_RIVALUTAZIONI = "IMPO_AUM_RIV";
    public final static String IMPO_AUM_RETTIFICHE  = "IMPO_AUM_RET";
    public final static String IMPO_AUM_ALTRE_CAUSE  = "IMPO_AUM_ALTRE";
    public final static String IMPO_AUM_SOPRAVV  = "IMPO_AUM_SOPRAVV";

    public final static String IMPO_DIM_DM_DI_SCARICO  = "IMPO_DIM_DM";
    public final static String IMPO_DIM_RETTIFICHE  = "IMPO_DIM_RET";
    public final static String IMPO_DIM_ALTRE_CAUSE  = "IMPO_DIM_ALTRE";

    public final static Integer OPERAZIONE_ATTIVITA = 0;
    public final static Integer OPERAZIONE_PASSIVITA = 1;
    public final static Integer OPERAZIONE_TUTTE = 2;

    public final static String TUTTE_CLASS_SEC = "00";
    
    public static final String IMPO_AUM_TIT1 = "IMPO_AUM_TIT1";
    public static final String IMPO_AUM_TIT2 = "IMPO_AUM_TIT2";
    public static final String IMPO_AUM_TIT3 = "IMPO_AUM_TIT3";
    public static final String IMPO_AUM_TIT4 = "IMPO_AUM_TIT4";
    public static final String IMPO_AUM_TRA  = "IMPO_AUM_TRA";
    public static final String IMPO_AUM_RES  = "IMPO_AUM_RES";
    public static final String IMPO_AUM_UTI  = "IMPO_AUM_UTI";
    public static final String IMPO_AUM_RET  = "IMPO_AUM_RET";
    public static final String IMPO_DIM_TIT1 = "IMPO_DIM_TIT1";
    public static final String IMPO_DIM_TIT2 = "IMPO_DIM_TIT2";
    public static final String IMPO_DIM_TIT3 = "IMPO_DIM_TIT3";
    public static final String IMPO_DIM_TIT4 = "IMPO_DIM_TIT4";
    public static final String IMPO_DIM_TRA  = "IMPO_DIM_TRA";
    public static final String IMPO_DIM_RES  = "IMPO_DIM_RES";
    public static final String IMPO_DIM_PER  = "IMPO_DIM_PER";
    public static final String IMPO_DIM_RET  = "IMPO_DIM_RET";

    public static final String PIANO_GESTIONALE_80 = "80";

    public static final String ACCESIBLE_DOCUMENT_TYPE_01 = "01";
    public static final String ACCESIBLE_DOCUMENT_TYPE_02 = "02";
    public static final String ACCESIBLE_DOCUMENT_TYPE_03 = "03";
    public static final String ACCESIBLE_DOCUMENT_TYPE_04 = "04";
    public static final String ACCESIBLE_DOCUMENT_TYPE_05 = "05";
    public static final String ACCESIBLE_DOCUMENT_TYPE_06 = "06";
    public static final String ACCESIBLE_DOCUMENT_TYPE_07 = "07";
    public static final String ACCESIBLE_DOCUMENT_TYPE_08 = "08";
    public static final String ACCESIBLE_DOCUMENT_TYPE_09 = "09";
    public static final String ACCESIBLE_DOCUMENT_TYPE_D1 = "D1";
    public static final String ACCESIBLE_DOCUMENT_CHART_TYPE_PREFIX = "G";
    public static final String ACCESIBLE_DOCUMENT_TYPE_G1 = "G1";
    public static final String ACCESIBLE_DOCUMENT_TYPE_G2 = "G2";
    public static final String ACCESIBLE_DOCUMENT_TYPE_G3 = "G3";
    public static final String ACCESIBLE_DOCUMENT_TYPE_G4 = "G4";
    public static final String ACCESIBLE_DOCUMENT_TYPE_G5 = "G5";
    public static final String ACCESIBLE_DOCUMENT_TYPE_G6 = "G6";
    
    public static final char TIPO_RICERCA_CONSUNTIVO = 'C';
    public static final char TIPO_RICERCA_GESTIONE = 'G';
    

    public static final String COL_ATTUALE = "Attuale";
    public static final String COL_CHIUSURA = "Chiusura"; 
    
    public static final int RIC_REI = 1;
    public static final int RIC_STANZ = 2;
    
    public static final String STAT_TIPO_RICHIESTA_INSERIMENTO = "I";
    public static final String STAT_TIPO_RICHIESTA_MODIFICA = "M";
    public static final String STAT_TIPO_RICHIESTA_CANCELLAZIONE = "C";
    public static final String STAT_TIPO_RICHIESTA_DISABILITAZIONE = "D";
    public static final String STAT_TIPO_RICHIESTA_ABILITAZIONE = "A";
    public static final String STAT_TIPO_RICHIESTA_INS_PROF = "E";
    
    public static final String STAT_STATUS_RICHIESTA_PERVENUTA = "P";
    public static final String STAT_STATUS_RICHIESTA_ESEGUITA = "E";
    public static final String STAT_STATUS_RICHIESTA_PRESA_IN_CARICO = "C";
    public static final String STAT_STATUS_RICHIESTA_RIFIUTATA = "R";
    public static final String STAT_STATUS_RICHIESTA_ANNULLATA = "A";
    
    // poste parifica radio button:
    public enum Consistenza{

        IMPORTO_NULLO( "1", "Importo nullo"),
        IMPORTO_SIGNIFICATIVO( "2", "Importo significativo" );

        private String id;
        private String descrizione;

        Consistenza( String id, String descrizione ){
            this.id = id;
            this.descrizione = descrizione;
        }

        public String getId() {
            return this.id;
        }

        public String getDescrizione() {
            return this.descrizione;
        }

        public String getCodice() {
            return this.name();
        }

        public static List<Consistenza> getList() {
            return Arrays.asList(values());
        }

        public static Consistenza getEnumById( String id ){
            Consistenza enumResult = null;
            for ( Consistenza enu : Consistenza.values() ) {
                if ( enu.getId().equals( id ) )	{
                    enumResult = enu;
                    break;
                }
            }
            return enumResult;
        }

    }

    public enum StatoParifica{

        POSTE_ALLEGATI_PARIFICATI( "", "Poste o allegati parificati"),
        POSTE_ALLEGATI_REGOLARITA( "R", "Poste o allegati in stato di regolarit\u00e0" ),
        POSTE_ALLEGATI_IRREGOLARITA( "I", "Poste o allegati in stato di irregolarit\u00e0" );

        private String id;
        private String descrizione;

        StatoParifica( String id, String descrizione ){
            this.id = id;
            this.descrizione = descrizione;
        }

        public String getId() {
            return this.id;
        }

        public String getDescrizione() {
            return this.descrizione;
        }

        public String getCodice() {
            return this.name();
        }

        public static List<StatoParifica> getList() {
            return Arrays.asList(values());
        }

        public static StatoParifica getEnumById( String id ){
            StatoParifica enumResult = null;
            for ( StatoParifica enu : StatoParifica.values() ) {
                    if ( enu.getId().equals( id ) )	{
                        enumResult = enu;
                        break;
                    }
            }
            return enumResult;
        }

    }

	
}
