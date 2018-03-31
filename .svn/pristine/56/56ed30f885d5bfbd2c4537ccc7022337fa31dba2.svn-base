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

public class WriteOnlyDataRowsHtmlParent2TableWriter extends WriteOnlyDataRowsHtmlParent3TableWriter {

	/**
	 * The paginated list containing the external pagination and sort parameters
	 * The presence of this paginated list is what determines if external
	 * pagination and sorting is used or not.
	 */
	private PaginatedList paginatedList;
	/**
	 * The param encoder used to generate unique parameter names. Initialized at
	 * the first use of encodeParameter().
	 */
	private ParamEncoder paramEncoder;
	/**
	 * <code>TableProperties</code>
	 */
	private TableProperties properties;
	/**
	 * <code>TableModel</code>
	 */
	private TableModel tableModel;
	/**
	 * Unique table id.
	 */
	private String uid;
	
	public PaginatedList getPaginatedList() {
		return paginatedList;
	}
	public void setPaginatedList(PaginatedList paginatedList) {
		this.paginatedList = paginatedList;
	}
	public ParamEncoder getParamEncoder() {
		return paramEncoder;
	}
	public void setParamEncoder(ParamEncoder paramEncoder) {
		this.paramEncoder = paramEncoder;
	}
	public TableProperties getProperties() {
		return properties;
	}
	public void setProperties(TableProperties properties) {
		this.properties = properties;
	}
	public TableModel getTableModel() {
		return tableModel;
	}
	public void setTableModel(TableModel tableModel) {
		this.tableModel = tableModel;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
	public void writeTable(TableModel model, String id) throws JspException {
		super.writeTable(model, id);
	}
	/**
	 * Writes the end of an HTML table's body to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeTableBodyCloser(org.displaytag.model.TableModel)
	 */
	protected void writeTableBodyCloser(TableModel model) {
		this.write(TagConstants.TAG_TBODY_CLOSE);
	}

}
