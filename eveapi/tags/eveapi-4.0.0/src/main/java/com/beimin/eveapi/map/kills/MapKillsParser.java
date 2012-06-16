package com.beimin.eveapi.map.kills;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MapKillsParser extends AbstractApiParser<MapKillsResponse> {
	public MapKillsParser() {
		super(MapKillsResponse.class, 2, ApiPath.MAP, ApiPage.KILLS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemKills.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static MapKillsParser getInstance() {
		return new MapKillsParser();
	}

	@Override
	public MapKillsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}