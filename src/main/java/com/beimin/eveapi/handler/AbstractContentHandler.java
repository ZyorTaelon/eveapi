package com.beimin.eveapi.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.utils.DateUtils;

public abstract class AbstractContentHandler extends DefaultHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractContentHandler.class);

    private static boolean strictCheckMode = false;
    private static Map<String, Integer> fields;

    protected StringBuffer accumulator = new StringBuffer(); // Accumulate parsed text
    private ApiError error;

    @Override
    public void characters(final char[] buffer, final int start, final int length) {
        accumulator.append(buffer, start, length);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (qName.equals("eveapi")) {
            getResponse().setVersion(getInt(attrs, "version"));
        } else if (qName.equals("error")) {
            error = new ApiError();
            saveFieldsCount(ApiError.class, attrs);
            error.setCode(getInt(attrs, "code"));
            getResponse().setError(error);
        }
        accumulator.setLength(0);
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (qName.equals("currentTime")) {
            getResponse().setCurrentTime(getDate());
        } else if (qName.equals("cachedUntil")) {
            getResponse().setCachedUntil(getDate());
        } else if (qName.equals("error")) {
            error.setError(getString());
        }
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
                result = Integer.parseInt(value);
            } catch (final NumberFormatException e) {
                LOGGER.error("Couldn't parse number", e);
            } catch (final NullPointerException e) {
                LOGGER.error("Couldn't parse number", e);
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
                result = Long.parseLong(value);
            } catch (final NumberFormatException e) {
                LOGGER.error("Couldn't parse number", e);
            } catch (final NullPointerException e) {
                LOGGER.error("Couldn't parse number", e);
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
                result = Double.parseDouble(value);
            } catch (final NumberFormatException e) {
                LOGGER.error("Couldn't parse number", e);
            } catch (final NullPointerException e) {
                LOGGER.error("Couldn't parse number", e);
            }
        }
        return result;
    }

    protected boolean getBoolean() {
        return "1".equals(getString()) || "true".equalsIgnoreCase(getString());
    }

    protected boolean getBoolean(final Attributes attrs, final String qName) {
        return "1".equals(getString(attrs, qName)) || "true".equalsIgnoreCase(getString(attrs, qName));
    }

    public static void enableStrictCheckMode() {
        AbstractContentHandler.strictCheckMode = true;
        fields = new HashMap<String, Integer>();
    }

    public static Map<String, Integer> getFields() {
        return fields;
    }

    protected void saveFieldsCount(final Class clazz, final Attributes attrs) {
        if (strictCheckMode) {
            Integer current = fields.get(clazz.getName());
            if (current == null) {
                current = 0;
            }
            fields.put(clazz.getName(), Math.max(current, attrs.getLength()));
        }
    }

    public abstract ApiResponse getResponse();
}