package com.beimin.eveapi.eve.alliancelist;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class AllianceListParser extends AbstractListParser<AllianceListHandler, AllianceListResponse, ApiAlliance> {
	public AllianceListParser() {
		super(AllianceListResponse.class, 2, ApiPath.EVE, ApiPage.ALLIANCE_LIST, AllianceListHandler.class);
	}

	@Override
	public AllianceListResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}