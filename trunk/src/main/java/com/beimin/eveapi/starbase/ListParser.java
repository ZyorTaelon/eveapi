package com.beimin.eveapi.starbase;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuthorization;

public class ListParser extends AbstractApiParser<ListResponse> {
	private static final String STARBASE_LIST_URL = "/StarbaseList.xml.aspx";

	public ListParser() {
		super(ListResponse.class);
	}

	public ListResponse getList(ApiAuthorization auth) throws IOException, SAXException {
		String url = EVE_API_URL;
		url += CORP_PATH;
		url += STARBASE_LIST_URL;
		url += auth.getUrlParams();
		url += "&version=2";
		return (ListResponse) getDigester().parse(url);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", Starbase.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStarbase");
		return digester;
	}

	public static ListParser getInstance() {
		return new ListParser();
	}
}