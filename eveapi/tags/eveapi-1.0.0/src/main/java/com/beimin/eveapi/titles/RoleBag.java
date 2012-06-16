package com.beimin.eveapi.titles;

import java.util.ArrayList;
import java.util.Collection;

public class RoleBag {
	private String name;
	private final Collection<ApiRole> roles = new ArrayList<ApiRole>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addRole(ApiRole role) {
		roles.add(role);
	}

	public Collection<ApiRole> getRoles() {
		return roles;
	}
}