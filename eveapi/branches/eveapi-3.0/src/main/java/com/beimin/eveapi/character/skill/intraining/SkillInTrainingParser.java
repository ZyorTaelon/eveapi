package com.beimin.eveapi.character.skill.intraining;


import org.apache.commons.digester.Digester;


import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class SkillInTrainingParser extends AbstractApiParser<SkillInTrainingResponse> {
	public SkillInTrainingParser() {
		super(SkillInTrainingResponse.class, 2, ApiPath.CHARACTER, ApiPage.SKILL_IN_TRAINING);
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

	@Override
	public SkillInTrainingResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}