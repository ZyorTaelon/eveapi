package com.beimin.eveapi.character.training;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String CHARACTER_SHEET_URL = Path.CHARACTER.getPath() + "/SkillInTraining.xml.aspx";

	public Parser() {
		super(Response.class, 1, CHARACTER_SHEET_URL);
	}

	public Response getSkillInTraining(ApiAuth auth) throws IOException, SAXException {
		return getResponse(auth);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/trainingEndTime");
		digester.addBeanPropertySetter("eveapi/result/trainingStartTime");
		digester.addBeanPropertySetter("eveapi/result/trainingTypeID");
		digester.addBeanPropertySetter("eveapi/result/trainingStartSP");
		digester.addBeanPropertySetter("eveapi/result/trainingDestinationSP");
		digester.addBeanPropertySetter("eveapi/result/trainingToLevel");
		digester.addBeanPropertySetter("eveapi/result/skillInTraining");
		return digester;
	}

	public static Parser getInstance() {
		return new Parser();
	}
}