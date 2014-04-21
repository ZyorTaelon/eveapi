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

	public void addEveCharacter(Character eveCharacter) {
		eveCharacters.add(eveCharacter);
	}

	public Collection<Character> getEveCharacters() {
		return eveCharacters;
	}

	public long getAccessMask() {
		return accessMask;
	}

	public void setAccessMask(long accessMask) {
		this.accessMask = accessMask;
	}

	public Date getExpires() {
		return expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	public KeyType getType() {
		return type;
	}

	public void setType(KeyType type) {
		this.type = type;
	}

	public boolean isCorporationKey() {
		return getType() == KeyType.Corporation;
	}

	public boolean isAccountKey() {
		return getType() == KeyType.Account;
	}

	public boolean isCharacterKey() {
		return getType() == KeyType.Character;
	}
}