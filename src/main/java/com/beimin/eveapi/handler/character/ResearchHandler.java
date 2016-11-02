package com.beimin.eveapi.handler.character;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.character.ResearchAgent;
import com.beimin.eveapi.response.character.ResearchResponse;

public class ResearchHandler extends AbstractContentListHandler<ResearchResponse, ResearchAgent> {
    public ResearchHandler() {
        super(ResearchResponse.class);
    }

    @Override
    protected ResearchAgent getItem(final Attributes attrs) {
        final ResearchAgent agent = new ResearchAgent();
        saveAttributes(ResearchAgent.class, attrs);
        agent.setAgentID(getInt(attrs, "agentID"));
        agent.setSkillTypeID(getInt(attrs, "skillTypeID"));
        agent.setPointsPerDay(getDouble(attrs, "pointsPerDay"));
        agent.setRemainderPoints(getDouble(attrs, "remainderPoints"));
        agent.setResearchStartDate(getDate(attrs, "researchStartDate"));
        return agent;
    }
}
