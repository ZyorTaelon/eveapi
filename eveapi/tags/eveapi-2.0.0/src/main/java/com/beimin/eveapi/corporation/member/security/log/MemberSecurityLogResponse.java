package com.beimin.eveapi.corporation.member.security.log;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class MemberSecurityLogResponse extends ApiResponse {
	private final Set<ApiRoleHistory> roleHistories = new HashSet<ApiRoleHistory>();

	public void addRoleHistory(ApiRoleHistory roleHistory) {
		roleHistories.add(roleHistory);
	}

	public Set<ApiRoleHistory> getRoleHistories() {
		return roleHistories;
	}
}