package com.beimin.eveapi.model.shared;

public enum RefType {
	UNDEFINED(0, "Undefined", "", ""), //
	PLAYER_TRADING(1, "Player Trading", "Station name", "Station ID "), //
	MARKET_TRANSACTION(2, "Market Transaction", "transactionID", ""), //
	GM_CASH_TRANSFER(3, "GM Cash Transfer", "", ""), //
	ATM_WITHDRAW(4, "ATM Withdraw", "", ""), //
	ATM_DEPOSIT(5, "ATM Deposit", "", ""), //
	BACKWARD_COMPATIBLE(6, "Backward Compatible", "", ""), //
	MISSION_REWARD(7, "Mission Reward", "", ""), //
	CLONE_ACTIVATION(8, "Clone Activation", "", ""), //
	INHERITANCE(9, "Inheritance", "", ""), //
	PLAYER_DONATION(10, "Player Donation", "", ""), //
	CORPORATION_PAYMENT(11, "Corporation Payment", "", ""), //
	DOCKING_FEE(12, "Docking Fee", "", ""), //
	OFFICE_RENTAL_FEE(13, "Office Rental Fee", "", ""), //
	FACTORY_SLOT_RENTAL_FEE(14, "Factory Slot Rental Fee", "", ""), //
	REPAIR_BILL(15, "Repair Bill", "", ""), //
	BOUNTY(16, "Bounty", "", ""), //
	BOUNTY_PRIZE(17, "Bounty Prize", "NPC Name", "NPC ID "), //
	AGENTS_TEMPORARY(18, "Agents_temporary", "", ""), //
	INSURANCE(19, "Insurance", "Destroyed ship's typeID", ""), //
	MISSION_EXPIRATION(20, "Mission Expiration", "", ""), //
	MISSION_COMPLETION(21, "Mission Completion", "", ""), //
	SHARES(22, "Shares", "", ""), //
	COURIER_MISSION_ESCROW(23, "Courier Mission Escrow", "", ""), //
	MISSION_COST(24, "Mission Cost", "", ""), //
	AGENT_MISCELLANEOUS(25, "Agent Miscellaneous", "", ""), //
	LP_STORE(26, "LP Store", "", ""), //
	AGENT_LOCATION_SERVICES(27, "Agent Location Services", "", ""), //
	AGENT_DONATION(28, "Agent Donation", "", ""), //
	AGENT_SECURITY_SERVICES(29, "Agent Security Services", "", ""), //
	AGENT_MISSION_COLLATERAL_PAID(30, "Agent Mission Collateral Paid", "", ""), //
	AGENT_MISSION_COLLATERAL_REFUNDED(31, "Agent Mission Collateral Refunded", "", ""), //
	AGENTS_PREWARD(32, "Agents_preward", "", ""), //
	AGENT_MISSION_REWARD(33, "Agent Mission Reward", "", ""), //
	AGENT_MISSION_TIME_BONUS_REWARD(34, "Agent Mission Time Bonus Reward", "", ""), //
	CSPA(35, "CSPA", "Player name", "Player characterID"), //
	CSPAOFFLINEREFUND(36, "CSPAOfflineRefund", "", ""), //
	CORPORATION_ACCOUNT_WITHDRAWAL(37, "Corporation Account Withdrawal", "", ""), //
	CORPORATION_DIVIDEND_PAYMENT(38, "Corporation Dividend Payment", "", ""), //
	CORPORATION_REGISTRATION_FEE(39, "Corporation Registration Fee", "", ""), //
	CORPORATION_LOGO_CHANGE_COST(40, "Corporation Logo Change Cost", "", ""), //
	RELEASE_OF_IMPOUNDED_PROPERTY(41, "Release Of Impounded Property", "", ""), //
	MARKET_ESCROW(42, "Market Escrow", "", ""), //
	AGENT_SERVICES_RENDERED(43, "Agent Services Rendered", "", ""), //
	MARKET_FINE_PAID(44, "Market Fine Paid", "", ""), //
	CORPORATION_LIQUIDATION(45, "Corporation Liquidation", "", ""), //
	BROKERS_FEE(46, "Brokers Fee", "", ""), //
	CORPORATION_BULK_PAYMENT(47, "Corporation Bulk Payment", "", ""), //
	ALLIANCE_REGISTRATION_FEE(48, "Alliance Registration Fee", "", ""), //
	WAR_FEE(49, "War Fee", "", ""), //
	ALLIANCE_MAINTAINANCE_FEE(50, "Alliance Maintainance Fee", "", ""), //
	CONTRABAND_FINE(51, "Contraband Fine", "", ""), //
	CLONE_TRANSFER(52, "Clone Transfer", "", ""), //
	ACCELERATION_GATE_FEE(53, "Acceleration Gate Fee", "", ""), //
	TRANSACTION_TAX(54, "Transaction Tax", "", ""), //
	JUMP_CLONE_INSTALLATION_FEE(55, "Jump Clone Installation Fee", "", ""), //
	MANUFACTURING(56, "Manufacturing", "Job ID", ""), //
	RESEARCHING_TECHNOLOGY(57, "Researching Technology", "", ""), //
	RESEARCHING_TIME_PRODUCTIVITY(58, "Researching Time Productivity", "", ""), //
	RESEARCHING_MATERIAL_PRODUCTIVITY(59, "Researching Material Productivity", "", ""), //
	COPYING(60, "Copying", "", ""), //
	DUPLICATING(61, "Duplicating", "", ""), //
	REVERSE_ENGINEERING(62, "Reverse Engineering", "", ""), //
	CONTRACT_AUCTION_BID(63, "Contract Auction Bid", "Contract ID", ""), //
	CONTRACT_AUCTION_BID_REFUND(64, "Contract Auction Bid Refund", "Contract ID", ""), //
	CONTRACT_COLLATERAL(65, "Contract Collateral", "Contract ID", ""), //
	CONTRACT_REWARD_REFUND(66, "Contract Reward Refund", "Contract ID", ""), //
	CONTRACT_AUCTION_SOLD(67, "Contract Auction Sold", "Contract ID", ""), //
	CONTRACT_REWARD(68, "Contract Reward", "Contract ID", ""), //
	CONTRACT_COLLATERAL_REFUND(69, "Contract Collateral Refund", "Contract ID", ""), //
	CONTRACT_COLLATERAL_PAYOUT(70, "Contract Collateral Payout", "Contract ID", ""), //
	CONTRACT_PRICE(71, "Contract Price", "Contract ID", ""), //
	CONTRACT_BROKERS_FEE(72, "Contract Brokers Fee", "Contract ID", ""), //
	CONTRACT_SALES_TAX(73, "Contract Sales Tax", "Contract ID", ""), //
	CONTRACT_DEPOSIT(74, "Contract Deposit", "Contract ID", ""), //
	CONTRACT_DEPOSIT_SALES_TAX(75, "Contract Deposit Sales Tax", "Contract ID", ""), //
	SECURE_EVE_TIME_CODE_EXCHANGE(76, "Secure EVE Time Code Exchange", "", ""), //
	CONTRACT_AUCTION_BID__CORP_(77, "Contract Auction Bid (corp)", "", ""), //
	CONTRACT_COLLATERAL_DEPOSITED__CORP_(78, "Contract Collateral Deposited (corp)", "", ""), //
	CONTRACT_PRICE_PAYMENT__CORP_(79, "Contract Price Payment (corp)", "", ""), //
	CONTRACT_BROKERS_FEE__CORP_(80, "Contract Brokers Fee (corp)", "", ""), //
	CONTRACT_DEPOSIT__CORP_(81, "Contract Deposit (corp)", "", ""), //
	CONTRACT_DEPOSIT_REFUND(82, "Contract Deposit Refund", "", ""), //
	CONTRACT_REWARD_DEPOSITED(83, "Contract Reward Deposited", "", ""), //
	CONTRACT_REWARD_DEPOSITED__CORP_(84, "Contract Reward Deposited (corp)", "", ""), //
	BOUNTY_PRIZES(85, "Bounty Prizes", "", "solarSystemID"), //
	ADVERTISEMENT_LISTING_FEE(86, "Advertisement Listing Fee", "", ""), //
	MEDAL_CREATION(87, "Medal Creation", "", ""), //
	MEDAL_ISSUED(88, "Medal Issued", "", ""), //
	BETTING(89, "Betting", "", ""), //
	DNA_MODIFICATION_FEE(90, "DNA Modification Fee", "", ""), //
	SOVEREIGNITY_BILL(91, "Sovereignty bill", "", ""), //
	BOUNTY_PRIZE_CORPORATION_TAX(92, "Bounty Prize Corporation Tax", "", ""), //
	AGENT_MISSION_REWARD_CORPORATION_TAX(93, "Agent Mission Reward Corporation Tax", "", ""), //
	AGENT_MISSION_TIME_BONUS_REWARD_CORPORATION_TAX(94, "Agent Mission Time Bonus Reward Corporation Tax", "", ""), //
	UPKEEP_ADJUSTMENT_FEE(95, "Upkeep adjustment fee", "", ""), //
	PLANETARY_IMPORT_TAX(96, "Planetary Import Tax", "", ""), //
	PLANETARY_EXPORT_TAX(97, "Planetary Export Tax", "", ""), //
	PLANETARY_CONSTRUCTION(98, "Planetary Construction", "", ""), //
	CORPORATE_REWARD_PAYOUT(99, "Corporate Reward Payout", "", ""), //
	MINIGAME_BETTING(100, "Minigame Betting", "", ""), //
	BOUNTY_SURCHARGE(101, "Bounty Surcharge", "", ""), //
	CONTRACT_REVERSAL(102, "Contract Reversal", "", ""), //
	CORPORATE_REWARD_TAX(103, "Corporate Reward Tax", "", ""), //

