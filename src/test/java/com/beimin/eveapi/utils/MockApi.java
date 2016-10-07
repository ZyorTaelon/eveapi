package com.beimin.eveapi.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class MockApi {
    public static String URL = "http://localhost:12344/api";

    public static String response(final String file) {
        try {
            final InputStream is = MockApi.class.getResourceAsStream(file);
            final Writer writer = new StringWriter();
            final char[] buffer = new char[1024];
            final Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            return writer.toString();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
