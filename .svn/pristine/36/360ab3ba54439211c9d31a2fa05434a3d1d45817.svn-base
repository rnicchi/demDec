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

public class WriteOnlyDataRowsHtmlTableWriter extends WriteOnlyDataRowsHtmlParentTableWriter {

	/**
	 * Logger.
	 */
	private static Log log = LogFactory
			.getLog(WriteOnlyDataRowsHtmlTableWriter.class);

	/**
	 * This table writer uses a <code>TableTag</code> and a
	 * <code>JspWriter</code> to do its work.
	 * 
	 * @param tableTag
	 *            <code>TableTag</code> instance called back by this writer.
	 * @param out
	 *            The output destination.
	 */
	public WriteOnlyDataRowsHtmlTableWriter(TableModel tableModel,
			TableProperties tableProperties, Href baseHref, boolean export,
			JspWriter out, CaptionTag captionTag, PaginatedList paginatedList,
			SmartListHelper listHelper, int pagesize,
			HtmlAttributeMap attributeMap, String uid) {
		setTableModel(tableModel);
		setProperties( tableProperties);
		setBaseHref(baseHref); 
		setExport(export);
		setOut(out);
		setCaptionTag(captionTag);
		setPaginatedList(paginatedList);
		setListHelper(listHelper);
		setPagesize(pagesize);
		setAttributeMap(attributeMap);
		setUid(uid);
	}

	/**
	 * Writes a banner containing search result and paging navigation above an
	 * HTML table to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeTopBanner(org.displaytag.model.TableModel)
	 */
	protected void writeTopBanner(TableModel model) {
		if (getTableModel().getForm() != null) {

			String js = "<script type=\"text/javascript\">\n"
					+ "function displaytagform(formname, fields){\n"
					+ "    var objfrm = document.forms[formname];\n"
					+ "    for (j=fields.length-1;j>=0;j--){var f= objfrm.elements[fields[j].f];if (f){f.value=fields[j].v};}\n"
					+ "    objfrm.submit();\n" + "}\n" + "</script>";
			writeFormFields();
			write(js);
		}
		writeSearchResultAndNavigation();
	}

	/**
	 * Writes an HTML table's opening tags to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeTableOpener(org.displaytag.model.TableModel)
	 */
	protected void writeTableOpener(TableModel model) {
		this.write(getOpenTag());
	}

