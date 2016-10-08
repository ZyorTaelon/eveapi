package com.beimin.eveapi.model.corporation;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.model.shared.Title;

public class TitleWithRoles extends Title {
    private final Collection<CorporationRole> roles = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> grantableRoles = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> rolesAtHQ = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> grantableRolesAtHQ = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> rolesAtBase = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> grantableRolesAtBase = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> rolesAtOther = new ArrayList<CorporationRole>();
    private final Collection<CorporationRole> grantableRolesAtOther = new ArrayList<CorporationRole>();

    public Collection<CorporationRole> getRoles() {
        return roles;
    }

    public Collection<CorporationRole> getGrantableRoles() {
        return grantableRoles;
    }

    public Collection<CorporationRole> getRolesAtHQ() {
        return rolesAtHQ;
    }

    public Collection<CorporationRole> getGrantableRolesAtHQ() {
        return grantableRolesAtHQ;
    }

    public Collection<CorporationRole> getRolesAtBase() {
        return rolesAtBase;
    }

    public Collection<CorporationRole> getGrantableRolesAtBase() {
        return grantableRolesAtBase;
    }

    public Collection<CorporationRole> getRolesAtOther() {
        return rolesAtOther;
    }

    public Collection<CorporationRole> getGrantableRolesAtOther() {
        return grantableRolesAtOther;
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
}
