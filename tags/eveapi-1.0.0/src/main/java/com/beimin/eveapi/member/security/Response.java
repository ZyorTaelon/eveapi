package com.beimin.eveapi.member.security;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Set<ApiSecurityMember> members = new HashSet<ApiSecurityMember>();

	public void addMember(ApiSecurityMember member) {
		members.add(member);
	}

	public Set<ApiSecurityMember> getMembers() {
		return members;
	}
}