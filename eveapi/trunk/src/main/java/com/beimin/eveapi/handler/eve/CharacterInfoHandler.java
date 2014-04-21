package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.eve.CharacterEmployment;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;

public class CharacterInfoHandler extends AbstractContentHandler {
	private CharacterInfoResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new CharacterInfoResponse();
		super.startDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("row")) {
			CharacterEmployment employ = new CharacterEmployment();
			employ.setCorporationID(getLong(attrs, "corporationID"));
			employ.setStartDate(getDate(attrs, "startDate"));
			response.addEmployment(employ);
		}
		super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("characterID"))
			response.setCharacterID(getLong());
		else if (qName.equals("characterName"))
			response.setCharacterName(getString());
		else if (qName.equals("race"))
			response.setRace(getRace());
		else if (qName.equals("bloodline"))
			response.setBloodline(getBloodline());
		else if (qName.equals("accountBalance"))
			response.setAccountBalance(getDouble());
		else if (qName.equals("skillPoints"))
			response.setSkillPoints(getInt());
		else if (qName.equals("shipName"))
			response.setShipName(getString());
		else if (qName.equals("shipTypeID"))
			response.setShipTypeID(getInt());
		else if (qName.equals("shipTypeName"))
			response.setShipTypeName(getString());
		else if (qName.equals("corporationID"))
			response.setCorporationID(getLong());
		else if (qName.equals("corporation"))
			response.setCorporation(getString());
		else if (qName.equals("corporationDate"))
			response.setCorporationDate(getDate());
		else if (qName.equals("allianceID"))
			response.setAllianceID(getLong());
		else if (qName.equals("alliance"))
			response.setAlliance(getString());
		else if (qName.equals("allianceDate"))
			response.setAllianceDate(getDate());
		else if (qName.equals("lastKnownLocation"))
			response.setLastKnownLocation(getString());
		else if (qName.equals("securityStatus"))
			response.setSecurityStatus(getDouble());
		super.endElement(uri, localName, qName);
	}

	private Bloodline getBloodline() {
		return Bloodline.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	private Race getRace() {
		return Race.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	@Override
	public ApiResponse getResponse() {
		return response;
	}

}