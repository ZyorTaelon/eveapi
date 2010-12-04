package com.beimin.eveapi.shared.standings;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public abstract class AbstractStandingsParser extends AbstractApiParser<StandingsResponse> {
	protected AbstractStandingsParser(ApiPath path) {
		super(StandingsResponse.class, 2, path, ApiPage.STANDINGS);
	}

	protected abstract Digester getDigester();

	protected Digester getDigester(String charCorpPath) {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/" + charCorpPath + "/rowset", StandingsList.class);
		digester.addSetProperties("eveapi/result/" + charCorpPath + "/rowset");
		digester.addObjectCreate("eveapi/result/" + charCorpPath + "/rowset/row", ApiStanding.class);
		digester.addSetProperties("eveapi/result/" + charCorpPath + "/rowset/row");
		digester.addSetNext("eveapi/result/" + charCorpPath + "/rowset/row", "add");
		digester.addSetNext("eveapi/result/" + charCorpPath + "/rowset", "addStandingsList");
		return digester;
	}

	public StandingsResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}