package com.beimin.eveapi.model.corporation;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.shared.Title;

public class SecurityMember {
    private long characterID;
    private String name;
    private final Set<CorporationRole> roles = new HashSet<>();
    private final Set<CorporationRole> grantableRoles = new HashSet<>();
    private final Set<CorporationRole> rolesAtHQ = new HashSet<>();
    private final Set<CorporationRole> grantableRolesAtHQ = new HashSet<>();
    private final Set<CorporationRole> rolesAtBase = new HashSet<>();
    private final Set<CorporationRole> grantableRolesAtBase = new HashSet<>();
    private final Set<CorporationRole> rolesAtOther = new HashSet<>();
    private final Set<CorporationRole> grantableRolesAtOther = new HashSet<>();
    private final Set<Title> titles = new HashSet<>();

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

    public Set<CorporationRole> getRoles() {
        return roles;
    }

    public Set<CorporationRole> getGrantableRoles() {
        return grantableRoles;
    }

    public Set<CorporationRole> getRolesAtHQ() {
        return rolesAtHQ;
    }

    public Set<CorporationRole> getGrantableRolesAtHQ() {
        return grantableRolesAtHQ;
    }

    public Set<CorporationRole> getRolesAtBase() {
        return rolesAtBase;
    }

    public Set<CorporationRole> getGrantableRolesAtBase() {
        return grantableRolesAtBase;
    }

    public Set<CorporationRole> getRolesAtOther() {
        return rolesAtOther;
    }

    public Set<CorporationRole> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
    }

    public Set<Title> getTitles() {
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
