package com.beimin.eveapi.character.contacts;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

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
        assertThat(response, notNullValue());

        Set<Contact> contactList = response.getContactList();
        assertThat(contactList.size(), equalTo(1));
        Contact apiContact = contactList.iterator().next();
        assertThat(apiContact.getContactID(), equalTo(3009560));
        assertThat(apiContact.getContactName(), equalTo("Gryncelbois Erris"));
        assertThat(apiContact.getStanding(), equalTo(0.0d));
        assertThat(apiContact.isInWatchlist(), equalTo(false));
        assertThat(apiContact.getContactTypeID(), equalTo(1378));
        assertThat(apiContact.getLabelMask(), equalTo(0l));

        Set<ContactLabel> contactLabels = response.getContactLabels();
        assertThat(contactLabels.size(), equalTo(1));
        final ContactLabel contactLabel = contactLabels.iterator().next();
        assertThat(contactLabel.getLabelID(), equalTo(1l));
        assertThat(contactLabel.getName(), equalTo("Huhu"));

        Set<Contact> corporateContactList = response.getCorporateContactList();
        assertThat(corporateContactList.size(), equalTo(1));
        Contact corporateContact = corporateContactList.iterator().next();
        assertThat(corporateContact.getContactID(), equalTo(90976800));
        assertThat(corporateContact.getContactName(), equalTo("DianaLynn ETC"));
        assertThat(corporateContact.getStanding(), equalTo(9.9d));
        assertThat(corporateContact.isInWatchlist(), equalTo(false));
        assertThat(corporateContact.getContactTypeID(), equalTo(1377));
        assertThat(corporateContact.getLabelMask(), equalTo(0l));

        Set<ContactLabel> corporateContactLabels = response.getCorporateContactLabels();
        assertThat(corporateContactLabels.size(), equalTo(1));
        final ContactLabel corporateContactLabel = corporateContactLabels.iterator().next();
        assertThat(corporateContactLabel.getLabelID(), equalTo(1l));
        assertThat(corporateContactLabel.getName(), equalTo("Huhu"));

        Set<Contact> allianceContactList = response.getAllianceContactList();
        assertThat(allianceContactList.size(), equalTo(1));
        Contact allianceContact = allianceContactList.iterator().next();
        assertThat(allianceContact.getContactID(), equalTo(1000148));
        assertThat(allianceContact.getContactName(), equalTo("InterBus"));
        assertThat(allianceContact.getStanding(), equalTo(0d));
        assertThat(allianceContact.isInWatchlist(), equalTo(false));
        assertThat(allianceContact.getContactTypeID(), equalTo(2));
        assertThat(allianceContact.getLabelMask(), equalTo(0l));

        Set<ContactLabel> allianceContactLabels = response.getAllianceContactLabels();
        assertThat(allianceContactLabels.size(), equalTo(1));
        final ContactLabel allianceContactLabel = allianceContactLabels.iterator().next();
        assertThat(allianceContactLabel.getLabelID(), equalTo(1l));
        assertThat(allianceContactLabel.getName(), equalTo("Boosters"));
    }
}