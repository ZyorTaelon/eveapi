package com.beimin.eveapi.character.research;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ResearchHandler extends AbstractContentListHandler<ResearchResponse, ApiResearchAgent> {
	public ResearchHandler() {
		super(ResearchResponse.class);
	}

	@Override
	protected ApiResearchAgent getItem(Attributes attrs) {
		ApiResearchAgent agent = new ApiResearchAgent();
		agent.setAgentID(getInt(attrs, "agentID"));
		agent.setSkillTypeID(getInt(attrs, "skillTypeID"));
		agent.setPointsPerDay(getDouble(attrs, "pointsPerDay"));
		agent.setRemainderPoints(getDouble(attrs, "remainderPoints"));
		agent.setResearchStartDate(getDate(attrs, "researchStartDate"));
		return agent;
	}
}