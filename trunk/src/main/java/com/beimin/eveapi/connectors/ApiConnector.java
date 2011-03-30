package com.beimin.eveapi.connectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiRequest;
import com.beimin.eveapi.core.ApiResponse;

public class ApiConnector {
	public static final String EVE_API_URL = "https://api.eveonline.com";
	private final String baseUrl;

	public ApiConnector() {
		baseUrl = EVE_API_URL;
	}

	public ApiConnector(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws ApiException {
		try {
			return getApiResponse(digester, getInputStream(getURL(request), getParams(request)), clazz);
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "unused" })
	protected <E> E getApiResponse(Digester digester, InputStream inputStream, Class<E> clazz) throws ApiException {
		try {
			return (E) digester.parse(inputStream);
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	protected InputStream getInputStream(URL requestUrl, Map<String, String> params) throws ApiException {
		OutputStreamWriter wr = null;
		try {
			URLConnection conn = openConnection(requestUrl);
			conn.setDoOutput(true);
			wr = new OutputStreamWriter(conn.getOutputStream());
			StringBuilder data = new StringBuilder();
			for (Entry<String, String> entry : params.entrySet()) {
				if (data.length() > 0) data.append("&"); // to ensure that we don't append an '&' to the end.
				String key = entry.getKey();
				String value = entry.getValue();
				data.append(URLEncoder.encode(key, "UTF8"));
				data.append("=");
				data.append(URLEncoder.encode(value, "UTF8"));
			}
			wr.write(data.toString());
			wr.flush();
			return conn.getInputStream();
		} catch (Exception e) {
			throw new ApiException(e);
		} finally {
			if (wr != null)
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	protected URLConnection openConnection(URL requestUrl) throws ApiException {
		try {
			return requestUrl.openConnection();
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	protected URL getURL(ApiRequest request) throws ApiException {
		try {
			StringBuilder result = new StringBuilder(getBaseUrl());
			result.append(request.getPath().getPath());
			result.append("/").append(request.getPage().getPage());
			result.append(".xml.aspx");
			return new URL(result.toString());
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	protected Map<String, String> getParams(ApiRequest request) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("version", Integer.toString(request.getVersion()));
		ApiAuth<?> auth = request.getAuth();
		if (auth != null)
			result.putAll(auth.getParams());
		Map<String, String> params = request.getParams();
		if (params != null) {
			result.putAll(params);
		}
		return result;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	protected ApiConnector getConnector() {
		return this;
	}
}