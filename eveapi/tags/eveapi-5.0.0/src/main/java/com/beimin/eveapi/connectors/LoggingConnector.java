package com.beimin.eveapi.connectors;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.beimin.eveapi.core.AbstractContentHandler;
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
	public <E extends ApiResponse> E execute(ApiRequest request, AbstractContentHandler contentHandler, Class<E> clazz) throws ApiException {
		if (logger.isInfoEnabled())
			logger.info("\nRequest:\n" + request.toString());
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
		if (logger.isInfoEnabled()) {
			inputStream = new InputStreamSplitter(inputStream, outputStream);
		}
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance(); 
		    SAXParser sp = spf.newSAXParser(); 
		    XMLReader xr = sp.getXMLReader(); 
		    xr.setContentHandler(contentHandler); 
		    xr.parse(new InputSource(inputStream)); 
			return (E) contentHandler.getResponse();
		} catch (Exception e) {
			throw new ApiException(e);
		} finally {
			logger.info("\nResponse:\n" + outputStream.toString());
		}
	}

	@Override
	protected ApiConnector getConnector() {
		if (baseConnector != null)
			return baseConnector;
		return super.getConnector();
	}
}