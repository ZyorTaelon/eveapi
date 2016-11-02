package com.beimin.eveapi.character.contacts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Contact;
import com.beimin.eveapi.model.shared.ContactLabel;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.CharContactListParser;
import com.beimin.eveapi.response.character.ContactListResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharContactListParserTest extends FullAuthParserTest {
    public CharContactListParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CONTACT_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharContactListParser parser = new CharContactListParser();
        final ContactListResponse response = parser.getResponse(auth);
        assertNotNull(response);

        Set<Contact> contactList = response.getContactList();
        assertEquals(1, contactList.size());
        Contact apiContact = contactList.iterator().next();
        assertEquals(3009560, apiContact.getContactID());
        assertEquals("Gryncelbois Erris", apiContact.getContactName());
        assertEquals(0.0, apiContact.getStanding(), 1E-15);
        assertFalse(apiContact.isInWatchlist());
        assertEquals(1378, apiContact.getContactTypeID());
        assertEquals(0, apiContact.getLabelMask());

        Set<ContactLabel> contactLabels = response.getContactLabels();
        assertEquals(1, contactLabels.size());
        final ContactLabel contactLabel = contactLabels.iterator().next();
        assertEquals(1, contactLabel.getLabelID());
        assertEquals("Huhu", contactLabel.getName());

        Set<Contact> corporateContactList = response.getCorporateContactList();
        assertEquals(1, corporateContactList.size());
        Contact corporateContact = corporateContactList.iterator().next();
        assertEquals(90976800, corporateContact.getContactID());
        assertEquals("DianaLynn ETC", corporateContact.getContactName());
        assertEquals(9.9, corporateContact.getStanding(), 1E-15);
        assertFalse(corporateContact.isInWatchlist());
        assertEquals(1377, corporateContact.getContactTypeID());
        assertEquals(0, corporateContact.getLabelMask());

        Set<ContactLabel> corporateContactLabels = response.getCorporateContactLabels();
        assertEquals(1, corporateContactLabels.size());
        final ContactLabel corporateContactLabel = corporateContactLabels.iterator().next();
        assertEquals(1, corporateContactLabel.getLabelID());
        assertEquals("Huhu", corporateContactLabel.getName());

        Set<Contact> allianceContactList = response.getAllianceContactList();
        assertEquals(1, allianceContactList.size());
        Contact allianceContact = allianceContactList.iterator().next();
        assertEquals(1000148, allianceContact.getContactID());
        assertEquals("InterBus", allianceContact.getContactName());
        assertEquals(0, allianceContact.getStanding(), 1E-15);
        assertFalse(allianceContact.isInWatchlist());
        assertEquals(2, allianceContact.getContactTypeID());
        assertEquals(0, allianceContact.getLabelMask());

        Set<ContactLabel> allianceContactLabels = response.getAllianceContactLabels();
        assertEquals(1, allianceContactLabels.size());
        final ContactLabel allianceContactLabel = allianceContactLabels.iterator().next();
        assertEquals(1, allianceContactLabel.getLabelID());
        assertEquals("Boosters", allianceContactLabel.getName());
    }
}