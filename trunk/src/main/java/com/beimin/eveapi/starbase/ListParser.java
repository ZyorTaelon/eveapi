package com.beimin.eveapi.starbase;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class ListParser extends AbstractApiParser<ListResponse> {

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
		String url = "http://api.eve-online.com/corp/StarbaseList.xml.aspx";
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