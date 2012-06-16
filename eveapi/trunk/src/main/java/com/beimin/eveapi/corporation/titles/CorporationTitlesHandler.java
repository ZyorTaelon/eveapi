package com.beimin.eveapi.corporation.titles;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class CorporationTitlesHandler extends AbstractContentListHandler<CorporationTitlesResponse, ApiTitle> {
	private boolean roles;
	private boolean grantableRoles;
	private boolean rolesAtHQ;
	private boolean grantableRolesAtHQ;
	private boolean rolesAtBase;
	private boolean grantableRolesAtBase;
	private boolean rolesAtOther;
	private boolean grantableRolesAtOther;
	private ApiTitle title;

	public CorporationTitlesHandler() {
		super(CorporationTitlesResponse.class);
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

	private ApiRole getRole(Attributes attrs) {
		ApiRole role = new ApiRole();
		role.setRoleID(getLong(attrs, "roleID"));
		role.setRoleName(getString(attrs, "roleName"));
		role.setRoleDescription(getString(attrs, "roleDescription"));
		return role;
	}

	@Override
	protected ApiTitle getItem(Attributes attrs) {
		ApiTitle item = new ApiTitle();
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