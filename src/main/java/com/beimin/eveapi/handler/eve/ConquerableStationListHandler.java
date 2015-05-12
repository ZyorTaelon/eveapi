package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.response.eve.StationListResponse;

public class ConquerableStationListHandler extends AbstractContentHandler {
	private StationListResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new StationListResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("row")) {
			Station item = new Station();
			item.setStationID(getInt(attrs, "stationID"));
			item.setStationName(getString(attrs, "stationName"));
			item.setStationTypeID(getInt(attrs, "stationTypeID"));
			item.setSolarSystemID(getInt(attrs, "solarSystemID"));
			item.setCorporationID(getInt(attrs, "corporationID"));
			item.setCorporationName(getString(attrs, "corporationName"));
			response.add(item);
		}
		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public StationListResponse getResponse() {
		return response;
	}
}