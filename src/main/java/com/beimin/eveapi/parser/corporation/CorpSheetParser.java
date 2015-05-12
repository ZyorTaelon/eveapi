package com.beimin.eveapi.parser.corporation;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.corporation.CorpSheetHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.corporation.CorpSheetResponse;

public class CorpSheetParser extends AbstractApiParser<CorpSheetResponse> {
	public CorpSheetParser() {
		super(CorpSheetResponse.class, 2, ApiPath.CORPORATION, ApiPage.CORPORATION_SHEET);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CorpSheetHandler();
	}

	@Override
	public CorpSheetResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}

	public CorpSheetResponse getResponse(long corporationID) throws ApiException {
		return getResponse("corporationID", Long.toString(corporationID));
	}
}