package com.beimin.eveapi.map.kills;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class MapKillsParser extends AbstractApiParser<MapKillsResponse> {
	public MapKillsParser() {
		super(MapKillsResponse.class, 2, ApiPath.MAP, ApiPage.KILLS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemKills.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemKills");
		return digester;
	}

	public static MapKillsParser getInstance() {
		return new MapKillsParser();
	}

	@Override
	public MapKillsResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}