package com.beimin.eveapi.map.kills;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class KillsParser extends AbstractListParser<KillsHandler, KillsResponse, ApiSystemKills> {
	public KillsParser() {
		super(KillsResponse.class, 2, ApiPath.MAP, ApiPage.KILLS, KillsHandler.class);
	}

	public static KillsParser getInstance() {
		return new KillsParser();
	}

	@Override
	public KillsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}