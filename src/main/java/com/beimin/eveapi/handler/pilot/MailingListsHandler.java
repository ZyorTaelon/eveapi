package com.beimin.eveapi.handler.pilot;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.pilot.MailingList;
import com.beimin.eveapi.response.pilot.MailingListsResponse;

public class MailingListsHandler extends AbstractContentListHandler<MailingListsResponse, MailingList> {

	public MailingListsHandler() {
		super(MailingListsResponse.class);
	}

	@Override
	protected MailingList getItem(Attributes attrs) {
		MailingList mailingList = new MailingList();
		mailingList.setListID(getLong(attrs, "listID"));
		mailingList.setDisplayName(getString(attrs, "displayName"));
		return mailingList;
	}
}