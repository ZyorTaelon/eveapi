package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.SkillQueueItem;
import com.beimin.eveapi.response.pilot.SkillQueueResponse;

public class SkillQueueHandler extends AbstractContentListHandler<SkillQueueResponse, SkillQueueItem> {

	public SkillQueueHandler() {
		super(SkillQueueResponse.class);
	}

	@Override
	protected SkillQueueItem getItem(Attributes attrs) {
		SkillQueueItem item = new SkillQueueItem();
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