package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class ContactListParser extends AbstractContactListParser<ContactListResponse> {
	public ContactListParser() {
		super(ContactListResponse.class, ApiPath.CORPORATION);
	}
}