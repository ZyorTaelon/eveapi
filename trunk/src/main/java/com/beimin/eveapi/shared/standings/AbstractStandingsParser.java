package com.beimin.eveapi.shared.standings;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiResponse;

public abstract class AbstractStandingsParser<SR extends ApiResponse> extends AbstractApiParser<SR> {
	protected static final String STANDINGS_URL = "/Standings.xml.aspx";
	private final Path path;

	protected AbstractStandingsParser(Class<SR> responseClass, Path path) {
		super(responseClass, 2, STANDINGS_URL);
		this.path = path;
	}

	protected Digester getDigester() {
		switch (path) {
		case CORP:
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
		digester.addObjectCreate("eveapi/result/" + path + "/rowset/row", ApiStandingFrom.class);
		digester.addSetProperties("eveapi/result/" + path + "/rowset/row");
		digester.addSetNext("eveapi/result/" + path + "/rowset/row", "add");
		digester.addSetNext("eveapi/result/" + path + "/rowset", "addStandingsList");
		return digester;
	}

	public SR getStandingsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
}