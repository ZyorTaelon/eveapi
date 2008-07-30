package com.beimin.eveapi.journal;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String JOURNAL_URL = "/WalletJournal.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getJournal(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		if (corporation)
			requestUrl += CORP_PATH;
		else
			requestUrl += CHAR_PATH;
		requestUrl += JOURNAL_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=1";
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		// TODO: Create Journal Entries digester.
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}