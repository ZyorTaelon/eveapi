package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;

public class ContactListParser extends AbstractContactListParser<ContactListResponse> {
	public ContactListParser() {
		super(ContactListResponse.class, ApiPath.CHARACTER);
	}
}