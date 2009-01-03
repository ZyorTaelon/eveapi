package com.beimin.eveapi.member.security.log;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.member.security.SecurityRole;

public class SecurityRoleBag {
	private String name;
	private final Collection<SecurityRole> securityRoles = new ArrayList<SecurityRole>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSecurityRole(SecurityRole securityRole) {
		securityRoles.add(securityRole);
	}

	public Collection<SecurityRole> getSecurityRoles() {
		return securityRoles;
	}
}