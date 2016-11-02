package com.beimin.eveapi.model.corporation;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.shared.Title;

public class SecurityMember {
    private long characterID;
    private String name;
    private final List<CorporationRole> roles = new ArrayList<>();
    private final List<CorporationRole> grantableRoles = new ArrayList<>();
    private final List<CorporationRole> rolesAtHQ = new ArrayList<>();
    private final List<CorporationRole> grantableRolesAtHQ = new ArrayList<>();
    private final List<CorporationRole> rolesAtBase = new ArrayList<>();
    private final List<CorporationRole> grantableRolesAtBase = new ArrayList<>();
    private final List<CorporationRole> rolesAtOther = new ArrayList<>();
    private final List<CorporationRole> grantableRolesAtOther = new ArrayList<>();
    private final List<Title> titles = new ArrayList<>();

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

    public List<CorporationRole> getRoles() {
        return roles;
    }

    public List<CorporationRole> getGrantableRoles() {
        return grantableRoles;
    }

    public List<CorporationRole> getRolesAtHQ() {
        return rolesAtHQ;
    }

    public List<CorporationRole> getGrantableRolesAtHQ() {
        return grantableRolesAtHQ;
    }

    public List<CorporationRole> getRolesAtBase() {
        return rolesAtBase;
    }

    public List<CorporationRole> getGrantableRolesAtBase() {
        return grantableRolesAtBase;
    }

    public List<CorporationRole> getRolesAtOther() {
        return rolesAtOther;
    }

    public List<CorporationRole> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void addRole(final CorporationRole role) {
        roles.add(role);
    }

    public void addGrantableRole(final CorporationRole role) {
        grantableRoles.add(role);
    }

    public void addRoleAtHQ(final CorporationRole role) {
        rolesAtHQ.add(role);
    }

    public void addGrantableRoleAtHQ(final CorporationRole role) {
        grantableRolesAtHQ.add(role);
    }

    public void addRoleAtBase(final CorporationRole role) {
        rolesAtBase.add(role);
    }

    public void addGrantableRoleAtBase(final CorporationRole role) {
        grantableRolesAtBase.add(role);
    }

    public void addRoleAtOther(final CorporationRole role) {
        rolesAtOther.add(role);
    }

    public void addGrantableRoleAtOther(final CorporationRole role) {
        grantableRolesAtOther.add(role);
    }

    public void addTitle(final Title title) {
        titles.add(title);
    }
}
