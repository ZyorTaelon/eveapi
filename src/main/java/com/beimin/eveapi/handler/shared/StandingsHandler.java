package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.model.shared.Standing;
import com.beimin.eveapi.response.shared.StandingsResponse;

public class StandingsHandler extends AbstractContentHandler<StandingsResponse> {
    private NamedList<Standing> list;

    public StandingsHandler() {
        super(new StandingsResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            list = new NamedList<>();
            list.setName(getString(attrs, ATTRIBUTE_NAME));
        } else if (ELEMENT_ROW.equals(qName)) {
            final Standing standing = new Standing();
            saveAttributes(Standing.class, attrs);
            standing.setFromID(getInt(attrs, "fromID"));
            standing.setFromName(getString(attrs, "fromName"));
            standing.setStanding(getDouble(attrs, "standing"));
            list.add(standing);
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            getResponse().addStandingsList(list);
        }
    }
}
