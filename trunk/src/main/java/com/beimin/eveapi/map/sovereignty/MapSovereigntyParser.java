package com.beimin.eveapi.map.sovereignty;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class MapSovereigntyParser extends AbstractApiParser<MapSovereigntyResponse> {
	private static final String SOVEREIGNTY_URL = "/map/Sovereignty";

	public MapSovereigntyParser() {
		super(MapSovereigntyResponse.class, 1, SOVEREIGNTY_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemSovereignty.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemSovereignty");
		return digester;
	}

	public MapSovereigntyResponse getSovereignties() throws IOException, SAXException {
		return getResponse();
	}

	public static MapSovereigntyParser getInstance() {
		return new MapSovereigntyParser();
	}
}
