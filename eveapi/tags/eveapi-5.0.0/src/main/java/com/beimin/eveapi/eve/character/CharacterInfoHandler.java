package com.beimin.eveapi.eve.character;

import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.core.ApiResponse;
import com.beimin.eveapi.shared.character.EveBloodline;
import com.beimin.eveapi.shared.character.EveRace;

public class CharacterInfoHandler extends AbstractContentHandler {
	private CharacterInfoResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new CharacterInfoResponse();
		super.startDocument();
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
	}

	private EveBloodline getBloodline() {
		return EveBloodline.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	private EveRace getRace() {
		return EveRace.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	@Override
	public ApiResponse getResponse() {
		return response;
	}

}