	STORE_PURCHASE(106, "Store Purchase", "", ""), //
	STORE_PURCHASE_REFUND(107, "Store Purchase Refund", "", ""), //
	PLEX_SOLD_FOR_AURUM(108, "PLEX sold for Aurum", "", ""), //
	LOTTERY_GIVE_AWAY(109, "Lottery Give Away", "", ""), //

	AURUM_TOKEN_EXCHANGED_FOR_AUR(111, "Aurum Token exchanged for Aur", "", ""), //
	DATACORE_FEE(112, "Datacore Fee", "", ""), //
	WAR_SURRENDER_FEE(113, "War Surrender Fee", "", ""), //
	WAR_ALLY_CONTRACT(114, "War Ally Contract", "", ""), //
	BOUNTY_REIMBURSEMENT(115, "Bounty Reimbursement", "", ""), //
	KILL_RIGHT(116, "Kill Right", "", ""), //
	FEE_FOR_PROCESSING_ONE_OR_MORE_SECURITY_TAGS(117, "Fee for processing one or more security tags", "", ""), //
	
	MODIFY_ISK(10001, "Modify ISK", "", ""), //
	PRIMARY_MARKETPLACE_PURCHASE(10002, "Primary Marketplace Purchase", "", ""), //
	BATTLE_REWARD(10003, "Battle Reward", "", ""), //
	NEW_CHARACTER_STARTING_FUNDS(10004, "New Character Starting Funds", "", ""), //
	CORPORATION_ACCOUNT_WITHDRAWAL_2(10005, "Corporation Account Withdrawal", "", ""), //
	CORPORATION_ACCOUNT_DEPOSIT(10006, "Corporation Account Deposit", "", ""), //
	BATTLE_WP_WIN_REWARD(10007, "Battle WP Win Reward", "", ""), //
	BATTLE_WP_LOSS_REWARD(10008, "Battle WP Loss Reward", "", ""), //
	BATTLE_WIN_REWARD(10009, "Battle Win Reward", "", ""), //
	BATTLE_LOSS_REWARD(10010, "Battle Loss Reward", "", ""), //
	UNKNOWN(10011, "Unknown", "", ""), //
	DISTRICT_CONTRACT_DEPOSIT(10012, "District Contract Deposit", "", ""), //
	DISTRICT_CONTRACT_DEPOSIT_REFUND(10013, "District Contract Deposit Refund", "", ""), //
	DISTRICT_CONTRACT_COLLATERAL(10014, "District Contract Collateral", "", ""), //
	DISTRICT_CONTRACT_COLLATERAL_REFUND(10015, "District Contract Collateral Refund", "", ""), //
	DISTRICT_CONTRACT_REWARD(10016, "District Contract Reward", "", ""), //
	DISTRICT_CLONE_TRANSPORTATION(10017, "District Clone Transportation", "", ""), //
	DISTRICT_CLONE_TRANSPORTATION_REFUND(10018, "District Clone Transportation Refund", "", ""), //
	DISTRICT_INFRASTRUCTURE(10019, "District Infrastructure", "", ""), //
	DISTRICT_CLONE_SALES(10020, "District Clone Sales", "", ""), //
	DISTRICT_CLONE_PURCHASE(10021, "District Clone Purchase", "", ""), //
	BIOMASS_REWARD(10022, "Biomass Reward", "", ""), //

	MODIFY_UPLEX(11001, "Modify AUR", "", ""),
	RESPEC_PAYMENT(11002, "Respec payment", "", ""), //
	UNKNOWN_1(11003, "Unknown", "", ""), //
	UNKNOWN_2(11004, "Unknown", "", ""), //
	UNKNOWN_3(11005, "Unknown", "", ""), //
	;
	private int id;
	private String name;
	private String argName;
	private String argID;

	private RefType(int id, String name, String argName, String argID) {
		this.id = id;
		this.name = name;
		this.argName = argName;
		this.argID = argID;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getArgName() {
		return argName;
	}

	public String getArgID() {
		return argID;
	}

	public static RefType forID(int refTypeID) {
		for (RefType refType : values()) {
			if (refType.getId() == refTypeID)
				return refType;
		}
		return null;
	}
}