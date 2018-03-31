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

public class WriteOnlyDataRowsHtmlParent1TableWriter extends WriteOnlyDataRowsHtmlParent2TableWriter {

	/**
	 * Writes a banner containing search result, paging navigation, and export
	 * links below an HTML table to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeBottomBanner(org.displaytag.model.TableModel)
	 */
	protected void writeBottomBanner(TableModel model) {
		// writeNavigationAndExportLinks();
	}

	/**
	 * Writes an HTML table's caption to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeCaption(org.displaytag.model.TableModel)
	 */
	protected void writeCaption(TableModel model) {
		// this.write(captionTag.getOpenTag() + model.getCaption() +
		// captionTag.getCloseTag());
	}

	/**
	 * Writes an HTML table's column-closing tag to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeColumnCloser(org.displaytag.model.Column)
	 */
	protected void writeColumnCloser(Column column) {
		this.write(column.getCloseTag());
	}

	/**
	 * Writes an HTML table's column-opening tag to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeColumnOpener(org.displaytag.model.Column)
	 */
	protected void writeColumnOpener(Column column)
			throws ObjectLookupException, DecoratorException {
		this.write(column.getOpenTag());
	}

	/**
	 * Writes a HTML table column value to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeColumnValue(java.lang.String,org.displaytag.model.Column)
	 */
	protected void writeColumnValue(Object value, Column column) {
		this.write(value);
	}

	/**
	 * @see org.displaytag.render.TableWriterTemplate#writeDecoratedRowFinish(org.displaytag.model.TableModel)
	 */
	protected void writeDecoratedRowFinish(TableModel model) {
		this.write(model.getTableDecorator().finishRow());
	}

	/**
	 * @see org.displaytag.render.TableWriterTemplate#writeDecoratedRowStart(org.displaytag.model.TableModel)
	 */
	protected void writeDecoratedRowStart(TableModel model) {
		this.write(model.getTableDecorator().startRow());
	}

	/**
	 * @see org.displaytag.render.TableWriterTemplate#writeDecoratedTableFinish(org.displaytag.model.TableModel)
	 */
	protected void writeDecoratedTableFinish(TableModel model) {
		// model.getTableDecorator().finish();
	}

	/**
	 * Writes an HTML message to a JSP page explaining that the table model
	 * contains no data.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeEmptyListMessage(java.lang.String)
	 */
	protected void writeEmptyListMessage(String emptyListMessage) {
		this.write(emptyListMessage);
	}

	/**
	 * Writes an HTML message to a JSP page explaining that the row contains no
	 * data.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeEmptyListRowMessage(java.lang.String)
	 */
	protected void writeEmptyListRowMessage(String message) {
		this.write(message);
	}

	/**
	 * Writes an HTML table's footer to a JSP page; HTML requires tfoot to
	 * appear before tbody.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeFooter(org.displaytag.model.TableModel)
	 */
	protected void writePreBodyFooter(TableModel model) {
		/*
		 * this.write(TagConstants.TAG_TFOOTER_OPEN);
		 * this.write(model.getFooter());
		 * this.write(TagConstants.TAG_TFOOTER_CLOSE);
		 */
	}

	/**
	 * Writes an HTML table's row-closing tag to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeRowCloser(org.displaytag.model.Row)
	 */
	protected void writeRowCloser(Row row) {
		this.write(row.getCloseTag());
	}

	/**
	 * Writes an HTML table's row-opening tag to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeRowOpener(org.displaytag.model.Row)
	 */
	protected void writeRowOpener(Row row) {
		this.write(row.getOpenTag());
	}

	/**
	 * Writes to a JSP page an HTML table row that has no columns.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeRowWithNoColumns(java.lang.String)
	 */
	protected void writeRowWithNoColumns(String rowValue) {
		this.write(TagConstants.TAG_TD_OPEN);
		this.write(rowValue);
		this.write(TagConstants.TAG_TD_CLOSE);
	}

}
