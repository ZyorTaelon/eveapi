package com.beimin.eveapi.eve.conquerablestationlist;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class ConquerableStationListHandler extends AbstractContentHandler {
	private StationListResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new StationListResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("row")) {
			ApiStation item = new ApiStation();
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