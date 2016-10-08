package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.corporation.CorporationRole;
import com.beimin.eveapi.model.corporation.SecurityMember;
import com.beimin.eveapi.model.corporation.TitleWithRoles;
import com.beimin.eveapi.response.ApiResponse;

public class RolesHandler<E extends ApiResponse> extends AbstractContentHandler<E> {
    private boolean roles;
    private boolean grantableRoles;
    private boolean rolesAtHQ;
    private boolean grantableRolesAtHQ;
    private boolean rolesAtBase;
    private boolean grantableRolesAtBase;
    private boolean rolesAtOther;
    private boolean grantableRolesAtOther;

    protected void parseRowsetRoles(String name) {
        roles = name.equals("roles");
        grantableRoles = name.equals("grantableRoles");
        rolesAtHQ = name.equals("rolesAtHQ");
        grantableRolesAtHQ = name.equals("grantableRolesAtHQ");
        rolesAtBase = name.equals("rolesAtBase");
        grantableRolesAtBase = name.equals("grantableRolesAtBase");
        rolesAtOther = name.equals("rolesAtOther");
        grantableRolesAtOther = name.equals("grantableRolesAtOther");
    }

    protected boolean handleRoles(SecurityMember member, Attributes attrs) {
        boolean done = false;
        if (roles) {
            member.addRole(getRole(attrs));
            done = true;
        } else if (grantableRoles) {
            member.addGrantableRole(getRole(attrs));
            done = true;
        } else if (rolesAtHQ) {
            member.addRoleAtHQ(getRole(attrs));
            done = true;
        } else if (grantableRolesAtHQ) {
            member.addGrantableRoleAtHQ(getRole(attrs));
            done = true;
        } else if (rolesAtBase) {
            member.addRoleAtBase(getRole(attrs));
            done = true;
        } else if (grantableRolesAtBase) {
            member.addGrantableRoleAtBase(getRole(attrs));
            done = true;
        } else if (rolesAtOther) {
            member.addRoleAtOther(getRole(attrs));
            done = true;
        } else if (grantableRolesAtOther) {
            member.addGrantableRoleAtOther(getRole(attrs));
            done = true;
        }
        return done;
    }

    protected boolean handleTitleRoles(TitleWithRoles title, Attributes attrs) {
        boolean done = false;
        if (roles) {
            title.addRole(getRole(attrs));
            done = true;
        } else if (grantableRoles) {
            title.addGrantableRole(getRole(attrs));
            done = true;
        } else if (rolesAtHQ) {
            title.addRoleAtHQ(getRole(attrs));
            done = true;
        } else if (grantableRolesAtHQ) {
            title.addGrantableRoleAtHQ(getRole(attrs));
            done = true;
        } else if (rolesAtBase) {
            title.addRoleAtBase(getRole(attrs));
            done = true;
        } else if (grantableRolesAtBase) {
            title.addGrantableRoleAtBase(getRole(attrs));
            done = true;
        } else if (rolesAtOther) {
            title.addRoleAtOther(getRole(attrs));
            done = true;
        } else if (grantableRolesAtOther) {
            title.addGrantableRoleAtOther(getRole(attrs));
            done = true;
        }
        return done;
    }

    protected void resetRoles() {
        if (roles) {
            roles = false;
        } else if (grantableRoles) {
            grantableRoles = false;
        } else if (rolesAtHQ) {
            rolesAtHQ = false;
        } else if (grantableRolesAtHQ) {
            grantableRolesAtHQ = false;
        } else if (rolesAtBase) {
            rolesAtBase = false;
        } else if (grantableRolesAtBase) {
            grantableRolesAtBase = false;
        } else if (rolesAtOther) {
            rolesAtOther = false;
        } else if (grantableRolesAtOther) {
            grantableRolesAtOther = false;
        }
    }

    private CorporationRole getRole(final Attributes attrs) {
        final CorporationRole role = new CorporationRole();
        saveFieldsCount(CorporationRole.class, attrs);
        role.setRoleID(getLong(attrs, "roleID"));
        role.setRoleName(getString(attrs, "roleName"));
        role.setRoleDescription(getString(attrs, "roleDescription"));
        return role;
    }
}
