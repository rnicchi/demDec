package it.almavivaitalia.web.sh.taglib.displaytable.extraheader;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.displaytag.exception.DecoratorException;
import org.displaytag.exception.ObjectLookupException;
import org.displaytag.exception.WrappedRuntimeException;
import org.displaytag.model.Column;
import org.displaytag.model.HeaderCell;
import org.displaytag.model.Row;
import org.displaytag.model.TableModel;
import org.displaytag.pagination.PaginatedList;
import org.displaytag.pagination.SmartListHelper;
import org.displaytag.properties.MediaTypeEnum;
import org.displaytag.properties.SortOrderEnum;
import org.displaytag.properties.TableProperties;
import org.displaytag.render.TableWriterAdapter;
import org.displaytag.tags.CaptionTag;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.Anchor;
import org.displaytag.util.Href;
import org.displaytag.util.HtmlAttributeMap;
import org.displaytag.util.ParamEncoder;
import org.displaytag.util.PostHref;
import org.displaytag.util.TagConstants;

public class WriteOnlyDataRowsHtmlParentTableWriter extends WriteOnlyDataRowsHtmlParent1TableWriter {

	protected String esc(Object value) {
		String valueEscaped = StringUtils.replace(ObjectUtils.toString(value),
				"\"", "\\\"");
		return valueEscaped;
	}

	/**
	 * @param key
	 * @param value
	 */
	protected void writeField(String key, Object value) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<input type=\"hidden\" name=\"");
		buffer.append(esc(key));
		buffer.append("\" value=\"");
		buffer.append(value);
		buffer.append("\"/>");
	
		write(buffer.toString());
	}

	/**
	 * Writes the start of an HTML table's body to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeTableBodyOpener(org.displaytag.model.TableModel)
	 */
	protected void writeTableBodyOpener(TableModel model) {
	
		this.write(TagConstants.TAG_TBODY_OPEN);
	
	}

	/**
	 * Writes the closing structure of an HTML table to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeTableCloser(org.displaytag.model.TableModel)
	 */
	// scrive </table>
	protected void writeTableCloser(TableModel model) {
		/*
		 * this.write(TagConstants.TAG_OPENCLOSING);
		 * this.write(TagConstants.TABLE_TAG_NAME); //table
		 * this.write(TagConstants.TAG_CLOSE);
		 */
	}

	/**
	 * Utility method.
	 * 
	 * @param string
	 *            String
	 */
	public void write(Object string) {
		if (string != null) {
			try {
				getOut().write(string.toString());
			} catch (IOException e) {
				throw new WrappedRuntimeException(getClass(), e);
			}
		}
	
	}

	/**
	 * Utility method.
	 * 
	 * @param string
	 *            String
	 */
	public void write(String string) {
		if (string != null) {
			try {
				getOut().write(string);
			} catch (IOException e) {
				throw new WrappedRuntimeException(getClass(), e);
			}
		}
	
	}

	
}
