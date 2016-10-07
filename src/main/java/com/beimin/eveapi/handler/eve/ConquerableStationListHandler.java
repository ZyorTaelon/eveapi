package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.response.eve.StationListResponse;

public class ConquerableStationListHandler extends AbstractContentHandler<StationListResponse> {
    @Override
    public void startDocument() throws SAXException {
        setResponse(new StationListResponse());
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            final Station item = new Station();
            item.setStationID(getLong(attrs, "stationID"));
            item.setStationName(getString(attrs, "stationName"));
            item.setStationTypeID(getInt(attrs, "stationTypeID"));
            item.setSolarSystemID(getInt(attrs, "solarSystemID"));
            item.setCorporationID(getInt(attrs, "corporationID"));
            item.setCorporationName(getString(attrs, "corporationName"));
            getResponse().add(item);
        }
        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }
}
