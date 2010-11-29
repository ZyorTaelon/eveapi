package com.beimin.eveapi.map.jumps;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class MapJumpsParser extends AbstractApiParser<MapJumpsResponse> {
	private static final String JUMPS_URL = "/map/Jumps";

	public MapJumpsParser() {
		super(MapJumpsResponse.class, 2, JUMPS_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemJumps.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemJumps");
		return digester;
	}

	public MapJumpsResponse getJumps() throws IOException, SAXException {
		return getResponse();
	}

	public static MapJumpsParser getInstance() {
		return new MapJumpsParser();
	}
}
