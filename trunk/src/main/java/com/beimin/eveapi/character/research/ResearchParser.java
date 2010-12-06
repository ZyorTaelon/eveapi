package com.beimin.eveapi.character.research;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class ResearchParser extends AbstractApiParser<ResearchResponse> {
	private ResearchParser() {
		super(ResearchResponse.class, 1, ApiPath.CHARACTER, ApiPage.RESEARCH);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiResearchAgent.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addResearchAgent");
		return digester;
	}

	public static ResearchParser getInstance() {
		return new ResearchParser();
	}

	@Override
	public ResearchResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}
}