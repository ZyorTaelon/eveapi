package com.beimin.eveapi.character.skill.queue;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class SkillQueueResponse extends ApiResponse {
	private final List<ApiSkillQueueItem> skillQueueItems = new ArrayList<ApiSkillQueueItem>();
	
	public void addSkillQueueItem(ApiSkillQueueItem skillQueueItem) {
		skillQueueItems.add(skillQueueItem);
	}

	public List<ApiSkillQueueItem> getSkillQueueItems() {
		return skillQueueItems;
	}
}