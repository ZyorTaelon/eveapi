package com.beimin.eveapi.parser.shared;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.ApiRequest;
import com.beimin.eveapi.response.ApiResponse;
import java.util.Set;

public abstract class AbstractApiParser<E extends ApiResponse> {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static ApiConnector connector = new ApiConnector();
    protected final ApiPath path;
    protected final ApiPage page;
    protected final int version;
    protected final Class<E> clazz;
    private AbstractContentHandler<E> contentHandler;

    public AbstractApiParser(final Class<E> clazz, final int version, final ApiPath path, final ApiPage page) {
        this.clazz = clazz;
        this.version = version;
        this.path = path;
        this.page = page;
    }

    protected abstract AbstractContentHandler<E> getContentHandler();

    protected E getResponse() throws ApiException {
        return getResponse(new ApiRequest(path, page, version));
    }

    protected E getResponse(final ApiAuth auth) throws ApiException {
        return getResponse(new ApiRequest(path, page, version, auth));
    }

    protected E getResponse(final ApiAuth auth, final String paramName, final String paramValue) throws ApiException {
        return getResponse(new ApiRequest(path, page, version, auth, Collections.singletonMap(paramName, paramValue)));
    }

    protected E getResponse(final ApiAuth auth, final Map<String, String> extraParams) throws ApiException {
        return getResponse(new ApiRequest(path, page, version, auth, extraParams));
    }

    protected E getResponse(final String paramName, final String paramValue) throws ApiException {
        return getResponse(new ApiRequest(path, page, version, Collections.singletonMap(paramName, paramValue)));
    }

    private E getResponse(final ApiRequest request) throws ApiException {
        return connector.execute(request, getAndPrepareContentHandler(), clazz);
    }

    public static void setConnector(final ApiConnector connector) {
        AbstractApiParser.connector = connector;
    }

    private AbstractContentHandler<E> getAndPrepareContentHandler() {
        if (contentHandler == null) {
            contentHandler = getContentHandler();
        }
        return contentHandler;
    }

    public Map<String, Integer> enableStrictCheckMode() {
        return getAndPrepareContentHandler().enableStrictCheckMode();
    }

    public void setIgnoreElements(Set<String> ignoreElements) {
        getAndPrepareContentHandler().setIgnoreElements(ignoreElements);
    }
}
