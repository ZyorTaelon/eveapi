package com.beimin.eveapi.parser;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class ApiAuth implements Serializable {
    private static final long serialVersionUID = 7360740132434924989L;

    public abstract int getKeyID();

    public abstract Long getCharacterID();

    public abstract void setCharacterID(long characterID);

    public abstract String getVCode();

    public Map<String, String> getParams() {
        Map<String, String> result = new HashMap<String, String>();
        result.put("keyID", Integer.toString(getKeyID()));
        if (getCharacterID() != null)
            result.put("characterID", Long.toString(getCharacterID()));
        result.put("vCode", getVCode());
        return result;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCharacterID() == null) ? 0 : getCharacterID().hashCode());
        result = prime * result + getKeyID();
        result = prime * result + ((getVCode() == null) ? 0 : getVCode().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ApiAuthorization other = (ApiAuthorization) obj;
        if (getCharacterID() == null) {
            if (other.getCharacterID() != null)
                return false;
        } else if (!getCharacterID().equals(other.getCharacterID()))
            return false;
        if (getKeyID() != other.getKeyID())
            return false;
        if (getVCode() == null) {
            if (other.getVCode() != null)
                return false;
        } else if (!getVCode().equals(other.getVCode()))
            return false;
        return true;
    }
}