package it.almavivaitalia.web.sh.export.pdf;

import static it.almavivaitalia.bsn.sh.utils.ParseUtil.getNumberFormat;
import it.almavivaitalia.web.sh.export.Column;
import it.almavivaitalia.web.sh.export.ColumnIterator;
import it.almavivaitalia.web.sh.export.FieldFormatter;
import it.almavivaitalia.web.sh.export.HeaderCell;
import it.almavivaitalia.web.sh.export.ReportFileExport;
import it.almavivaitalia.web.sh.export.Row;
import it.almavivaitalia.web.sh.utils.Util;

import java.awt.Color;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public abstract class PdfReportParentFileExport  extends ReportFileExport{
    /*LOCM*/
	@SuppressWarnings("unused") private static final long serialVersionLOCM = 0L;
	/*END LOCM*/

   
	
    @Override
	public String getMimeType() {
        return "application/pdf";
	}
    
    
    protected PdfPCell getCell(String value,boolean trim, Font font) throws BadElementException {	
    	Phrase p =(trim) 
    		?new Phrase(new Chunk(StringUtils.trimToEmpty(value), font))
			:new Phrase(new Chunk(value, font));
    	
    	PdfPCell cell = new PdfPCell(p);
    	
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        return cell;
    }

}
