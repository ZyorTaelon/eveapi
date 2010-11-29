package com.beimin.eveapi.character.skill.intraining;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class SkillInTrainingParser extends AbstractApiParser<SkillInTrainingResponse> {
	protected static final String CHARACTER_SHEET_URL = Path.CHARACTER.getPath() + "/SkillInTraining";

	public SkillInTrainingParser() {
		super(SkillInTrainingResponse.class, 2, CHARACTER_SHEET_URL);
	}

	public SkillInTrainingResponse getSkillInTraining(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/currentTQTime");
		digester.addBeanPropertySetter("eveapi/result/trainingEndTime");
		digester.addBeanPropertySetter("eveapi/result/trainingStartTime");
		digester.addBeanPropertySetter("eveapi/result/trainingTypeID");
		digester.addBeanPropertySetter("eveapi/result/trainingStartSP");
		digester.addBeanPropertySetter("eveapi/result/trainingDestinationSP");
		digester.addBeanPropertySetter("eveapi/result/trainingToLevel");
		digester.addBeanPropertySetter("eveapi/result/skillInTraining");
		return digester;
	}

	public static SkillInTrainingParser getInstance() {
		return new SkillInTrainingParser();
	}
}