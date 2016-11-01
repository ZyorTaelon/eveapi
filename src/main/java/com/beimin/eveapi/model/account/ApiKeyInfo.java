package com.beimin.eveapi.model.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.beimin.eveapi.model.shared.KeyType;

public class ApiKeyInfo {
    private long accessMask;
    private KeyType type;
    private Date expires;
    private final Collection<Character> eveCharacters = new ArrayList<Character>();

    public void addEveCharacter(final Character eveCharacter) {
        eveCharacters.add(eveCharacter);
    }

    public Collection<Character> getEveCharacters() {
        return eveCharacters;
    }

    public long getAccessMask() {
        return accessMask;
    }

    public void setAccessMask(final long accessMask) {
        this.accessMask = accessMask;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(final Date expires) {
        this.expires = expires;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(final KeyType type) {
        this.type = type;
    }

    public boolean isCorporationKey() {
        return getType() == KeyType.CORPORATION;
    }

    public boolean isAccountKey() {
        return getType() == KeyType.ACCOUNT;
    }

    public boolean isCharacterKey() {
        return getType() == KeyType.CHARACTER;
    }
}
