package com.beimin.eveapi.character.standings;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.shared.standings.AbstractStandingsParser;
import com.beimin.eveapi.shared.standings.ApiStanding;
import com.beimin.eveapi.shared.standings.StandingsList;

public class StandingsParser extends AbstractStandingsParser<StandingsResponse> {

	private StandingsParser() {
		super(StandingsResponse.class, Path.CHARACTER);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/standingsTo/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/standingsTo/rowset");
		digester.addObjectCreate("eveapi/result/standingsTo/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/standingsTo/rowset/row");
		digester.addSetNext("eveapi/result/standingsTo/rowset/row", "add");
		digester.addSetNext("eveapi/result/standingsTo/rowset", "addStandingsToList");

		digester.addObjectCreate("eveapi/result/standingsFrom/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/standingsFrom/rowset");
		digester.addObjectCreate("eveapi/result/standingsFrom/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/standingsFrom/rowset/row");
		digester.addSetNext("eveapi/result/standingsFrom/rowset/row", "add");
		digester.addSetNext("eveapi/result/standingsFrom/rowset", "addStandingsFromList");
		return digester;
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}
}