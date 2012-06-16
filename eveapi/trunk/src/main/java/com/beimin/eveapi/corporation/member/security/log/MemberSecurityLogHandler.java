package com.beimin.eveapi.corporation.member.security.log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentListHandler;
import com.beimin.eveapi.corporation.member.security.ApiSecurityRole;

public class MemberSecurityLogHandler extends AbstractContentListHandler<MemberSecurityLogResponse, ApiRoleHistory> {
	private boolean oldRoles;
	private boolean newRoles;
	private ApiRoleHistory roleHistory;

	public MemberSecurityLogHandler() {
		super(MemberSecurityLogResponse.class);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			oldRoles = name.equals("oldRoles");
			newRoles = name.equals("newRoles");
		} else if (qName.equals("row")) {
			if (oldRoles) {
				roleHistory.addOldRole(getRole(attrs));
			} else if (newRoles) {
				roleHistory.addNewRole(getRole(attrs));
			} else {
				roleHistory = getItem(attrs);
				response.add(roleHistory);
			}
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	private ApiSecurityRole getRole(Attributes attrs) {
		ApiSecurityRole securityRole = new ApiSecurityRole();
		securityRole.setRoleID(getLong(attrs, "roleID"));
		securityRole.setRoleName(getString(attrs, "roleName"));
		return securityRole;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset") && oldRoles || newRoles) {
			oldRoles = false;
			newRoles = false;
		}
	}

	@Override
	protected ApiRoleHistory getItem(Attributes attrs) {
		ApiRoleHistory item = new ApiRoleHistory();
		item.setCharacterID(getLong(attrs, "characterID"));
		item.setCharacterName(getString(attrs, "characterName"));
		item.setChangeTime(getDate(attrs, "changeTime"));
		item.setIssuerID(getLong(attrs, "issuerID"));
		item.setIssuerName(getString(attrs, "issuerName"));
		item.setRoleLocationType(getString(attrs, "roleLocationType"));
		return item;
	}
}