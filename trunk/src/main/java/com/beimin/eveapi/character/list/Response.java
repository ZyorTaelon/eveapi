package com.beimin.eveapi.character.list;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<EveCharacter> eveCharacters = new ArrayList<EveCharacter>();

	public void addEveCharacter(EveCharacter eveCharacter) {
		eveCharacters.add(eveCharacter);
	}

	public Collection<EveCharacter> getEveCharacters() {
		return eveCharacters;
	}
}