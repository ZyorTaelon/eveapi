package com.beimin.eveapi.corporation.member.security;

import java.util.HashSet;
import java.util.Set;

public class ApiSecurityMember {
	private long characterID;
	private String name;
	private final Set<ApiSecurityRole> roles = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> grantableRoles = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> rolesAtHQ = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> grantableRolesAtHQ = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> rolesAtBase = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> grantableRolesAtBase = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> rolesAtOther = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> grantableRolesAtOther = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityTitle> titles = new HashSet<ApiSecurityTitle>();

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ApiSecurityRole> getRoles() {
		return roles;
	}

	public Set<ApiSecurityRole> getGrantableRoles() {
		return grantableRoles;
	}

	public Set<ApiSecurityRole> getRolesAtHQ() {
		return rolesAtHQ;
	}

	public Set<ApiSecurityRole> getGrantableRolesAtHQ() {
		return grantableRolesAtHQ;
	}

	public Set<ApiSecurityRole> getRolesAtBase() {
		return rolesAtBase;
	}

	public Set<ApiSecurityRole> getGrantableRolesAtBase() {
		return grantableRolesAtBase;
	}

	public Set<ApiSecurityRole> getRolesAtOther() {
		return rolesAtOther;
	}

	public Set<ApiSecurityRole> getGrantableRolesAtOther() {
		return grantableRolesAtOther;
	}

	public Set<ApiSecurityTitle> getTitles() {
		return titles;
	}

	public void addRole(ApiSecurityRole role) {
		roles.add(role);
	}

	public void addGrantableRole(ApiSecurityRole role) {
		grantableRoles.add(role);
	}

	public void addRoleAtHQ(ApiSecurityRole role) {
		rolesAtHQ.add(role);
	}

	public void addGrantableRoleAtHQ(ApiSecurityRole role) {
		grantableRolesAtHQ.add(role);
	}

	public void addRoleAtBase(ApiSecurityRole role) {
		rolesAtBase.add(role);
	}

	public void addGrantableRoleAtBase(ApiSecurityRole role) {
		grantableRolesAtBase.add(role);
	}

	public void addRoleAtOther(ApiSecurityRole role) {
		rolesAtOther.add(role);
	}

	public void addGrantableRoleAtOther(ApiSecurityRole role) {
		grantableRolesAtOther.add(role);
	}

	public void addTitle(ApiSecurityTitle title) {
		titles.add(title);
	}
}
