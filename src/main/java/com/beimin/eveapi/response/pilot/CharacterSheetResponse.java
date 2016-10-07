package com.beimin.eveapi.response.pilot;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.pilot.AttributeEnhancer;
import com.beimin.eveapi.model.pilot.Certificate;
import com.beimin.eveapi.model.pilot.CorporationRole;
import com.beimin.eveapi.model.pilot.CorporationTitle;
import com.beimin.eveapi.model.pilot.Skill;
import com.beimin.eveapi.model.shared.Ancestry;
import com.beimin.eveapi.model.shared.Bloodline;
import com.beimin.eveapi.model.shared.Race;
import com.beimin.eveapi.response.ApiResponse;

public class CharacterSheetResponse extends ApiResponse {
    private long characterID;
    private String name;
    private Race race;
    private Date dateOfBirth;
    private Bloodline bloodLine;
    private Ancestry ancestry;
    private String gender;
    private String corporationName;
    private long corporationID;
    private Long allianceID;
    private String allianceName;
    private String cloneName;
    private long cloneSkillPoints;
    private double balance;
    private final Set<AttributeEnhancer> attributeEnhancers = new HashSet<AttributeEnhancer>();
    private int intelligence;
    private int memory;
    private int charisma;
    private int perception;
    private int willpower;
    private final Set<Skill> skills = new HashSet<Skill>();
    private final Set<Certificate> certificates = new HashSet<Certificate>();
    private final Set<CorporationRole> corporationRoles = new HashSet<CorporationRole>();
    private final Set<CorporationRole> corporationRolesAtHQ = new HashSet<CorporationRole>();
    private final Set<CorporationRole> corporationRolesAtBase = new HashSet<CorporationRole>();
    private final Set<CorporationRole> corporationRolesAtOther = new HashSet<CorporationRole>();
    private final Set<CorporationTitle> corporationTitles = new HashSet<CorporationTitle>();

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(final Race race) {
        this.race = race;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date doB) {
        dateOfBirth = doB;
    }

    public Bloodline getBloodLine() {
        return bloodLine;
    }

    public void setBloodLine(final Bloodline bloodLine) {
        this.bloodLine = bloodLine;
    }

    public Ancestry getAncestry() {
        return ancestry;
    }

    public void setAncestry(final Ancestry ancestry) {
        this.ancestry = ancestry;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getCorporationName() {
        return corporationName;
    }

    public void setCorporationName(final String corporationName) {
        this.corporationName = corporationName;
    }

    public long getCorporationID() {
        return corporationID;
    }

    public void setCorporationID(final long corporationID) {
        this.corporationID = corporationID;
    }

    public String getAllianceName() {
        return allianceName;
    }

    public void setAllianceName(final String allianceName) {
        this.allianceName = allianceName;
    }

    public Long getAllianceID() {
        return allianceID;
    }

    public void setAllianceID(final Long allianceID) {
        this.allianceID = allianceID;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(final String cloneName) {
        this.cloneName = cloneName;
    }

    public long getCloneSkillPoints() {
        return cloneSkillPoints;
    }

    public void setCloneSkillPoints(final long cloneSkillPoints) {
        this.cloneSkillPoints = cloneSkillPoints;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public void addAttributeEnhancer(final AttributeEnhancer attributeEnhancer) {
        attributeEnhancers.add(attributeEnhancer);
    }

    public Set<AttributeEnhancer> getAttributeEnhancers() {
        return attributeEnhancers;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(final int intelligence) {
        this.intelligence = intelligence;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(final int memory) {
        this.memory = memory;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(final int charisma) {
        this.charisma = charisma;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(final int perception) {
        this.perception = perception;
    }

    public int getWillpower() {
        return willpower;
    }

    public void setWillpower(final int willpower) {
        this.willpower = willpower;
    }

    public void addSkill(final Skill skill) {
        skills.add(skill);
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void addCertificate(final Certificate certificate) {
        certificates.add(certificate);
    }

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void addCorporationRole(final CorporationRole corporationRole) {
        corporationRoles.add(corporationRole);
    }

    public Set<CorporationRole> getCorporationRoles() {
        return corporationRoles;
    }

    public void addCorporationRoleAtHQ(final CorporationRole corporationRole) {
        corporationRolesAtHQ.add(corporationRole);
    }

    public Set<CorporationRole> getCorporationRolesAtHQ() {
        return corporationRolesAtHQ;
    }

    public void addCorporationRoleAtBase(final CorporationRole corporationRole) {
        corporationRolesAtBase.add(corporationRole);
    }

    public Set<CorporationRole> getCorporationRolesAtBase() {
        return corporationRolesAtBase;
    }

    public void addCorporationRoleAtOther(final CorporationRole corporationRole) {
        corporationRolesAtOther.add(corporationRole);
    }

    public Set<CorporationRole> getCorporationRolesAtOther() {
        return corporationRolesAtOther;
    }

    public void addCorporationTitle(final CorporationTitle title) {
        corporationTitles.add(title);
    }

    public Set<CorporationTitle> getCorporationTitles() {
        return corporationTitles;
    }
}
