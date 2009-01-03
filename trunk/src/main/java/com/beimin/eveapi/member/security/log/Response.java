package com.beimin.eveapi.member.security.log;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Set<RoleHistory> roleHistories = new HashSet<RoleHistory>();

	public void addRoleHistory(RoleHistory roleHistory) {
		roleHistories.add(roleHistory);
	}

	public Set<RoleHistory> getRoleHistories() {
		return roleHistories;
	}
}