package com.beimin.eveapi.server;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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

	public ServerStatusResponse getServerStatus() throws IOException, SAXException {
		return getResponse();
	}
}