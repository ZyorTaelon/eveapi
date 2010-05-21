package com.beimin.eveapi.character.research;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class ResearchResponse extends ApiResponse {
	private final List<ApiResearchAgent> researchAgents = new ArrayList<ApiResearchAgent>();

	public void addResearchAgent(ApiResearchAgent researchAgent) {
		researchAgents.add(researchAgent);
	}

	public List<ApiResearchAgent> getResearchAgents() {
		return researchAgents;
	}
}