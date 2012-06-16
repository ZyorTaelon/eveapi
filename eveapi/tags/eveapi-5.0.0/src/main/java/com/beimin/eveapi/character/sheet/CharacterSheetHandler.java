package com.beimin.eveapi.character.sheet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;
import com.beimin.eveapi.shared.character.EveAncestry;
import com.beimin.eveapi.shared.character.EveBloodline;
import com.beimin.eveapi.shared.character.EveRace;

public class CharacterSheetHandler extends AbstractContentHandler {
	private CharacterSheetResponse response;
	private ApiAttributeEnhancer attributeEnhancer;

	@Override
	public void startDocument() throws SAXException {
		response = new CharacterSheetResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("intelligenceBonus"))
			attributeEnhancer = new IntelligenceBonus();
		else if (qName.equals("memoryBonus"))
			attributeEnhancer = new MemoryBonus();
		else if (qName.equals("charismaBonus"))
			attributeEnhancer = new CharismaBonus();
		else if (qName.equals("perceptionBonus"))
			attributeEnhancer = new PerceptionBonus();
		else if (qName.equals("row")) {
			ApiSkill skill = new ApiSkill();
			skill.setTypeID(getInt(attrs, "typeID"));
			Integer level = getInt(attrs, "level");
			if (level != null)
				skill.setLevel(level);
			skill.setSkillpoints(getInt(attrs, "skillpoints"));
			skill.setUnpublished(getBoolean(attrs, "unpublished"));
			response.addSkill(skill);
		}

		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("characterID"))
			response.setCharacterID(getLong());
		else if (qName.equals("name"))
			response.setName(getString());
		else if (qName.equals("race"))
			response.setRace(getRace());
		else if (qName.equals("DoB"))
			response.setDateOfBirth(getDate());
		else if (qName.equals("bloodLine"))
			response.setBloodLine(getBloodline());
		else if (qName.equals("ancestry"))
			response.setAncestry(getAncestry());
		else if (qName.equals("gender"))
			response.setGender(getString());
		else if (qName.equals("corporationID"))
			response.setCorporationID(getLong());
		else if (qName.equals("corporationName"))
			response.setCorporationName(getString());
		else if (qName.equals("balance"))
			response.setBalance(getDouble());
		else if (qName.equals("augmentatorName"))
			attributeEnhancer.setAugmentatorName(getString());
		else if (qName.equals("augmentatorValue"))
			attributeEnhancer.setAugmentatorValue(getInt());
		else if (qName.endsWith("Bonus")) {
			response.addAttributeEnhancer(attributeEnhancer);
			attributeEnhancer = null;
		} else if (qName.equals("intelligence"))
			response.setIntelligence(getInt());
		else if (qName.equals("memory"))
			response.setMemory(getInt());
		else if (qName.equals("charisma"))
			response.setCharisma(getInt());
		else if (qName.equals("perception"))
			response.setPerception(getInt());
		else if (qName.equals("willpower"))
			response.setWillpower(getInt());

		super.endElement(uri, localName, qName);
	}

	private EveAncestry getAncestry() {
		return EveAncestry.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	private EveBloodline getBloodline() {
		return EveBloodline.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	private EveRace getRace() {
		return EveRace.valueOf(getString().toUpperCase().replaceAll("[-\\s]", "_"));
	}

	@Override
	public CharacterSheetResponse getResponse() {
		return response;
	}
}