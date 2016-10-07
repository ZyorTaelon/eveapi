package com.beimin.eveapi.connectors;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.parser.ApiRequest;
import com.beimin.eveapi.response.ApiResponse;

public class CachingConnector extends ApiConnector {
    private final Map<ApiRequest, ApiResponse> cache = new ConcurrentHashMap<>();
    private final ApiConnector baseConnector;

    public CachingConnector() {
        this(null);
    }

    public CachingConnector(final ApiConnector baseConnector) {
        super();
        this.baseConnector = baseConnector;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <E extends ApiResponse> E execute(final ApiRequest request, final AbstractContentHandler contentHandler, final Class<E> clazz) throws ApiException {
        if (!cache.containsKey(request)) {
            cache.put(request, getConnector().execute(request, contentHandler, clazz));
        }
        return (E) cache.get(request);
    }

    @Override
    public ApiConnector getNewInstance() {
        return new CachingConnector(baseConnector);
    }

    private ApiConnector getConnector() {
        if (baseConnector != null) {
            return baseConnector.getNewInstance();
        }
        return super.getNewInstance();
    }
}
