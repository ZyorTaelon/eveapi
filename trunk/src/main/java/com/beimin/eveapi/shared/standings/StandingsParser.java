package com.beimin.eveapi.shared.standings;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class StandingsParser extends AbstractApiParser<StandingsResponse> {
	protected static final String SHAREHOLDERS_URL = "/Shareholders.xml.aspx";

	public StandingsParser() {
		super(StandingsResponse.class, 2, SHAREHOLDERS_URL);
	}

	public StandingsResponse getShareholders(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, Path.CORP);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/corporationStandings/standingsTo/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsTo/rowset");
		digester.addObjectCreate("eveapi/result/corporationStandings/standingsTo/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsTo/rowset/row");
		digester.addSetNext("eveapi/result/corporationStandings/standingsTo/rowset/row", "add");
		digester.addSetNext("eveapi/result/corporationStandings/standingsTo/rowset", "addCorporationStandingsToList");

		digester.addObjectCreate("eveapi/result/corporationStandings/standingsFrom/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsFrom/rowset");
		digester.addObjectCreate("eveapi/result/corporationStandings/standingsFrom/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/corporationStandings/standingsFrom/rowset/row");
		digester.addSetNext("eveapi/result/corporationStandings/standingsFrom/rowset/row", "add");
		digester.addSetNext("eveapi/result/corporationStandings/standingsFrom/rowset", "addCorporationStandingsFromList");

		digester.addObjectCreate("eveapi/result/allianceStandings/standingsTo/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsTo/rowset");
		digester.addObjectCreate("eveapi/result/allianceStandings/standingsTo/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsTo/rowset/row");
		digester.addSetNext("eveapi/result/allianceStandings/standingsTo/rowset/row", "add");
		digester.addSetNext("eveapi/result/allianceStandings/standingsTo/rowset", "addAllianceStandingsToList");

		digester.addObjectCreate("eveapi/result/allianceStandings/standingsFrom/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsFrom/rowset");
		digester.addObjectCreate("eveapi/result/allianceStandings/standingsFrom/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/allianceStandings/standingsFrom/rowset/row");
		digester.addSetNext("eveapi/result/allianceStandings/standingsFrom/rowset/row", "add");
		digester.addSetNext("eveapi/result/allianceStandings/standingsFrom/rowset", "addAllianceStandingsFromList");

		digester.addObjectCreate("eveapi/result/standingsTo/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/standingsTo/rowset");
		digester.addObjectCreate("eveapi/result/standingsTo/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/standingsTo/rowset/row");
		digester.addSetNext("eveapi/result/standingsTo/rowset/row", "add");
		digester.addSetNext("eveapi/result/standingsTo/rowset", "addCharacterStandingsToList");

		digester.addObjectCreate("eveapi/result/standingsFrom/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/standingsFrom/rowset");
		digester.addObjectCreate("eveapi/result/standingsFrom/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/standingsFrom/rowset/row");
		digester.addSetNext("eveapi/result/standingsFrom/rowset/row", "add");
		digester.addSetNext("eveapi/result/standingsFrom/rowset", "addCharacterStandingsFromList");
		return digester;
	}

	public static StandingsParser getInstance() {
		return new StandingsParser();
	}
}