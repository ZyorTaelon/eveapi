package com.beimin.eveapi.handler;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.utils.DateUtils;

public abstract class AbstractContentHandler<E extends ApiResponse> extends DefaultHandler {
    private static final String MESSAGE_NUMBER_PARSER = "Couldn't parse number";
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractContentHandler.class);
    protected static final String ELEMENT_EVEAPI = "eveapi";
    protected static final String ELEMENT_CACHED_UNTIL = "cachedUntil";
    protected static final String ELEMENT_CURRENT_TIME = "currentTime";
    protected static final String ELEMENT_ROW = "row";
    protected static final String ELEMENT_ROWSET = "rowset";
    protected static final String ATTRIBUTE_VERSION = "version";
    protected static final String ATTRIBUTE_RESULT = "result";
    protected static final String ATTRIBUTE_CODE = "code";
    protected static final String ATTRIBUTE_ERROR = "error";
    protected static final String ATTRIBUTE_NAME = "name";
    protected static final String VALUE_TRUE = "true";

    private E response;
    private boolean strictCheckMode;
    private Map<String, Integer> fields;
    private Set<String> elements;
    private Set<String> ignoreElements;
    private String currentClassName;

    private final StringBuilder accumulator = new StringBuilder();
    private ApiError error;

    public AbstractContentHandler() {
        this(null);
    }

    public AbstractContentHandler(final E response) {
        super();
        this.response = response;
    }

    @Override
    public void characters(final char[] buffer, final int start, final int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public final void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        currentClassName = null; //May be set in elementStart
        elementStart(uri, localName, qName, attrs);
        if (ELEMENT_EVEAPI.equals(qName)) {
            response.setVersion(getInt(attrs, ATTRIBUTE_VERSION));
        } else if (ATTRIBUTE_ERROR.equals(qName)) {
            error = new ApiError();
            saveAttributes(ApiError.class, attrs);
            error.setCode(getInt(attrs, ATTRIBUTE_CODE));
            response.setError(error);
        }
        accumulator.setLength(0);
    }

    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException { }

    @Override
    public final void endElement(final String uri, final String localName, final String qName) throws SAXException {
        elementEnd(uri, localName, qName);
        if (ELEMENT_CURRENT_TIME.equals(qName)) {
            response.setCurrentTime(getDate());
        } else if (ELEMENT_CACHED_UNTIL.equals(qName)) {
            response.setCachedUntil(getDate());
        } else if (ATTRIBUTE_ERROR.equals(qName)) {
            error.setError(getString());
        } else if (!ATTRIBUTE_RESULT.equals(qName)
                && !ELEMENT_EVEAPI.equals(qName)
                //&& !ELEMENT_ROW.equals(qName)
                && !ELEMENT_ROWSET.equals(qName)
                && (ignoreElements == null || !ignoreElements.contains(qName))
                ) {
            saveElement(qName);
        }
    }

    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException { }

    protected String getString() {
        return accumulator.toString().trim();
    }

    protected String getString(final Attributes attrs, final String qName) {
        return attrs.getValue(qName);
    }

    protected Date getDate() {
        return getDate(getString());
    }

    protected Date getDate(final String string) {
        return DateUtils.getGMTConverter().convert(Date.class, string);
    }

    protected Date getDate(final Attributes attrs, final String qName) {
        return getDate(getString(attrs, qName));
    }

    protected Integer getInt() {
        return parseInteger(getString());
    }

    protected Integer getInt(final Attributes attrs, final String qName) {
        return parseInteger(getString(attrs, qName));
    }

    protected Integer parseInteger(final String value) {
        Integer result = null;
        if ((value != null) && !value.trim().isEmpty()) {
            try {
                result = Integer.valueOf(value);
            } catch (final NumberFormatException e) {
                LOGGER.error(MESSAGE_NUMBER_PARSER, e);
            }
        }
        return result;
    }

    protected Long getLong() {
        return parseLong(getString());
    }

    protected Long getLong(final Attributes attrs, final String qName) {
        return parseLong(getString(attrs, qName));
    }

    protected Long parseLong(final String value) {
        Long result = null;
        if ((value != null) && !value.trim().isEmpty()) {
            try {
                result = Long.valueOf(value);
            } catch (final NumberFormatException e) {
                LOGGER.error(MESSAGE_NUMBER_PARSER, e);
            }
        }
        return result;
    }

    protected Double getDouble() {
        return parseDouble(getString());
    }

    protected Double getDouble(final Attributes attrs, final String qName) {
        return parseDouble(getString(attrs, qName));
    }

    protected Double parseDouble(final String value) {
        Double result = null;
        if ((value != null) && !value.trim().isEmpty()) {
            try {
                result = Double.valueOf(value);
            } catch (final NumberFormatException e) {
                LOGGER.error(MESSAGE_NUMBER_PARSER, e);
            }
        }
        return result;
    }

    protected boolean getBoolean() {
        return "1".equals(getString()) || VALUE_TRUE.equalsIgnoreCase(getString());
    }

    protected boolean getBoolean(final Attributes attrs, final String qName) {
        return "1".equals(getString(attrs, qName)) || VALUE_TRUE.equalsIgnoreCase(getString(attrs, qName));
    }

    public Map<String, Integer> enableStrictCheckMode() {
        strictCheckMode = true;
        fields = new ConcurrentHashMap<>();
        return fields;
    }

    public void setIgnoreElements(Set<String> ignoreElements) {
        this.ignoreElements = ignoreElements;
    }

    protected void saveAttributes(final Class<?> clazz, final Attributes attrs) {
        if (strictCheckMode) {
            String className = clazz.getName();
            addCount(className, className, attrs.getLength());
        }
    }

    protected void setElementClass(Class<?> currentElementClass) {
        this.currentClassName = currentElementClass.getName();
    }

    private void saveElement(String elementName) {
        if (strictCheckMode) {
            if (currentClassName == null) {
                currentClassName = getResponse().getClass().getName();
            }
            addCount(elementName, currentClassName, 1);
        }
    }

    private void addCount(String id, String className, int add) {
        if (elements == null) {
            elements = new HashSet<>();
        }
        if (elements.contains(id)) {
            return; //Only add each element once
        }
        elements.add(id);
        Integer current = fields.get(className);
        if (current == null) {
            current = 0;
        }
        fields.put(className, current + add);
    }

    protected void setResponse(final E response) {
        this.response = response;
    }

    public E getResponse() {
        return response;
    }
}
