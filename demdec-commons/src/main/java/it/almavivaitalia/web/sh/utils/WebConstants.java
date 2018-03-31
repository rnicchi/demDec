package it.almavivaitalia.web.sh.utils;

public interface WebConstants {
	public static final String HTTP_PROTOCOL="http";
	public static final String DEFAULT_HTTP_PORT="8080";
	public final static String E_COMMERCIALE="&";
	public final static String AMPERSAND_ENTITY ="&amp;";
	public final static String UGUALE="=";
	public final static String P_INTERROGATIVO="?";
 	public static final String SLASH="/";
 	public static final String BACKSLASH="\\";
 	
 	public static final String COLON=":";
 	
	public final static String COMMAND_BUTTON_PREFIX_POST="cmdPOST___";
	public final static String COMMAND_BUTTON_PREFIX_GET="cmdGET___";
	
	public final static String PARAMETER_PAGINATOR_NAME = "pgName";
	
	/* MENU */
	public final static String MENU_SBFJ = "baseMenu";
	public final static String PARAMETER_MENU_ITEM_SELECTED 		= "itemSelected";
	public final static String PARAMETER_MENU_ACTION_SELECTED 		= "actionSelected";
	public final static String PARAMETER_MENU_MENU_SELECTED 		= "menuSelected";
	public final static String PARAMETER_MENU_EXT_MENU_SELECTED		= "menuExtSelected";
	public final static String PARAMETER_MENU_SUB_ITEM_SELECTED 	= "subItemSelected";
	public static final String PARAMETER_REDIRECT					= "redirect";
	public final static String PARAMETER_SELECTOR 					= "selector";
	public final static String PARAMETER_SELECTOR_BACK_METHOD_NAME 	= "backMethodNameSelector";
	/* FINE MENU */
	
	public final static String PARAMETER_SELECT_ALL_ROWS			= "selectAllRows";
	
	public final static String SAVE_VIEW_FOR_SELECTOR="saveViewForSelector";
	public final static String FIELD_FORMATTER_FILE_NAME="fieldFormatterFileName";
	public final static String PARAMETER_SELECTOR_VALIDATOR_METHOD_NAME 	= "validatorMethodNameSelector";
	public final static String ACTION ="action";
	public final static String OUTPUT ="output_";
	public final static String INPUT ="input_";
	public final static String SRC ="src";
	public final static String IMAGE ="image";
	public final static String HIDDEN ="hidden";
	public final static String VALUE ="value";
	public final static String UNDERSCORE ="_";
	
	public final static String AMBIENTE="ambiente";
	public final static String AMBIENTE_SVIL="SVIL";
	public final static String AMBIENTE_COLL="COLL";
	// summary  per selector
    public final static String SUMMARY_SELECTOR_ITEM="__SUMMARY_SELECTOR_ITEM__";
    public final static String SUMMARY_PREFIX="summary.";
	// caption  per selector
    public final static String CAPTION_SELECTOR_ITEM="__CAPTION_SELECTOR_ITEM__";
    public final static String CAPTION_PREFIX="caption.";
    
    public final static String FORMATTER_SUFFIX="Formatter";
}
