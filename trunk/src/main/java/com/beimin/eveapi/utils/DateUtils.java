package com.beimin.eveapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.beanutils.Converter;

public class DateUtils {
	private static final SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	public static Date parseDate(String source) throws ParseException {
		return sdf.parse(source);
	}

	public static Converter getGMTConverter() {
		return new Converter() {
			@SuppressWarnings("rawtypes")
			@Override
			public Object convert(Class type, Object value) {
				try {
					return parseDate((String) value);
				} catch (ParseException e) {
					return null;
				}
			}
		};
	}
}