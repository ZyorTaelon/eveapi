package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.Role;
import com.beimin.eveapi.model.corporation.Title;
import com.beimin.eveapi.response.corporation.TitlesResponse;

public class TitlesHandler extends AbstractContentListHandler<TitlesResponse, Title> {
	private boolean roles;
	private boolean grantableRoles;
	private boolean rolesAtHQ;
	private boolean grantableRolesAtHQ;
	private boolean rolesAtBase;
	private boolean grantableRolesAtBase;
	private boolean rolesAtOther;
	private boolean grantableRolesAtOther;
	private Title title;

	public TitlesHandler() {
		super(TitlesResponse.class);
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
		} else if (qName.equals("row")) {
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
				response.add(title);
			}
		} else
			super.startElement(uri, localName, qName, attrs);
	}

	private Role getRole(Attributes attrs) {
		Role role = new Role();
		role.setRoleID(getLong(attrs, "roleID"));
		role.setRoleName(getString(attrs, "roleName"));
		role.setRoleDescription(getString(attrs, "roleDescription"));
		return role;
	}

	@Override
	protected Title getItem(Attributes attrs) {
		Title item = new Title();
		item.setTitleID(getLong(attrs, "titleID"));
		item.setTitleName(getString(attrs, "titleName"));
		return item;
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
			}
		}
		super.endElement(uri, localName, qName);
	}
}