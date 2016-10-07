package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Standing;
import com.beimin.eveapi.model.shared.StandingsList;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class StandingsHandler extends AbstractContentHandler {
    private StandingsResponse response;
    private StandingsList list;

    @Override
    public void startDocument() throws SAXException {
        response = new StandingsResponse();
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        super.startElement(uri, localName, qName, attrs);
        if (qName.equals("rowset")) {
            list = new StandingsList();
            saveFieldsCount(StandingsList.class, attrs);
            list.setName(getString(attrs, "name"));
        } else if (qName.equals("row")) {
            final Standing standing = new Standing();
            saveFieldsCount(Standing.class, attrs);
            standing.setFromID(getInt(attrs, "fromID"));
            standing.setFromName(getString(attrs, "fromName"));
            standing.setStanding(getDouble(attrs, "standing"));
            list.add(standing);
        }
        accumulator.setLength(0);
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (qName.equals("rowset")) {
            response.addStandingsList(list);
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public StandingsResponse getResponse() {
        return response;
    }
}