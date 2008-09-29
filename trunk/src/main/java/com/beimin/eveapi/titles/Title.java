package com.beimin.eveapi.titles;

import java.util.ArrayList;
import java.util.Collection;

public class Title {
	private int titleID; // ="1"
	private String titleName; // ="Member"
	private final Collection<Role> roles = new ArrayList<Role>();
	private final Collection<Role> grantableRoles = new ArrayList<Role>();
	private final Collection<Role> rolesAtHQ = new ArrayList<Role>();
	private final Collection<Role> grantableRolesAtHQ = new ArrayList<Role>();
	private final Collection<Role> rolesAtBase = new ArrayList<Role>();
	private final Collection<Role> grantableRolesAtBase = new ArrayList<Role>();
	private final Collection<Role> rolesAtOther = new ArrayList<Role>();
	private final Collection<Role> grantableRolesAtOther = new ArrayList<Role>();

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

	public Collection<Role> getRoles() {
		return roles;
	}

	public Collection<Role> getGrantableRoles() {
		return grantableRoles;
	}

	public Collection<Role> getRolesAtHQ() {
		return rolesAtHQ;
	}

	public Collection<Role> getGrantableRolesAtHQ() {
		return grantableRolesAtHQ;
	}

	public Collection<Role> getRolesAtBase() {
		return rolesAtBase;
	}

	public Collection<Role> getGrantableRolesAtBase() {
		return grantableRolesAtBase;
	}

	public Collection<Role> getRolesAtOther() {
		return rolesAtOther;
	}

	public Collection<Role> getGrantableRolesAtOther() {
		return grantableRolesAtOther;
	}

	public void addRoleBag(RoleBag roleBag) {
		String name = roleBag.getName();
		Collection<Role> target = null;
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
		Collection<Role> roles = roleBag.getRoles();
		for (Role role : roles) {
			target.add(role);
		}
	}
}