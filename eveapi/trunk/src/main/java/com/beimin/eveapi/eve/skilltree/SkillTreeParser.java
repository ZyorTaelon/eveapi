package com.beimin.eveapi.eve.skilltree;


import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;

public class SkillTreeParser extends AbstractListParser<SkillTreeHandler, SkillTreeResponse, ApiSkillGroup> {
	public SkillTreeParser() {
		super(SkillTreeResponse.class, 2, ApiPath.EVE, ApiPage.SKILL_TREE, SkillTreeHandler.class);
	}

	public static SkillTreeParser getInstance() {
		return new SkillTreeParser();
	}

	@Override
	public SkillTreeResponse getResponse() throws ApiException {
		return super.getResponse();
	}
}