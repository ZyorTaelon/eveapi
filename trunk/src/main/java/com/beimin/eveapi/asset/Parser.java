package com.beimin.eveapi.asset;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ASSETLIST_URL = "/AssetList.xml.aspx";

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
		String url = EVE_API_URL;
		if (corporation)
			url += Parser.CORP_PATH;
		else
			url += Parser.CHAR_PATH;
		url += ASSETLIST_URL;
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