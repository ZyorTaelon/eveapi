package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.corporation.CombatSetting;
import com.beimin.eveapi.response.corporation.StarbaseDetailResponse;

public class StarbaseDetailHandler extends AbstractContentHandler<StarbaseDetailResponse> {
    public StarbaseDetailHandler() {
        super(new StarbaseDetailResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        final StarbaseDetailResponse response = getResponse();
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
        }
    }

    private CombatSetting getCombatSetting(final Attributes attrs) {
        final CombatSetting onStandingDrop = new CombatSetting();
        saveAttributes(CombatSetting.class, attrs);
        final Integer standing = getInt(attrs, "standing");
        if (standing != null) {
            onStandingDrop.setStanding(standing);
        }
        onStandingDrop.setEnabled(getBoolean(attrs, "enabled"));
        return onStandingDrop;
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final StarbaseDetailResponse response = getResponse();
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
    }
}
