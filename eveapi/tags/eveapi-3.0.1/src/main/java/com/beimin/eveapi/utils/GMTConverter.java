package com.beimin.eveapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.beanutils.Converter;

public class GMTConverter implements Converter {
	private final String dateFormat;

	public GMTConverter(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Date convert(Class type, Object value) {
		if (!(value instanceof String))
			throw new RuntimeException("wrong input value");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			return sdf.parse((String) value);
		} catch (ParseException e) {
			return null;
		}
	}
}
