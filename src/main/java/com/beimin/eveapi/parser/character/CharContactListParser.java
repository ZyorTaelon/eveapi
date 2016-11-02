package com.beimin.eveapi.parser.character;

import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.shared.AbstractContactListParser;
import com.beimin.eveapi.response.character.ContactListResponse;

public class CharContactListParser extends AbstractContactListParser<ContactListResponse> {
    public CharContactListParser() {
        super(ContactListResponse.class, ApiPath.CHARACTER);
    }
}
