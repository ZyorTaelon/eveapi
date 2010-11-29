package com.beimin.eveapi.map.kills;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class MapKillsParser extends AbstractApiParser<MapKillsResponse> {
	private static final String KIILS_URL = "/map/Kills";

	public MapKillsParser() {
		super(MapKillsResponse.class, 2, KIILS_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemKills.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemKills");
		return digester;
	}

	public MapKillsResponse getKills() throws IOException, SAXException {
		return getResponse();
	}

	public static MapKillsParser getInstance() {
		return new MapKillsParser();
	}
}
