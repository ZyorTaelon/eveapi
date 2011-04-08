package com.beimin.eveapi.character.skill.queue;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class SkillQueueParser extends AbstractApiParser<SkillQueueResponse> {
	public SkillQueueParser() {
		super(SkillQueueResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_QUEUE);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiSkillQueueItem.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addSkillQueueItem");
		return digester;
	}

	public static SkillQueueParser getInstance() {
		return new SkillQueueParser();
	}

	@Override
	public SkillQueueResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}