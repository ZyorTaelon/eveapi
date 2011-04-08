package com.beimin.eveapi.eve.character;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.core.ApiResponse;

public class CharacterLookupResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiCharacterLookup> characters = new HashSet<ApiCharacterLookup>();

	public Collection<ApiCharacterLookup> getCharacterLookups() {
		return characters;
	}

	public void addCharacterLookup(ApiCharacterLookup lookup) {
		characters.add(lookup);
	}
}