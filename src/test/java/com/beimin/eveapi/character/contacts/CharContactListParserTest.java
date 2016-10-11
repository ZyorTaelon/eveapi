package com.beimin.eveapi.character.contacts;


import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.model.shared.NamedList;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharContactListParser;
import com.beimin.eveapi.response.pilot.ContactListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CharContactListParserTest extends FullAuthParserTest {
    public CharContactListParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CONTACT_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharContactListParser parser = new CharContactListParser();
        final ContactListResponse response = parser.getResponse(auth);
        assertNotNull(response);

        NamedList<Contact> contactList = response.getContactList();
        assertEquals("contactList", contactList.getName());
        assertEquals(108, contactList.size());
        Contact apiContact = contactList.iterator().next();
        assertEquals(3008667, apiContact.getContactID());
        assertEquals("Falian Khivad", apiContact.getContactName());
        assertEquals(5.0, apiContact.getStanding(), 1E-15);
        assertFalse(apiContact.isInWatchlist());
        assertEquals(1374, apiContact.getContactTypeID());
        assertEquals(1, apiContact.getLabelMask());

        apiContact = contactList.get(contactList.size() - 1);
        assertEquals(2065725204, apiContact.getContactID());
        assertEquals("De Boer", apiContact.getContactName());
        assertEquals(10.0, apiContact.getStanding(), 1E-15);
        assertTrue(apiContact.isInWatchlist());
        assertEquals(1376, apiContact.getContactTypeID());
        assertEquals(0, apiContact.getLabelMask());

        NamedList<ContactLabel> contactLabelList = response.getContactLabelList();
        final ContactLabel contactLabel = contactLabelList.get(0);
        assertEquals(1, contactLabel.getLabelID());
        assertEquals("Explorers", contactLabel.getName());
    }
}