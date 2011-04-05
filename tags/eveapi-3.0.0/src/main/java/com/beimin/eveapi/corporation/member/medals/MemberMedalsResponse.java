package com.beimin.eveapi.corporation.member.medals;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class MemberMedalsResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<MemberMedal> medals = new ArrayList<MemberMedal>();

	public void addMedal(MemberMedal entry) {
		medals.add(entry);
	}

	public List<MemberMedal> getMemberMedals() {
		return medals;
	}
}