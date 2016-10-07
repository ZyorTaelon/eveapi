package com.beimin.eveapi.parser;

public class ApiAuthorization extends ApiAuth {
    private static final long serialVersionUID = 1369641401371970736L;

    private final int keyID;
    private Long characterID;
    private final String vCode;

    public ApiAuthorization(final int keyID, final long characterID, final String vCode) {
        this.keyID = keyID;
        this.vCode = vCode;
        this.characterID = characterID;
    }

    public ApiAuthorization(final int keyID, final String vCode) {
        this.keyID = keyID;
        this.vCode = vCode;
        characterID = null;
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
    public void setCharacterID(final long characterID) {
        this.characterID = characterID;
    }

    @Override
    public String getVCode() {
        return vCode;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("keyID: ").append(keyID).append(", characterID: ").append(characterID).toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = (prime * result) + ((characterID == null) ? 0 : characterID.hashCode());
        result = (prime * result) + keyID;
        result = (prime * result) + ((vCode == null) ? 0 : vCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ApiAuthorization other = (ApiAuthorization) obj;
        if (characterID == null) {
            if (other.characterID != null) {
                return false;
            }
        } else if (!characterID.equals(other.characterID)) {
            return false;
        }
        if (keyID != other.keyID) {
            return false;
        }
        if (vCode == null) {
            if (other.vCode != null) {
                return false;
            }
        } else if (!vCode.equals(other.vCode)) {
            return false;
        }
        return true;
    }
}
