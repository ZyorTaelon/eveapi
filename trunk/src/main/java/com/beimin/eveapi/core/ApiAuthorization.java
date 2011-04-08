package com.beimin.eveapi.core;

public class ApiAuthorization extends ApiAuth<ApiAuthorization> {
	private final int userID;
	private Long characterID;
	private final String apiKey;

	public ApiAuthorization(int userID, String apiKey) {
		this.userID = userID;
		this.apiKey = apiKey;
		this.characterID = null;
	}

	public ApiAuthorization(int userID, long characterID, String apiKey) {
		this.userID = userID;
		this.characterID = characterID;
		this.apiKey = apiKey;
	}

	@Override
	public int getUserID() {
		return userID;
	}

	@Override
	public Long getCharacterID() {
		return characterID;
	}

	@Override
	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}
	@Override
	public String getApiKey() {
		return apiKey;
	}

	@Override
	public int hashCode() {
		return new StringBuilder(userID).append(characterID).append(apiKey).toString().hashCode();
	}

	@Override
	public int compareTo(ApiAuthorization o) {
		return o.hashCode() - hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ApiAuthorization)
			return compareTo((ApiAuthorization) obj) == 0;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("userID: ").append(userID).append(", characterID: ").append(characterID);
		return result.toString();
	}
}