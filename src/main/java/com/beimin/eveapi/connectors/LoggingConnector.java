package com.beimin.eveapi.connectors;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.parser.ApiRequest;
import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.utils.InputStreamSplitter;

public class LoggingConnector extends ApiConnector {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingConnector.class);
	private final ApiConnector baseConnector;

	public LoggingConnector() {
		super();
		this.baseConnector = null;
	}

	public LoggingConnector(ApiConnector baseConnector) {
		this.baseConnector = baseConnector;
	}

	@Override
	public <E extends ApiResponse> E execute(ApiRequest request, AbstractContentHandler contentHandler, Class<E> clazz) throws ApiException {
		if (LOGGER.isInfoEnabled())
			LOGGER.info("\nRequest:\n" + request.toString());
		ApiConnector connector = getConnector();
		URL url = connector.getURL(request);
		Map<String, String> params = connector.getParams(request);
		InputStream is = connector.getInputStream(url, params);
		return getApiResponse(contentHandler, is, clazz);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected <E> E getApiResponse(AbstractContentHandler contentHandler, InputStream inputStream, Class<E> clazz) throws ApiException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		InputStream workInputStream = inputStream;
		try {
			if (LOGGER.isInfoEnabled()) {
				workInputStream = new InputStreamSplitter(inputStream, outputStream);
			}
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			xr.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
			xr.setContentHandler(contentHandler);
			xr.parse(new InputSource(workInputStream));
			return (E) contentHandler.getResponse();
		} catch (Exception e) {
			throw new ApiException(e);
		} finally {
			if (LOGGER.isInfoEnabled()) {
				try {
					LOGGER.info("\nResponse:\n" + outputStream.toString("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					LOGGER.error("Could not write response as utf-8", e);
				}
			}
			try {
				if (workInputStream != null) {
					workInputStream.close();
				}
			} catch (IOException e) {
				LOGGER.error("Could not close input stream", e);
			}
		}
	}

	@Override
	public ApiConnector getNewInstance() {
		return new LoggingConnector(baseConnector);
	}

	private ApiConnector getConnector() {
		if (baseConnector != null)
			return baseConnector.getNewInstance();
		return super.getNewInstance();
	}
}