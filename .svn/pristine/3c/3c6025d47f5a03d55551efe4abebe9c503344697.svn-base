package it.almavivaitalia.web.sh.taglib;


import javax.servlet.jsp.JspException;








/**
 * Contiene i metodi base per le taglib nssb html
 * @author 
 *
 */
public class BaseAlmavivaHTMLTag extends BaseTag {

	private static final long serialVersionUID = 1L;


	 protected String getElementClose() {
		 return "/>";
    }

    /**
     * Return the text specified by the literal value or the message resources
     * key, if any; otherwise return <code>null</code>.
     *
     * @param literal Literal text value or <code>null</code>
     * @param key     Message resources key or <code>null</code>
     * @throws JspException if both arguments are non-null
     */
    protected String message(String literal, String key)
        throws JspException {
        if (literal != null) {
            if (key != null) {
                JspException e =
                    new JspException("no message in bundle under key: "+key);

                throw e;
            } else {
                return (literal);
            }
        } else {
            if (key != null) {
            	return getMessageSource().getMessage(key);
            } else {
                return null;
            }
        }
    }
	    //  Navigation Management

	    /**
	     * Access key character.
	     */
	    private String accesskey = null;

	    /**
	     * Tab index value.
	     */
	    private String tabindex = null;

	    //  Indexing ability for Iterate

	    /**
	     * Whether to created indexed names for fields
	     *
	     * @since Struts 1.1
	     */
	    private boolean indexed = false;

	    //  Mouse Events

	    /**
	     * Mouse click event.
	     */
	    private String onclick = null;

	    /**
	     * Mouse double click event.
	     */
	    private String ondblclick = null;

	    /**
	     * Mouse over component event.
	     */
	    private String onmouseover = null;

	    /**
	     * Mouse exit component event.
	     */
	    private String onmouseout = null;

	    /**
	     * Mouse moved over component event.
	     */
	    private String onmousemove = null;

	    /**
	     * Mouse pressed on component event.
	     */
	    private String onmousedown = null;

	    /**
	     * Mouse released on component event.
	     */
	    private String onmouseup = null;

	    //  Keyboard Events

	    /**
	     * Key down in component event.
	     */
	    private String onkeydown = null;

	    /**
	     * Key released in component event.
	     */
	    private String onkeyup = null;

	    /**
	     * Key down and up together in component event.
	     */
	    private String onkeypress = null;

	    // Text Events

	    /**
	     * Text selected in component event.
	     */
	    private String onselect = null;

	    /**
	     * Content changed after component lost focus event.
	     */
	    private String onchange = null;

	    // Focus Events and States

	    /**
	     * Component lost focus event.
	     */
	    private String onblur = null;

	    /**
	     * Component has received focus event.
	     */
	    private String onfocus = null;

	    /**
	     * Component is disabled.
	     */
	    private boolean disabled = false;

	    /**
	     * Indicates whether 'disabled' is a valid attribute
	     */
	    @SuppressWarnings("unused")
		private boolean doDisabled = true;

	    /**
	     * Component is readonly.
	     */
	    private boolean readonly = false;

	    /**
	     * <p>Indicates whether 'readonly' is a valid attribute.</p>
	     *
	     * <p>According to the HTML 4.0 Specification &lt;readonly&gt; is valid
	     * for &lt;input type="text"&gt;, &lt;input type="password"&gt; and
	     * &lt;textarea"&gt; elements. Therefore, except for those tags this value
	     * is set to <code>false</code>.</p>
	     */
	    @SuppressWarnings("unused")
		private boolean doReadonly = false;

	    // CSS Style Support

	    /**
	     * Style attribute associated with component.
	     */
	    private String style = null;

	    /**
	     * Named Style class associated with component.
	     */
	    private String styleClass = null;

	    /**
	     * Identifier associated with component.
	     */
	    private String styleId = null;


	    /**
	     * Style attribute associated with component when errors exist.
	     */
	    private String errorStyle = null;

