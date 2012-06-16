package com.beimin.eveapi.eve.character;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class CharacterLookupHandler extends AbstractContentListHandler<CharacterLookupResponse, ApiCharacterLookup> {

	public CharacterLookupHandler() {
		super(CharacterLookupResponse.class);
	}

	@Override
	protected ApiCharacterLookup getItem(Attributes attrs) {
		ApiCharacterLookup lookup = new ApiCharacterLookup();
		lookup.setCharacterID(getLong(attrs, "characterID"));
		lookup.setName(getString(attrs, "name"));
		return lookup;
	}
}