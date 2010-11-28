package com.beimin.eveapi.corporation.standings;

import com.beimin.eveapi.shared.standings.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {

	private StandingsParser() {
		super(Path.CORPORATION);
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}
}