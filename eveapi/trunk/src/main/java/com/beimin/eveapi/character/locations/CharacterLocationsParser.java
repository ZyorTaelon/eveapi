package com.beimin.eveapi.character.locations;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.locations.AbstractLocationsParser;

public class CharacterLocationsParser extends AbstractLocationsParser {
	public CharacterLocationsParser() {
		super(ApiPath.CHARACTER);
	}
}