package com.beimin.eveapi.map.sovereignty;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	private static final String SOVEREIGNTY_URL = "/map/Sovereignty.xml.aspx";

	public Parser() {
		super(Response.class, 1, SOVEREIGNTY_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemSovereignty.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemSovereignty");
		return digester;
	}

	public Response getSovereignties() throws IOException, SAXException {
		return getResponse();
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
