package com.beimin.eveapi.character.notifications;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ApiNotification {
	private static final Map<Integer, String> types = getNotificationTypes();
	private long notificationID;
	private int typeID;
	private long senderID;
	private Date sentDate;
	private boolean read;

	private static Map<Integer, String> getNotificationTypes() {
		HashMap<Integer, String> types = new HashMap<Integer, String>();
		types.put(2, "Character deleted");
		types.put(3, "Give medal to character");
		types.put(4, "Alliance maintenance bill");
		types.put(5, "Alliance war declared");
		types.put(6, "Alliance war surrender");
		types.put(7, "Alliance war retracted");
		types.put(8, "Alliance war invalidated by Concord");
		types.put(9, "Bill issued to a character");
		types.put(10, "Bill issued to corporation or alliance");
		types.put(11, "Bill not paid because there's not enough ISK available");
		types.put(12, "Bill, issued by a character, paid");
		types.put(13, "Bill, issued by a corporation or alliance, paid");
		types.put(14, "Bounty claimed");
		types.put(15, "Clone activated");
		types.put(16, "New corp member application");
		types.put(17, "Corp application rejected");
		types.put(18, "Corp application accepted");
		types.put(19, "Corp tax rate changed");
		types.put(20, "Corp news report, typically for shareholders");
		types.put(21, "Player leaves corp");
		types.put(22, "Corp news, new CEO");
		types.put(23, "Corp dividend/liquidation, sent to shareholders");
		types.put(24, "Corp dividend payout, sent to shareholders");
		types.put(25, "Corp vote created");
		types.put(26, "Corp CEO votes revoked during voting");
		types.put(27, "Corp declares war");
		types.put(28, "Corp war has started");
		types.put(29, "Corp surrenders war");
		types.put(30, "Corp retracts war");
		types.put(31, "Corp war invalidated by Concord");
		types.put(32, "Container password retrieval");
		types.put(33, "Contraband or low standings cause an attack or items being confiscated");
		types.put(34, "First ship insurance");
		types.put(35, "Ship destroyed, insurance payed");
		types.put(36, "Insurance contract invalidated/runs out");
		types.put(37, "Sovereignty claim fails (alliance)");
		types.put(38, "Sovereignty claim fails (corporation)");
		types.put(39, "Sovereignty bill late (alliance)");
		types.put(40, "Sovereignty bill late (corporation)");
		types.put(41, "Sovereignty claim lost (alliance)");
		types.put(42, "Sovereignty claim lost (corporation)");
		types.put(43, "Sovereignty claim aquired (alliance)");
		types.put(44, "Sovereignty claim aquired (corporation)");
		types.put(45, "Alliance anchoring alert");
		types.put(46, "Alliance structure turns vulnerable");
		types.put(47, "Alliance structure turns invulnerable");
		types.put(48, "Sovereignty disruptor anchored");
		types.put(49, "Structure won/lost");
		types.put(50, "Corp office lease expiration notice");
		types.put(51, "Clone contract revoked by station manager");
		types.put(52, "Corp member clones moved between stations");
		types.put(53, "Clone contract revoked by station manager");
		types.put(54, "Insurance contract expired");
		types.put(55, "Insurance contract issued");
		types.put(56, "Jump clone destroyed");
		types.put(57, "Jump clone destroyed");
		types.put(58, "Corporation joining factional warfare");
		types.put(59, "Corporation leaving factional warfare");
		types.put(60, "Corporation kicked from factional warfare on startup because of too low standing to the faction");
		types.put(61, "Character kicked from factional warfare on startup because of too low standing to the faction");
		types.put(62, "Corporation in factional warfare warned on startup because of too low standing to the faction");
		types.put(63, "Character in factional warfare warned on startup because of too low standing to the faction");
		types.put(64, "Character loses factional warfare rank");
		types.put(65, "Character gains factional warfare rank");
		types.put(66, "Agent has moved");
		types.put(67, "Mass transaction reversal message");
		types.put(68, "Reimbursement message");
		types.put(69, "Agent locates a character");
		types.put(70, "Research mission becomes available from an agent");
		types.put(71, "Agent mission offer expires");
		types.put(72, "Agent mission times out");
		types.put(73, "Agent offers a storyline mission");
		types.put(74, "Tutorial message sent on character creation");
		types.put(75, "Tower alert");
		types.put(76, "Tower resource alert");
		types.put(77, "Station aggression message");
		types.put(78, "Station state change message");
		types.put(79, "Station conquered message");
		types.put(80, "Station aggression message");
		types.put(81, "Corporation requests joining factional warfare");
		types.put(82, "Corporation requests leaving factional warfare");
		types.put(83, "Corporation withdrawing a request to join factional warfare");
		types.put(84, "Corporation withdrawing a request to leave factional warfare");
		return types;
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

	public String getType() {
		return types.get(typeID);
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