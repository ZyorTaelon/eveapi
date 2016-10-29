package com.beimin.eveapi.handler.pilot;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.pilot.Implant;
import com.beimin.eveapi.model.pilot.JumpClone;
import com.beimin.eveapi.model.pilot.JumpCloneImplant;
import com.beimin.eveapi.model.pilot.Role;
import com.beimin.eveapi.model.pilot.Skill;
import com.beimin.eveapi.model.shared.Ancestry;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.model.shared.Title;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;

public class CharacterSheetHandler extends AbstractContentHandler<CharacterSheetResponse> {
    private static final String REGEX = "[-\\s]";
    private static final String ATTRIBUTE_ROLE_NAME = "roleName";
    private static final String ATTRIBUTE_ROLE_ID = "roleID";
    private String rowsetName;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new CharacterSheetResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        final CharacterSheetResponse response = getResponse();
        if (ELEMENT_ROWSET.equals(qName)) {
            rowsetName = getString(attrs, ATTRIBUTE_NAME);
        } else if (ELEMENT_ROW.equals(qName)) {
            if ("skills".equals(rowsetName)) {
                saveAttributes(Skill.class, attrs);
                final Skill skill = new Skill();
                skill.setTypeID(getInt(attrs, "typeID"));
                final Integer level = getInt(attrs, "level");
                if (level != null) {
                    skill.setLevel(level);
                }
                skill.setSkillpoints(getInt(attrs, "skillpoints"));
                skill.setPublished(getBoolean(attrs, "published"));
                response.addSkill(skill);
            } else if ("corporationRoles".equals(rowsetName)) {
                final Role corporationRole = new Role();
                saveAttributes(Role.class, attrs);
                corporationRole.setRoleID(getLong(attrs, ATTRIBUTE_ROLE_ID));
                corporationRole.setRoleName(getString(attrs, ATTRIBUTE_ROLE_NAME));
                response.addCorporationRole(corporationRole);
            } else if ("corporationRolesAtHQ".equals(rowsetName)) {
                final Role corporationRole = new Role();
                saveAttributes(Role.class, attrs);
                corporationRole.setRoleID(getLong(attrs, ATTRIBUTE_ROLE_ID));
                corporationRole.setRoleName(getString(attrs, ATTRIBUTE_ROLE_NAME));
                response.addCorporationRoleAtHQ(corporationRole);
            } else if ("corporationRolesAtBase".equals(rowsetName)) {
                final Role corporationRole = new Role();
                saveAttributes(Role.class, attrs);
                corporationRole.setRoleID(getLong(attrs, ATTRIBUTE_ROLE_ID));
                corporationRole.setRoleName(getString(attrs, ATTRIBUTE_ROLE_NAME));
                response.addCorporationRoleAtBase(corporationRole);
            } else if ("corporationRolesAtOther".equals(rowsetName)) {
                final Role corporationRole = new Role();
                saveAttributes(Role.class, attrs);
                corporationRole.setRoleID(getLong(attrs, ATTRIBUTE_ROLE_ID));
                corporationRole.setRoleName(getString(attrs, ATTRIBUTE_ROLE_NAME));
                response.addCorporationRoleAtOther(corporationRole);
            } else if ("corporationTitles".equals(rowsetName)) {
                final Title corporationTitle = new Title();
                saveAttributes(Title.class, attrs);
                corporationTitle.setTitleID(getLong(attrs, "titleID"));
                corporationTitle.setTitleName(getString(attrs, "titleName"));
                response.addCorporationTitle(corporationTitle);
            } else if ("jumpCloneImplants".equals(rowsetName)) {
                final JumpCloneImplant jumpCloneImplant = new JumpCloneImplant();
                saveAttributes(JumpCloneImplant.class, attrs);
                jumpCloneImplant.setJumpCloneID(getLong(attrs, "jumpCloneID"));
                jumpCloneImplant.setTypeID(getInt(attrs, "typeID"));
                jumpCloneImplant.setTypeName(getString(attrs, "typeName"));
                response.addJumpCloneImplant(jumpCloneImplant);
            } else if ("jumpClones".equals(rowsetName)) {
                final JumpClone jumpClone = new JumpClone();
                saveAttributes(JumpClone.class, attrs);
                jumpClone.setJumpCloneID(getLong(attrs, "jumpCloneID"));
                jumpClone.setTypeID(getInt(attrs, "typeID"));
                jumpClone.setLocationID(getLong(attrs, "locationID"));
                jumpClone.setCloneName(getString(attrs, "cloneName"));
                response.addJumpClone(jumpClone);
            } else if ("implants".equals(rowsetName)) {
                final Implant implant = new Implant();
                saveAttributes(Implant.class, attrs);
                implant.setTypeID(getInt(attrs, "typeID"));
                implant.setTypeName(getString(attrs, "typeName"));
                response.addImplant(implant);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final CharacterSheetResponse response = getResponse();
        if ("characterID".equals(qName)) {
            response.setCharacterID(getLong());
        } else if (ATTRIBUTE_NAME.equals(qName)) {
            response.setName(getString());
        } else if ("homeStationID".equals(qName)) {
            response.setHomeStationID(getLong());
        } else if ("DoB".equals(qName)) {
            response.setDateOfBirth(getDate());
        } else if ("race".equals(qName)) {
            response.setRace(getRace());
        } else if ("bloodLineID".equals(qName)) {
            response.setBloodLineID(getInt());
        } else if ("bloodLine".equals(qName)) {
            response.setBloodLine(getBloodline());
        } else if ("ancestryID".equals(qName)) {
            response.setAncestryID(getInt());
        } else if ("ancestry".equals(qName)) {
            response.setAncestry(getAncestry());
        } else if ("gender".equals(qName)) {
            response.setGender(getString());
        } else if ("corporationName".equals(qName)) {
            response.setCorporationName(getString());
        } else if ("corporationID".equals(qName)) {
            response.setCorporationID(getLong());
        } else if ("allianceName".equals(qName) && (getString() != null) && !getString().trim().isEmpty()) {
            response.setAllianceName(getString());
        } else if ("allianceID".equals(qName)) {
            response.setAllianceID(getLong());
        } else if ("factionName".equals(qName)) {
            response.setFactionName(getString());
        } else if ("factionID".equals(qName)) {
            response.setFactionID(getInt());
        } else if ("cloneTypeID".equals(qName)) {
            response.setCloneTypeID(getInt());
        } else if ("cloneName".equals(qName)) {
            response.setCloneName(getString());
        } else if ("cloneSkillPoints".equals(qName)) {
            response.setCloneSkillPoints(getLong());
        } else if ("freeSkillPoints".equals(qName)) {
            response.setFreeSkillPoints(getLong());
        } else if ("freeRespecs".equals(qName)) {
            response.setFreeRespecs(getInt());
        } else if ("cloneJumpDate".equals(qName)) {
            response.setCloneJumpDate(getDate());
        } else if ("lastRespecDate".equals(qName)) {
            response.setLastRespecDate(getDate());
        } else if ("lastTimedRespec".equals(qName)) {
            response.setLastTimedRespec(getDate());
        } else if ("remoteStationDate".equals(qName)) {
            response.setRemoteStationDate(getDate());
        } else if ("jumpActivation".equals(qName)) {
            response.setJumpActivation(getDate());
        } else if ("jumpFatigue".equals(qName)) {
            response.setJumpFatigue(getDate());
        } else if ("jumpLastUpdate".equals(qName)) {
            response.setJumpLastUpdate(getDate());
        } else if ("balance".equals(qName)) {
            response.setBalance(getDouble());
        } else if ("intelligence".equals(qName)) {
            response.setIntelligence(getInt());
        } else if ("memory".equals(qName)) {
            response.setMemory(getInt());
        } else if ("charisma".equals(qName)) {
            response.setCharisma(getInt());
        } else if ("perception".equals(qName)) {
            response.setPerception(getInt());
        } else if ("willpower".equals(qName)) {
            response.setWillpower(getInt());
        } else if (ELEMENT_ROWSET.equals(qName)) {
            rowsetName = null;
        }
    }

    private Ancestry getAncestry() {
        return Ancestry.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll(REGEX, "_"));
    }

    private Bloodline getBloodline() {
        return Bloodline.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll(REGEX, "_"));
    }

    private Race getRace() {
        return Race.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll(REGEX, "_"));
    }
}
