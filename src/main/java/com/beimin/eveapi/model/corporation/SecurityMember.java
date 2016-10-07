package com.beimin.eveapi.model.corporation;

import java.util.HashSet;
import java.util.Set;

public class SecurityMember {
    private long characterID;
    private String name;
    private final Set<SecurityRole> roles = new HashSet<SecurityRole>();
    private final Set<SecurityRole> grantableRoles = new HashSet<SecurityRole>();
    private final Set<SecurityRole> rolesAtHQ = new HashSet<SecurityRole>();
    private final Set<SecurityRole> grantableRolesAtHQ = new HashSet<SecurityRole>();
    private final Set<SecurityRole> rolesAtBase = new HashSet<SecurityRole>();
    private final Set<SecurityRole> grantableRolesAtBase = new HashSet<SecurityRole>();
    private final Set<SecurityRole> rolesAtOther = new HashSet<SecurityRole>();
    private final Set<SecurityRole> grantableRolesAtOther = new HashSet<SecurityRole>();
    private final Set<SecurityTitle> titles = new HashSet<SecurityTitle>();

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

    public Set<SecurityRole> getRoles() {
        return roles;
    }

    public Set<SecurityRole> getGrantableRoles() {
        return grantableRoles;
    }

    public Set<SecurityRole> getRolesAtHQ() {
        return rolesAtHQ;
    }

    public Set<SecurityRole> getGrantableRolesAtHQ() {
        return grantableRolesAtHQ;
    }

    public Set<SecurityRole> getRolesAtBase() {
        return rolesAtBase;
    }

    public Set<SecurityRole> getGrantableRolesAtBase() {
        return grantableRolesAtBase;
    }

    public Set<SecurityRole> getRolesAtOther() {
        return rolesAtOther;
    }

    public Set<SecurityRole> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
    }

    public Set<SecurityTitle> getTitles() {
        return titles;
    }

    public void addRole(final SecurityRole role) {
        roles.add(role);
    }

    public void addGrantableRole(final SecurityRole role) {
        grantableRoles.add(role);
    }

    public void addRoleAtHQ(final SecurityRole role) {
        rolesAtHQ.add(role);
    }

    public void addGrantableRoleAtHQ(final SecurityRole role) {
        grantableRolesAtHQ.add(role);
    }

    public void addRoleAtBase(final SecurityRole role) {
        rolesAtBase.add(role);
    }

    public void addGrantableRoleAtBase(final SecurityRole role) {
        grantableRolesAtBase.add(role);
    }

    public void addRoleAtOther(final SecurityRole role) {
        rolesAtOther.add(role);
    }

    public void addGrantableRoleAtOther(final SecurityRole role) {
        grantableRolesAtOther.add(role);
    }

    public void addTitle(final SecurityTitle title) {
        titles.add(title);
    }
}
