package com.beimin.eveapi.map.jumps;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	private static final String JUMPS_URL = "/map/Jumps.xml.aspx";

	public Parser() {
		super(Response.class, 2, JUMPS_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemJumps.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemJumps");
		return digester;
	}

	public Response getJumps() throws IOException, SAXException {
		return getResponse();
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
