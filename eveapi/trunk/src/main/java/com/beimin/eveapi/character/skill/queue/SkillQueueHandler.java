package com.beimin.eveapi.character.skill.queue;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class SkillQueueHandler extends AbstractContentListHandler<SkillQueueResponse, ApiSkillQueueItem> {

	public SkillQueueHandler() {
		super(SkillQueueResponse.class);
	}

	@Override
	protected ApiSkillQueueItem getItem(Attributes attrs) {
		ApiSkillQueueItem item = new ApiSkillQueueItem();
		item.setTypeID(getInt(attrs, "typeID"));
		item.setLevel(getInt(attrs, "level"));
		item.setQueuePosition(getInt(attrs, "queuePosition"));
		item.setStartTime(getDate(attrs, "startTime"));
		item.setStartSP(getInt(attrs, "startSP"));
		item.setEndTime(getDate(attrs, "endTime"));
		item.setEndSP(getInt(attrs, "endSP"));
		return item;
	}
}