package it.almavivaitalia.bilancio.commons.web.utils;

import it.almavivaitalia.web.sh.utils.BaseSessionAttributes;

public interface CommonSessionAttributes extends BaseSessionAttributes {

	public final static String ESERCIZIO_GESTIONE = "__ESERCIZIO_GESTIONE__";
	public final static String ESERCIZIO_FORMAZIONE = "__ESERCIZIO_FORMAZIONE__";
	public final static String ESERCIZIO_CONSUNTIVO = "__ESERCIZIO_CONSUNTIVO__";
	public final static String STAT_TIPO_ESE_GEST 			="G";
	public final static String STAT_TIPO_ESE_FORM 			="F";
	public final static String STAT_TIPO_ESE_CONS 			="C";
	 
	public final static String OBJECT_SECURITY = "__OBJECT_SECURITY__";

	public final static String OBJECT_MENU = "__OBJECT_MENU__";
	public final static String MAP_MENU = "__MAP_MENU__";
	public final static String DESC_CODI_MENU_MAP = "__DESC_CODI_MENU_MAP__";
	public final static String LIST_MENU_ITEM = "__LIST_MENU_ITEM__";
	public final static String OBJECT_SELECTED_ITEM_ID = "__OBJECT_SELECTED_ITEM_ID__";
	public final static String OBJ_SELECTED_CODI_ITEM_I_LEV = "__OBJ_SELECTED_CODI_ITEM_I_LEV__";
	public final static String LIST_MENU = "__LIST_MENU__";
	
	/* FILE EXPORT PDF E EXCEL */
	 public final static String EXPORT_GENERIC_PDF="__EXPORT_GENERIC_PDF__";
	 public final static String EXPORT_GENERIC_EXCEL="__EXPORT_GENERIC_EXCEL__";
	 public final static String EXPORT_KEYS_PDF="__EXPORT_KEYS_PDF__";
	 public final static String EXPORT_KEYS_EXCEL="__EXPORT_KEYS_EXCEL__";
	 /* FINE FILE EXPORT PDF  E EXCEL*/
	 
	 public final static String CONTEXT="CONTEXT";
	 
	 public final static String ID_ITEM_FROM_SUB_ITEM = "__ID_ITEM_FROM_SUB_ITEM__";
	 public final static String STR_INTERPUNZIONE = "*";
	 public final static String FORCE_OPEN = "forceOpen";
	 
	 public static final String RETURN_METHOD_NAME_OF_REDIRECT_CONTROLLER = "backFrom";
	 
	 public final static String J_STAMPANTE_LIST 	= "_J_STAMPANTE_LIST_";
	 
	 public final static String STRUMENTO = "__STRUMENTO__";
	 
	 public final static String APPLICATION_PARAMETERS_MAP = "_APPLICATION_PARAMETERS_MAP_";
	 
	 public final static String LIST_MENU_SECONDARIO = "__LIST_MENU_SECONDARIO__";
	 public final static String SELECT_ALL_ROWS		 = "selectAllRows";
	 
	 public final static String OBJECT_ESERCIZI = "__OBJECT_ESERCIZI__";
}
