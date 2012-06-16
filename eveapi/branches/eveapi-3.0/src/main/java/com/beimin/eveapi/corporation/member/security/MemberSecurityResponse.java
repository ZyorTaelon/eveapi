package com.beimin.eveapi.corporation.member.security;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.core.ApiResponse;

public class MemberSecurityResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Set<ApiSecurityMember> members = new HashSet<ApiSecurityMember>();

	public void addMember(ApiSecurityMember member) {
		members.add(member);
	}

	public Set<ApiSecurityMember> getMembers() {
		return members;
	}
}