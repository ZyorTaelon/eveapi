package com.beimin.eveapi.connectors;

import java.net.Proxy;

public class ProxyConnector extends ApiConnector {
    private final Proxy proxy;
    private final ApiConnector baseConnector;

    public ProxyConnector(final Proxy proxy) {
        this.proxy = proxy;
        baseConnector = null;
    }

    public ProxyConnector(final Proxy proxy, final ApiConnector baseConnector) {
        this.proxy = proxy;
        this.baseConnector = baseConnector;
    }

    @Override
    public ApiConnector getNewInstance() {
        return new ProxyConnector(proxy, baseConnector);
    }
}