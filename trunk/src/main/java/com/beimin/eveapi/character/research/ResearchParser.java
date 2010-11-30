package com.beimin.eveapi.character.research;

import java.io.IOException;
import java.util.List;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class ResearchParser extends AbstractApiParser<ResearchResponse> {
	private static final String RESEARCH_URL = "/Research";

	private ResearchParser() {
		super(ResearchResponse.class, 1, Path.CHARACTER, RESEARCH_URL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiResearchAgent.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addResearchAgent");
		return digester;
	}

	public ResearchResponse getResearchResponse(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	public List<ApiResearchAgent> getResearchAgents(ApiAuth auth) throws IOException, SAXException {
		return getResearchResponse(auth).getResearchAgents();
	}

	public static ResearchParser getInstance() {
		return new ResearchParser();
	}
}