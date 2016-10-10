package com.beimin.eveapi.parser.pilot;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;

public class CharContactListParser extends AbstractContactListParser<ContactListResponse> {
    public CharContactListParser() {
        super(ContactListResponse.class, ApiPath.CHARACTER);
    }
}
