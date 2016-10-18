package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.corporation.SecurityMember;
import com.beimin.eveapi.model.shared.Title;
import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;

public class MemberSecurityHandler extends AbstractContentHandler<MemberSecurityResponse> {
    private final RolesHandler<ApiResponse> roleHandler = new RolesHandler<>();
    private boolean titles;
    private SecurityMember member;

    @Override
    public void startDocument() throws SAXException {
        setResponse(new MemberSecurityResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            final String name = getString(attrs, "name");
            roleHandler.parseRowsetRoles(name);
            titles = name.equals("titles");
        } else if (ELEMENT_ROW.equals(qName)) {
            boolean handledRoles = roleHandler.handleRoles(member, attrs);
            if (titles && !handledRoles) {
                member.addTitle(getTitle(attrs));
            } else if (!handledRoles) {
                member = new SecurityMember();
                saveAttributes(SecurityMember.class, attrs);
                member.setCharacterID(getLong(attrs, "characterID"));
                member.setName(getString(attrs, "name"));
                getResponse().addMember(member);
            }
        }
    }

    private Title getTitle(final Attributes attrs) {
        final Title title = new Title();
        saveAttributes(Title.class, attrs);
        title.setTitleID(getLong(attrs, "titleID"));
        title.setTitleName(getString(attrs, "titleName"));
        return title;
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        if (ELEMENT_ROWSET.equals(qName)) {
            roleHandler.resetRoles();
            if (titles) {
                titles = false;
            }
        }
    }
}
