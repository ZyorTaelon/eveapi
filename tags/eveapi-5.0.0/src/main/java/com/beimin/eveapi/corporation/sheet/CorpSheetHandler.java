package com.beimin.eveapi.corporation.sheet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class CorpSheetHandler extends AbstractContentHandler {
	private CorpSheetResponse response;
	private ApiCorpLogo logo;
	private boolean divisions;
	private boolean walletDivisions;

	@Override
	public void startDocument() throws SAXException {
		response = new CorpSheetResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("logo")) {
			logo = new ApiCorpLogo();
		} else if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			divisions = name.equals("divisions");
			walletDivisions = name.equals("walletDivisions");
		} else if (qName.equals("row")) {
			Division division = new Division();
			division.setAccountKey(getInt(attrs, "accountKey"));
			division.setDescription(getString(attrs, "description"));
			if(divisions)
				response.addDivision(division);
			else if (walletDivisions)
				response.addWalletDivision(division);
		} 
		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("corporationID")) {
			response.setCorporationID(getLong());
		} else if (qName.equals("corporationName")) {
			response.setCorporationName(getString());
		} else if (qName.equals("ticker")) {
			response.setTicker(getString());
		} else if (qName.equals("ceoID")) {
			response.setCeoID(getLong());
		} else if (qName.equals("ceoName")) {
			response.setCeoName(getString());
		} else if (qName.equals("stationID")) {
			response.setStationID(getLong());
		} else if (qName.equals("stationName")) {
			response.setStationName(getString());
		} else if (qName.equals("description")) {
			response.setDescription(getString());
		} else if (qName.equals("url")) {
			response.setUrl(getString());
		} else if (qName.equals("allianceID")) {
			response.setAllianceID(getLong());
		} else if (qName.equals("allianceName")) {
			response.setAllianceName(getString());
		} else if (qName.equals("taxRate")) {
			response.setTaxRate(getDouble());
		} else if (qName.equals("memberCount")) {
			response.setMemberCount(getInt());
		} else if (qName.equals("memberLimit")) {
			response.setMemberLimit(getInt());
		} else if (qName.equals("shares")) {
			response.setShares(getInt());
		} else if (qName.equals("graphicsID")) {
			logo.setGraphicID(getInt());
		} else if (qName.equals("shape1")) {
			logo.setShape1(getInt());
		} else if (qName.equals("shape2")) {
			logo.setShape2(getInt());
		} else if (qName.equals("shape3")) {
			logo.setShape3(getInt());
		} else if (qName.equals("color1")) {
			logo.setColor1(getInt());
		} else if (qName.equals("color2")) {
			logo.setColor2(getInt());
		} else if (qName.equals("color3")) {
			logo.setColor3(getInt());
		} else if (qName.equals("logo")) {
			response.setLogo(logo);
		} else if (qName.equals("rowset")) {
			if(divisions || walletDivisions) {
				divisions = false;
				walletDivisions = false;
			}
		}
		
		super.endElement(uri, localName, qName);
	}

	@Override
	public CorpSheetResponse getResponse() {
		return response;
	}
}