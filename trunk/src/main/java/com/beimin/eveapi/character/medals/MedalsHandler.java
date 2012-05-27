package com.beimin.eveapi.character.medals;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MedalsHandler extends AbstractContentListHandler<CharacterMedalsResponse, CharacterMedal> {
	public MedalsHandler() {
		super(CharacterMedalsResponse.class);
	}

	@Override
	protected CharacterMedal getItem(Attributes attrs) {
		CharacterMedal medal = new CharacterMedal();
		medal.setMedalID(getInt(attrs, "medalID"));
		medal.setCorporationID(getLong(attrs, "corporationID"));
		medal.setDescription(getString(attrs, "description"));
		medal.setIssued(getDate(attrs, "issued"));
		medal.setIssuerID(getLong(attrs, "issuerID"));
		medal.setReason(getString(attrs, "reason"));
		medal.setStatus(getString(attrs, "status"));
		medal.setTitle(getString(attrs, "title"));
		return medal;
	}
}