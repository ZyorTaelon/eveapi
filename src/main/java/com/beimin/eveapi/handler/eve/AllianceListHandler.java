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
        super(new AllianceListResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            memberCorporations = "memberCorporations".equals(getString(attrs, ATTRIBUTE_NAME));
            if (memberCorporations) {
                setCurrentClass(Alliance.class);
            }
        } else if (ELEMENT_ROW.equals(qName)) {
            if (memberCorporations) {
                final MemberCorporation memberCorporation = new MemberCorporation();
                saveAttributes(MemberCorporation.class, attrs);
                memberCorporation.setCorporationID(getLong(attrs, "corporationID"));
                memberCorporation.setStartDate(getDate(attrs, "startDate"));
                alliance.add(memberCorporation);
            } else {
                alliance = getItem(attrs);
                getResponse().add(alliance);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (memberCorporations && ELEMENT_ROWSET.equals(qName)) {
            memberCorporations = false;
        }
    }

    @Override
    protected Alliance getItem(final Attributes attrs) {
        final Alliance createdAlliance = new Alliance();
        saveAttributes(Alliance.class, attrs);
        createdAlliance.setAllianceID(getLong(attrs, "allianceID"));
        createdAlliance.setName(getString(attrs, ATTRIBUTE_NAME));
        createdAlliance.setShortName(getString(attrs, "shortName"));
        createdAlliance.setExecutorCorpID(getLong(attrs, "executorCorpID"));
        createdAlliance.setMemberCount(getInt(attrs, "memberCount"));
        createdAlliance.setStartDate(getDate(attrs, "startDate"));
        return createdAlliance;
    }
}
