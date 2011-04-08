package com.beimin.eveapi.shared.standings;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractStandingsParser extends AbstractApiParser<StandingsResponse> {
	protected AbstractStandingsParser(ApiPath path) {
		super(StandingsResponse.class, 2, path, ApiPage.STANDINGS);
	}

	@Override
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

	@Override
	public StandingsResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}