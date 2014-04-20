package com.beimin.eveapi;

import java.util.Set;

import com.beimin.eveapi.account.accountstatus.AccountStatusParser;
import com.beimin.eveapi.account.accountstatus.EveAccountStatus;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoParser;
import com.beimin.eveapi.account.apikeyinfo.ApiKeyInfoResponse;
import com.beimin.eveapi.account.characters.CharactersParser;
import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.api.calllist.CallList;
import com.beimin.eveapi.api.calllist.CallListParser;
import com.beimin.eveapi.character.accountbalance.CharacterAccountBalanceParser;
import com.beimin.eveapi.character.assetlist.CharacterAssetListParser;
import com.beimin.eveapi.character.calendar.attendees.CalendarEventAttendeesParser;
import com.beimin.eveapi.character.calendar.attendees.EveCalendarEventAttendee;
import com.beimin.eveapi.character.calendar.upcomingevents.EveUpcomingCalendarEvent;
import com.beimin.eveapi.character.calendar.upcomingevents.UpcomingCalendarEventsParser;
import com.beimin.eveapi.character.contact.list.CharacterContactListParser;
import com.beimin.eveapi.character.contact.notifications.ContactNotificationsParser;
import com.beimin.eveapi.character.contact.notifications.EveContactNotification;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.corporation.accountbalance.CorporationAccountBalanceParser;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.exception.NoAuthException;
import com.beimin.eveapi.shared.KeyType;
import com.beimin.eveapi.shared.accountbalance.AbstractAccountBalanceParser;
import com.beimin.eveapi.shared.accountbalance.AccountBalanceResponse;
import com.beimin.eveapi.shared.accountbalance.EveAccountBalance;
import com.beimin.eveapi.shared.assetlist.EveAsset;
import com.beimin.eveapi.shared.contacts.ContactList;

public class EveApi {
	private static ApiConnector connector = new ApiConnector();
	private ApiAuth<?> auth;

	public EveApi() {
		// default constructor
	}

	public EveApi(ApiAuth<?> auth) {
		this.auth = auth;
	}

	public ApiAuth<?> getAuth() {
		if (auth == null)
			throw new NoAuthException();
		return auth;
	}

	public void setAuth(ApiAuth<?> auth) {
		this.auth = auth;
	}

	public static ApiConnector getConnector() {
		return connector.getNewInstance();
	}

	public static void setConnector(ApiConnector connector) {
		EveApi.connector = connector;
	}

	public ApiKeyInfoResponse getAPIKeyInfo() throws ApiException {
		ApiKeyInfoParser apiKeyInfoParser = new ApiKeyInfoParser();
		return apiKeyInfoParser.getResponse(auth);
	}

	public EveAccountStatus getAccountStatus() throws ApiException {
		return new AccountStatusParser().getResponse(getAuth()).get();
	}

	public Set<EveCharacter> getCharacters() throws ApiException {
		return new CharactersParser().getResponse(getAuth()).getAll();
	}

	public void selectCharacter(EveCharacter eveCharacter) {
		if (auth == null)
			throw new NoAuthException();
		auth.setCharacterID(eveCharacter.getCharacterID());
	}

	public void selectCharacter(long characterID) {
		if (auth == null)
			throw new NoAuthException();
		auth.setCharacterID(characterID);
	}

	public Set<EveAccountBalance> getAccountBalance(KeyType type) throws ApiException {
		AbstractAccountBalanceParser accountBalanceParser;
		if (type == KeyType.Character)
			accountBalanceParser = new CharacterAccountBalanceParser();
		else if (type == KeyType.Corporation)
			accountBalanceParser = new CorporationAccountBalanceParser();
		else
			return null;
		AccountBalanceResponse response = accountBalanceParser.getResponse(getAuth());
		if (response.hasError())
			throw new ApiException(response.getError().getError());
		return response.getAll();
	}

	public Set<EveAsset<EveAsset<?>>> getCharacterAssets() throws ApiException {
		return new CharacterAssetListParser().getResponse(getAuth()).getAll();
	}

	public Set<EveUpcomingCalendarEvent> getUpcomingCalendarEvents() throws ApiException {
		return new UpcomingCalendarEventsParser().getResponse(getAuth()).getAll();
	}

	public Set<EveCalendarEventAttendee> getCalendarEventAttendees(long... eventIds) throws ApiException {
		return new CalendarEventAttendeesParser().getResponse(getAuth(), eventIds).getAll();
	}

	public ContactList getContactList() throws ApiException {
		return new CharacterContactListParser().getResponse(getAuth()).getContactList();
	}

	public Set<EveContactNotification> getContactNotifications() throws ApiException {
		return new ContactNotificationsParser().getResponse(getAuth()).getAll();
	}

	public CallList getCallList() throws ApiException {
		return new CallListParser().getResponse().get();
	}
}