package com.beimin.eveapi.titles;

import java.util.ArrayList;
import java.util.Collection;

public class ApiTitle {
	private int titleID; // ="1"
	private String titleName; // ="Member"
	private final Collection<ApiRole> roles = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRoles = new ArrayList<ApiRole>();
	private final Collection<ApiRole> rolesAtHQ = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRolesAtHQ = new ArrayList<ApiRole>();
	private final Collection<ApiRole> rolesAtBase = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRolesAtBase = new ArrayList<ApiRole>();
	private final Collection<ApiRole> rolesAtOther = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRolesAtOther = new ArrayList<ApiRole>();

	public int getTitleID() {
		return titleID;
	}

	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public Collection<ApiRole> getRoles() {
		return roles;
	}

	public Collection<ApiRole> getGrantableRoles() {
		return grantableRoles;
	}

	public Collection<ApiRole> getRolesAtHQ() {
		return rolesAtHQ;
	}

	public Collection<ApiRole> getGrantableRolesAtHQ() {
		return grantableRolesAtHQ;
	}

	public Collection<ApiRole> getRolesAtBase() {
		return rolesAtBase;
	}

	public Collection<ApiRole> getGrantableRolesAtBase() {
		return grantableRolesAtBase;
	}

	public Collection<ApiRole> getRolesAtOther() {
		return rolesAtOther;
	}

	public Collection<ApiRole> getGrantableRolesAtOther() {
		return grantableRolesAtOther;
	}

	public void addRoleBag(RoleBag roleBag) {
		String name = roleBag.getName();
		Collection<ApiRole> target = null;
		if (name.equals("roles")) {
			target = roles;
		} else if (name.equals("grantableRoles")) {
			target = grantableRoles;
		} else if (name.equals("rolesAtHQ")) {
			target = rolesAtHQ;
		} else if (name.equals("grantableRolesAtHQ")) {
			target = grantableRolesAtHQ;
		} else if (name.equals("rolesAtBase")) {
			target = rolesAtBase;
		} else if (name.equals("grantableRolesAtBase")) {
			target = grantableRolesAtBase;
		} else if (name.equals("rolesAtOther")) {
			target = rolesAtOther;
		} else if (name.equals("grantableRolesAtOther")) {
			target = grantableRolesAtOther;
		}
		Collection<ApiRole> roles = roleBag.getRoles();
		for (ApiRole role : roles) {
			target.add(role);
		}
	}
}