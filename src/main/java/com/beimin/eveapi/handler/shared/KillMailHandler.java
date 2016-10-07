package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.model.shared.KillAttacker;
import com.beimin.eveapi.model.shared.KillItem;
import com.beimin.eveapi.model.shared.KillVictim;
import com.beimin.eveapi.response.shared.KillMailResponse;

public class KillMailHandler extends AbstractContentListHandler<KillMailResponse, Kill> {
    private Kill apiKill;
    private boolean inAttackers;
    private boolean inItems;

    public KillMailHandler() {
        super(KillMailResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {

        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, ATTRIBUTE_NAME);
            inAttackers = "attackers".equals(name);
            inItems = "items".equals(name);
        }
        if (ELEMENT_ROW.equals(qName)) {
            if (inAttackers) {
                final KillAttacker attacker = new KillAttacker();
                attacker.setCharacterID(getLong(attrs, "characterID"));
                attacker.setCharacterName(getString(attrs, "characterName"));
                attacker.setCorporationID(getLong(attrs, "corporationID"));
                attacker.setCorporationName(getString(attrs, "corporationName"));
                attacker.setAllianceID(getLong(attrs, "allianceID"));
                attacker.setAllianceName(getString(attrs, "allianceName"));
                attacker.setFactionID(getInt(attrs, "factionID"));
                attacker.setFactionName(getString(attrs, "factionName"));
                attacker.setSecurityStatus(getDouble(attrs, "securityStatus"));
                attacker.setDamageDone(getInt(attrs, "damageDone"));
                attacker.setFinalBlow(getBoolean(attrs, "finalBlow"));
                attacker.setWeaponTypeID(getInt(attrs, "weaponTypeID"));
                attacker.setShipTypeID(getInt(attrs, "shipTypeID"));
                checkForNewFields(attrs, 13);
                apiKill.add(attacker);
            } else if (inItems) {
                final KillItem item = new KillItem();
                item.setTypeID(getLong(attrs, "typeID"));
                item.setFlag(getInt(attrs, "flag"));
                item.setQtyDestroyed(getInt(attrs, "qtyDestroyed"));
                item.setQtyDropped(getInt(attrs, "qtyDropped"));
                item.setSingleton(getInt(attrs, "singleton"));
                checkForNewFields(attrs, 5);
                apiKill.add(item);
            } else {
                apiKill = getItem(attrs);
            }
        } else if ("victim".equals(qName)) {
            final KillVictim victim = new KillVictim();
            victim.setCharacterID(getLong(attrs, "characterID"));
            victim.setCharacterName(getString(attrs, "characterName"));
            victim.setCorporationID(getLong(attrs, "corporationID"));
            victim.setCorporationName(getString(attrs, "corporationName"));
            victim.setAllianceID(getLong(attrs, "allianceID"));
            victim.setAllianceName(getString(attrs, "allianceName"));
            victim.setFactionID(getInt(attrs, "factionID"));
            victim.setFactionName(getString(attrs, "factionName"));
            victim.setDamageTaken(getLong(attrs, "damageTaken"));
            victim.setShipTypeID(getLong(attrs, "shipTypeID"));
            victim.setPositionX(getDouble(attrs, "x"));
            victim.setPositionY(getDouble(attrs, "y"));
            victim.setPositionZ(getDouble(attrs, "z"));
            checkForNewFields(attrs, 13);
            apiKill.setVictim(victim);
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            inAttackers = false;
            inItems = false;
        } else if (ELEMENT_ROW.equals(qName)) {
            if (!inAttackers && !inItems) {
                response.add(apiKill);
                apiKill = null;
            }
        } else {
            super.endElement(uri, localName, qName);
        }
    }

    @Override
    protected Kill getItem(final Attributes attrs) {
        final Kill item = new Kill();
        item.setKillID(getLong(attrs, "killID"));
        item.setKillTime(getDate(attrs, "killTime"));
        item.setMoonID(getInt(attrs, "moonID"));
        item.setSolarSystemID(getLong(attrs, "solarSystemID"));
        checkForNewFields(attrs, 4);
        return item;
    }
}
