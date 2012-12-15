package com.beimin.eveapi.core;

public class ApiAuthorization extends ApiAuth<ApiAuthorization> {
	private final int keyID;
	private Long characterID;
	private final String vCode;

	public ApiAuthorization(int keyID, long characterID, String vCode) {
		this.keyID = keyID;
		this.vCode = vCode;
		this.characterID = characterID;
	}

	public ApiAuthorization(int keyID, String vCode) {
		this.keyID = keyID;
		this.vCode = vCode;
		this.characterID = null;
	}

	@Override
	public int getKeyID() {
		return keyID;
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
	public String getVCode() {
		return vCode;
	}

	@Override
	public int hashCode() {
		return new StringBuilder(keyID).append(characterID).append(vCode).toString().hashCode();
	}

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
		result.append("keyID: ").append(keyID).append(", characterID: ").append(characterID);
		return result.toString();
	}
}