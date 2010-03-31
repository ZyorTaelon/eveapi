package com.beimin.eveapi.character.training;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class CharacterTrainingParser extends AbstractApiParser<CharacterTrainingResponse> {
	protected static final String CHARACTER_SHEET_URL = Path.CHARACTER.getPath() + "/SkillInTraining.xml.aspx";

	public CharacterTrainingParser() {
		super(CharacterTrainingResponse.class, 2, CHARACTER_SHEET_URL);
	}

	public CharacterTrainingResponse getSkillInTraining(ApiAuth auth) throws IOException, SAXException {
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

	public static CharacterTrainingParser getInstance() {
		return new CharacterTrainingParser();
	}
}