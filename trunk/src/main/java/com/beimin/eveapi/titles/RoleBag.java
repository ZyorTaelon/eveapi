package com.beimin.eveapi.titles;

import java.util.ArrayList;
import java.util.Collection;

public class RoleBag {
	private String name;
	private final Collection<Role> roles = new ArrayList<Role>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public Collection<Role> getRoles() {
		return roles;
	}
}