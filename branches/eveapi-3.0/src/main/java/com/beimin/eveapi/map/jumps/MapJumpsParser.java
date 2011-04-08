package com.beimin.eveapi.map.jumps;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class MapJumpsParser extends AbstractApiParser<MapJumpsResponse> {
	public MapJumpsParser() {
		super(MapJumpsResponse.class, 2, ApiPath.MAP, ApiPage.JUMPS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemJumps.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemJumps");
		return digester;
	}

	public static MapJumpsParser getInstance() {
		return new MapJumpsParser();
	}

	@Override
	public MapJumpsResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}