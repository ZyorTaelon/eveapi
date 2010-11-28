package com.beimin.eveapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {
	private static final SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	public static Date parse(String source) throws ParseException {
		return sdf.parse(source);
	}

}