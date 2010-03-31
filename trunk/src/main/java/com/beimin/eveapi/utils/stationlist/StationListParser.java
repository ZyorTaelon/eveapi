package com.beimin.eveapi.utils.stationlist;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;

public class StationListParser extends AbstractApiParser<StationListResponse> {
	protected static final String STATION_LIST_URL = "/eve/ConquerableStationList.xml.aspx";

	public StationListParser() {
		super(StationListResponse.class, 2, STATION_LIST_URL);
	}

	public StationListResponse getStationList() throws IOException, SAXException {
		return getResponse();
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiStation.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addStation");
		return digester;
	}

	public static StationListParser getInstance() {
		return new StationListParser();
	}
}
