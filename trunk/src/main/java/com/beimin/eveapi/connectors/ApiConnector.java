package com.beimin.eveapi.connectors;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiRequest;
import com.beimin.eveapi.core.ApiResponse;

public class ApiConnector {
	public static final String EVE_API_URL = "http://api.eve-online.com";
	private final String baseUrl;

	public ApiConnector() {
		baseUrl = EVE_API_URL;
	}

	public ApiConnector(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws ApiException {
		try {
			return getApiResponse(digester, getInputStream(getURL(request)), clazz);
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

	protected InputStream getInputStream(URL requestUrl) throws ApiException {
		try {
			return openConnection(requestUrl).getInputStream();
		} catch (Exception e) {
			throw new ApiException(e);
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
			result.append("?version=" + request.getVersion());
			Map<String, String> urlParams = new HashMap<String, String>();
			ApiAuth auth = request.getAuth();
			if (auth != null)
				urlParams.putAll(auth.getParams());
			Map<String, String> params = request.getParams();
			if (params != null) {
				urlParams.putAll(params);
			}
			for (Entry<String, String> entry : urlParams.entrySet()) {
				result.append("&" + entry.getKey() + "=" + entry.getValue());
			}
			return new URL(result.toString());
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	protected ApiConnector getConnector() {
		return this;
	}
}