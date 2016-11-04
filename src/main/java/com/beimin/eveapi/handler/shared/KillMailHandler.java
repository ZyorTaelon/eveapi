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
        super(new KillMailResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, ATTRIBUTE_NAME);
            inAttackers = "attackers".equals(name);
            inItems = "items".equals(name);
        }
        if (ELEMENT_ROW.equals(qName)) {
            if (inAttackers) {
                final KillAttacker attacker = processKillAttacker(attrs);
                apiKill.add(attacker);
            } else if (inItems) {
                apiKill.add(processKillItem(attrs));
            } else {
                apiKill = getItem(attrs);
            }
        } else if ("victim".equals(qName)) {
            apiKill.setVictim(processVictim(attrs));
        }
    }

    private KillAttacker processKillAttacker(final Attributes attrs) {
        final KillAttacker attacker = new KillAttacker();
        saveAttributes(KillAttacker.class, attrs);
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
        return attacker;
    }

    private KillItem processKillItem(final Attributes attrs) {
        final KillItem item = new KillItem();
        saveAttributes(KillItem.class, attrs);
        item.setTypeID(getLong(attrs, "typeID"));
        item.setFlag(getInt(attrs, "flag"));
        item.setQtyDestroyed(getInt(attrs, "qtyDestroyed"));
        item.setQtyDropped(getInt(attrs, "qtyDropped"));
        item.setSingleton(getInt(attrs, "singleton"));
        return item;
    }

    private KillVictim processVictim(final Attributes attrs) {
        final KillVictim victim = new KillVictim();
        saveAttributes(KillVictim.class, attrs);
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
        return victim;
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            inAttackers = false;
            inItems = false;
        } else if (!inAttackers && !inItems && ELEMENT_ROW.equals(qName)) {
            getResponse().add(apiKill);
            apiKill = null;
        }
    }

    @Override
    protected Kill getItem(final Attributes attrs) {
        final Kill item = new Kill();
        saveAttributes(Kill.class, attrs);
        item.setKillID(getLong(attrs, "killID"));
        item.setKillTime(getDate(attrs, "killTime"));
        item.setMoonID(getInt(attrs, "moonID"));
        item.setSolarSystemID(getLong(attrs, "solarSystemID"));
        return item;
    }
}
