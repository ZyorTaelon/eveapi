package com.beimin.eveapi.parser.corporation;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.corporation.OutpostServiceDetailHandler;
import com.beimin.eveapi.model.corporation.OutpostServiceDetail;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.corporation.OutpostServiceDetailResponse;

public class OutpostServiceDetailParser extends AbstractListParser<OutpostServiceDetailHandler, OutpostServiceDetailResponse, OutpostServiceDetail> {
	public OutpostServiceDetailParser() {
		super(OutpostServiceDetailResponse.class, 2, ApiPath.CORPORATION, ApiPage.OUTPOST_SERVICE_DETAIL, OutpostServiceDetailHandler.class);
	}

	@Override
	public OutpostServiceDetailResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}