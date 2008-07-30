package com.beimin.eveapi.member;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	Set<Member> members = new HashSet<Member>();

	public void addMember(Member member) {
		members.add(member);
	}

	public Set<Member> getMembers() {
		return members;
	}
}
