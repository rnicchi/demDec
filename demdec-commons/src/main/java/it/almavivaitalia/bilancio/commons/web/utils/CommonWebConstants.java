package it.almavivaitalia.bilancio.commons.web.utils;

import it.almavivaitalia.web.sh.utils.WebConstants;

public interface CommonWebConstants extends WebConstants{
	public final static String ACTION_KEY_MESSAGE_PREFIX = "action.";
	public final static String MENU_KEY_MESSAGE_PREFIX = "menu.";

	/* ANCHOR */
	public final static String ANCHOR_START_FILTRI = "start_filtri";
	public final static String ANCHOR_START_TITOLO = "start_titolo";
	
	/* ITEM SELECTOR */
	public final static String PREFIX_METHOD_NAME = "on";
	
	public final static String ITEM_SELECTED = "_ITEM_SELECTED_";
	public final static String ACTION_SELECTED = "_ACTION_SELECTED_";
	
	public final static String SBSJ="SBSJ";
	
    // ***********COSTANTI PER ACCESSO OAM***************//
    public static final String OAM_LOGIN_URL = "/oam";
    public static final String OAM_LOGOUT_URL = "/oamuscita";
    public static final String OAM_AUTH_LOGIN_URL = "/login";
    public static final String OAM_AUTH_LOGOUT_URL = "/oamuscitaauth";
    public static final String OAM_REDIRECT_MENU_UTENTE = "redirect:secure/menu.html";
    public static final String OAM_REDIRECT_LOGOUT = "redirect:logoutoam.jsp";
    public static final String OAM_REDIRECT_SESSION_INVALID = "redirect:invalidSession.jsp";
      public static final String OAM_HEADER_NAME = "oam-user";
    public static final String OAM_HEADER_VALUE = "utente:";
    public static final String UFFICIO_LOGIN_PRM_ID = "idUfficio";
	
}