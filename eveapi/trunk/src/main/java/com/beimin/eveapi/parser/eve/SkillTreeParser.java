package com.beimin.eveapi.parser.eve;


import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.eve.SkillTreeHandler;
import com.beimin.eveapi.model.eve.SkillGroup;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractListParser;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeParser extends AbstractListParser<SkillTreeHandler, SkillTreeResponse, SkillGroup> {
	public SkillTreeParser() {
		super(SkillTreeResponse.class, 2, ApiPath.EVE, ApiPage.SKILL_TREE, SkillTreeHandler.class);
	}

	@Override
	public SkillTreeResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}