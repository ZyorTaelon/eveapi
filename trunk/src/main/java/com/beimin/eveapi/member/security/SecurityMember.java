package com.beimin.eveapi.member.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class SecurityMember {
	private long characterID;
	private String name;
	private final Set<SecurityRole> roles = new HashSet<SecurityRole>();
	private final Set<SecurityRole> grantableRoles = new HashSet<SecurityRole>();
	private final Set<SecurityRole> rolesAtHQ = new HashSet<SecurityRole>();
	private final Set<SecurityRole> grantableRolesAtHQ = new HashSet<SecurityRole>();
	private final Set<SecurityRole> rolesAtBase = new HashSet<SecurityRole>();
	private final Set<SecurityRole> grantableRolesAtBase = new HashSet<SecurityRole>();
	private final Set<SecurityRole> rolesAtOther = new HashSet<SecurityRole>();
	private final Set<SecurityRole> grantableRolesAtOther = new HashSet<SecurityRole>();
	private final Set<SecurityTitle> titles = new HashSet<SecurityTitle>();

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
		String name = securityRoleBag.getName();
		if (name.equals("roles")) {
			addSecurityRoles(roles, securityRoleBag);
		} else if (name.equals("grantableRoles")) {
			addSecurityRoles(grantableRoles, securityRoleBag);
		} else if (name.equals("rolesAtHQ")) {
			addSecurityRoles(rolesAtHQ, securityRoleBag);
		} else if (name.equals("grantableRolesAtHQ")) {
			addSecurityRoles(grantableRolesAtHQ, securityRoleBag);
		} else if (name.equals("rolesAtBase")) {
			addSecurityRoles(rolesAtBase, securityRoleBag);
		} else if (name.equals("grantableRolesAtBase")) {
			addSecurityRoles(grantableRolesAtBase, securityRoleBag);
		} else if (name.equals("rolesAtOther")) {
			addSecurityRoles(rolesAtOther, securityRoleBag);
		} else if (name.equals("grantableRolesAtOther")) {
			addSecurityRoles(grantableRolesAtOther, securityRoleBag);
		} else if (name.equals("titles")) {
			Collection<SecurityRoleOrTitle> securityRoles = securityRoleBag.getSecurityRoles();
			for (SecurityRoleOrTitle securityRoleOrTitle : securityRoles) {
				titles.add(securityRoleOrTitle.getTitle());
			}
		}
	}

	private void addSecurityRoles(Set<SecurityRole> roleSet, SecurityRoleOrTitleBag securityRoleBag) {
		Collection<SecurityRoleOrTitle> securityRoles = securityRoleBag.getSecurityRoles();
		for (SecurityRoleOrTitle securityRoleOrTitle : securityRoles) {
			roleSet.add(securityRoleOrTitle.getRole());
		}
	}

	public Set<SecurityRole> getRoles() {
		return roles;
	}

	public Set<SecurityRole> getGrantableRoles() {
		return grantableRoles;
	}

	public Set<SecurityRole> getRolesAtHQ() {
		return rolesAtHQ;
	}

	public Set<SecurityRole> getGrantableRolesAtHQ() {
		return grantableRolesAtHQ;
	}

	public Set<SecurityRole> getRolesAtBase() {
		return rolesAtBase;
	}

	public Set<SecurityRole> getGrantableRolesAtBase() {
		return grantableRolesAtBase;
	}

	public Set<SecurityRole> getRolesAtOther() {
		return rolesAtOther;
	}

	public Set<SecurityRole> getGrantableRolesAtOther() {
		return grantableRolesAtOther;
	}

	public Set<SecurityTitle> getTitles() {
		return titles;
	}
}
