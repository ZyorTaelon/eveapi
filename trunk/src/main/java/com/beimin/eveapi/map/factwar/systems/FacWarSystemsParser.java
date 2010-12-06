package com.beimin.eveapi.map.factwar.systems;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class FacWarSystemsParser extends AbstractApiParser<FacWarSystemsResponse> {
	private FacWarSystemsParser() {
		super(FacWarSystemsResponse.class, 2, ApiPath.MAP, ApiPage.FACTION_WAR_SYSTEMS);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiFacWarSystem.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSystem");
		return digester;
	}

	public static FacWarSystemsParser getInstance() {
		return new FacWarSystemsParser();
	}

	@Override
	public FacWarSystemsResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}