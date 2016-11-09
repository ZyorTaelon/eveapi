package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.eve.Station;
import com.beimin.eveapi.response.eve.StationListResponse;

public class ConquerableStationListHandler extends AbstractContentHandler<StationListResponse> {
    public ConquerableStationListHandler() {
        super(new StationListResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            final Station item = new Station();
            saveAttributes(Station.class, attrs);
            item.setStationID(getLong(attrs, "stationID"));
            item.setStationName(getString(attrs, "stationName"));
            item.setStationTypeID(getInt(attrs, "stationTypeID"));
            item.setSolarSystemID(getInt(attrs, "solarSystemID"));
            item.setCorporationID(getInt(attrs, "corporationID"));
            item.setCorporationName(getString(attrs, "corporationName"));
            item.setX(getLong(attrs, "x"));
            item.setY(getLong(attrs, "y"));
            item.setZ(getLong(attrs, "z"));
            getResponse().add(item);
        }
    }
}
