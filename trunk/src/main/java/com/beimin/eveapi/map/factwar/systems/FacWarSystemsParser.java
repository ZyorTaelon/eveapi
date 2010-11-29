package com.beimin.eveapi.map.factwar.systems;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class FacWarSystemsParser extends AbstractApiParser<FacWarSystemsResponse> {
	private static final String FACTION_WAR_SYSTEMS_URL = "/map/FacWarSystems";

	private FacWarSystemsParser() {
		super(FacWarSystemsResponse.class, 2, FACTION_WAR_SYSTEMS_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiFacWarSystem.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystem");
		return digester;
	}

	public FacWarSystemsResponse getFacWarSystemsResponse() throws IOException, SAXException {
		return getResponse();
	}

	public static FacWarSystemsParser getInstance() {
		return new FacWarSystemsParser();
	}
}