package com.beimin.eveapi.shared.standings;

import java.io.IOException;

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

	public SR getStandingsResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth, path);
	}
}