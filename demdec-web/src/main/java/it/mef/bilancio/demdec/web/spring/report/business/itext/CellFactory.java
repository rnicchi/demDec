package it.mef.bilancio.demdec.web.spring.report.business.itext;

import com.itextpdf.text.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nicchi
 * Date: 02/02/16
 * Time: 15.45
 * To change this template use File | Settings | File Templates.
 */

public class CellFactory {
	
	public static AccessibleCell getCell(String rowType, Object content, boolean isFirstColumn) {
        String stringContent = content == null ? "" : content.toString();
        String[] splittedContent = stringContent.split(ReportITextConstants.SPLIT_CHARACTER);
        String text = splittedContent[0];
        String alternativeText = splittedContent.length == 2 ? splittedContent[1] : null;
        /*
        si formattano le celle in base alla loro tipologia
         */
        AccessibleCell cell = null;
        /*
         ****************  HEADER
         */
        if (rowType.equals(ReportITextConstants.HEADER_01)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.BIG_BOLD_WHITE), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.ROYAL_BLUE_MINE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        } else if (rowType.equals(ReportITextConstants.HEADER_02)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.MEDIUM_BOLD_WHITE), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.ROYAL_BLUE_MINE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        } else if (rowType.equals(ReportITextConstants.HEADER_03)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.LITTLE_BOLD_WHITE), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.ROYAL_BLUE_MINE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        }
        /*
        **************************  COLSPAN
         */
        else if (rowType.contains(ReportITextConstants.COLSPAN_01)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.BIG_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setPaddingLeft(40f);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_02)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_03)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.LITTLE_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_04)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.GREY_79);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_05)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_06)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.BIG_MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setPaddingLeft(40f);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_07)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.BIG_MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_SKY_BLUE_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setPaddingLeft(40f);

        } else if (rowType.contains(ReportITextConstants.COLSPAN_08)) {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_SKY_BLUE_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setPaddingLeft(40f);

        }
        /*
        ****************************** TOTALE
         */
        else if (rowType.equals(ReportITextConstants.TOTALE_01)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_SKY_BLUE_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_02)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_03)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.LITTLE_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_04)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_MEDIUM_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_SKY_BLUE_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_05)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.BIG_MEDIUM_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_06)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.BIG_MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_07)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.GREY_79);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.TOTALE_08)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.GREY_79);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        }
        /*
        **************************      DIFFERENZA
         */
        else if (rowType.equals(ReportITextConstants.DIFFERENZA_01)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.DIFFERENZA_02)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_MEDIUM_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        }
        /*
        *******************************   MIGLIORAMENTO/PEGGIORAMENTO
         */
        else if (rowType.equals(ReportITextConstants.MIGLIORAMENTO_01)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_MEDIUM_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        }
        /*
        ******************************    COMMON
         */
        else if (rowType.equals(ReportITextConstants.COMMON_01)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_02)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_NORMAL_BLACK : ReportITextConstants.MEDIUM_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_03)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_BOLD_BLACK : ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_CYAN_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_04)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.MEDIUM_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_05)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.LITTLE_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_06)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.LITTLE_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_07)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_08)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_SKY_BLUE_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_09)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.LITTLE_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.LIGHT_SKY_BLUE_2);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_10)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_MEDIUM_BOLD_BLACK : ReportITextConstants.MEDIUM_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_11)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.BIG_MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_12)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), ReportITextConstants.BIG_MEDIUM_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        } else if (rowType.equals(ReportITextConstants.COMMON_13)) {
            cell = new AccessibleCell(new Phrase(isFirstColumn ?  text : text.trim(), isFirstColumn ? ReportITextConstants.BIG_BOLD_BLACK : ReportITextConstants.MEDIUM_NORMAL_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(isFirstColumn ? Element.ALIGN_LEFT : Element.ALIGN_RIGHT);

        }
        /*
        *********************** JUST IN CASE ;)
         */
        else {
            cell = new AccessibleCell(new Phrase(text, ReportITextConstants.MEDIUM_BOLD_BLACK), alternativeText);
            cell.setBackgroundColor(ReportITextConstants.WHITE);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);

        }
        cell.setRowType(rowType);
        return cell;
    }

}
