package com.beimin.eveapi.corporation.standings;

import org.apache.commons.digester.Digester;

import com.beimin.eveapi.shared.standings.AbstractStandingsParser;
import com.beimin.eveapi.shared.standings.ApiStanding;
import com.beimin.eveapi.shared.standings.ApiStandingFrom;
import com.beimin.eveapi.shared.standings.ApiStandingTo;
import com.beimin.eveapi.shared.standings.StandingsList;

public class StandingsParser extends AbstractStandingsParser<StandingsResponse> {

	private StandingsParser() {
		super(StandingsResponse.class, Path.CORP);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/corporationStandings/standingsTo/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsTo/rowset");
		digester.addObjectCreate("eveapi/result/corporationStandings/standingsTo/rowset/row", ApiStandingTo.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsTo/rowset/row");
		digester.addSetNext("eveapi/result/corporationStandings/standingsTo/rowset/row", "add");
		digester.addSetNext("eveapi/result/corporationStandings/standingsTo/rowset", "addCorporationStandingsToList");

		digester.addObjectCreate("eveapi/result/corporationStandings/standingsFrom/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsFrom/rowset");
		digester.addObjectCreate("eveapi/result/corporationStandings/standingsFrom/rowset/row", ApiStandingFrom.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsFrom/rowset/row");
		digester.addSetNext("eveapi/result/corporationStandings/standingsFrom/rowset/row", "add");
		digester.addSetNext("eveapi/result/corporationStandings/standingsFrom/rowset", "addCorporationStandingsFromList");

		digester.addObjectCreate("eveapi/result/allianceStandings/standingsTo/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsTo/rowset");
		digester.addObjectCreate("eveapi/result/allianceStandings/standingsTo/rowset/row", ApiStandingTo.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsTo/rowset/row");
		digester.addSetNext("eveapi/result/allianceStandings/standingsTo/rowset/row", "add");
		digester.addSetNext("eveapi/result/allianceStandings/standingsTo/rowset", "addAllianceStandingsToList");

		digester.addObjectCreate("eveapi/result/allianceStandings/standingsFrom/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsFrom/rowset");
		digester.addObjectCreate("eveapi/result/allianceStandings/standingsFrom/rowset/row", ApiStandingFrom.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsFrom/rowset/row");
		digester.addSetNext("eveapi/result/allianceStandings/standingsFrom/rowset/row", "add");
		digester.addSetNext("eveapi/result/allianceStandings/standingsFrom/rowset", "addAllianceStandingsFromList");
		
		return digester;
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}
}