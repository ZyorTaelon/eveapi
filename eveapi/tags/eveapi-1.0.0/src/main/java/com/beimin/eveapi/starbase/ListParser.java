package com.beimin.eveapi.starbase;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class ListParser extends AbstractApiParser<ListResponse> {
	private static final String STARBASE_LIST_URL = Path.CORP.getPath() + "/StarbaseList.xml.aspx";

	public ListParser() {
		super(ListResponse.class, 2, STARBASE_LIST_URL);
	}

	public ListResponse getList(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiStarbase.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStarbase");
		return digester;
	}

	public static ListParser getInstance() {
		return new ListParser();
	}
}