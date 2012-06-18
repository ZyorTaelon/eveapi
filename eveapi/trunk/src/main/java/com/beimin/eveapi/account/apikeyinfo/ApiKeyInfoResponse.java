package com.beimin.eveapi.account.apikeyinfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.beimin.eveapi.account.characters.EveCharacter;
import com.beimin.eveapi.core.ApiResponse;
import com.beimin.eveapi.shared.KeyType;

public class ApiKeyInfoResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	public enum AccessMask{
		ACCOUNT_BALANCE(1),
		ASSET_LIST(2),
		CALENDAR_EVENT_ATTENDEES(4),
		CHARACTER_SHEET(8),
		CONTACT_LIST(16),
		CONTACT_NOTIFICATIONS(32),
		FAC_WAR_STATS(64),
		INDUSTRY_JOBS(128),
		KILL_LOG(256),
		MAIL_BODIES(512),
		MAILING_LISTS(1024),
		MAIL_MESSAGES(2048),
		MARKET_ORDERS(4096),
		MEDALS(8192),
		NOTIFICATIONS(16384),
		NOTIFICATION_TEXTS(32768),
		RESEARCH(65536),
		SKILL_IN_TRAINING(131072),
		SKILL_QUEUE(262144),
		STANDINGS(524288),
		UPCOMING_CALENDAR_EVENTS(1048576),
		WALLET_JOURNAL(2097152),
		WALLET_TRANSACTIONS(4194304),
		CHARACTER_INFO_PRIVATE(8388608),
		CHARACTER_INFO_PUBLIC(16777216),
		ACCOUNT_STATUS(33554432),
		CONTRACTS(67108864);
		private final int accessMask;

		private AccessMask(int accessMask) {
			this.accessMask = accessMask;
		}

		public int getAccessMask() {
			return accessMask;
		}
	}


	private long accessMask;
	private KeyType type;
	private Date expires;
	private final Collection<EveCharacter> eveCharacters = new ArrayList<EveCharacter>();

	public void addEveCharacter(EveCharacter eveCharacter) {
		eveCharacters.add(eveCharacter);
	}

	public Collection<EveCharacter> getEveCharacters() {
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