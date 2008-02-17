package com.beimin.eveapi.asset;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuthorization;

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

	public Response getAssets(ApiAuthorization auth, boolean corporation) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		if (corporation)
			requestUrl += CORP_PATH;
		else
			requestUrl += CHAR_PATH;
		requestUrl += ASSETLIST_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=2";
		return getResponse(requestUrl, getDigester());
	}

	public static Parser getInstance() {
		return new Parser();
	}
}