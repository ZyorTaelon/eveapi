package com.beimin.eveapi.member.tracking;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	Set<ApiMember> members = new HashSet<ApiMember>();

	public void addMember(ApiMember member) {
		members.add(member);
	}

	public Set<ApiMember> getMembers() {
		return members;
	}
}
