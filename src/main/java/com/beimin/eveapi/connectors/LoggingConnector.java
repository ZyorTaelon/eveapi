package com.beimin.eveapi.connectors;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
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
        this(null);
    }

    public LoggingConnector(final ApiConnector baseConnector) {
        super();
        this.baseConnector = baseConnector;
    }

    @Override
    public <E extends ApiResponse> E execute(final ApiRequest request, final AbstractContentHandler<E> contentHandler, final Class<E> clazz) throws ApiException {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("\nRequest:\n{}", request.toString());
        }
        final ApiConnector connector = getConnector();
        final URL url = connector.getURL(request);
        final Map<String, String> params = connector.getParams(request);
        final InputStream is = connector.getInputStream(url, params);
        return getApiResponse(contentHandler, is, clazz);
    }

    @Override
    protected <E extends ApiResponse> E getApiResponse(final AbstractContentHandler<E> contentHandler, final InputStream inputStream, final Class<E> clazz) throws ApiException {
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        InputStream workInputStream = inputStream;
        try (InputStream splitInputStream = new InputStreamSplitter(inputStream, outputStream);) {
            if (LOGGER.isInfoEnabled()) {
                workInputStream = splitInputStream;
            }
            final SAXParserFactory spf = SAXParserFactory.newInstance();
            final SAXParser sp = spf.newSAXParser();
            final XMLReader xr = sp.getXMLReader();
            xr.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            xr.setContentHandler(contentHandler);
            xr.parse(new InputSource(workInputStream));
            return (E) contentHandler.getResponse();
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new ApiException(e);
        } finally {
            if (LOGGER.isInfoEnabled()) {
                try {
                    LOGGER.info("\nResponse:\n{}", outputStream.toString(StandardCharsets.UTF_8.name()));
                } catch (final UnsupportedEncodingException e) {
                    LOGGER.error("Could not write response as utf-8", e);
                }
            }
        }
    }

    @Override
    public ApiConnector getNewInstance() {
        return new LoggingConnector(baseConnector);
    }

    private ApiConnector getConnector() {
        if (baseConnector != null) {
            return baseConnector.getNewInstance();
        }
        return super.getNewInstance();
    }
}
