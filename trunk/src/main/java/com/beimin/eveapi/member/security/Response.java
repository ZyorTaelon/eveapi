package com.beimin.eveapi.member.security;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Set<SecurityMember> members = new HashSet<SecurityMember>();

	public void addMember(SecurityMember member) {
		members.add(member);
	}

	public Set<SecurityMember> getMembers() {
		return members;
	}
}