package com.beimin.eveapi.corporation.member.security.log;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.corporation.member.security.ApiSecurityRole;

public class SecurityRoleBag {
	private String name;
	private final Collection<ApiSecurityRole> securityRoles = new ArrayList<ApiSecurityRole>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(ApiSecurityRole securityRole) {
		securityRoles.add(securityRole);
	}

	public Collection<ApiSecurityRole> getSecurityRoles() {
		return securityRoles;
	}
}