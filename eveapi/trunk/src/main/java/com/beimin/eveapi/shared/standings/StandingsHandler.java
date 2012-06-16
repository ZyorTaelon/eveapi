package com.beimin.eveapi.shared.standings;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class StandingsHandler extends AbstractContentHandler {
	private StandingsResponse response;
	private StandingsList list;

	@Override
	public void startDocument() throws SAXException {
		response = new StandingsResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		super.startElement(uri, localName, qName, attrs);
		if (qName.equals("rowset")) {
			list = new StandingsList();
			list.setName(getString(attrs, "name"));
		} else if (qName.equals("row")) {
			ApiStanding standing = new ApiStanding();
			standing.setFromID(getInt(attrs, "fromID"));
			standing.setFromName(getString(attrs, "fromName"));
			standing.setStanding(getDouble(attrs, "standing"));
			list.add(standing);
		}
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset"))
			response.addStandingsList(list);
		super.endElement(uri, localName, qName);
	}
	@Override
	public StandingsResponse getResponse() {
		return response;
	}
}