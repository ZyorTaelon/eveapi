package com.beimin.eveapi.character.list;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiCharacter> eveCharacters = new ArrayList<ApiCharacter>();

	public void addEveCharacter(ApiCharacter eveCharacter) {
		eveCharacters.add(eveCharacter);
	}

	public Collection<ApiCharacter> getEveCharacters() {
		return eveCharacters;
	}
}