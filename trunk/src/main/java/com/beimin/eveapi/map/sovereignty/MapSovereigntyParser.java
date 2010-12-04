package com.beimin.eveapi.map.sovereignty;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class MapSovereigntyParser extends AbstractApiParser<MapSovereigntyResponse> {
	public MapSovereigntyParser() {
		super(MapSovereigntyResponse.class, 1, ApiPath.MAP, ApiPage.SOVEREIGNTY);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemSovereignty.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystemSovereignty");
		return digester;
	}

	public static MapSovereigntyParser getInstance() {
		return new MapSovereigntyParser();
	}

	public MapSovereigntyResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}