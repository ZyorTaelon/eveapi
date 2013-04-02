package com.beimin.eveapi.utils;

public class StringUtils {
	public static String join(String glue, long... arguments) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arguments.length; i++) {
			result.append(arguments[i]);
			if (i < arguments.length - 1)
				result.append(glue);
		}
		return result.toString();
	}
	
	public static String join(String glue, int... arguments) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arguments.length; i++) {
			result.append(arguments[i]);
			if (i < arguments.length - 1)
				result.append(glue);
		}
		return result.toString();
	}

	public static String join(String glue, String[] arguments) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arguments.length; i++) {
			result.append(arguments[i]);
			if (i < arguments.length - 1)
				result.append(glue);
		}
		return result.toString();
	}
}