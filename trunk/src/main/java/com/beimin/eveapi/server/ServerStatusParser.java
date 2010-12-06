package com.beimin.eveapi.server;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ServerStatusParser extends AbstractApiParser<ServerStatusResponse> {
	public ServerStatusParser() {
		super(ServerStatusResponse.class, 2, ApiPath.SERVER, ApiPage.SERVER_STATUS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/serverOpen");
		digester.addBeanPropertySetter("eveapi/result/onlinePlayers");
		return digester;
	}

	public static ServerStatusParser getInstance() {
		return new ServerStatusParser();
	}

	public ServerStatusResponse getServerStatus() throws ApiException {
		return getResponse();
	}
}