package com.beimin.eveapi.handler.pilot;

import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;

public class SkillInTrainingHandler extends AbstractContentHandler {
	private SkillInTrainingResponse response;

	@Override
	public void startDocument() throws SAXException {
		response = new SkillInTrainingResponse();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("currentTQTime"))
			response.setCurrentTQTime(getDate());
		else if (qName.equals("trainingEndTime"))
			response.setTrainingEndTime(getDate());
		else if (qName.equals("trainingStartTime"))
			response.setTrainingStartTime(getDate());
		else if (qName.equals("trainingTypeID"))
			response.setTrainingTypeID(getInt());
		else if (qName.equals("trainingStartSP"))
			response.setTrainingStartSP(getInt());
		else if (qName.equals("trainingDestinationSP"))
			response.setTrainingDestinationSP(getInt());
		else if (qName.equals("trainingToLevel"))
			response.setTrainingToLevel(getInt());
		else if (qName.equals("skillInTraining"))
			response.setSkillInTraining(getBoolean());
		super.endElement(uri, localName, qName);
	}

	@Override
	public SkillInTrainingResponse getResponse() {
		return response;
	}
}