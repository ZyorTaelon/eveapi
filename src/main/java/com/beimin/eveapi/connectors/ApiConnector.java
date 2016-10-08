package com.beimin.eveapi.connectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

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
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiRequest;
import com.beimin.eveapi.response.ApiResponse;

public class ApiConnector {
    public static final String EVE_API_URL = "https://api.eveonline.com";
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiConnector.class);

    private final String baseUrl;
    private static boolean secureXmlProcessing = true;

    public ApiConnector() {
        baseUrl = EVE_API_URL;
    }

    public ApiConnector(final String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public <E extends ApiResponse> E execute(final ApiRequest request, final AbstractContentHandler<E> contentHandler, final Class<E> clazz) throws ApiException {
        return getApiResponse(contentHandler, getInputStream(getURL(request), getParams(request)), clazz);
    }

    protected <E extends ApiResponse> E getApiResponse(final AbstractContentHandler<E> contentHandler, final InputStream inputStream, final Class<E> clazz) throws ApiException {
        try {
            final SAXParserFactory spf = SAXParserFactory.newInstance();
            final SAXParser sp = spf.newSAXParser();
            final XMLReader xr = sp.getXMLReader();
            if (secureXmlProcessing) {
                xr.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            }
            xr.setContentHandler(contentHandler);
            xr.parse(new InputSource(inputStream));
            return (E) contentHandler.getResponse();
        } catch (SAXException | ParserConfigurationException | IOException e) {
            throw new ApiException(e);
        }
    }

    protected InputStream getInputStream(final URL requestUrl, final Map<String, String> params) throws ApiException {
        OutputStreamWriter wr = null;
        try {
            final HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
            conn.setDoOutput(true);
            wr = new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8);
            final StringBuilder data = new StringBuilder();
            for (final Entry<String, String> entry : params.entrySet()) {
                if (data.length() > 0) {
                    // to ensure that we don't append an '&' to the end.
                    data.append('&');
                }
                final String key = entry.getKey();
                final String value = entry.getValue();
                data.append(URLEncoder.encode(key, StandardCharsets.UTF_8.name()));
                data.append('=');
                data.append(URLEncoder.encode(value, StandardCharsets.UTF_8.name()));
            }
            wr.write(data.toString());
            wr.flush();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return conn.getInputStream();
            } else {
                return conn.getErrorStream();
            }
        } catch (final IOException e) {
            throw new ApiException(e);
        } finally {
            if (wr != null) {
                try {
                    wr.close();
                } catch (final IOException e) {
                    LOGGER.warn("Error closing the stream", e);
                }
            }
        }
    }

    protected URL getURL(final ApiRequest request) throws ApiException {
        try {
            final StringBuilder result = new StringBuilder(getBaseUrl());
            result.append(request.getPath().getPath()).append('/').append(request.getPage().getPage()).append(".xml.aspx");
            return new URL(result.toString());
        } catch (final MalformedURLException e) {
            throw new ApiException(e);
        }
    }

    protected Map<String, String> getParams(final ApiRequest request) {
        final Map<String, String> result = new ConcurrentHashMap<>();
        result.put("version", Integer.toString(request.getVersion()));
        final ApiAuth auth = request.getAuth();
        if (auth != null) {
            result.putAll(auth.getParams());
        }
        final Map<String, String> params = request.getParams();
        if (params != null) {
            result.putAll(params);
        }
        return result;
    }

    protected String getBaseUrl() {
        return baseUrl;
    }

    public static boolean isSecureXmlProcessing() {
        return secureXmlProcessing;
    }

    public static void setSecureXmlProcessing(final boolean secureXmlProcessing) {
        ApiConnector.secureXmlProcessing = secureXmlProcessing;
    }

    public ApiConnector getNewInstance() {
        return new ApiConnector(baseUrl);
    }
}
