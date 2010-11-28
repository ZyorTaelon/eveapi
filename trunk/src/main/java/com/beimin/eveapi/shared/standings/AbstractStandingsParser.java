package com.beimin.eveapi.shared.standings;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractStandingsParser extends AbstractApiParser<StandingsResponse> {
	protected static final String STANDINGS_URL = "/Standings.xml.aspx";
	private final Path path;

	protected AbstractStandingsParser(Path path) {
		super(StandingsResponse.class, 2, STANDINGS_URL);
		this.path = path;
	}

	protected Digester getDigester() {
		switch (path) {
		case CORPORATION:
			return getDigester("corporationNPCStandings");
		case CHARACTER:
			return getDigester("characterNPCStandings");
		default:
			throw new RuntimeException("No valid path.");
		}
	}

	private Digester getDigester(String path) {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/" + path + "/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/" + path + "/rowset");
		digester.addObjectCreate("eveapi/result/" + path + "/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/" + path + "/rowset/row");
		digester.addSetNext("eveapi/result/" + path + "/rowset/row", "add");
		digester.addSetNext("eveapi/result/" + path + "/rowset", "addStandingsList");
		return digester;
	}

	public StandingsResponse getStandingsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
}