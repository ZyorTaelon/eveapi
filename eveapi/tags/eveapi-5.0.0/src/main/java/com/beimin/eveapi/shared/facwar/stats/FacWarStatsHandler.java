package com.beimin.eveapi.shared.facwar.stats;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class FacWarStatsHandler extends AbstractContentHandler {
	private FacWarStatsResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new FacWarStatsResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("factionID"))
			response.setFactionID(getInt());
		if(qName.equals("factionName"))
			response.setFactionName(getString());
		if(qName.equals("enlisted"))
			response.setEnlisted(getDate());
		if(qName.equals("currentRank"))
			response.setCurrentRank(getInt());
		if(qName.equals("highestRank"))
			response.setHighestRank(getInt());
		if(qName.equals("killsYesterday"))
			response.setKillsYesterday(getInt());
		if(qName.equals("killsLastWeek"))
			response.setKillsLastWeek(getInt());
		if(qName.equals("killsTotal"))
			response.setKillsTotal(getInt());
		if(qName.equals("victoryPointsYesterday"))
			response.setVictoryPointsYesterday(getInt());
		if(qName.equals("killsTotal"))
			response.setKillsTotal(getInt());
		if(qName.equals("victoryPointsYesterday"))
			response.setVictoryPointsYesterday(getInt());
		if(qName.equals("victoryPointsLastWeek"))
			response.setVictoryPointsLastWeek(getInt());
		if(qName.equals("victoryPointsTotal"))
			response.setVictoryPointsTotal(getInt());
		if(qName.equals("pilots"))
			response.setPilots(getInt());
		super.endElement(uri, localName, qName);
	}
	
	@Override
	public FacWarStatsResponse getResponse() {
		return response;
	}
}