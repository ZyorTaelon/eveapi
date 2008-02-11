package com.beimin.eveapi.skill;

import java.util.Collection;
import java.util.HashSet;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<SkillGroup> skillGroups = new HashSet<SkillGroup>();

	public void addSkillGroup(SkillGroup skillGroup) {
		skillGroups.add(skillGroup);
	}

	public Collection<SkillGroup> getSkillGroups() {
		return skillGroups;
	}

	@Override
	public String toString() {
		String result = "";
		for (SkillGroup skillGroup : skillGroups) {
			result += skillGroup + "\n";
		}
		return result;
	}
}
