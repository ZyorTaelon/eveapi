package com.beimin.eveapi.eve.errorlist;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

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

	@Override
	public ErrorListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}