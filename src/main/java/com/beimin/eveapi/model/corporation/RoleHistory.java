package com.beimin.eveapi.model.corporation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class RoleHistory {
    private Date changeTime;
    private long characterID;
    private String characterName;
    private long issuerID;
    private String issuerName;
    private String roleLocationType;
    private final Set<CorporationRole> oldRoles = new HashSet<>();
    private final Set<CorporationRole> newRoles = new HashSet<>();

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(final Date changeTime) {
        this.changeTime = changeTime;
    }

    public long getCharacterID() {
        return characterID;
    }

    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public long getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(final long issuerID) {
        this.issuerID = issuerID;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(final String issuerName) {
        this.issuerName = issuerName;
    }

    public String getRoleLocationType() {
        return roleLocationType;
    }

    public void setRoleLocationType(final String roleLocationType) {
        this.roleLocationType = roleLocationType;
    }

    public Set<CorporationRole> getOldRoles() {
        return oldRoles;
    }

    public Set<CorporationRole> getNewRoles() {
        return newRoles;
    }

    public void addOldRole(final CorporationRole securityRole) {
        oldRoles.add(securityRole);
    }

    public void addNewRole(final CorporationRole securityRole) {
        newRoles.add(securityRole);
    }
}
