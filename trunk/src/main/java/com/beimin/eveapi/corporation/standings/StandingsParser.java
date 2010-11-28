package com.beimin.eveapi.corporation.standings;

import com.beimin.eveapi.shared.standings.AbstractStandingsParser;
import com.beimin.eveapi.shared.standings.StandingsResponse;

public class StandingsParser extends AbstractStandingsParser<StandingsResponse> {

	private StandingsParser() {
		super(StandingsResponse.class, Path.CORP);
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}
}