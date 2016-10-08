package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.response.shared.FacWarStatsResponse;

public class FacWarStatsHandler extends AbstractContentHandler<FacWarStatsResponse> {
    @Override
    public void startDocument() throws SAXException {
        setResponse(new FacWarStatsResponse());
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        FacWarStatsResponse response = getResponse();
        if ("factionID".equals(qName)) {
            response.setFactionID(getInt());
        }
        if ("factionName".equals(qName)) {
            response.setFactionName(getString());
        }
        if ("enlisted".equals(qName)) {
            response.setEnlisted(getDate());
        }
        if ("currentRank".equals(qName)) {
            response.setCurrentRank(getInt());
        }
        if ("highestRank".equals(qName)) {
            response.setHighestRank(getInt());
        }
        if ("killsYesterday".equals(qName)) {
            response.setKillsYesterday(getInt());
        }
        if ("killsLastWeek".equals(qName)) {
            response.setKillsLastWeek(getInt());
        }
        if ("killsTotal".equals(qName)) {
            response.setKillsTotal(getInt());
        }
        if ("victoryPointsYesterday".equals(qName)) {
            response.setVictoryPointsYesterday(getInt());
        }
        if ("killsTotal".equals(qName)) {
            response.setKillsTotal(getInt());
        }
        if ("victoryPointsYesterday".equals(qName)) {
            response.setVictoryPointsYesterday(getInt());
        }
        if ("victoryPointsLastWeek".equals(qName)) {
            response.setVictoryPointsLastWeek(getInt());
        }
        if ("victoryPointsTotal".equals(qName)) {
            response.setVictoryPointsTotal(getInt());
        }
        if ("pilots".equals(qName)) {
            response.setPilots(getInt());
        }
        super.endElement(uri, localName, qName);
    }
}
