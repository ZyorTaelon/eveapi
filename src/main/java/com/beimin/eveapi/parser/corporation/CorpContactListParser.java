package com.beimin.eveapi.parser.corporation;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContactListParser;
import com.beimin.eveapi.response.corporation.ContactListResponse;

public class CorpContactListParser extends AbstractContactListParser<ContactListResponse> {
    public CorpContactListParser() {
        super(ContactListResponse.class, ApiPath.CORPORATION);
    }
}
