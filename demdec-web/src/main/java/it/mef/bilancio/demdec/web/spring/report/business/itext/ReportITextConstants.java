package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public abstract class ReportITextConstants {

	/*
    FONT
     */
    public final static Font BIG_BOLD_WHITE = FontFactory.getFont(FontFactory.HELVETICA, 11f, Font.BOLD, BaseColor.WHITE);
    public final static Font BIG_BOLD_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 11f, Font.BOLD, BaseColor.BLACK);
    public final static Font BIG_NORMAL_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 11f, Font.NORMAL, BaseColor.BLACK);
    public final static Font BIG_MEDIUM_BOLD_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 10.5f, Font.BOLD, BaseColor.BLACK);
    public final static Font BIG_MEDIUM_NORMAL_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 10.5f, Font.NORMAL, BaseColor.BLACK);
    public final static Font MEDIUM_BOLD_WHITE = FontFactory.getFont(FontFactory.HELVETICA, 9f, Font.BOLD, BaseColor.WHITE);
    public final static Font MEDIUM_BOLD_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 9f, Font.BOLD, BaseColor.BLACK);
    public final static Font MEDIUM_NORMAL_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 9f, Font.NORMAL, BaseColor.BLACK);
    public final static Font LITTLE_BOLD_WHITE = FontFactory.getFont(FontFactory.HELVETICA, 8f, Font.BOLD, BaseColor.WHITE);
    public final static Font LITTLE_BOLD_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 8f, Font.BOLD, BaseColor.BLACK);
    public final static Font LITTLE_NORMAL_BLACK = FontFactory.getFont(FontFactory.HELVETICA, 8f, Font.NORMAL, BaseColor.BLACK);

    /*
   COLORI - vedi http://web.njit.edu/~kevin/rgb.txt.html

   NB: messi in ordine dal più scuro al più chiaro
    */
    //HEADER_01
    //public final static BaseColor ROYAL_BLUE_MINE = new BaseColor(70, 130, 190);
    public final static BaseColor ROYAL_BLUE_MINE = new BaseColor(39, 74, 106);
    //TOTALE_01
    public final static BaseColor LIGHT_SKY_BLUE_2 = new BaseColor(164, 211, 238);
    //COLSPAN_01
    public final static BaseColor LIGHT_CYAN_2 = new BaseColor(209, 238, 238);
    //DIFFERENZA_01
    public final static BaseColor LIGHT_CYAN = new BaseColor(224, 255, 255);
    //COLSPAN_04
    public final static BaseColor GREY_79 = new BaseColor(201, 201, 201);
    //COMMON_01, COMMON_02
    public final static BaseColor WHITE = new BaseColor(255, 255, 255);

    /*
    pie chart
     */
    public final static Color[] PIE_CHART_COLORS = {
            new Color(LIGHT_SKY_BLUE_2.getRGB()),
            new Color(ROYAL_BLUE_MINE.getRGB()),
            new Color(LIGHT_CYAN_2.getRGB()),
            new Color(GREY_79.getRGB()),
            new Color(LIGHT_CYAN.getRGB())
    };

    public final static java.awt.Font PIE_CHART_LABEL_FONT = new java.awt.Font(FontFactory.HELVETICA, java.awt.Font.BOLD, 11);
    public final static java.awt.Font PIE_CHART_LEGEND_FONT = new java.awt.Font(FontFactory.HELVETICA, java.awt.Font.BOLD, 9);

    public final static double[] PIE_CHART_EXPLODE_PERCENTS = {0.20D, 0.20D, 0.20D, 0.20D, 0.20D};

    /*
    bar chart
     */
    public final static Color[] BAR_CHART_COLORS = {new Color(ROYAL_BLUE_MINE.getRGB()),
            new Color(LIGHT_SKY_BLUE_2.getRGB()),
            new Color(LIGHT_CYAN_2.getRGB()),
            new Color(LIGHT_CYAN.getRGB()),
            new Color(GREY_79.getRGB())
    };

    public final static java.awt.Font BAR_CHART_LABEL_FONT = new java.awt.Font(FontFactory.HELVETICA, java.awt.Font.BOLD, 9);
    public final static java.awt.Font BAR_CHART_LABEL_FONT_LITTLE = new java.awt.Font(FontFactory.HELVETICA, java.awt.Font.BOLD, 8);
    public final static java.awt.Font BAR_CHART_LEGEND_FONT = new java.awt.Font(FontFactory.HELVETICA, java.awt.Font.BOLD, 11);
    public static final String DEFAULT_BAR_CHART_ROW_KEY = "DEFAULT_BAR_CHART_ROW_KEY";


    /*
   VARIE
    */
    public static final String DOCUMENT_NAME = "Report %s.pdf";
    public static final String DOCUMENT_NAME_XLS = "Report %s.xls";
    public static final String DOCUMENT_TITLE = "Tavola %s";
    public static final String SPLIT_CHARACTER = "\\$";
    public static final String ANNO_CONSUNTIVO = "\\$A";
    public static final String ANNO_CONSUNTIVO_MENO_UNO = "\\$B";
    public static final String ANNO_CONSUNTIVO_MENO_DUE = "\\$C";
    public static final String ANNO_CONSUNTIVO_MENO_TRE = "\\$D";
    public static final String ANNO_CONSUNTIVO_MENO_QUATTRO = "\\$E";
    public static final String COLUMN_PREFIX = "COL_";
    public static final String ROW_TYPE_KEY = "ROW_TYPE";
    public static final String HEADER_BREAK = "   ";
    public static final String TITLE_TAVOLA_DETTAGLIO_1 = "Tavola di dettaglio 1";
    public static final String CHART_TITLE = "Grafico n. %s";

    /*
   MARGINI
    */
    public static final String TOP_MARGIN_KEY = "TOP_MARGIN";
    public static final String BOTTOM_MARGIN_KEY = "BOTTOM_MARGIN";
    public static final String LEFT_MARGIN_KEY = "LEFT_MARGIN";
    public static final String RIGHT_MARGIN_KEY = "RIGHT_MARGIN";

    /*
    TIPI DI RIGHE
     */
    public static final String NEW_TABLE = "NEW_TABLE";
    public static final String HEADER_PREFIX = "HEADER";
    public static final String HEADER_01 = "HEADER_01";
    public static final String HEADER_02 = "HEADER_02";
    public static final String HEADER_03 = "HEADER_03";
    public static final String COLSPAN_PREFIX = "COLSPAN";
    public static final String COLSPAN_01 = "COLSPAN_01";
    public static final String COLSPAN_02 = "COLSPAN_02";
    public static final String COLSPAN_03 = "COLSPAN_03";
    public static final String COLSPAN_04 = "COLSPAN_04";
    public static final String COLSPAN_05 = "COLSPAN_05";
    public static final String COLSPAN_06 = "COLSPAN_06";
    public static final String COLSPAN_07 = "COLSPAN_07";
    public static final String COLSPAN_08 = "COLSPAN_08";
    public static final String TOTALE_01 = "TOTALE_01";
    public static final String TOTALE_02 = "TOTALE_02";
    public static final String TOTALE_03 = "TOTALE_03";
    public static final String TOTALE_04 = "TOTALE_04";
    public static final String TOTALE_05 = "TOTALE_05";
    public static final String TOTALE_06 = "TOTALE_06";
    public static final String TOTALE_07 = "TOTALE_07";
    public static final String TOTALE_08 = "TOTALE_08";
    public static final String DIFFERENZA_01 = "DIFFERENZA_01";
    public static final String DIFFERENZA_02 = "DIFFERENZA_02";
    public static final String MIGLIORAMENTO_01 = "MIGLIORAMENTO_01";
    public static final String COMMON_01 = "COMMON_01";
    public static final String COMMON_02 = "COMMON_02";
    public static final String COMMON_03 = "COMMON_03";
    public static final String COMMON_04 = "COMMON_04";
    public static final String COMMON_05 = "COMMON_05";
    public static final String COMMON_06 = "COMMON_06";
    public static final String COMMON_07 = "COMMON_07";
    public static final String COMMON_08 = "COMMON_08";
    public static final String COMMON_09 = "COMMON_09";
    public static final String COMMON_10 = "COMMON_10";
    public static final String COMMON_11 = "COMMON_11";
    public static final String COMMON_12 = "COMMON_12";
    public static final String COMMON_13 = "COMMON_13";
    public static final String NOTA_GRAFICO_7 = "NOTA_MIN_DIFESA";
    public static final String MIN_DIFESA = "MIN_DIFESA";
    public static final String NO_TAG = "NO_TAG";

	
}
