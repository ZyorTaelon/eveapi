package com.beimin.eveapi.server;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String SERVER_STATUS_URL = "/server/ServerStatus.xml.aspx";

	public Parser() {
		super(Response.class, 2, SERVER_STATUS_URL);
	}

	public Response getServerStatus() throws IOException, SAXException {
		return getResponse();
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/serverOpen");
		digester.addBeanPropertySetter("eveapi/result/onlinePlayers");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}