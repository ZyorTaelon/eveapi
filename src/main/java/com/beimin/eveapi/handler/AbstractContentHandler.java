package com.beimin.eveapi.handler;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.utils.GMTConverter;

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
    private static final HashSet<String> BASE_ELEMENTS = new HashSet<>(Arrays.asList(new String[] { ELEMENT_EVEAPI, ATTRIBUTE_RESULT, ELEMENT_ROW, ELEMENT_ROWSET }));

    private static GMTConverter converter = new GMTConverter();

    private E response;
    private boolean strictCheckMode;
    private Map<String, Set<String>> fields;
    private String currentClassName;
    private Deque<String> path;

    private final StringBuilder accumulator = new StringBuilder();
    private ApiError error;

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
        // May be set in elementStart
        currentClassName = null;
        elementStart(uri, localName, qName, attrs);
        if (ELEMENT_EVEAPI.equals(qName)) {
            response.setVersion(getInt(attrs, ATTRIBUTE_VERSION));
        } else if (ATTRIBUTE_ERROR.equals(qName)) {
            processError(attrs);
        } else if (strictCheckMode && ELEMENT_ROWSET.equals(qName)) {
            processRowset(attrs);
        }
        if (strictCheckMode && path != null) { // Save path
            processPath(qName, attrs);
        }
        accumulator.setLength(0);
    }

    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
    }

    @Override
    public final void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (strictCheckMode && path != null) {
            path.pollFirst();
        }
        elementEnd(uri, localName, qName);
        if (ELEMENT_CURRENT_TIME.equals(qName)) {
            response.setCurrentTime(getDate());
        } else if (ELEMENT_CACHED_UNTIL.equals(qName)) {
            response.setCachedUntil(getDate());
        } else if (ATTRIBUTE_ERROR.equals(qName)) {
            error.setError(getString());
        } else if (strictCheckMode && !BASE_ELEMENTS.contains(qName)) {
            save(qName);
        }
    }

    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
    }

    private void processPath(final String qName, final Attributes attrs) {
        String pathName;
        if (ELEMENT_ROWSET.equals(qName)) { // If rowset, use the rowset name
            String rowsetName = getString(attrs, ATTRIBUTE_NAME);
            if (rowsetName == null) {
                rowsetName = ELEMENT_ROWSET;
            }
            pathName = rowsetName;
        } else {
            pathName = qName;
        }
        path.addFirst(pathName);
    }

    private void processRowset(final Attributes attrs) {
        String name = getString(attrs, ATTRIBUTE_NAME);
        if (name == null) {
            name = ELEMENT_ROWSET;
        }
        if (path != null) {
            String parentElement = path.peekFirst();
            if (parentElement == null) {
                parentElement = "";
            }
            save(parentElement + name);
        } else {
            save(name);
        }
    }

    private void processError(final Attributes attrs) {
        error = new ApiError();
        saveAttributes(ApiError.class, attrs);
        error.setCode(getInt(attrs, ATTRIBUTE_CODE));
        response.setError(error);
    }

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
        return converter.convert(Date.class, string);
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

    public Map<String, Set<String>> enableStrictCheckMode(boolean fullPath) {
        if (fullPath) {
            path = new ArrayDeque<>();
        }
        strictCheckMode = true;
        fields = new ConcurrentHashMap<>();
        return fields;
    }

    protected void saveAttributes(final Class<?> clazz, final Attributes attrs) {
        if (strictCheckMode) {
            setCurrentClass(clazz);
            final String className = clazz.getName();
            final Set<String> add = new HashSet<>();
            for (int i = 0; i < attrs.getLength(); i++) {
                add.add(attrs.getQName(i));
            }
            addCount(className, add);
        }
    }

    protected void setCurrentClass(Class<?> currentElementClass) {
        this.currentClassName = currentElementClass.getName();
    }

    private void save(String name) {
        if (strictCheckMode) {
            if (currentClassName == null) {
                currentClassName = getResponse().getClass().getName();
            }
            addCount(currentClassName, Collections.singleton(name));
        }
    }

    private void addCount(String className, Set<String> add) {
        Set<String> set = fields.get(className);
        if (set == null) {
            set = new HashSet<>();
            fields.put(className, set);
        }
        for (String s : add) {
            set.add(s.toLowerCase(Locale.ENGLISH));
        }
    }

    public E getResponse() {
        return response;
    }
}
