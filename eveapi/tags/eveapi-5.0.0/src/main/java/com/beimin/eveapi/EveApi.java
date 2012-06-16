package com.beimin.eveapi;

import java.util.Set;

import com.beimin.eveapi.account.accountstatus.AccountStatusParser;
import com.beimin.eveapi.account.accountstatus.EveAccountStatus;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.character.accountbalance.AccountBalanceParser;
import com.beimin.eveapi.character.assetlist.AssetListParser;
import com.beimin.eveapi.character.calendar.attendees.CalendarEventAttendeesParser;
import com.beimin.eveapi.character.calendar.attendees.EveCalendarEventAttendee;
import com.beimin.eveapi.character.calendar.upcomingevents.EveUpcomingCalendarEvent;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsParser;
import com.beimin.eveapi.character.contact.list.ContactListParser;
import com.beimin.eveapi.character.contact.notifications.ContactNotificationsParser;
import com.beimin.eveapi.character.contact.notifications.EveContactNotification;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.shared.accountbalance.EveAccountBalance;
import com.beimin.eveapi.shared.assetlist.EveAsset;
import com.beimin.eveapi.shared.contacts.ContactList;

public class EveApi {
	private static ApiConnector connector = new ApiConnector();
	private final ApiAuth<?> auth;
	private AccountStatusParser accountStatusParser;
	private CharactersParser charactersParser;
	private AccountBalanceParser characterAccountBalanceParser;
	private AssetListParser characterAssetListParser;
	private UpcomingCalendarEventsParser upcomingCalendarEventsParser;
	private CalendarEventAttendeesParser calendarEventAttendeesParser;
	private ContactListParser characterContactListParser;
	private ContactNotificationsParser contactNotificationsParser;

	public EveApi(ApiAuth<?> auth) {
		this.auth = auth;
	}

	public static ApiConnector getConnector() {
		return connector;
	}

	public static void setConnector(ApiConnector connector) {
		EveApi.connector = connector;
	}

	public EveAccountStatus getAccountStatus() throws ApiException {
		return getAccountStatusParser().getResponse(auth).get();
	}

	private AccountStatusParser getAccountStatusParser() {
		if (accountStatusParser == null)
			accountStatusParser = AccountStatusParser.getInstance();
		return accountStatusParser;
	}

	public Set<EveCharacter> getCharacters() throws ApiException {
		return getCharactersParser().getResponse(auth).getAll();
	}

	private CharactersParser getCharactersParser() {
		if (charactersParser == null)
			charactersParser = CharactersParser.getInstance();
		return charactersParser;
	}

	public void selectCharacter(EveCharacter eveCharacter) {
		auth.setCharacterID(eveCharacter.getCharacterID());
	}

	public void selectCharacter(long characterID) {
		auth.setCharacterID(characterID);
	}

	public EveAccountBalance getAccountBalance() throws ApiException {
		return getCharacterAccountBalanceParser().getResponse(auth).getAll().iterator().next();
	}

	private AccountBalanceParser getCharacterAccountBalanceParser() {
		if (characterAccountBalanceParser == null)
			characterAccountBalanceParser = com.beimin.eveapi.character.accountbalance.AccountBalanceParser.getInstance();
		return characterAccountBalanceParser;
	}

	public Set<EveAsset<EveAsset<?>>> getCharacterAssets() throws ApiException {
		return getCharacterAssetParser().getResponse(auth).getAll();
	}

	private AssetListParser getCharacterAssetParser() {
		if (characterAssetListParser == null)
			characterAssetListParser = com.beimin.eveapi.character.assetlist.AssetListParser.getInstance();
		return characterAssetListParser;
	}

	public Set<EveUpcomingCalendarEvent> getUpcomingCalendarEvents() throws ApiException {
		return getUpcomingCalendatEventsParser().getResponse(auth).getAll();
	}

	private UpcomingCalendarEventsParser getUpcomingCalendatEventsParser() {
		if (upcomingCalendarEventsParser == null)
			upcomingCalendarEventsParser = UpcomingCalendarEventsParser.getInstance();
		return upcomingCalendarEventsParser;
	}

	public Set<EveCalendarEventAttendee> getCalendarEventAttendees(long... eventIds) throws ApiException {
		return getCalendarEventAttendeesParser().getResponse(auth, eventIds).getAll();
	}

	private CalendarEventAttendeesParser getCalendarEventAttendeesParser() {
		if (calendarEventAttendeesParser == null)
			calendarEventAttendeesParser = CalendarEventAttendeesParser.getInstance();
		return calendarEventAttendeesParser;
	}

	public ContactList getContactList() throws ApiException {
		return getCharacterContactListParser().getResponse(auth).getContactList();
	}

	private ContactListParser getCharacterContactListParser() {
		if (characterContactListParser == null)
			characterContactListParser = com.beimin.eveapi.character.contact.list.ContactListParser.getInstance();
		return characterContactListParser;
	}

	public Set<EveContactNotification> getContactNotifications() throws ApiException {
		return getContactNotificationsParser().getResponse(auth).getAll();
	}

	private ContactNotificationsParser getContactNotificationsParser() {
		if (contactNotificationsParser == null)
			contactNotificationsParser = ContactNotificationsParser.getInstance();
		return contactNotificationsParser;
	}
}