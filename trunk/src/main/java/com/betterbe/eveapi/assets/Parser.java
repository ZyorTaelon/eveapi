package com.betterbe.eveapi.assets;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.betterbe.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	private static final String CORP_URL = "http://api.eve-online.com/corp/AssetList.xml.aspx";
	private static final String CHAR_URL = "http://api.eve-online.com/char/AssetList.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("*/rowset/row", Asset.class);
		digester.addSetProperties("*/rowset/row");
		digester.addSetNext("*/rowset/row", "addAsset");
		return digester;
	}

	public Response getAssets(int userID, int characterID, String apiKey, boolean corporation) throws IOException, SAXException {
		String url = CHAR_URL;
		if (corporation)
			url = CORP_URL;
		url += "?userID=" + userID;
		url += "&characterID=" + characterID;
		url += "&apiKey=" + URLEncoder.encode(apiKey, "UTF8");
		url += "&version=2";
		System.out.println(url);
		Digester digester = getDigester();
		Response response = (Response) digester.parse(url);
		return response;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}