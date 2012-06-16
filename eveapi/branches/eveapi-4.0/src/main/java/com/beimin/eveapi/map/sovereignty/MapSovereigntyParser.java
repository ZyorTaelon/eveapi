package com.beimin.eveapi.map.sovereignty;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MapSovereigntyParser extends AbstractApiParser<MapSovereigntyResponse> {
	public MapSovereigntyParser() {
		super(MapSovereigntyResponse.class, 1, ApiPath.MAP, ApiPage.SOVEREIGNTY);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemSovereignty.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "add");
		return digester;
	}

	public static MapSovereigntyParser getInstance() {
		return new MapSovereigntyParser();
	}

	@Override
	public MapSovereigntyResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}