package com.beimin.eveapi.parser.corporation;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.handler.corporation.StarbaseDetailHandler;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.corporation.StarbaseDetailResponse;

public class StarbaseDetailParser extends AbstractApiParser<StarbaseDetailResponse> {
	public StarbaseDetailParser() {
		super(StarbaseDetailResponse.class, 2, ApiPath.CORPORATION, ApiPage.STARBASE_DETAIL);
	}

	@Override
	protected AbstractContentHandler getContentHandler() {
		return new StarbaseDetailHandler();
	}

	public StarbaseDetailResponse getResponse(ApiAuth<?> auth, long itemID) throws ApiException {
		return super.getResponse(auth, "itemID", Long.toString(itemID));
	}
}
