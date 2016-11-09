package com.beimin.eveapi.handler.eve;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.eve.CharacterEmployment;
import com.beimin.eveapi.model.shared.Ancestry;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;

public class CharacterInfoHandler extends AbstractContentHandler<CharacterInfoResponse> {
    private static final String REPLACE_REGEX = "[-\\s]";

    public CharacterInfoHandler() {
        super(new CharacterInfoResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROW.equals(qName)) {
            final CharacterEmployment employ = new CharacterEmployment();
            saveAttributes(CharacterEmployment.class, attrs);
            employ.setRecordID(getLong(attrs, "recordID"));
            employ.setCorporationID(getLong(attrs, "corporationID"));
            employ.setCorporationName(getString(attrs, "corporationName"));
            employ.setStartDate(getDate(attrs, "startDate"));
            getResponse().addEmployment(employ);
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final CharacterInfoResponse response = getResponse();
        if ("characterID".equals(qName)) {
            response.setCharacterID(getLong());
        } else if ("characterName".equals(qName)) {
            response.setCharacterName(getString());
        } else if ("race".equals(qName)) {
            response.setRace(getRace());
        } else if ("bloodline".equals(qName)) {
            response.setBloodline(getBloodline());
        } else if ("accountBalance".equals(qName)) {
            response.setAccountBalance(getDouble());
        } else if ("skillPoints".equals(qName)) {
            response.setSkillPoints(getInt());
        } else if ("shipName".equals(qName)) {
            response.setShipName(getString());
        } else if ("shipTypeID".equals(qName)) {
            response.setShipTypeID(getInt());
        } else if ("shipTypeName".equals(qName)) {
            response.setShipTypeName(getString());
        } else if ("corporationID".equals(qName)) {
            response.setCorporationID(getLong());
        } else if ("corporation".equals(qName)) {
            response.setCorporation(getString());
        } else if ("corporationDate".equals(qName)) {
            response.setCorporationDate(getDate());
        } else if ("allianceID".equals(qName)) {
            response.setAllianceID(getLong());
        } else if ("alliance".equals(qName)) {
            response.setAlliance(getString());
        } else if ("allianceDate".equals(qName)) {
            response.setAllianceDate(getDate());
        } else if ("lastKnownLocation".equals(qName)) {
            response.setLastKnownLocation(getString());
        } else if ("securityStatus".equals(qName)) {
            response.setSecurityStatus(getDouble());
        } else if ("bloodlineID".equals(qName)) {
            response.setBloodlineID(getInt());
        } else if ("ancestryID".equals(qName)) {
            response.setAncestryID(getInt());
        } else if ("ancestry".equals(qName)) {
            response.setAncestry(getAncestry());
        } else if ("nextTrainingEnds".equals(qName)) {
            response.setNextTrainingEnds(getDate());
        }
    }

    private Bloodline getBloodline() {
        return Bloodline.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll(REPLACE_REGEX, "_"));
    }

    private Ancestry getAncestry() {
        return Ancestry.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll(REPLACE_REGEX, "_"));
    }

    private Race getRace() {
        return Race.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll(REPLACE_REGEX, "_"));
    }
}
