package com.beimin.eveapi.eve.errorlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class ErrorListParser extends AbstractApiParser<ErrorListResponse> {
	protected static final String ERROR_LIST_URL = "/eve/ErrorList";

	public ErrorListParser() {
		super(ErrorListResponse.class, 2, ERROR_LIST_URL);
	}

	public ErrorListResponse getErrorList() throws IOException, SAXException {
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

	public static ErrorListParser getInstance() {
		return new ErrorListParser();
	}
}
