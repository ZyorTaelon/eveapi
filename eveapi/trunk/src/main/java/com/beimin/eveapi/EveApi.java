package com.beimin.eveapi;

import java.util.Set;

import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.exception.NoAuthException;
import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.model.account.Character;
import com.beimin.eveapi.model.calllist.CallList;
import com.beimin.eveapi.model.pilot.CalendarEventAttendee;
import com.beimin.eveapi.model.pilot.ContactNotification;
import com.beimin.eveapi.model.pilot.UpcomingCalendarEvent;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.model.shared.ContactList;
import com.beimin.eveapi.model.shared.EveAccountBalance;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.account.AccountStatusParser;
import com.beimin.eveapi.parser.account.ApiKeyInfoParser;
import com.beimin.eveapi.parser.account.CharactersParser;
import com.beimin.eveapi.parser.calllist.CallListParser;
import com.beimin.eveapi.parser.corporation.AccountBalanceParser;
import com.beimin.eveapi.parser.pilot.CalendarEventAttendeesParser;
import com.beimin.eveapi.parser.pilot.ContactListParser;
import com.beimin.eveapi.parser.pilot.ContactNotificationsParser;
import com.beimin.eveapi.parser.pilot.PilotAssetListParser;
import com.beimin.eveapi.parser.pilot.PilotAccountBalanceParser;
import com.beimin.eveapi.parser.pilot.UpcomingCalendarEventsParser;
import com.beimin.eveapi.parser.shared.AbstractAccountBalanceParser;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

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

	public AccountStatus getAccountStatus() throws ApiException {
		return new AccountStatusParser().getResponse(getAuth()).get();
	}

	public Set<Character> getCharacters() throws ApiException {
		return new CharactersParser().getResponse(getAuth()).getAll();
	}

	public void selectCharacter(Character eveCharacter) {
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
			accountBalanceParser = new PilotAccountBalanceParser();
		else if (type == KeyType.Corporation)
			accountBalanceParser = new AccountBalanceParser();
		else
			return null;
		AccountBalanceResponse response = accountBalanceParser.getResponse(getAuth());
		if (response.hasError())
			throw new ApiException(response.getError().getError());
		return response.getAll();
	}

	public Set<Asset<Asset<?>>> getCharacterAssets() throws ApiException {
		return new PilotAssetListParser().getResponse(getAuth()).getAll();
	}

	public Set<UpcomingCalendarEvent> getUpcomingCalendarEvents() throws ApiException {
		return new UpcomingCalendarEventsParser().getResponse(getAuth()).getAll();
	}

	public Set<CalendarEventAttendee> getCalendarEventAttendees(long... eventIds) throws ApiException {
		return new CalendarEventAttendeesParser().getResponse(getAuth(), eventIds).getAll();
	}

	public ContactList getContactList() throws ApiException {
		return new ContactListParser().getResponse(getAuth()).getContactList();
	}

	public Set<ContactNotification> getContactNotifications() throws ApiException {
		return new ContactNotificationsParser().getResponse(getAuth()).getAll();
	}

	public CallList getCallList() throws ApiException {
		return new CallListParser().getResponse().get();
	}
}