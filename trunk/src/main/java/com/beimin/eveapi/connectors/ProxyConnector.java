package com.beimin.eveapi.connectors;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import com.beimin.eveapi.core.ApiException;

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

	protected URLConnection openConnection(URL requestUrl) throws ApiException {
		try {
			return requestUrl.openConnection(proxy);
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	protected ApiConnector getConnector() {
		if (baseConnector != null)
			return baseConnector;
		return super.getConnector();
	}
}