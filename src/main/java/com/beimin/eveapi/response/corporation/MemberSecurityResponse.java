package com.beimin.eveapi.response.corporation;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.corporation.SecurityMember;
import com.beimin.eveapi.response.ApiResponse;

public class MemberSecurityResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Set<SecurityMember> members = new HashSet<SecurityMember>();

	public void addMember(SecurityMember member) {
		members.add(member);
	}

	public Set<SecurityMember> getMembers() {
		return members;
	}
}