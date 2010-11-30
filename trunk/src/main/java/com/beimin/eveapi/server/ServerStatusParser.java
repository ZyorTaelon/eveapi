package com.beimin.eveapi.server;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class ServerStatusParser extends AbstractApiParser<ServerStatusResponse> {
	protected static final String SERVER_STATUS_URL = "/ServerStatus";

	public ServerStatusParser() {
		super(ServerStatusResponse.class, 2, Path.SERVER, SERVER_STATUS_URL);
	}

	public ServerStatusResponse getServerStatus() throws IOException, SAXException {
		return getResponse();
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
}