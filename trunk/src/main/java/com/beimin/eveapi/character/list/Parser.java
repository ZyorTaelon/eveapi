package com.beimin.eveapi.character.list;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String CHARACTER_LIST_URL = "/account/Characters.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getEveCharacters(ApiAuth auth) throws IOException, SAXException {
		String urlParams = "?userID=" + auth.getUserID();
		urlParams += "&apiKey=" + URLEncoder.encode(auth.getApiKey(), "UTF8");

		String requestUrl = EVE_API_URL;
		requestUrl += CHARACTER_LIST_URL;
		requestUrl += urlParams;
		requestUrl += "&version=1";
		return getResponse(requestUrl, getDigester());
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", EveCharacter.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addEveCharacter");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}