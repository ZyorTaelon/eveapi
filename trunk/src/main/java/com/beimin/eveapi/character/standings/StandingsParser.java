package com.beimin.eveapi.character.standings;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.ApiPath;
import com.beimin.eveapi.shared.standings.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
	private StandingsParser() {
		super(ApiPath.CHARACTER);
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}

	@Override
	protected Digester getDigester() {
		return getDigester("characterNPCStandings");
	}
}