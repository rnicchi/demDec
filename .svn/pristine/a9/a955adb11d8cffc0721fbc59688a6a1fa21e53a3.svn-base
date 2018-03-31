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

public class WriteOnlyDataRowsHtmlParent3TableWriter extends TableWriterAdapter {

//	@SuppressWarnings("unused")
	private HtmlAttributeMap attributeMap;
	/**
	 * base href used for links.
	 */
	private Href baseHref;
//	@SuppressWarnings("unused")
	private CaptionTag captionTag;
	/**
	 * add export links.
	 */
	private boolean export;
	/**
	 * Used by various functions when the person wants to do paging.
	 */
	private SmartListHelper listHelper;
	/**
	 * Output destination.
	 */
	private JspWriter out;
	/**
	 * page size.
	 */
	private int pagesize;
	
	public HtmlAttributeMap getAttributeMap() {
		return attributeMap;
	}
	public void setAttributeMap(HtmlAttributeMap attributeMap) {
		this.attributeMap = attributeMap;
	}
	public Href getBaseHref() {
		return baseHref;
	}
	public void setBaseHref(Href baseHref) {
		this.baseHref = baseHref;
	}
	public CaptionTag getCaptionTag() {
		return captionTag;
	}
	public void setCaptionTag(CaptionTag captionTag) {
		this.captionTag = captionTag;
	}
	public boolean isExport() {
		return export;
	}
	public void setExport(boolean export) {
		this.export = export;
	}
	public SmartListHelper getListHelper() {
		return listHelper;
	}
	public void setListHelper(SmartListHelper listHelper) {
		this.listHelper = listHelper;
	}
	public JspWriter getOut() {
		return out;
	}
	public void setOut(JspWriter out) {
		this.out = out;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
