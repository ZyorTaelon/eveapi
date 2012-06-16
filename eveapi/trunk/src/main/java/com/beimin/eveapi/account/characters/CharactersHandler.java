package com.beimin.eveapi.account.characters;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class CharactersHandler extends AbstractContentListHandler<CharactersResponse, EveCharacter> {
	public CharactersHandler() {
		super(CharactersResponse.class);
	}

	@Override
	protected EveCharacter getItem(Attributes attrs) {
		EveCharacter character = new EveCharacter();
		character.setCharacterID(getLong(attrs, "characterID"));
		character.setName(getString(attrs, "name"));
		character.setCorporationID(getLong(attrs, "corporationID"));
		character.setCorporationName(getString(attrs, "corporationName"));
		return character;
	}
}