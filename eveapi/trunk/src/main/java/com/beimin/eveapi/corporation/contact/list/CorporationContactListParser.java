package com.beimin.eveapi.corporation.contact.list;

import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.shared.contacts.AbstractContactListParser;

public class CorporationContactListParser extends AbstractContactListParser<CorporationContactListResponse> {
	public CorporationContactListParser() {
		super(CorporationContactListResponse.class, ApiPath.CORPORATION);
	}
}