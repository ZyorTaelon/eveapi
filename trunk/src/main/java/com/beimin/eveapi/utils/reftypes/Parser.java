package com.beimin.eveapi.utils.reftypes;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String REFTYPES_LIST_URL = "/eve/RefTypes.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getRefTypes() throws IOException, SAXException {
		String requestUrl = EVE_API_URL + REFTYPES_LIST_URL;
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create RefTypes List digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
