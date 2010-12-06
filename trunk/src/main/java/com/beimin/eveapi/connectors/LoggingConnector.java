package com.beimin.eveapi.connectors;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.digester.Digester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiRequest;
import com.beimin.eveapi.core.ApiResponse;
import com.beimin.eveapi.utils.InputStreamSplitter;

public class LoggingConnector extends ApiConnector {
	private final Logger logger = LoggerFactory.getLogger(ApiConnector.class);
	private final ApiConnector baseConnector;

	public LoggingConnector() {
		this.baseConnector = null;
	}

	public LoggingConnector(ApiConnector baseConnector) {
		this.baseConnector = baseConnector;
	}

	@Override
	public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws ApiException {
		if (logger.isInfoEnabled())
			logger.info("\nRequest:\n" + request.toString());
		ApiConnector connector = getConnector();
		URL url = connector.getURL(request);
		InputStream is = connector.getInputStream(url);
		return getApiResponse(digester, is, clazz);
	}

	@SuppressWarnings("unchecked")
	protected <E> E getApiResponse(Digester digester, InputStream inputStream, Class<E> clazz) throws ApiException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		if (logger.isInfoEnabled()) {
			inputStream = new InputStreamSplitter(inputStream, outputStream);
		}
		try {
			return (E) digester.parse(inputStream);
		} catch (Exception e) {
			throw new ApiException(e);
		} finally {
			logger.info("\nResponse:\n" + outputStream.toString());
		}
	}

	protected ApiConnector getConnector() {
		if (baseConnector != null)
			return baseConnector;
		return super.getConnector();
	}
}