package com.beimin.eveapi.eve.conquerablestationlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public class ConquerableStationListParser extends AbstractApiParser<StationListResponse> {
	public ConquerableStationListParser() {
		super(StationListResponse.class, 2, ApiPath.EVE, ApiPage.CONQUERABLE_STATION_LIST);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiStation.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStation");
		return digester;
	}

	public static ConquerableStationListParser getInstance() {
		return new ConquerableStationListParser();
	}

	public StationListResponse getResponse() throws IOException, SAXException {
		return super.getResponse();
	}
}