package com.beimin.eveapi.parser.eve;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.AllianceListHandler;
import com.beimin.eveapi.model.eve.Alliance;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.AllianceListResponse;

public class AllianceListParser extends AbstractListParser<AllianceListHandler, AllianceListResponse, Alliance> {
	public AllianceListParser() {
		super(AllianceListResponse.class, 2, ApiPath.EVE, ApiPage.ALLIANCE_LIST, AllianceListHandler.class);
	}

	@Override
	public AllianceListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}