package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.ResearchAgent;
import com.beimin.eveapi.response.pilot.ResearchResponse;

public class ResearchHandler extends AbstractContentListHandler<ResearchResponse, ResearchAgent> {
	public ResearchHandler() {
		super(ResearchResponse.class);
	}

	@Override
	protected ResearchAgent getItem(Attributes attrs) {
		ResearchAgent agent = new ResearchAgent();
		agent.setAgentID(getInt(attrs, "agentID"));
		agent.setSkillTypeID(getInt(attrs, "skillTypeID"));
		agent.setPointsPerDay(getDouble(attrs, "pointsPerDay"));
		agent.setRemainderPoints(getDouble(attrs, "remainderPoints"));
		agent.setResearchStartDate(getDate(attrs, "researchStartDate"));
		return agent;
	}
}