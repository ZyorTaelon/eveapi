package com.beimin.eveapi.character.skill.queue;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.core.ApiResponse;

public class SkillQueueResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiSkillQueueItem> skillQueueItems = new ArrayList<ApiSkillQueueItem>();

	public void addSkillQueueItem(ApiSkillQueueItem skillQueueItem) {
		skillQueueItems.add(skillQueueItem);
	}

	public List<ApiSkillQueueItem> getSkillQueueItems() {
		return skillQueueItems;
	}
}