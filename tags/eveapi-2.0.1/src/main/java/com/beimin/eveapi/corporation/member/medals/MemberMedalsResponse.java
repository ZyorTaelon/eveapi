package com.beimin.eveapi.corporation.member.medals;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class MemberMedalsResponse extends ApiResponse {
	private final List<MemberMedal> medals = new ArrayList<MemberMedal>();

	public void addMedal(MemberMedal entry) {
		medals.add(entry);
	}

	public List<MemberMedal> getMemberMedals() {
		return medals;
	}
}