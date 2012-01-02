package com.beimin.eveapi.shared.calendar;

import org.apache.commons.beanutils.Converter;

public class CalendarEventResponseConverter implements Converter {
	@SuppressWarnings("rawtypes")
	@Override
	public Object convert(Class type, Object value) {
		return CalendarEventResponse.valueOf(((String) value).toUpperCase());
	}
}