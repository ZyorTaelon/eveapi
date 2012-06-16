package com.beimin.eveapi.account.characters;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class CharactersResponse extends ApiResponse {
	private final Collection<ApiCharacter> eveCharacters = new ArrayList<ApiCharacter>();

	public void addEveCharacter(ApiCharacter eveCharacter) {
		eveCharacters.add(eveCharacter);
	}

	public Collection<ApiCharacter> getEveCharacters() {
		return eveCharacters;
	}
}