	    /**
	     * Named Style class associated with component when errors exist.
	     */
	    private String errorStyleClass = null;

	    /**
	     * Identifier associated with component when errors exist.
	     */
	    private String errorStyleId = null;

	    // Other Common Attributes

	    /**
	     * The alternate text of this element.
	     */
	    private String alt = null;

	    /**
	     * The message resources key of the alternate text.
	     */
	    private String altKey = null;

	    /**
	     * The name of the message resources bundle for message lookups.
	     */
	    private String bundle = null;

	    
	    /**
	     * The advisory title of this element.
	     */
	    private String title = null;

	    /**
	     * The language code of this element.
	     */
	    private String lang = null;
	    
	    /**
	     * The direction for weak/neutral text of this element.
	     */
	    private String dir = null;

	    /**
	     * The message resources key of the advisory title.
	     */
	    private String titleKey = null;

	    // ------------------------------------------------------------- Properties
	    //  Navigation Management

	    /**
	     * Sets the accessKey character.
	     */
	    public void setAccesskey(String accessKey) {
	        this.accesskey = accessKey;
	    }

	    /**
	     * Returns the accessKey character.
	     */
	    public String getAccesskey() {
	        return (this.accesskey);
	    }

	    /**
	     * Sets the tabIndex value.
	     */
	    public void setTabindex(String tabIndex) {
	        this.tabindex = tabIndex;
	    }

	    /**
	     * Returns the tabIndex value.
	     */
	    public String getTabindex() {
	        return (this.tabindex);
	    }

	    //  Indexing ability for Iterate [since Struts 1.1]

	    /**
	     * Sets the indexed value.
	     *
	     * @since Struts 1.1
	     */
	    public void setIndexed(boolean indexed) {
	        this.indexed = indexed;
	    }

	    /**
	     * Returns the indexed value.
	     *
	     * @since Struts 1.1
	     */
	    public boolean getIndexed() {
	        return (this.indexed);
	    }

	    // Mouse Events

	    /**
	     * Sets the onClick event handler.
	     */
	    public void setOnclick(String onClick) {
	        this.onclick = onClick;
	    }

	    /**
	     * Returns the onClick event handler.
	     */
	    public String getOnclick() {
	        return onclick;
	    }

	    /**
	     * Sets the onDblClick event handler.
	     */
	    public void setOndblclick(String onDblClick) {
	        this.ondblclick = onDblClick;
	    }

	    /**
	     * Returns the onDblClick event handler.
	     */
	    public String getOndblclick() {
	        return ondblclick;
	    }

	    /**
	     * Sets the onMouseDown event handler.
	     */
	    public void setOnmousedown(String onMouseDown) {
	        this.onmousedown = onMouseDown;
	    }

	    /**
	     * Returns the onMouseDown event handler.
	     */
	    public String getOnmousedown() {
	        return onmousedown;
	    }

	    /**
	     * Sets the onMouseUp event handler.
	     */
	    public void setOnmouseup(String onMouseUp) {
	        this.onmouseup = onMouseUp;
	    }

	    /**
	     * Returns the onMouseUp event handler.
	     */
	    public String getOnmouseup() {
	        return onmouseup;
	    }

	    /**
	     * Sets the onMouseMove event handler.
	     */
	    public void setOnmousemove(String onMouseMove) {
	        this.onmousemove = onMouseMove;
	    }

	    /**
	     * Returns the onMouseMove event handler.
	     */
	    public String getOnmousemove() {
	        return onmousemove;
	    }

	    /**
	     * Sets the onMouseOver event handler.
	     */
	    public void setOnmouseover(String onMouseOver) {
	        this.onmouseover = onMouseOver;
	    }

	    /**
	     * Returns the onMouseOver event handler.
	     */
	    public String getOnmouseover() {
	        return onmouseover;
	    }

	    /**
	     * Sets the onMouseOut event handler.
	     */
	    public void setOnmouseout(String onMouseOut) {
	        this.onmouseout = onMouseOut;
	    }

