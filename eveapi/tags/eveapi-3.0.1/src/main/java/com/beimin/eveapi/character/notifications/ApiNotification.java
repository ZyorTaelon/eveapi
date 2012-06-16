package com.beimin.eveapi.character.notifications;

import java.util.Date;

public class ApiNotification {
	private long notificationID;
	private int typeID;
	private long senderID;
	private Date sentDate;
	private boolean read;

	public enum NotificationType {
		CHARACTER_DELETED(2, "Character deleted"), //
		GIVE_MEDAL(3, "Give medal to character"), //
		ALLIANCE_MAINTENANCE_BILL(4, "Alliance maintenance bill"), //
		ALLIANCE_WAR_DECLARED(5, "Alliance war declared"), //
		ALLIANCE_WAR_SURRENDER(6, "Alliance war surrender"), //
		ALLIANCE_WAR_RETRACTED(7, "Alliance war retracted"), //
		ALLIANCE_WAR_INVALIDATED(8, "Alliance war invalidated by Concord"), //
		BILL_ISSUED_CHARACTER(9, "Bill issued to a character"), //
		BILL_ISSUED_CORPORATION_ALLIANCE(10, "Bill issued to corporation or alliance"), //
		BILL_NOT_PAID(11, "Bill not paid because there's not enough ISK available"), //
		BILL_BY_CHARACTER_PAID(12, "Bill, issued by a character, paid"), //
		BILL_BY_CORP_OR_ALLIANCE_PAID(13, "Bill, issued by a corporation or alliance, paid"), //
		BOUNTY_CLAIMED(14, "Bounty claimed"), //
		CLONE_ACTIVATED(15, "Clone activated"), //
		APPLICATION_REJECTED(17, "Corp application rejected"), //
		NEW_APPLICATION(16, "New corp member application"), //
		CORP_TAX_CHANGED(19, "Corp tax rate changed"), //
		APPLICATION_ACCEPTED(18, "Corp application accepted"), //
		PLAYER_LEAVES_CORP(21, "Player leaves corp"), //
		CORP_NEWS_REPORT(20, "Corp news report, typically for shareholders"), //
		CORP_DIVIDEND_LIQUIDATION(23, "Corp dividend/liquidation, sent to shareholders"), //
		CORP_NEW_CEO(22, "Corp news, new CEO"), //
		CORP_VOTE(25, "Corp vote created"), //
		CORP_DIVIDEND_PAYOUT(24, "Corp dividend payout, sent to shareholders"), //
		WAR_DECLARATION(27, "Corp declares war"), //
		CORP_CEO_VOTES_REVOKED(26, "Corp CEO votes revoked during voting"), //
		CORP_SURRENDERS_WAR(29, "Corp surrenders war"), //
		CORP_WAR_HAS_STARTED(28, "Corp war has started"), //
		CORP_WAR_INVALIDATED(31, "Corp war invalidated by Concord"), //
		CORP_RETRACTS_WAR(30, "Corp retracts war"), //
		FIRST_SHIP_INSURANCE(34, "First ship insurance"), //
		INSURANCE_PAYED(35, "Ship destroyed, insurance payed"), //
		CONTAINER_PASSWORD_RETRIEVAL(32, "Container password retrieval"), //
		POLICE_TROUBLE(33, "Contraband or low standings cause an attack or items being confiscated"), //
		SOVEREIGNTY_CLAIM_FAILS_CORPORATION(38, "Sovereignty claim fails (corporation)"), //
		SOVEREIGNTY_BILL_LATE_ALLIANCE(39, "Sovereignty bill late (alliance)"), //
		INSURANCE_CONTRACT_INVALIDATED(36, "Insurance contract invalidated/runs out"), //
		SOVEREIGNTY_CLAIM_FAILS_ALLIANCE(37, "Sovereignty claim fails (alliance)"), //
		SOVEREIGNTY_CLAIM_LOST_CORPORATION(42, "Sovereignty claim lost (corporation)"), //
		SOVEREIGNTY_CLAIM_AQUIRED_ALLIANCE(43, "Sovereignty claim aquired (alliance)"), //
		SOVEREIGNTY_BILL_LATE_CORPORATION(40, "Sovereignty bill late (corporation)"), //
		SOVEREIGNTY_CLAIM_LOST_ALLIANCE(41, "Sovereignty claim lost (alliance)"), //
		ALLIANCE_STRUCTURE_VULNERABLE(46, "Alliance structure turns vulnerable"), //
		ALLIANCE_STRUCTURE_INVULNERABLE(47, "Alliance structure turns invulnerable"), //
		SOVEREIGNTY_CLAIM_AQUIRED_CORPORATION(44, "Sovereignty claim aquired (corporation)"), //
		ALLIANCE_ANCHORING_ALERT(45, "Alliance anchoring alert"), //
		CLONE_CONTRACT_REVOKED1(51, "Clone contract revoked by station manager"), //
		CORP_OFFICE_EXPIRATION_NOTICE(50, "Corp office lease expiration notice"), //
		STRUCTURE_WON_LOST(49, "Structure won/lost"), //
		SOVEREIGNTY_DISRUPTOR_ANCHORED(48, "Sovereignty disruptor anchored"), //
		INSURANCE_CONTRACT_ISSUED(55, "Insurance contract issued"), //
		INSURANCE_CONTRACT_EXPIRED(54, "Insurance contract expired"), //
		CLONE_CONTRACT_REVOKED2(53, "Clone contract revoked by station manager"), //
		CORP_MEMBER_CLONES_MOVED(52, "Corp member clones moved between stations"), //
		CORPORATION_LEAVING_FACTIONAL_WARFARE(59, "Corporation leaving factional warfare"), //
		CORPORATION_JOINING_FACTIONAL_WARFARE(58, "Corporation joining factional warfare"), //
		JUMP_CLONE_DESTROYED1(57, "Jump clone destroyed"), //
		JUMP_CLONE_DESTROYED2(56, "Jump clone destroyed"), //
		CHARACTER_FACTIONAL_WARFARE_LOW_STANDINGS_WARNING(63,
				"Character in factional warfare warned on startup because of too low standing to the faction"), //
		CORPORATION_FACTIONAL_WARFARE_LOW_STANDINGS_WARNING(62,
				"Corporation in factional warfare warned on startup because of too low standing to the faction"), //
		CHARACTER_FROM_FACTIONAL_KICKED(61,
				"Character kicked from factional warfare on startup because of too low standing to the faction"), //
		CORPORATION_FROM_FACTIONAL_KICKED(60,
				"Corporation kicked from factional warfare on startup because of too low standing to the faction"), //
		REIMBURSEMENT_MESSAGE(68, "Reimbursement message"), //
		CHARACTER_LOCATED(69, "Agent locates a character"), //
		RESEARCH_MISSION_AVAILABLE(70, "Research mission becomes available from an agent"), //
		AGENT_MISSION_OFFER_EXPIRES(71, "Agent mission offer expires"), //
		FACTIONAL_WARFARE_RANK_LOSS(64, "Character loses factional warfare rank"), //
		FACTIONAL_WARFARE_RANK_GAIN(65, "Character gains factional warfare rank"), //
		AGENT_MOVED(66, "Agent has moved"), //
		MASS_TRANSACTION_REVERSAL(67, "Mass transaction reversal message"), //
		TOWER_RESOURCE_ALERT(76, "Tower resource alert"), //
		STATION_AGGRESSION1(77, "Station aggression message"), //
		STATION_STATE_CHANGE(78, "Station state change message"), //
		STATION_CONQUERED(79, "Station conquered message"), //
		MISSION_TIMEOUT(72, "Agent mission times out"), //
		STORYLINE_MISSION_OFFER(73, "Agent offers a storyline mission"), //
		TUTORIAL_MESSAGE(74, "Tutorial message sent on character creation"), //
		TOWER_ALERT(75, "Tower alert"), //
		FACTIONAL_WARFARE_LEAVE_WITHDRAWN(84, "Corporation withdrawing a request to leave factional warfare"), //
		FACTIONAL_WARFARE_JOIN(81, "Corporation requests joining factional warfare"), //
		STATION_AGGRESSION_MESSAGE2(80, "Station aggression message"), //
		FACTIONAL_WARFARE_JOIN_WITHDRAWN(83, "Corporation withdrawing a request to join factional warfare"), //
		FACTIONAL_WARFARE_LEAVE(82, "Corporation requests leaving factional warfare"), //
		UNKNOWN(0, "Unknown notification type");

		private final int id;
		private final String description;

		private NotificationType(int id, String description) {
			this.id = id;
			this.description = description;
		}

		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		public static NotificationType get(int typeID) {
			for (NotificationType notificationType : values()) {
				if (notificationType.getId() == typeID)
					return notificationType;
			}
			return UNKNOWN;
		}
	}

	public long getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(long notificationID) {
		this.notificationID = notificationID;
	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public NotificationType getType() {
		return NotificationType.get(typeID);
	}

	public long getSenderID() {
		return senderID;
	}

	public void setSenderID(long senderID) {
		this.senderID = senderID;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
}