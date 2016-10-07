package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.Alliance;
import com.beimin.eveapi.model.eve.MemberCorporation;
import com.beimin.eveapi.response.eve.AllianceListResponse;

public class AllianceListHandler extends AbstractContentListHandler<AllianceListResponse, Alliance> {
    private boolean memberCorporations;
    private Alliance alliance;

    public AllianceListHandler() {
        super(AllianceListResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            memberCorporations = getString(attrs, ATTRIBUTE_NAME).equals("memberCorporations");
        } else if (ELEMENT_ROW.equals(qName)) {
            if (memberCorporations) {
                final MemberCorporation memberCorporation = new MemberCorporation();
                memberCorporation.setCorporationID(getLong(attrs, "corporationID"));
                memberCorporation.setStartDate(getDate(attrs, "startDate"));
                alliance.add(memberCorporation);
            } else {
                alliance = getItem(attrs);
                response.add(alliance);
            }
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (memberCorporations && ELEMENT_ROWSET.equals(qName)) {
            memberCorporations = false;
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    protected Alliance getItem(final Attributes attrs) {
        final Alliance alliance = new Alliance();
        alliance.setAllianceID(getLong(attrs, "allianceID"));
        alliance.setName(getString(attrs, ATTRIBUTE_NAME));
        alliance.setShortName(getString(attrs, "shortName"));
        alliance.setExecutorCorpID(getLong(attrs, "executorCorpID"));
        alliance.setMemberCount(getInt(attrs, "memberCount"));
        alliance.setStartDate(getDate(attrs, "startDate"));
        return alliance;
    }
}