	    /**
	     * Returns the onMouseOut event handler.
	     */
	    public String getOnmouseout() {
	        return onmouseout;
	    }

	    // Keyboard Events

	    /**
	     * Sets the onKeyDown event handler.
	     */
	    public void setOnkeydown(String onKeyDown) {
	        this.onkeydown = onKeyDown;
	    }

	    /**
	     * Returns the onKeyDown event handler.
	     */
	    public String getOnkeydown() {
	        return onkeydown;
	    }

	    /**
	     * Sets the onKeyUp event handler.
	     */
	    public void setOnkeyup(String onKeyUp) {
	        this.onkeyup = onKeyUp;
	    }

	    /**
	     * Returns the onKeyUp event handler.
	     */
	    public String getOnkeyup() {
	        return onkeyup;
	    }

	    /**
	     * Sets the onKeyPress event handler.
	     */
	    public void setOnkeypress(String onKeyPress) {
	        this.onkeypress = onKeyPress;
	    }

	    /**
	     * Returns the onKeyPress event handler.
	     */
	    public String getOnkeypress() {
	        return onkeypress;
	    }

	    // Text Events

	    /**
	     * Sets the onChange event handler.
	     */
	    public void setOnchange(String onChange) {
	        this.onchange = onChange;
	    }

	    /**
	     * Returns the onChange event handler.
	     */
	    public String getOnchange() {
	        return onchange;
	    }

	    /**
	     * Sets the onSelect event handler.
	     */
	    public void setOnselect(String onSelect) {
	        this.onselect = onSelect;
	    }

	    /**
	     * Returns the onSelect event handler.
	     */
	    public String getOnselect() {
	        return onselect;
	    }

	    // Focus Events and States

	    /**
	     * Sets the onBlur event handler.
	     */
	    public void setOnblur(String onBlur) {
	        this.onblur = onBlur;
	    }

	    /**
	     * Returns the onBlur event handler.
	     */
	    public String getOnblur() {
	        return onblur;
	    }

	    /**
	     * Sets the onFocus event handler.
	     */
	    public void setOnfocus(String onFocus) {
	        this.onfocus = onFocus;
	    }

	    /**
	     * Returns the onFocus event handler.
	     */
	    public String getOnfocus() {
	        return onfocus;
	    }

	    /**
	     * Sets the disabled event handler.
	     */
	    public void setDisabled(boolean disabled) {
	        this.disabled = disabled;
	    }

	    /**
	     * Returns the disabled event handler.
	     */
	    public boolean getDisabled() {
	        return disabled;
	    }

	    /**
	     * Sets the readonly event handler.
	     */
	    public void setReadonly(boolean readonly) {
	        this.readonly = readonly;
	    }

	    /**
	     * Returns the readonly event handler.
	     */
	    public boolean getReadonly() {
	        return readonly;
	    }

	    // CSS Style Support

	    /**
	     * Sets the style attribute.
	     */
	    public void setStyle(String style) {
	        this.style = style;
	    }

	    /**
	     * Returns the style attribute.
	     */
	    public String getStyle() {
	        return style;
	    }

	    /**
	     * Sets the style class attribute.
	     */
	    public void setStyleClass(String styleClass) {
	        this.styleClass = styleClass;
	    }

	    /**
	     * Returns the style class attribute.
	     */
	    public String getStyleClass() {
	        return styleClass;
	    }

	    /**
	     * Sets the style id attribute.
	     */
	    public void setStyleId(String styleId) {
	        this.styleId = styleId;
	    }

	    /**
	     * Returns the style id attribute.
	     */
	    public String getStyleId() {
	        return styleId;
	    }

	    /**
	     * Returns the error style attribute.
	     */
	    public String getErrorStyle() {
	        return errorStyle;
	    }

	    /**
	     * Sets the error style attribute.
	     */
	    public void setErrorStyle(String errorStyle) {
	        this.errorStyle = errorStyle;
	    }

