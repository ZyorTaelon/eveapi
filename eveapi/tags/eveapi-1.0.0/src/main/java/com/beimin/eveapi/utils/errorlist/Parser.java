package com.beimin.eveapi.utils.errorlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class Parser extends AbstractApiParser<Response> {
	protected static final String ERROR_LIST_URL = "/eve/ErrorList.xml.aspx";

	public Parser() {
		super(Response.class, 2, ERROR_LIST_URL);
	}

	public Response getErrorList() throws IOException, SAXException {
		return getResponse();
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiErrorListItem.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addApiErrorListItem");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}
