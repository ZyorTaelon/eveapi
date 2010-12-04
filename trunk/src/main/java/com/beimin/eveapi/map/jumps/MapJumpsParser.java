package com.beimin.eveapi.map.jumps;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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

	public MapJumpsResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}