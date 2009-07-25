package com.beimin.eveapi.containerlog;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String CONTAINER_LOG_URL = "/corp/ContainerLog.xml.aspx ";

	public Parser() {
		super(Response.class, 2, CONTAINER_LOG_URL);
	}

	public Response getContainerLog(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiContainerLog.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addContainerLog");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}