	private void writeFormFields() {
		@SuppressWarnings("rawtypes")
		Map parameters = getBaseHref().getParameterMap();

		ParamEncoder pe = new ParamEncoder(getTableModel().getId());

		addIfMissing(parameters,
				pe.encodeParameterName(TableTagParameters.PARAMETER_ORDER));
		addIfMissing(parameters,
				pe.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		addIfMissing(parameters,
				pe.encodeParameterName(TableTagParameters.PARAMETER_SORT));

		for (@SuppressWarnings("rawtypes")
		Iterator it = parameters.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			Object value = parameters.get(key);

			if (value != null & value.getClass().isArray()) {
				Object[] arr = (Object[]) value;
				for (int j = 0; j < arr.length; j++) {
					writeField(key, arr[j]);
				}
			} else {
				writeField(key, value);
			}
		}
	}

	/**
	 * Adds an element to the given map if empty (use an empty string as value)
	 * 
	 * @param parameters
	 *            Map of parameters
	 * @param key
	 *            param key
	 */
	@SuppressWarnings("unchecked")
	private void addIfMissing(@SuppressWarnings("rawtypes") Map parameters,
			String key) {
		if (!parameters.containsKey(key)) {
			parameters.put(key, StringUtils.EMPTY);
		}
	}

	/**
	 * Writes an HTML table's column header to a JSP page.
	 * 
	 * @see org.displaytag.render.TableWriterTemplate#writeTableHeader(org.displaytag.model.TableModel)
	 */
	protected void writeTableHeader(TableModel model) {

		if (log.isDebugEnabled()) {
			log.debug("[" + getTableModel().getId() + "] getTableHeader called");
		}

		// open thead
		// write(TagConstants.TAG_THEAD_OPEN);

		// open tr
		write(TagConstants.TAG_TR_OPEN);

		// no columns?
		if (getTableModel().isEmpty()) {
			write(TagConstants.TAG_TH_OPEN);
			write(TagConstants.TAG_TH_CLOSE);
		}

		// iterator on columns for header
		@SuppressWarnings("rawtypes")
		Iterator iterator = getTableModel().getHeaderCellList().iterator();

		while (iterator.hasNext()) {
			// get the header cell
			HeaderCell headerCell = (HeaderCell) iterator.next();

			if (headerCell.getSortable()) {
				String cssSortable = getProperties().getCssSortable();
				headerCell.addHeaderClass(cssSortable);
			}

			// if sorted add styles
			if (headerCell.isAlreadySorted()) {
				// sorted css class
				headerCell.addHeaderClass(getProperties().getCssSorted());

				// sort order css class
				headerCell.addHeaderClass(getProperties()
						.getCssOrder(getTableModel().isSortOrderAscending()));
			}

			// append th with html attributes
			write(headerCell.getHeaderOpenTag());

			// title
			String header = headerCell.getTitle();

			// column is sortable, create link
			if (headerCell.getSortable()) {
				// creates the link for sorting
				Anchor anchor = new Anchor(getSortingHref(headerCell), header);

				// append to buffer
				header = anchor.toString();
			}

			write(header);
			write(headerCell.getHeaderCloseTag());
		}

		// close tr
		write(TagConstants.TAG_TR_CLOSE);

		// close thead
		write(TagConstants.TAG_THEAD_CLOSE);

		if (log.isDebugEnabled()) {
			log.debug("[" + getTableModel().getId() + "] getTableHeader end");
		}

	}

	/**
	 * Generates the link to be added to a column header for sorting.
	 * 
	 * @param headerCell
	 *            header cell the link should be added to
	 * @return Href for sorting
	 */
	private Href getSortingHref(HeaderCell headerCell) {
		// costruct Href from base href, preserving parameters
		Href href = (Href) getBaseHref().clone();

		if (getTableModel().getForm() != null) {
			href = new PostHref(href, getTableModel().getForm());
		}

		if (this.getPaginatedList() == null) {
			// add column number as link parameter
			if (!getTableModel().isLocalSort()
					&& (headerCell.getSortName() != null)) {
				href.addParameter(
						encodeParameter(TableTagParameters.PARAMETER_SORT),
						headerCell.getSortName());
				href.addParameter(
						encodeParameter(TableTagParameters.PARAMETER_SORTUSINGNAME),
						"1");
			} else {
				href.addParameter(
						encodeParameter(TableTagParameters.PARAMETER_SORT),
						headerCell.getColumnNumber());
			}

			boolean nowOrderAscending = true;

			if (headerCell.getDefaultSortOrder() != null) {
				boolean sortAscending = SortOrderEnum.ASCENDING
						.equals(headerCell.getDefaultSortOrder());
				nowOrderAscending = headerCell.isAlreadySorted() ? !getTableModel()
						.isSortOrderAscending() : sortAscending;
			} else {
				nowOrderAscending = !(headerCell.isAlreadySorted() && getTableModel()
						.isSortOrderAscending());
			}

			int sortOrderParam = nowOrderAscending ? SortOrderEnum.ASCENDING
					.getCode() : SortOrderEnum.DESCENDING.getCode();
			href.addParameter(
					encodeParameter(TableTagParameters.PARAMETER_ORDER),
					sortOrderParam);

			// If user want to sort the full table I need to reset the page
			// number.
			// or if we aren't sorting locally we need to reset the page as
			// well.
			if (getTableModel().isSortFullTable()
					|| !getTableModel().isLocalSort()) {
				href.addParameter(
						encodeParameter(TableTagParameters.PARAMETER_PAGE), 1);
			}
		} else {
			if (getProperties().getPaginationSkipPageNumberInSort()) {
				href.removeParameter(getProperties().getPaginationPageNumberParam());
			}

			String sortProperty = headerCell.getSortProperty();
			if (sortProperty == null) {
				sortProperty = headerCell.getBeanPropertyName();
			}

			href.addParameter(getProperties().getPaginationSortParam(), sortProperty);
			String dirParam;
			if (headerCell.isAlreadySorted()) {
				dirParam = getTableModel().isSortOrderAscending() ? getProperties()
						.getPaginationDescValue() : getProperties()
						.getPaginationAscValue();
			} else {
				dirParam = getProperties().getPaginationAscValue();
			}
			href.addParameter(getProperties().getPaginationSortDirectionParam(),
					dirParam);
			if (getPaginatedList().getSearchId() != null) {
				href.addParameter(getProperties().getPaginationSearchIdParam(),
						getPaginatedList().getSearchId());
			}
		}

		return href;
	}

	/**
	 * encode a parameter name to be unique in the page using ParamEncoder.
	 * 
	 * @param parameterName
	 *            parameter name to encode
	 * @return String encoded parameter name
	 */
	private String encodeParameter(String parameterName) {
		// paramEncoder has been already instantiated?
		if (getParamEncoder() == null) {
			// use the id attribute to get the unique identifier
//			getParamEncoder() = new ParamEncoder(getTableModel().getId());
			setParamEncoder(new ParamEncoder(getTableModel().getId()));
		}

		return getParamEncoder().encodeParameterName(parameterName);
	}

	/**
	 * Generates table footer with links for export commands.
	 */
	public void writeNavigationAndExportLinks() {
		// Put the page stuff there if it needs to be there...
		if (getProperties().getAddPagingBannerBottom()) {
			writeSearchResultAndNavigation();
		}

		// add export links (only if the table is not empty)
		if (isExport()&& getTableModel().getRowListPage().size() != 0) {
			writeExportLinks();
		}
	}

	/**
	 * generates the search result and navigation bar.
	 */
	public void writeSearchResultAndNavigation() {
		if ((getPaginatedList() == null && getPagesize() != 0 && getListHelper() != null)
				|| (getPaginatedList() != null)) {
			// create a new href
			Href navigationHref = (Href) getBaseHref().clone();

			if (getTableModel().getForm() != null) {
				navigationHref = new PostHref(navigationHref,
						getTableModel().getForm());
			}

			write(getListHelper().getSearchResultsSummary());

			String pageParameter;
			if (getPaginatedList() == null) {
				pageParameter = encodeParameter(TableTagParameters.PARAMETER_PAGE);
			} else {
				pageParameter = getProperties().getPaginationPageNumberParam();
				if ((getPaginatedList().getSearchId() != null)
						&& (!navigationHref.getParameterMap().containsKey(
								getProperties().getPaginationSearchIdParam()))) {
					navigationHref.addParameter(
							getProperties().getPaginationSearchIdParam(),
							getPaginatedList().getSearchId());
				}
			}
			write(getListHelper().getPageNavigationBar(navigationHref,
					pageParameter));
		}
	}

	/**
	 * Writes the formatted export links section.
	 */
	private void writeExportLinks() {
		// Figure out what formats they want to export, make up a little string
		Href exportHref = (Href) getBaseHref().clone();

		StringBuffer buffer = new StringBuffer(200);
		@SuppressWarnings("rawtypes")
		Iterator iterator = MediaTypeEnum.iterator();

		while (iterator.hasNext()) {
			MediaTypeEnum currentExportType = (MediaTypeEnum) iterator.next();

			if (getProperties().getAddExport(currentExportType)) {

				if (buffer.length() > 0) {
					buffer.append(getProperties().getExportBannerSeparator());
				}

				exportHref
						.addParameter(
								encodeParameter(TableTagParameters.PARAMETER_EXPORTTYPE),
								currentExportType.getCode());

				// export marker
				exportHref.addParameter(TableTagParameters.PARAMETER_EXPORTING,
						"1");

				Anchor anchor = new Anchor(exportHref,
						getProperties().getExportLabel(currentExportType));
				buffer.append(anchor.toString());
			}
		}

		String[] exportOptions = { buffer.toString() };
		
		write(MessageFormat.format(getProperties().getExportBanner(), exportOptions));
	}

	/**
	 * create the open tag containing all the attributes.
	 * 
	 * @return open tag string: <code>%lt;table attribute="value" ... ></code>
	 */
	public String getOpenTag() {
		/*
		 * if (this.uid != null && attributeMap.get(TagConstants.ATTRIBUTE_ID)
		 * == null) { // we need to clone the attribute map in order to "fix"
		 * the html id when using only the "uid" attribute Map localAttributeMap
		 * = (Map) attributeMap.clone();
		 * localAttributeMap.put(TagConstants.ATTRIBUTE_ID, this.uid);
		 * 
		 * StringBuffer buffer = new StringBuffer();
		 * buffer.append(TagConstants.TAG_OPEN
		 * ).append(TagConstants.TABLE_TAG_NAME);
		 * buffer.append(localAttributeMap);
		 * buffer.append(TagConstants.TAG_CLOSE);
		 * 
		 * return buffer.toString();
		 * 
		 * }
		 * 
		 * // fast, no clone StringBuffer buffer = new StringBuffer();
		 * 
		 * buffer.append(TagConstants.TAG_OPEN).append(TagConstants.TABLE_TAG_NAME
		 * ); buffer.append(attributeMap);
		 * buffer.append(TagConstants.TAG_CLOSE);
		 * 
		 * return buffer.toString();
		 */
		return "";
	}

}
