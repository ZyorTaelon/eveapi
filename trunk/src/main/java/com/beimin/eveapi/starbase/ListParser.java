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
		String requestUrl = EVE_API_URL;
		requestUrl += CORP_PATH;
		requestUrl += STARBASE_LIST_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=2";
		return getResponse(requestUrl, getDigester());
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