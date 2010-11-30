package com.beimin.eveapi.shared.standings;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractStandingsParser extends AbstractApiParser<StandingsResponse> {
	protected static final String STANDINGS_URL = "/Standings";

	protected AbstractStandingsParser(Path path) {
		super(StandingsResponse.class, 2, path, STANDINGS_URL);
	}

	@Override
	protected Digester getDigester() {
		String charCorpPath;
		switch (path) {
		case CORPORATION:
			charCorpPath = "corporationNPCStandings";
			break;
		case CHARACTER:
			charCorpPath = "characterNPCStandings";
			break;
		default:
			throw new RuntimeException("No valid path.");
		}
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/" + charCorpPath + "/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/" + charCorpPath + "/rowset");
		digester.addObjectCreate("eveapi/result/" + charCorpPath + "/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/" + charCorpPath + "/rowset/row");
		digester.addSetNext("eveapi/result/" + charCorpPath + "/rowset/row", "add");
		digester.addSetNext("eveapi/result/" + charCorpPath + "/rowset", "addStandingsList");
		return digester;
	}

	public StandingsResponse getStandingsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}
}