package com.beimin.eveapi.corporation.member.security.log;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.corporation.member.security.ApiSecurityRole;

public class ApiRoleHistory {
	private Date changeTime;
	private long characterID;
	private String characterName;
	private long issuerID;
	private String issuerName;
	private String roleLocationType;
	private final Set<ApiSecurityRole> oldRoles = new HashSet<ApiSecurityRole>();
	private final Set<ApiSecurityRole> newRoles = new HashSet<ApiSecurityRole>();

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public long getCharacterID() {
		return characterID;
	}

	public void setCharacterID(long characterID) {
		this.characterID = characterID;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public long getIssuerID() {
		return issuerID;
	}

	public void setIssuerID(long issuerID) {
		this.issuerID = issuerID;
	}

	public String getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}

	public String getRoleLocationType() {
		return roleLocationType;
	}

	public void setRoleLocationType(String roleLocationType) {
		this.roleLocationType = roleLocationType;
	}

	public void addSecurityRoleBag(SecurityRoleBag securityRoleBag) {
		String name = securityRoleBag.getName();
		if (name.equals("oldRoles")) {
			oldRoles.addAll(securityRoleBag.getSecurityRoles());
		} else if (name.equals("newRoles")) {
			newRoles.addAll(securityRoleBag.getSecurityRoles());
		}
	}

	public Set<ApiSecurityRole> getOldRoles() {
		return oldRoles;
	}

	public Set<ApiSecurityRole> getNewRoles() {
		return newRoles;
	}
}