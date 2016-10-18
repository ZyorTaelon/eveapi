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
    protected MailingList getItem(final Attributes attrs) {
        final MailingList mailingList = new MailingList();
        saveAttributes(MailingList.class, attrs);
        mailingList.setListID(getLong(attrs, "listID"));
        mailingList.setDisplayName(getString(attrs, "displayName"));
        return mailingList;
    }
}
