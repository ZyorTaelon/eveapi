package com.beimin.eveapi.connectors;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiRequest;
import com.beimin.eveapi.core.ApiResponse;

public class CachingConnector extends ApiConnector {
	private final Map<ApiRequest, ApiResponse> cache = new HashMap<ApiRequest, ApiResponse>();
	private final ApiConnector baseConnector;

	public CachingConnector() {
		this.baseConnector = null;
	}

	public CachingConnector(ApiConnector baseConnector) {
		this.baseConnector = baseConnector;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E extends ApiResponse> E execute(ApiRequest request, AbstractContentHandler contentHandler, Class<E> clazz) throws ApiException {
		if (!cache.containsKey(request))
			cache.put(request, getConnector().execute(request, contentHandler, clazz));
		return (E) cache.get(request);
	}

	@Override
	protected ApiConnector getConnector() {
		if (baseConnector != null)
			return baseConnector;
		return super.getConnector();
	}
}