package com.beimin.eveapi.handler.pilot;

import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.response.pilot.SkillInTrainingResponse;

public class SkillInTrainingHandler extends AbstractContentHandler<SkillInTrainingResponse> {
    @Override
    public void startDocument() throws SAXException {
        setResponse(new SkillInTrainingResponse());
    }

    public void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final SkillInTrainingResponse response = getResponse();
        if ("currentTQTime".equals(qName)) {
            response.setCurrentTQTime(getDate());
        } else if ("trainingEndTime".equals(qName)) {
            response.setTrainingEndTime(getDate());
        } else if ("trainingStartTime".equals(qName)) {
            response.setTrainingStartTime(getDate());
        } else if ("trainingTypeID".equals(qName)) {
            response.setTrainingTypeID(getInt());
        } else if ("trainingStartSP".equals(qName)) {
            response.setTrainingStartSP(getInt());
        } else if ("trainingDestinationSP".equals(qName)) {
            response.setTrainingDestinationSP(getInt());
        } else if ("trainingToLevel".equals(qName)) {
            response.setTrainingToLevel(getInt());
        } else if ("skillInTraining".equals(qName)) {
            response.setSkillInTraining(getBoolean());
        }
    }
}
