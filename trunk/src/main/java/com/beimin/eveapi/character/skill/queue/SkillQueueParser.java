package com.beimin.eveapi.character.skill.queue;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class SkillQueueParser extends AbstractApiParser<SkillQueueResponse> {
	protected static final String CHARACTER_SKILL_QUEUE_URL = "/SkillQueue";

	public SkillQueueParser() {
		super(SkillQueueResponse.class, 2, Path.CHARACTER, CHARACTER_SKILL_QUEUE_URL);
	}

	public SkillQueueResponse getSkillQueue(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
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
}