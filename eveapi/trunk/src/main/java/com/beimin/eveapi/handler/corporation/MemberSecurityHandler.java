package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.corporation.SecurityMember;
import com.beimin.eveapi.model.corporation.SecurityRole;
import com.beimin.eveapi.model.corporation.SecurityTitle;
import com.beimin.eveapi.response.ApiResponse;
import com.beimin.eveapi.response.corporation.MemberSecurityResponse;

public class MemberSecurityHandler extends AbstractContentHandler {
	private MemberSecurityResponse response;
	private boolean roles;
	private boolean grantableRoles;
	private boolean rolesAtHQ;
	private boolean grantableRolesAtHQ;
	private boolean rolesAtBase;
	private boolean grantableRolesAtBase;
	private boolean rolesAtOther;
	private boolean grantableRolesAtOther;
	private boolean titles;
	private SecurityMember member;

	@Override
	public void startDocument() throws SAXException {
		response = new MemberSecurityResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			String name = getString(attrs, "name");
			roles = name.equals("roles");
			grantableRoles = name.equals("grantableRoles");
			rolesAtHQ = name.equals("rolesAtHQ");
			grantableRolesAtHQ = name.equals("grantableRolesAtHQ");
			rolesAtBase = name.equals("rolesAtBase");
			grantableRolesAtBase = name.equals("grantableRolesAtBase");
			rolesAtOther = name.equals("rolesAtOther");
			grantableRolesAtOther = name.equals("grantableRolesAtOther");
			titles = name.equals("titles");
		} else if (qName.equals("row")) {
			if (roles) {
				member.addRole(getRole(attrs));
			} else if (grantableRoles) {
				member.addGrantableRole(getRole(attrs));
			} else if (rolesAtHQ) {
				member.addRoleAtHQ(getRole(attrs));
			} else if (grantableRolesAtHQ) {
				member.addGrantableRoleAtHQ(getRole(attrs));
			} else if (rolesAtBase) {
				member.addRoleAtBase(getRole(attrs));
			} else if (grantableRolesAtBase) {
				member.addGrantableRoleAtBase(getRole(attrs));
			} else if (rolesAtOther) {
				member.addRoleAtOther(getRole(attrs));
			} else if (grantableRolesAtOther) {
				member.addGrantableRoleAtOther(getRole(attrs));
			} else if (titles) {
				member.addTitle(getTitle(attrs));
			} else {
				member = new SecurityMember();
				member.setCharacterID(getLong(attrs, "characterID"));
				member.setName(getString(attrs, "name"));
				response.addMember(member);
			}
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	private SecurityTitle getTitle(Attributes attrs) {
		SecurityTitle title = new SecurityTitle();
		title.setTitleID(getLong(attrs, "titleID"));
		title.setTitleName(getString(attrs, "titleName"));
		return title;
	}

	private SecurityRole getRole(Attributes attrs) {
		SecurityRole role = new SecurityRole();
		role.setRoleID(getLong(attrs, "roleID"));
		role.setRoleName(getString(attrs, "roleName"));
		return role;
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset")) {
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
			} else if (titles) {
				titles = false;
			}
		}
		super.endElement(uri, localName, qName);
	}

	@Override
	public ApiResponse getResponse() {
		return response;
	}
}