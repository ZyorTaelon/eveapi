package com.beimin.eveapi.corporation.sheet;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class CorpSheetParser extends AbstractApiParser<CorpSheetResponse> {
	public CorpSheetParser() {
		super(CorpSheetResponse.class, 2, ApiPath.CORPORATION, ApiPage.CORPORATION_SHEET);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new CorpSheetHandler();
	}

	public static CorpSheetParser getInstance() {
		return new CorpSheetParser();
	}

	@Override
	public CorpSheetResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}

	public CorpSheetResponse getResponse(long corporationID) throws ApiException {
		return getResponse("corporationID", Long.toString(corporationID));
	}
}