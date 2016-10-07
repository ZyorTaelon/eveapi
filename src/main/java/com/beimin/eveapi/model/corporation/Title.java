package com.beimin.eveapi.model.corporation;

import java.util.ArrayList;
import java.util.Collection;

public class Title {
    private long titleID;
    private String titleName;
    private final Collection<Role> roles = new ArrayList<Role>();
    private final Collection<Role> grantableRoles = new ArrayList<Role>();
    private final Collection<Role> rolesAtHQ = new ArrayList<Role>();
    private final Collection<Role> grantableRolesAtHQ = new ArrayList<Role>();
    private final Collection<Role> rolesAtBase = new ArrayList<Role>();
    private final Collection<Role> grantableRolesAtBase = new ArrayList<Role>();
    private final Collection<Role> rolesAtOther = new ArrayList<Role>();
    private final Collection<Role> grantableRolesAtOther = new ArrayList<Role>();

    public long getTitleID() {
        return titleID;
    }

    public void setTitleID(final long titleID) {
        this.titleID = titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(final String titleName) {
        this.titleName = titleName;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public Collection<Role> getGrantableRoles() {
        return grantableRoles;
    }

    public Collection<Role> getRolesAtHQ() {
        return rolesAtHQ;
    }

    public Collection<Role> getGrantableRolesAtHQ() {
        return grantableRolesAtHQ;
    }

    public Collection<Role> getRolesAtBase() {
        return rolesAtBase;
    }

    public Collection<Role> getGrantableRolesAtBase() {
        return grantableRolesAtBase;
    }

    public Collection<Role> getRolesAtOther() {
        return rolesAtOther;
    }

    public Collection<Role> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
    }

    public void addRole(final Role role) {
        roles.add(role);
    }

    public void addGrantableRole(final Role role) {
        grantableRoles.add(role);
    }

    public void addRoleAtHQ(final Role role) {
        rolesAtHQ.add(role);
    }

    public void addGrantableRoleAtHQ(final Role role) {
        grantableRolesAtHQ.add(role);
    }

    public void addRoleAtBase(final Role role) {
        rolesAtBase.add(role);
    }

    public void addGrantableRoleAtBase(final Role role) {
        grantableRolesAtBase.add(role);
    }

    public void addRoleAtOther(final Role role) {
        rolesAtOther.add(role);
    }

    public void addGrantableRoleAtOther(final Role role) {
        grantableRolesAtOther.add(role);
    }
}