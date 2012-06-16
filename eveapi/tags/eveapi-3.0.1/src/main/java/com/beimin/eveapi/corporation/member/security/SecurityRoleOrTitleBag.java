package com.beimin.eveapi.corporation.member.security;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityRoleOrTitleBag {
	private String name;
	private final Collection<SecurityRoleOrTitle> securityRoles = new ArrayList<SecurityRoleOrTitle>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSecurityRole(SecurityRoleOrTitle securityRole) {
		securityRoles.add(securityRole);
	}

	public Collection<SecurityRoleOrTitle> getSecurityRoles() {
		return securityRoles;
	}

}