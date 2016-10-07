package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.Role;
import com.beimin.eveapi.model.corporation.TitleWithRoles;
import com.beimin.eveapi.response.corporation.TitlesResponse;

public class TitlesHandler extends AbstractContentListHandler<TitlesResponse, TitleWithRoles> {
    private boolean roles;
    private boolean grantableRoles;
    private boolean rolesAtHQ;
    private boolean grantableRolesAtHQ;
    private boolean rolesAtBase;
    private boolean grantableRolesAtBase;
    private boolean rolesAtOther;
    private boolean grantableRolesAtOther;
    private TitleWithRoles title;

    public TitlesHandler() {
        super(TitlesResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            roles = name.equals("roles");
            grantableRoles = name.equals("grantableRoles");
            rolesAtHQ = name.equals("rolesAtHQ");
            grantableRolesAtHQ = name.equals("grantableRolesAtHQ");
            rolesAtBase = name.equals("rolesAtBase");
            grantableRolesAtBase = name.equals("grantableRolesAtBase");
            rolesAtOther = name.equals("rolesAtOther");
            grantableRolesAtOther = name.equals("grantableRolesAtOther");
        } else if (ELEMENT_ROW.equals(qName)) {
            if (roles) {
                title.addRole(getRole(attrs));
            } else if (grantableRoles) {
                title.addGrantableRole(getRole(attrs));
            } else if (rolesAtHQ) {
                title.addRoleAtHQ(getRole(attrs));
            } else if (grantableRolesAtHQ) {
                title.addGrantableRoleAtHQ(getRole(attrs));
            } else if (rolesAtBase) {
                title.addRoleAtBase(getRole(attrs));
            } else if (grantableRolesAtBase) {
                title.addGrantableRoleAtBase(getRole(attrs));
            } else if (rolesAtOther) {
                title.addRoleAtOther(getRole(attrs));
            } else if (grantableRolesAtOther) {
                title.addGrantableRoleAtOther(getRole(attrs));
            } else {
                title = getItem(attrs);
                getResponse().add(title);
            }
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    private Role getRole(final Attributes attrs) {
        final Role role = new Role();
        role.setRoleID(getLong(attrs, "roleID"));
        role.setRoleName(getString(attrs, "roleName"));
        role.setRoleDescription(getString(attrs, "roleDescription"));
        return role;
    }

    @Override
    protected TitleWithRoles getItem(final Attributes attrs) {
        final TitleWithRoles item = new TitleWithRoles();
        item.setTitleID(getLong(attrs, "titleID"));
        item.setTitleName(getString(attrs, "titleName"));
        return item;
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
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
        super.endElement(uri, localName, qName);
    }
}
