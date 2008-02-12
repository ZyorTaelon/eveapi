package com.beimin.eveapi.map.jumps;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	private static final String JUMPS_URL = "/map/Jumps.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", SystemJumps.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemJumps");
		return digester;
	}

	public Response getJumps() throws IOException, SAXException {
		Digester digester = getDigester();
		return (Response) digester.parse(EVE_API_URL + JUMPS_URL);
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
