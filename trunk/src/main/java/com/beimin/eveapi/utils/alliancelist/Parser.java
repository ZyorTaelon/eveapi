package com.beimin.eveapi.utils.alliancelist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ALLIANCE_LIST_URL = "/eve/AllianceList.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getAllianceList() throws IOException, SAXException {
		String requestUrl = EVE_API_URL + ALLIANCE_LIST_URL;
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Alliance List digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
