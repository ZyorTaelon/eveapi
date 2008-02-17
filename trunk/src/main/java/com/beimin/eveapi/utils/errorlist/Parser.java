package com.beimin.eveapi.utils.errorlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ERROR_LIST_URL = "/eve/ErrorList.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getErrorList() throws IOException, SAXException {
		String requestUrl = EVE_API_URL + ERROR_LIST_URL;
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Error List digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
