package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.corporation.CombatSetting;
import com.beimin.eveapi.response.corporation.StarbaseDetailResponse;

public class StarbaseDetailHandler extends AbstractContentHandler {
    private StarbaseDetailResponse response;

    @Override
    public void startDocument() throws SAXException {
        response = new StarbaseDetailResponse();
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if ("onStandingDrop".equals(qName)) {
            response.setOnStandingDrop(getCombatSetting(attrs));
        } else if ("onStatusDrop".equals(qName)) {
            response.setOnStatusDrop(getCombatSetting(attrs));
        } else if ("onAggression".equals(qName)) {
            response.setOnAggression(getCombatSetting(attrs));
        } else if ("onCorporationWar".equals(qName)) {
            response.setOnCorporationWar(getCombatSetting(attrs));
        } else if (ELEMENT_ROW.equals(qName)) {
            response.addFuelLevel(getInt(attrs, "typeID"), getInt(attrs, "quantity"));
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    private CombatSetting getCombatSetting(final Attributes attrs) {
        final CombatSetting onStandingDrop = new CombatSetting();
        final Integer standing = getInt(attrs, "standing");
        if (standing != null) {
            onStandingDrop.setStanding(standing);
        }
        onStandingDrop.setEnabled(getBoolean(attrs, "enabled"));
        return onStandingDrop;
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if ("usageFlags".equals(qName)) {
            response.setUsageFlags(getInt());
        } else if ("deployFlags".equals(qName)) {
            response.setDeployFlags(getInt());
        } else if ("allowCorporationMembers".equals(qName)) {
            response.setAllowCorporationMembers(getBoolean());
        } else if ("allowAllianceMembers".equals(qName)) {
            response.setAllowAllianceMembers(getBoolean());
        } else if ("claimSovereignty".equals(qName)) {
            response.setClaimSovereignty(getBoolean());
        }

        super.endElement(uri, localName, qName);
    }

    @Override
    public StarbaseDetailResponse getResponse() {
        return response;
    }
}
