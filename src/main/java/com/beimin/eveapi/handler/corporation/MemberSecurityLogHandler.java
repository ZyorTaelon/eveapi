package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.CorporationRole;
import com.beimin.eveapi.model.corporation.RoleHistory;
import com.beimin.eveapi.response.corporation.MemberSecurityLogResponse;

public class MemberSecurityLogHandler extends AbstractContentListHandler<MemberSecurityLogResponse, RoleHistory> {
    private boolean oldRoles;
    private boolean newRoles;
    private RoleHistory roleHistory;

    public MemberSecurityLogHandler() {
        super(MemberSecurityLogResponse.class);
    }

    @Override
    public void startElement(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            oldRoles = name.equals("oldRoles");
            newRoles = name.equals("newRoles");
        } else if (ELEMENT_ROW.equals(qName)) {
            if (oldRoles) {
                roleHistory.addOldRole(getRole(attrs));
            } else if (newRoles) {
                roleHistory.addNewRole(getRole(attrs));
            } else {
                roleHistory = getItem(attrs);
                getResponse().add(roleHistory);
            }
        } else {
            super.startElement(uri, localName, qName, attrs);
        }
    }

    private CorporationRole getRole(final Attributes attrs) {
        final CorporationRole securityRole = new CorporationRole();
        securityRole.setRoleID(getLong(attrs, "roleID"));
        securityRole.setRoleName(getString(attrs, "roleName"));
        return securityRole;
    }

    @Override
    public void endElement(final String uri, final String localName, final String qName) throws SAXException {
        if ((ELEMENT_ROWSET.equals(qName) && oldRoles) || newRoles) {
            oldRoles = false;
            newRoles = false;
        }
    }

    @Override
    protected RoleHistory getItem(final Attributes attrs) {
        final RoleHistory item = new RoleHistory();
        item.setCharacterID(getLong(attrs, "characterID"));
        item.setCharacterName(getString(attrs, "characterName"));
        item.setChangeTime(getDate(attrs, "changeTime"));
        item.setIssuerID(getLong(attrs, "issuerID"));
        item.setIssuerName(getString(attrs, "issuerName"));
        item.setRoleLocationType(getString(attrs, "roleLocationType"));
        return item;
    }
}
