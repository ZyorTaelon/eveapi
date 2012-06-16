package com.beimin.eveapi.connectors;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import com.beimin.eveapi.exception.ApiException;

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
	protected URLConnection openConnection(URL requestUrl) throws ApiException {
		try {
			return requestUrl.openConnection(proxy);
		} catch (Exception e) {
			throw new ApiException(e);
		}
	}

	@Override
	public ApiConnector getInstance() {
		return new ProxyConnector(proxy, baseConnector);
	}
}