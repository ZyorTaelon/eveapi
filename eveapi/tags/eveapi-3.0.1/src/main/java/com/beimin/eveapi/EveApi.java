package com.beimin.eveapi;

import com.beimin.eveapi.connectors.ApiConnector;

public class EveApi {
	private static ApiConnector connector = new ApiConnector();

	public static ApiConnector getConnector() {
		return connector;
	}

	public static void setConnector(ApiConnector connector) {
		EveApi.connector = connector;
	}
}