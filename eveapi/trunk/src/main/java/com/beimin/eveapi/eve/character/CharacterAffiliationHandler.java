package com.beimin.eveapi.eve.character;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class CharacterAffiliationHandler extends AbstractContentListHandler<CharacterAffiliationResponse, CharacterAffiliation> {

	public CharacterAffiliationHandler() {
		super(CharacterAffiliationResponse.class);
	}

	@Override
	protected CharacterAffiliation getItem(Attributes attrs) {
		CharacterAffiliation alliance = new CharacterAffiliation();
		alliance.setCharacterName(getString(attrs, "characterName"));
		alliance.setCharacterID(getLong(attrs, "characterID"));
		alliance.setCorporationName(getString(attrs, "corporationName"));
		alliance.setCorporationID(getLong(attrs, "corporationID"));
		alliance.setAllianceName(getString(attrs, "allianceName"));
		alliance.setAllianceID(getLong(attrs, "allianceID"));
		alliance.setFactionName(getString(attrs, "factionName"));
		alliance.setFactionID(getLong(attrs, "factionID"));
		return alliance;
	}
}