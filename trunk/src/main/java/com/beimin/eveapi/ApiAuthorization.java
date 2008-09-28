package com.beimin.eveapi;


public class ApiAuthorization extends ApiAuth {
	private final int userID;
	private final int characterID;
	private final String apiKey;

	public ApiAuthorization(int userID, int characterID, String apiKey) {
		this.userID = userID;
		this.characterID = characterID;
		this.apiKey = apiKey;
	}

	@Override
	public int getUserID() {
		return userID;
	}

	@Override
	public int getCharacterID() {
		return characterID;
	}

	@Override
	public String getApiKey() {
		return apiKey;
	}

}
