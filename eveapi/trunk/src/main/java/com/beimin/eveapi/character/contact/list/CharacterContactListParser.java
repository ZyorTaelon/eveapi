package com.beimin.eveapi.character.contact.list;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contacts.AbstractContactListParser;

public class CharacterContactListParser extends AbstractContactListParser<CharacterContactListResponse> {
	public CharacterContactListParser() {
		super(CharacterContactListResponse.class, ApiPath.CHARACTER);
	}
}