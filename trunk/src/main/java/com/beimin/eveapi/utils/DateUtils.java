package com.beimin.eveapi.utils;

public class DateUtils {

	public static GMTConverter getGMTConverter() {
		return new GMTConverter("yyyy-MM-dd HH:mm:ss");
	}
}