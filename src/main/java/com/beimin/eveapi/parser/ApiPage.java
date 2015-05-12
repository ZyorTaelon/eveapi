package com.beimin.eveapi.parser;

public enum ApiPage {
	ACCOUNT_STATUS("AccountStatus"), //
	CHARACTERS("Characters"), //
	ACCOUNT_BALANCE("AccountBalance"), //
	ASSET_LIST("AssetList"), //
	CALENDAR_EVENT_ATTENDEES("/CalendarEventAttendees"), //
	UPCOMING_CALENDAR_EVENTS("UpcomingCalendarEvents"), //
	CONTACT_LIST("ContactList"), //
	CONTACT_NOTIFICATIONS("ContactNotifications"), //
	CONTRACTS("Contracts"), //
	CONTRACT_BIDS("ContractBids"), //
	CONTRACT_ITEMS("ContractItems"), //
	FACT_WAR_STATS("FacWarStats"), //
	INDUSTRY_JOBS("IndustryJobs"), //
	KILL_LOG("KillLog"), //
	LOCATIONS("Locations"), //
	MAIL_BODIES("MailBodies"), //
	MAILING_LISTS("MailingLists"), //
	MAIL_MESSAGES("MailMessages"), //
	MARKET_ORDERS("MarketOrders"), //
	MEDALS("Medals"), //
	NOTIFICATIONS("Notifications"), //
	NOTIFICATION_TEXTS("NotificationTexts"), //
	RESEARCH("Research"), //
	CHARACTER_SHEET("CharacterSheet"), //
	SKILL_IN_TRAINING("SkillInTraining"), //
	SKILL_QUEUE("SkillQueue"), //
	STANDINGS("Standings"), //
	WALLET_JOURNAL("WalletJournal"), //
	WALLET_TRANSACTIONS("WalletTransactions"), //
	CONTAINER_LOG("ContainerLog"), //
	MEMBER_MEDALS("MemberMedals"), //
	MEMBER_SECURITY_LOG("MemberSecurityLog"), //
	MEMBER_SECURITY("MemberSecurity"), //
	MEMBER_TRACKING("MemberTracking"), //
	SHAREHOLDERS("Shareholders"), //
	CORPORATION_SHEET("CorporationSheet"), //
	STARBASE_DETAIL("StarbaseDetail"), //
	STARBASE_LIST("StarbaseList"), //
	TITLES("Titles"), //
	ALLIANCE_LIST("AllianceList"), //
	CERTIFICATE_TREE("CertificateTree"), //
	CHARACTER_ID("CharacterID"), //
	CHARACTER_NAME("CharacterName"), //
	TYPE_NAME("TypeName"), //
	CONQUERABLE_STATION_LIST("ConquerableStationList"), //
	ERROR_LIST("ErrorList"), //
	FACT_WAR_TOP_STATS("FacWarTopStats"), //
	REF_TYPES("RefTypes"), //
	SKILL_TREE("SkillTree"), //
	FACTION_WAR_SYSTEMS("FacWarSystems"), //
	JUMPS("Jumps"), //
	KILLS("Kills"), //
	SOVEREIGNTY("Sovereignty"), //
	SERVER_STATUS("ServerStatus"), //
	CHARACTER_INFO("CharacterInfo"), //
	CHARACTER_AFFILIATION("CharacterAffiliation"), //
	OUTPOST_LIST("OutpostList"), //
	OUTPOST_SERVICE_DETAIL("OutpostServiceDetail"),
	CALL_LIST("CallList"),
	API_KEY_INFO("APIKeyInfo"),
	;

	private final String url;

	private ApiPage(String url) {
		this.url = url;
	}

	public String getPage() {
		return url;
	}
}