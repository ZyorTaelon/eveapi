package com.beimin.eveapi.handler.pilot;

import java.util.Locale;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.pilot.AttributeEnhancer;
import com.beimin.eveapi.model.pilot.Certificate;
import com.beimin.eveapi.model.pilot.CharismaBonus;
import com.beimin.eveapi.model.pilot.CorporationRole;
import com.beimin.eveapi.model.pilot.CorporationTitle;
import com.beimin.eveapi.model.pilot.IntelligenceBonus;
import com.beimin.eveapi.model.pilot.MemoryBonus;
import com.beimin.eveapi.model.pilot.PerceptionBonus;
import com.beimin.eveapi.model.pilot.Skill;
import com.beimin.eveapi.model.pilot.WillpowerBonus;
import com.beimin.eveapi.model.shared.Ancestry;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.response.pilot.CharacterSheetResponse;

public class CharacterSheetHandler extends AbstractContentHandler {
    private CharacterSheetResponse response;
    private AttributeEnhancer attributeEnhancer;
    private String rowsetName;

    @Override
    public void startDocument() throws SAXException {
        response = new CharacterSheetResponse();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if ("intelligenceBonus".equals(qName))
            attributeEnhancer = new IntelligenceBonus();
        else if ("memoryBonus".equals(qName))
            attributeEnhancer = new MemoryBonus();
        else if ("charismaBonus".equals(qName))
            attributeEnhancer = new CharismaBonus();
        else if ("perceptionBonus".equals(qName))
            attributeEnhancer = new PerceptionBonus();
        else if ("willpowerBonus".equals(qName))
            attributeEnhancer = new WillpowerBonus();
        else if (ELEMENT_ROWSET.equals(qName))
            rowsetName = getString(attrs, "name");
        else if (ELEMENT_ROW.equals(qName)) {
            if ("skills".equals(rowsetName)) {
                Skill skill = new Skill();
                skill.setTypeID(getInt(attrs, "typeID"));
                Integer level = getInt(attrs, "level");
                if (level != null)
                    skill.setLevel(level);
                skill.setSkillpoints(getInt(attrs, "skillpoints"));
                skill.setUnpublished(getBoolean(attrs, "unpublished"));
                response.addSkill(skill);
            } else if ("certificates".equals(rowsetName)) {
                Certificate certificate = new Certificate();
                certificate.setCertificateID(getInt(attrs, "certificateID"));
                response.addCertificate(certificate);
            } else if ("corporationRoles".equals(rowsetName)) {
                CorporationRole corporationRole = new CorporationRole();
                corporationRole.setRoleID(getLong(attrs, "roleID"));
                corporationRole.setRoleName(getString(attrs, "roleName"));
                response.addCorporationRole(corporationRole);
            } else if ("corporationRolesAtHQ".equals(rowsetName)) {
                CorporationRole corporationRole = new CorporationRole();
                corporationRole.setRoleID(getLong(attrs, "roleID"));
                corporationRole.setRoleName(getString(attrs, "roleName"));
                response.addCorporationRoleAtHQ(corporationRole);
            } else if ("corporationRolesAtBase".equals(rowsetName)) {
                CorporationRole corporationRole = new CorporationRole();
                corporationRole.setRoleID(getLong(attrs, "roleID"));
                corporationRole.setRoleName(getString(attrs, "roleName"));
                response.addCorporationRoleAtBase(corporationRole);
            } else if ("corporationRolesAtOther".equals(rowsetName)) {
                CorporationRole corporationRole = new CorporationRole();
                corporationRole.setRoleID(getLong(attrs, "roleID"));
                corporationRole.setRoleName(getString(attrs, "roleName"));
                response.addCorporationRoleAtOther(corporationRole);
            } else if ("corporationTitles".equals(rowsetName)) {
                CorporationTitle corporationTitle = new CorporationTitle();
                corporationTitle.setTitleID(getLong(attrs, "titleID"));
                corporationTitle.setTitleName(getString(attrs, "titleName"));
                response.addCorporationTitle(corporationTitle);
            }
        }

        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("characterID".equals(qName))
            response.setCharacterID(getLong());
        else if ("name".equals(qName))
            response.setName(getString());
        else if ("race".equals(qName))
            response.setRace(getRace());
        else if ("DoB".equals(qName))
            response.setDateOfBirth(getDate());
        else if ("bloodLine".equals(qName))
            response.setBloodLine(getBloodline());
        else if ("ancestry".equals(qName))
            response.setAncestry(getAncestry());
        else if ("gender".equals(qName))
            response.setGender(getString());
        else if ("corporationID".equals(qName))
            response.setCorporationID(getLong());
        else if ("corporationName".equals(qName))
            response.setCorporationName(getString());
        else if ("allianceID".equals(qName))
            response.setAllianceID(getLong());
        else if ("allianceName".equals(qName)) {
            if (getString() != null && !getString().equals(""))
                response.setAllianceName(getString());
        } else if ("cloneName".equals(qName))
            response.setCloneName(getString());
        else if ("cloneSkillPoints".equals(qName))
            response.setCloneSkillPoints(getLong());
        else if ("balance".equals(qName))
            response.setBalance(getDouble());
        else if ("augmentatorName".equals(qName))
            attributeEnhancer.setAugmentatorName(getString());
        else if ("augmentatorValue".equals(qName))
            attributeEnhancer.setAugmentatorValue(getInt());
        else if (qName.endsWith("Bonus")) {
            response.addAttributeEnhancer(attributeEnhancer);
            attributeEnhancer = null;
        } else if ("intelligence".equals(qName))
            response.setIntelligence(getInt());
        else if ("memory".equals(qName))
            response.setMemory(getInt());
        else if ("charisma".equals(qName))
            response.setCharisma(getInt());
        else if ("perception".equals(qName))
            response.setPerception(getInt());
        else if ("willpower".equals(qName))
            response.setWillpower(getInt());
        else if (ELEMENT_ROWSET.equals(qName))
            rowsetName = null;
        super.endElement(uri, localName, qName);
    }

    private Ancestry getAncestry() {
        return Ancestry.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll("[-\\s]", "_"));
    }

    private Bloodline getBloodline() {
        return Bloodline.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll("[-\\s]", "_"));
    }

    private Race getRace() {
        return Race.valueOf(getString().toUpperCase(Locale.ENGLISH).replaceAll("[-\\s]", "_"));
    }

    @Override
    public CharacterSheetResponse getResponse() {
        return response;
    }
}