package com.beimin.eveapi.connectors;

import java.net.Proxy;

public class ProxyConnector extends ApiConnector {
    private final Proxy proxy;
    private final ApiConnector baseConnector;

    public ProxyConnector(Proxy proxy) {
        this.proxy = proxy;
        this.baseConnector = null;
    }

    public ProxyConnector(Proxy proxy, ApiConnector baseConnector) {
        this.proxy = proxy;
        this.baseConnector = baseConnector;
    }

    @Override
    public ApiConnector getNewInstance() {
        return new ProxyConnector(proxy, baseConnector);
    }
}