	    /**
	     * Returns the error style class attribute.
	     */
	    public String getErrorStyleClass() {
	        return errorStyleClass;
	    }

	    /**
	     * Sets the error style class attribute.
	     */
	    public void setErrorStyleClass(String errorStyleClass) {
	        this.errorStyleClass = errorStyleClass;
	    }

	    /**
	     * Returns the error style id attribute.
	     */
	    public String getErrorStyleId() {
	        return errorStyleId;
	    }

	    /**
	     * Sets the error style id attribute.
	     */
	    public void setErrorStyleId(String errorStyleId) {
	        this.errorStyleId = errorStyleId;
	    }

	    // Other Common Elements

	    /**
	     * Returns the alternate text attribute.
	     */
	    public String getAlt() {
	        return alt;
	    }

	    /**
	     * Sets the alternate text attribute.
	     */
	    public void setAlt(String alt) {
	        this.alt = alt;
	    }

	    /**
	     * Returns the message resources key of the alternate text.
	     */
	    public String getAltKey() {
	        return altKey;
	    }

	    /**
	     * Sets the message resources key of the alternate text.
	     */
	    public void setAltKey(String altKey) {
	        this.altKey = altKey;
	    }

	    /**
	     * Returns the name of the message resources bundle to use.
	     */
	    public String getBundle() {
	        return bundle;
	    }

	    /**
	     * Sets the name of the message resources bundle to use.
	     */
	    public void setBundle(String bundle) {
	        this.bundle = bundle;
	    }


	    /**
	     * Returns the advisory title attribute.
	     */
	    public String getTitle() {
	        return title;
	    }

	    /**
	     * Sets the advisory title attribute.
	     */
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    /**
	     * Returns the message resources key of the advisory title.
	     */
	    public String getTitleKey() {
	        return titleKey;
	    }

	    /**
	     * Sets the message resources key of the advisory title.
	     */
	    public void setTitleKey(String titleKey) {
	        this.titleKey = titleKey;
	    }

	    /**
	     * Returns the language code of this element.
	     * 
	     * @since Struts 1.3.6
	     */
	    public String getLang() {
	        return this.lang;
	    }

	    /**
	     * Sets the language code of this element.
	     * 
	     * @since Struts 1.3.6
	     */
	    public void setLang(String lang) {
	        this.lang = lang;
	    }

	    /**
	     * Returns the direction for weak/neutral text this element.
	     * 
	     * @since Struts 1.3.6
	     */
	    public String getDir() {
	        return this.dir;
	    }

	    /**
	     * Sets the direction for weak/neutral text of this element.
	     * 
	     * @since Struts 1.3.6
	     */
	    public void setDir(String dir) {
	        this.dir = dir;
	    }

	    // --------------------------------------------------------- Public Methods

	    /**
	     * Release any acquired resources.
	     */
	    public void release() {
	        super.release();
	        accesskey = null;
	        alt = null;
	        altKey = null;
	        bundle = null;
	        dir = null;
	        errorStyle = null;
	        errorStyleClass = null;
	        errorStyleId = null;
	        indexed = false;
	        lang = null;
	        onclick = null;
	        ondblclick = null;
	        onmouseover = null;
	        onmouseout = null;
	        onmousemove = null;
	        onmousedown = null;
	        onmouseup = null;
	        onkeydown = null;
	        onkeyup = null;
	        onkeypress = null;
	        onselect = null;
	        onchange = null;
	        onblur = null;
	        onfocus = null;
	        disabled = false;
	        readonly = false;
	        style = null;
	        styleClass = null;
	        styleId = null;
	        tabindex = null;
	        title = null;
	        titleKey = null;
	    }

	    // ------------------------------------------------------ Protected Methods


	


