package com.beimin.eveapi.character.standings;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.standings.AbstractStandingsParser;

public class CharacterStandingsParser extends AbstractStandingsParser {
	public CharacterStandingsParser() {
		super(ApiPath.CHARACTER);
	}
}