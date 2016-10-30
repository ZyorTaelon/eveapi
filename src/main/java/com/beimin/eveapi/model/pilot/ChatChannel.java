package com.beimin.eveapi.model.pilot;

import java.util.ArrayList;
import java.util.List;

public class ChatChannel {
	private long channelID;
	private long ownerID;
	private String ownerName;
	private String displayName;
	private String comparisonKey;
	private boolean hasPassword;
	private String motd;
	private List<ChatChannelAccessor> allowedAccessors = new ArrayList<>();
	private List<ChatChannelAccessor> blockedAccessors = new ArrayList<>();
	private List<ChatChannelAccessor> mutedAccessors = new ArrayList<>();
	private List<ChatChannelAccessor> operatorAccessors = new ArrayList<>();

	public long getChannelID() {
		return channelID;
	}

	public void setChannelID(long channelID) {
		this.channelID = channelID;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getComparisonKey() {
		return comparisonKey;
	}

	public void setComparisonKey(String comparisonKey) {
		this.comparisonKey = comparisonKey;
	}

	public boolean isHasPassword() {
		return hasPassword;
	}

	public void setHasPassword(boolean hasPassword) {
		this.hasPassword = hasPassword;
	}

	public String getMotd() {
		return motd;
	}

	public void setMotd(String motd) {
		this.motd = motd;
	}

	public List<ChatChannelAccessor> getAllowedAccessors() {
		return allowedAccessors;
	}

	public void addAllowedAccessor(ChatChannelAccessor accessor) {
		allowedAccessors.add(accessor);
	}
	
	public List<ChatChannelAccessor> getBlockedAccessors() {
		return blockedAccessors;
	}

	
	public void addBlockedAccessor(ChatChannelAccessor accessor) {
		blockedAccessors.add(accessor);
	}
	
	public List<ChatChannelAccessor> getMutedAccessors() {
		return mutedAccessors;
	}

	public void addMutedAccessor(ChatChannelAccessor accessor) {
		mutedAccessors.add(accessor);
	}
	
	public List<ChatChannelAccessor> getOperatorAccessors() {
		return operatorAccessors;
	}

	public void addOperatorAccessor(ChatChannelAccessor accessor) {
		operatorAccessors.add(accessor);
	}
	
	@Override
	public String toString() {
		return "ChatChannel [channelID=" + channelID + ", ownerID=" + ownerID + ", ownerName=" + ownerName
				+ ", displayName=" + displayName + ", comparisonKey=" + comparisonKey + ", hasPassword=" + hasPassword
				+ ", motd=" + motd + ", allowedAccessors=" + allowedAccessors + ", blockedAccessors=" + blockedAccessors
				+ ", mutedAccessors=" + mutedAccessors + ", operatorAccessors=" + operatorAccessors + "]";
	}
}
