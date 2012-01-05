package com.beimin.eveapi.character.standings;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.standings.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
	private StandingsParser() {
		super(ApiPath.CHARACTER);
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}

}