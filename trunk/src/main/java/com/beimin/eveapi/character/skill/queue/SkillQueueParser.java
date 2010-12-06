package com.beimin.eveapi.character.skill.queue;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

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
	public SkillQueueResponse getResponse(ApiAuth auth) throws IOException, SAXException {
		return super.getResponse(auth);
	}
}