package com.beimin.eveapi.character.research;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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

	public ResearchResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}