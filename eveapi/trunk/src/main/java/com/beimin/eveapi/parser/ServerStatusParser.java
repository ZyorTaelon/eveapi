package com.beimin.eveapi.parser;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.ServerStatusHandler;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.ServerStatusResponse;

public class ServerStatusParser extends AbstractApiParser<ServerStatusResponse> {
	public ServerStatusParser() {
		super(ServerStatusResponse.class, 2, ApiPath.SERVER, ApiPage.SERVER_STATUS);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new ServerStatusHandler();
	}

	public ServerStatusResponse getServerStatus() throws ApiException {
		return getResponse();
	}
}