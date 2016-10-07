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
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		
		if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			inAttackers = name.equals("attackers");
			inItems = name.equals("items");
		}
		if (qName.equals("row")) {
			if (inAttackers) {
				KillAttacker attacker = new KillAttacker();
				saveFieldsCount(KillAttacker.class, attrs);
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
				apiKill.add(attacker);
			} else if (inItems) {
				KillItem item = new KillItem();
				saveFieldsCount(KillItem.class, attrs);
				item.setTypeID(getLong(attrs, "typeID"));
				item.setFlag(getInt(attrs, "flag"));
				item.setQtyDestroyed(getInt(attrs, "qtyDestroyed"));
				item.setQtyDropped(getInt(attrs, "qtyDropped"));
				item.setSingleton(getInt(attrs, "singleton"));
				apiKill.add(item);
			} else {
				apiKill = getItem(attrs);
			}
		} else if (qName.equals("victim")) {
			KillVictim victim = new KillVictim();
			saveFieldsCount(KillVictim.class, attrs);
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
			apiKill.setVictim(victim);
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset")) {
			inAttackers = false;
			inItems = false;
		} else if (qName.equals("row")) {
			if (!inAttackers && !inItems) {
				response.add(apiKill);
				apiKill = null;
			}
		} else {
			super.endElement(uri, localName, qName);
		}
	}

	@Override
	protected Kill getItem(Attributes attrs) {
		Kill item = new Kill();
		saveFieldsCount(Kill.class, attrs);
		item.setKillID(getLong(attrs, "killID"));
		item.setKillTime(getDate(attrs, "killTime"));
		item.setMoonID(getInt(attrs, "moonID"));
		item.setSolarSystemID(getLong(attrs, "solarSystemID"));
		return item;
	}
}