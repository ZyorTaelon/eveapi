package com.beimin.eveapi.eve.skilltree;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class SkillTreeHandler extends AbstractContentListHandler<SkillTreeResponse, ApiSkillGroup> {
	private boolean skills;
	private boolean requiredSkills;
	private boolean skillBonusCollection;
	private ApiSkillGroup skillGroup;
	private ApiSkill skill;

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
				ApiBonus bonus = new ApiBonus();
				bonus.setBonusType(getString(attrs, "bonusType"));
				bonus.setBonusValue(getString(attrs, "bonusValue"));
				skill.add(bonus);
			} else if (requiredSkills) {
				ApiRequirement requirement = new ApiRequirement();
				requirement.setTypeID(getInt(attrs, "typeID"));
				requirement.setSkillLevel(getInt(attrs, "skillLevel"));
				skill.add(requirement);
			} else if (skills) {
				skill = new ApiSkill();
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
	protected ApiSkillGroup getItem(Attributes attrs) {
		ApiSkillGroup item = new ApiSkillGroup();
		item.setGroupID(getInt(attrs, "groupID"));
		item.setGroupName(getString(attrs, "groupName"));
		return item;
	}
}