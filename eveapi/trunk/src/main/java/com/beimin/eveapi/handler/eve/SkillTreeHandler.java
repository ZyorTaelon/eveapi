package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.eve.Bonus;
import com.beimin.eveapi.model.eve.CharacterAttribute;
import com.beimin.eveapi.model.eve.Requirement;
import com.beimin.eveapi.model.eve.Skill;
import com.beimin.eveapi.model.eve.SkillGroup;
import com.beimin.eveapi.response.eve.SkillTreeResponse;

public class SkillTreeHandler extends AbstractContentListHandler<SkillTreeResponse, SkillGroup> {
	private boolean skills;
	private boolean requiredSkills;
	private boolean skillBonusCollection;
	private SkillGroup skillGroup;
	private Skill skill;

	public SkillTreeHandler() {
		super(SkillTreeResponse.class);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			if (name.equals("skills"))
				skills = true;
			else if (name.equals("requiredSkills"))
				requiredSkills = true;
			else if (name.equals("skillBonusCollection"))
				skillBonusCollection = true;
		} else if (qName.equals("row")) {
			if (skillBonusCollection) {
				Bonus bonus = new Bonus();
				bonus.setBonusType(getString(attrs, "bonusType"));
				bonus.setBonusValue(getString(attrs, "bonusValue"));
				skill.add(bonus);
			} else if (requiredSkills) {
				Requirement requirement = new Requirement();
				requirement.setTypeID(getInt(attrs, "typeID"));
				requirement.setSkillLevel(getInt(attrs, "skillLevel"));
				skill.add(requirement);
			} else if (skills) {
				skill = new Skill();
				skill.setTypeName(getString(attrs, "typeName"));
				skill.setTypeID(getInt(attrs, "typeID"));
				skill.setGroupID(getInt(attrs, "groupID"));
				skill.setPublished(getBoolean(attrs, "published"));
				skillGroup.add(skill);
			} else {
				skillGroup = getItem(attrs);
			}
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset")) {
			if (requiredSkills) {
				requiredSkills = false;
			} else if (skillBonusCollection) {
				skillBonusCollection = false;
			} else if (skills) {
				skills = false;
				response.add(skillGroup);
				skillGroup = null;
			}
		} else if (qName.equals("description")) {
			skill.setDescription(getString());
		} else if (qName.equals("rank")) {
			skill.setRank(getInt());
		} else if (qName.equals("primaryAttribute")) {
			skill.setPrimaryAttribute(CharacterAttribute.valueOf(getString().toUpperCase()));
		} else if (qName.equals("secondaryAttribute")) {
			skill.setSecondaryAttribute(CharacterAttribute.valueOf(getString().toUpperCase()));
		} else
			super.endElement(uri, localName, qName);
	}

	@Override
	protected SkillGroup getItem(Attributes attrs) {
		SkillGroup item = new SkillGroup();
		item.setGroupID(getInt(attrs, "groupID"));
		item.setGroupName(getString(attrs, "groupName"));
		return item;
	}
}