package com.beimin.eveapi.corporation.titles;

import java.util.ArrayList;
import java.util.Collection;

public class ApiTitle {
	private long titleID;
	private String titleName;
	private final Collection<ApiRole> roles = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRoles = new ArrayList<ApiRole>();
	private final Collection<ApiRole> rolesAtHQ = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRolesAtHQ = new ArrayList<ApiRole>();
	private final Collection<ApiRole> rolesAtBase = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRolesAtBase = new ArrayList<ApiRole>();
	private final Collection<ApiRole> rolesAtOther = new ArrayList<ApiRole>();
	private final Collection<ApiRole> grantableRolesAtOther = new ArrayList<ApiRole>();

	public long getTitleID() {
		return titleID;
	}

	public void setTitleID(long titleID) {
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

	public void addRole(ApiRole role) {
		roles.add(role);
	}
	
	public void addGrantableRole(ApiRole role) {
		grantableRoles.add(role);
	}
	
	public void addRoleAtHQ(ApiRole role) {
		rolesAtHQ.add(role);
	}
	
	public void addGrantableRoleAtHQ(ApiRole role) {
		grantableRolesAtHQ.add(role);
	}
	
	public void addRoleAtBase(ApiRole role) {
		rolesAtBase.add(role);
	}
	
	public void addGrantableRoleAtBase(ApiRole role) {
		grantableRolesAtBase.add(role);
	}
	
	public void addRoleAtOther(ApiRole role) {
		rolesAtOther.add(role);
	}
	
	public void addGrantableRoleAtOther(ApiRole role) {
		grantableRolesAtOther.add(role);
	}
}