	    /**
	     * Prepares the style attributes for inclusion in the component's HTML
	     * tag.
	     *
	     * @return The prepared String for inclusion in the HTML tag.
	     * @throws JspException if invalid attributes are specified
	     */
	    protected String prepareStyles()
	        throws JspException {
	        StringBuffer styles = new StringBuffer();

            prepareAttribute(styles, "id", getStyleId());

            prepareAttribute(styles, "style", getStyle());

            prepareAttribute(styles, "class", getStyleClass());

	        prepareAttribute(styles, "title", message(getTitle(), getTitleKey()));
	        prepareAttribute(styles, "alt", message(getAlt(), getAltKey()));
	        prepareInternationalization(styles);

	        return styles.toString();
	    }


	    /**
	     * Prepares the actual name of the component.
	     *
	     * @return The actual component name.
	     */
	    protected String prepareName()
	        throws JspException {
	        return null;
	    }
	    
	    /**
	     * Prepares the event handlers for inclusion in the component's HTML tag.
	     *
	     * @return The prepared String for inclusion in the HTML tag.
	     */
	    protected String prepareEventHandlers() {
	        StringBuffer handlers = new StringBuffer();

	        prepareMouseEvents(handlers);
	        prepareKeyEvents(handlers);
	        prepareTextEvents(handlers);

	        return handlers.toString();
	    }

	    /**
	     * Prepares the mouse event handlers, appending them to the the given
	     * StringBuffer.
	     *
	     * @param handlers The StringBuffer that output will be appended to.
	     */
	    protected void prepareMouseEvents(StringBuffer handlers) {
	        prepareAttribute(handlers, "onclick", getOnclick());
	        prepareAttribute(handlers, "ondblclick", getOndblclick());
	        prepareAttribute(handlers, "onmouseover", getOnmouseover());
	        prepareAttribute(handlers, "onmouseout", getOnmouseout());
	        prepareAttribute(handlers, "onmousemove", getOnmousemove());
	        prepareAttribute(handlers, "onmousedown", getOnmousedown());
	        prepareAttribute(handlers, "onmouseup", getOnmouseup());
	    }

	    /**
	     * Prepares the keyboard event handlers, appending them to the the given
	     * StringBuffer.
	     *
	     * @param handlers The StringBuffer that output will be appended to.
	     */
	    protected void prepareKeyEvents(StringBuffer handlers) {
	        prepareAttribute(handlers, "onkeydown", getOnkeydown());
	        prepareAttribute(handlers, "onkeyup", getOnkeyup());
	        prepareAttribute(handlers, "onkeypress", getOnkeypress());
	    }

	    /**
	     * Prepares the text event handlers, appending them to the the given
	     * StringBuffer.
	     *
	     * @param handlers The StringBuffer that output will be appended to.
	     */
	    protected void prepareTextEvents(StringBuffer handlers) {
	        prepareAttribute(handlers, "onselect", getOnselect());
	        prepareAttribute(handlers, "onchange", getOnchange());
	    }


	    /**
	     * Prepares the internationalization attribtes, appending them to the the given
	     * StringBuffer.
	     *
	     * @param handlers The StringBuffer that output will be appended to.
	     * @since Struts 1.3.6
	     */
	    protected void prepareInternationalization(StringBuffer handlers) {
	        prepareAttribute(handlers, "lang", getLang());
	        prepareAttribute(handlers, "dir", getDir());
	    }

	    /**
	     * 'Hook' to enable tags to be extended and additional attributes added.
	     *
	     * @param handlers The StringBuffer that output will be appended to.
	     */
	    protected void prepareOtherAttributes(StringBuffer handlers) {
	    }

	    /**
	     * Prepares an attribute if the value is not null, appending it to the the
	     * given StringBuffer.
	     *
	     * @param handlers The StringBuffer that output will be appended to.
	     */
	    protected void prepareAttribute(StringBuffer handlers, String name,
	        Object value) {
	        if (value != null) {
	            handlers.append(" ");
	            handlers.append(name);
	            handlers.append("=\"");
	            handlers.append(value);
	            handlers.append("\"");
	        }
	    }

		protected void write(String s) throws JspException{
			try {
				pageContext.getOut().write(s);
			}catch (Exception e) {
				throw new JspException(e);
			}
		}


	  

}
