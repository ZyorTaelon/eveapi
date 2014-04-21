package com.beimin.eveapi.handler.account;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.response.account.CharactersResponse;

public class CharactersHandler extends AbstractContentListHandler<CharactersResponse, Character> {
	public CharactersHandler() {
		super(CharactersResponse.class);
	}

	@Override
	protected Character getItem(Attributes attrs) {
		Character character = new Character();
		character.setCharacterID(getLong(attrs, "characterID"));
		character.setName(getString(attrs, "name"));
		character.setCorporationID(getLong(attrs, "corporationID"));
		character.setCorporationName(getString(attrs, "corporationName"));
		return character;
	}
}