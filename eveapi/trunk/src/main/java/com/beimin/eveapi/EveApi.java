package com.beimin.eveapi;

import java.util.Set;

import com.beimin.eveapi.account.accountstatus.AccountStatusParser;
import com.beimin.eveapi.account.accountstatus.EveAccountStatus;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.api.calllist.CallList;
import com.beimin.eveapi.api.calllist.CallListParser;
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
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.exception.NoAuthException;
import com.beimin.eveapi.shared.accountbalance.EveAccountBalance;
import com.beimin.eveapi.shared.assetlist.EveAsset;
import com.beimin.eveapi.shared.contacts.ContactList;

public class EveApi {
	private static ApiConnector connector = new ApiConnector();
	private ApiAuth<?> auth;
	private AccountStatusParser accountStatusParser;
	private CharactersParser charactersParser;
	private AccountBalanceParser characterAccountBalanceParser;
	private AssetListParser characterAssetListParser;
	private UpcomingCalendarEventsParser upcomingCalendarEventsParser;
	private CalendarEventAttendeesParser calendarEventAttendeesParser;
	private ContactListParser characterContactListParser;
	private ContactNotificationsParser contactNotificationsParser;
	private CallListParser callListParser;

	public EveApi() {
		// default constructor
	}

	public EveApi(ApiAuth<?> auth) {
		this.auth = auth;
	}
	
	public final ApiAuth<?> getAuth() {
		if(auth == null)
			throw new NoAuthException();
		return auth;
	}

	public final void setAuth(ApiAuth<?> auth) {
		this.auth = auth;
	}

	public static ApiConnector getConnector() {
		return connector.getInstance();
	}

	public static void setConnector(ApiConnector connector) {
		EveApi.connector = connector;
	}

	public EveAccountStatus getAccountStatus() throws ApiException {
		return getAccountStatusParser().getResponse(getAuth()).get();
	}

	private AccountStatusParser getAccountStatusParser() {
		if (accountStatusParser == null)
			accountStatusParser = AccountStatusParser.getInstance();
		return accountStatusParser;
	}

	public Set<EveCharacter> getCharacters() throws ApiException {
		return getCharactersParser().getResponse(getAuth()).getAll();
	}

	private CharactersParser getCharactersParser() {
		if (charactersParser == null)
			charactersParser = CharactersParser.getInstance();
		return charactersParser;
	}

	public void selectCharacter(EveCharacter eveCharacter) {
		if(auth == null)
			throw new NoAuthException();
		auth.setCharacterID(eveCharacter.getCharacterID());
	}

	public void selectCharacter(long characterID) {
		if(auth == null)
			throw new NoAuthException();
		auth.setCharacterID(characterID);
	}

	public EveAccountBalance getAccountBalance() throws ApiException {
		return getCharacterAccountBalanceParser().getResponse(getAuth()).getAll().iterator().next();
	}

	private AccountBalanceParser getCharacterAccountBalanceParser() {
		if (characterAccountBalanceParser == null)
			characterAccountBalanceParser = com.beimin.eveapi.character.accountbalance.AccountBalanceParser.getInstance();
		return characterAccountBalanceParser;
	}

	public Set<EveAsset<EveAsset<?>>> getCharacterAssets() throws ApiException {
		return getCharacterAssetParser().getResponse(getAuth()).getAll();
	}

	private AssetListParser getCharacterAssetParser() {
		if (characterAssetListParser == null)
			characterAssetListParser = com.beimin.eveapi.character.assetlist.AssetListParser.getInstance();
		return characterAssetListParser;
	}

	public Set<EveUpcomingCalendarEvent> getUpcomingCalendarEvents() throws ApiException {
		return getUpcomingCalendatEventsParser().getResponse(getAuth()).getAll();
	}

	private UpcomingCalendarEventsParser getUpcomingCalendatEventsParser() {
		if (upcomingCalendarEventsParser == null)
			upcomingCalendarEventsParser = UpcomingCalendarEventsParser.getInstance();
		return upcomingCalendarEventsParser;
	}

	public Set<EveCalendarEventAttendee> getCalendarEventAttendees(long... eventIds) throws ApiException {
		return getCalendarEventAttendeesParser().getResponse(getAuth(), eventIds).getAll();
	}

	private CalendarEventAttendeesParser getCalendarEventAttendeesParser() {
		if (calendarEventAttendeesParser == null)
			calendarEventAttendeesParser = CalendarEventAttendeesParser.getInstance();
		return calendarEventAttendeesParser;
	}

	public ContactList getContactList() throws ApiException {
		return getCharacterContactListParser().getResponse(getAuth()).getContactList();
	}

	private ContactListParser getCharacterContactListParser() {
		if (characterContactListParser == null)
			characterContactListParser = com.beimin.eveapi.character.contact.list.ContactListParser.getInstance();
		return characterContactListParser;
	}

	public Set<EveContactNotification> getContactNotifications() throws ApiException {
		return getContactNotificationsParser().getResponse(getAuth()).getAll();
	}

	private ContactNotificationsParser getContactNotificationsParser() {
		if (contactNotificationsParser == null)
			contactNotificationsParser = ContactNotificationsParser.getInstance();
		return contactNotificationsParser;
	}
	
	private CallListParser getCallListParser() {
		if(callListParser == null)
			callListParser = CallListParser.getInstance();
		return callListParser;
	}

	public CallList getCallList() throws ApiException {
		return getCallListParser().getResponse().get();
	}
}