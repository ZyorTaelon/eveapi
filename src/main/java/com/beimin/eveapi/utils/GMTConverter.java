package com.beimin.eveapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GMTConverter {
    public final static TimeZone DEFAULT_TIMEZONE = TimeZone.getTimeZone("GMT");
    private final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private final String dateFormat;

    public GMTConverter() {
        this(DEFAULT_FORMAT);
    }

    public GMTConverter(final String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @SuppressWarnings("rawtypes")
    public Date convert(final Class type, final Object value) {
        if (!(value instanceof String)) {
            throw new RuntimeException("wrong input value");
        }
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            sdf.setTimeZone(DEFAULT_TIMEZONE);
            return sdf.parse((String) value);
        } catch (final ParseException e) {
            return null;
        }
    }
}
