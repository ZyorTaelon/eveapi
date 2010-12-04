package com.beimin.eveapi.corporation.standings;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.standings.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
	private StandingsParser() {
		super(ApiPath.CORPORATION);
	}

	@Override
	protected Digester getDigester() {
		return getDigester("corporationNPCStandings");
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}
}