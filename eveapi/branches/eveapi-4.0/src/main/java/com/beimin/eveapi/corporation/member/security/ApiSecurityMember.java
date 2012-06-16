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

	public void addSecurityRoleBag(SecurityRoleOrTitleBag securityRoleBag) {
		String bagName = securityRoleBag.getName();
		if (bagName.equals("roles"))
			addSecurityRoles(roles, securityRoleBag);
		else if (bagName.equals("grantableRoles"))
			addSecurityRoles(grantableRoles, securityRoleBag);
		else if (bagName.equals("rolesAtHQ"))
			addSecurityRoles(rolesAtHQ, securityRoleBag);
		else if (bagName.equals("grantableRolesAtHQ"))
			addSecurityRoles(grantableRolesAtHQ, securityRoleBag);
		else if (bagName.equals("rolesAtBase"))
			addSecurityRoles(rolesAtBase, securityRoleBag);
		else if (bagName.equals("grantableRolesAtBase"))
			addSecurityRoles(grantableRolesAtBase, securityRoleBag);
		else if (bagName.equals("rolesAtOther"))
			addSecurityRoles(rolesAtOther, securityRoleBag);
		else if (bagName.equals("grantableRolesAtOther"))
			addSecurityRoles(grantableRolesAtOther, securityRoleBag);
		else if (bagName.equals("titles"))
			for (SecurityRoleOrTitle securityRoleOrTitle : securityRoleBag.getSecurityRoles())
				titles.add(securityRoleOrTitle.getTitle());
		else
			throw new RuntimeException("Unknown roleOrTitleBag name");
	}

	private void addSecurityRoles(Set<ApiSecurityRole> roleSet, SecurityRoleOrTitleBag securityRoleBag) {
		for (SecurityRoleOrTitle securityRoleOrTitle : securityRoleBag.getSecurityRoles())
			roleSet.add(securityRoleOrTitle.getRole());
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
}
