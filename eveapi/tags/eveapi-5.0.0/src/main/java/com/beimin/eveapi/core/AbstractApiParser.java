package com.beimin.eveapi.core;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.EveApi;

public abstract class AbstractApiParser<E extends ApiResponse> {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected final ApiPath path;
	protected final ApiPage page;
	protected final int version;
	protected final Class<E> clazz;

	public AbstractApiParser(Class<E> clazz, int version, ApiPath path, ApiPage page) {
		this.clazz = clazz;
		this.version = version;
		this.path = path;
		this.page = page;
	}

	protected abstract AbstractContentHandler getContentHandler();

	protected E getResponse() throws ApiException {
		return getResponse(new ApiRequest(path, page, version));
	}

	protected E getResponse(ApiAuth<?> auth) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, auth));
	}

	protected E getResponse(ApiAuth<?> auth, String paramName, String paramValue) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, auth, Collections.singletonMap(paramName, paramValue)));
	}

	protected E getResponse(ApiAuth<?> auth, Map<String, String> extraParams) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, auth, extraParams));
	}

	protected E getResponse(String paramName, String paramValue) throws ApiException {
		return getResponse(new ApiRequest(path, page, version, Collections.singletonMap(paramName, paramValue)));
	}

	private E getResponse(ApiRequest request) throws ApiException {
		return EveApi.getConnector().execute(request, getContentHandler(), clazz);
	}
}