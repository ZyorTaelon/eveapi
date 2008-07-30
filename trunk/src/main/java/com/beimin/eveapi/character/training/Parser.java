package com.beimin.eveapi.character.training;

import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public class Parser extends AbstractApiParser<Response> {
	protected static final String CHARACTER_SHEET_URL = "/SkillInTraining.xml.aspx";

	public Parser() {
		super(Response.class);
	}

	public Response getSkillInTraining(ApiAuth auth, boolean corporation) throws IOException, SAXException {
		String requestUrl = EVE_API_URL;
		requestUrl += CHAR_PATH;
		requestUrl += CHARACTER_SHEET_URL;
		requestUrl += auth.getUrlParams();
		requestUrl += "&version=1";
		return getResponse(requestUrl, getDigester());
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