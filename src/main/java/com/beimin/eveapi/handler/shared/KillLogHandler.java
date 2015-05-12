package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.model.shared.KillAttacker;
import com.beimin.eveapi.model.shared.KillItem;
import com.beimin.eveapi.model.shared.KillVictim;
import com.beimin.eveapi.response.shared.KillLogResponse;

public class KillLogHandler extends AbstractContentListHandler<KillLogResponse, Kill> {
	private Kill apiKill;
	private boolean inAttackers;
	private boolean inItems;

	public KillLogHandler() {
		super(KillLogResponse.class);
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
				item.setTypeID(getInt(attrs, "typeID"));
				item.setFlag(getInt(attrs, "flag"));
				item.setQtyDestroyed(getInt(attrs, "qtyDestroyed"));
				item.setQtyDropped(getInt(attrs, "qtyDropped"));
				apiKill.add(item);
			} else {
				apiKill = getItem(attrs);
			}
		} else if (qName.equals("victim")) {
			KillVictim victim = new KillVictim();
			victim.setCharacterID(getLong(attrs, "characterID"));
			victim.setCharacterName(getString(attrs, "characterName"));
			victim.setCorporationID(getLong(attrs, "corporationID"));
			victim.setCorporationName(getString(attrs, "corporationName"));
			victim.setAllianceID(getLong(attrs, "allianceID"));
			victim.setAllianceName(getString(attrs, "allianceName"));
			victim.setFactionID(getInt(attrs, "factionID"));
			victim.setFactionName(getString(attrs, "factionName"));
			victim.setDamageTaken(getLong(attrs, "damageTaken"));
			victim.setShipTypeID(getInt(attrs, "shipTypeID"));
			apiKill.setVictim(victim);
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset")) {
			inAttackers = false;
			inItems = false;
		}
		if (qName.equals("row")) {
			if (!inAttackers && !inItems) {
				response.add(apiKill);
				apiKill = null;
			}
		}
	}

	@Override
	protected Kill getItem(Attributes attrs) {
		Kill item = new Kill();
		item.setKillID(getLong(attrs, "killID"));
		item.setKillTime(getDate(attrs, "killTime"));
		item.setMoonID(getInt(attrs, "moonID"));
		item.setSolarSystemID(getLong(attrs, "solarSystemID"));
		return item;
	}
}