package com.beimin.eveapi.starbase;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class ListParser extends AbstractApiParser<ListResponse> {
	private static final String STARBASE_LIST_URL = "/StarbaseList.xml.aspx";

	public ListParser() {
		super(ListResponse.class);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", Starbase.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStarbase");
		return digester;
	}

	public ListResponse getList(int userID, int characterID, String apiKey) throws IOException, SAXException {
		String url = EVE_API_URL;
		url += CORP_PATH;
		url += STARBASE_LIST_URL;
		url += "?userID=" + userID;
		url += "&characterID=" + characterID;
		url += "&apiKey=" + URLEncoder.encode(apiKey, "UTF8");
		url += "&version=2";
		return (ListResponse) getDigester().parse(url);
	}

	public static ListParser getInstance() {
		return new ListParser();
	}
}