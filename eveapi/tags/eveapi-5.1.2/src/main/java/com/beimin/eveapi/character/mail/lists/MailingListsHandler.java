package com.beimin.eveapi.character.mail.lists;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MailingListsHandler extends AbstractContentListHandler<MailingListsResponse, ApiMailingList> {

	public MailingListsHandler() {
		super(MailingListsResponse.class);
	}

	@Override
	protected ApiMailingList getItem(Attributes attrs) {
		ApiMailingList mailingList = new ApiMailingList();
		mailingList.setListID(getLong(attrs, "listID"));
		mailingList.setDisplayName(getString(attrs, "displayName"));
		return mailingList;
	}
}