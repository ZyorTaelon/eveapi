package com.beimin.eveapi.parser.map;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.map.KillsHandler;
import com.beimin.eveapi.model.map.SystemKills;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.map.KillsResponse;

public class KillsParser extends AbstractListParser<KillsHandler, KillsResponse, SystemKills> {
	public KillsParser() {
		super(KillsResponse.class, 2, ApiPath.MAP, ApiPage.KILLS, KillsHandler.class);
	}

	@Override
	public KillsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}