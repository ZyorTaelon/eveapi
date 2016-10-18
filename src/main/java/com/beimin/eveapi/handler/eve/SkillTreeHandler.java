package com.beimin.eveapi.handler.eve;

import java.util.Locale;

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
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            if (name.equals("skills")) {
                skills = true;
            } else if (name.equals("requiredSkills")) {
                requiredSkills = true;
            } else if (name.equals("skillBonusCollection")) {
                skillBonusCollection = true;
            }
        } else if (ELEMENT_ROW.equals(qName)) {
            if (skillBonusCollection) {
                final Bonus bonus = new Bonus();
                saveAttributes(Bonus.class, attrs);
                bonus.setBonusType(getString(attrs, "bonusType"));
                bonus.setBonusValue(getString(attrs, "bonusValue"));
                skill.add(bonus);
            } else if (requiredSkills) {
                final Requirement requirement = new Requirement();
                saveAttributes(Requirement.class, attrs);
                requirement.setTypeID(getInt(attrs, "typeID"));
                requirement.setSkillLevel(getInt(attrs, "skillLevel"));
                skill.add(requirement);
            } else if (skills) {
                skill = new Skill();
                saveAttributes(Skill.class, attrs);
                skill.setTypeName(getString(attrs, "typeName"));
                skill.setTypeID(getInt(attrs, "typeID"));
                skill.setGroupID(getInt(attrs, "groupID"));
                skill.setPublished(getBoolean(attrs, "published"));
                skillGroup.add(skill);
            } else {
                skillGroup = getItem(attrs);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            if (requiredSkills) {
                requiredSkills = false;
            } else if (skillBonusCollection) {
                skillBonusCollection = false;
            } else if (skills) {
                skills = false;
                getResponse().add(skillGroup);
                skillGroup = null;
            }
        } else if ("description".equals(qName)) {
            skill.setDescription(getString());
            setElementClass(Skill.class);
        } else if ("rank".equals(qName)) {
            skill.setRank(getInt());
            setElementClass(Skill.class);
        } else if ("primaryAttribute".equals(qName)) {
            skill.setPrimaryAttribute(CharacterAttribute.valueOf(getString().toUpperCase(Locale.ENGLISH)));
            setElementClass(Skill.class);
        } else if ("secondaryAttribute".equals(qName)) {
            setElementClass(Skill.class);
            skill.setSecondaryAttribute(CharacterAttribute.valueOf(getString().toUpperCase(Locale.ENGLISH)));
        }
    }

    @Override
    protected SkillGroup getItem(final Attributes attrs) {
        final SkillGroup item = new SkillGroup();
        saveAttributes(SkillGroup.class, attrs);
        item.setGroupID(getInt(attrs, "groupID"));
        item.setGroupName(getString(attrs, "groupName"));
        return item;
    }
}
