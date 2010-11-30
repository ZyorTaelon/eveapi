package com.beimin.eveapi.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class MockApi {
	public static String URL = "http://localhost/api";

	public static String response(String file) {
		try {
			InputStream is = MockApi.class.getResourceAsStream(file);
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			int n;
			while ((n = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, n);
			}
			return writer.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}