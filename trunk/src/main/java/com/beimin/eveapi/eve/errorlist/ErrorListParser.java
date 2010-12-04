package com.beimin.eveapi.eve.errorlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class ErrorListParser extends AbstractApiParser<ErrorListResponse> {
	public ErrorListParser() {
		super(ErrorListResponse.class, 2, ApiPath.EVE, ApiPage.ERROR_LIST);
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

	public ErrorListResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}