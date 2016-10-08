package com.beimin.eveapi.utils;

public class StringUtils {
    public static String join(final String glue, final long... arguments) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < arguments.length; i++) {
            result.append(arguments[i]);
            if (i < (arguments.length - 1)) {
                result.append(glue);
            }
        }
        return result.toString();
    }

    public static String join(final String glue, final int... arguments) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < arguments.length; i++) {
            result.append(arguments[i]);
            if (i < (arguments.length - 1)) {
                result.append(glue);
            }
        }
        return result.toString();
    }

    public static String join(final String glue, final String[] arguments) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < arguments.length; i++) {
            result.append(arguments[i]);
            if (i < (arguments.length - 1)) {
                result.append(glue);
            }
        }
        return result.toString();
    }
}
