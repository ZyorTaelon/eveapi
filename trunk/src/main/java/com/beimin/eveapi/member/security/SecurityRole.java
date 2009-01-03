package com.beimin.eveapi.member.security;

public class SecurityRole {
	private int roleID;
	private String roleName;

	public SecurityRole() {
		// default constructor needed for Digester
	}

	public SecurityRole(int roleID, String roleName) {
		this.roleID = roleID;
		this.roleName = roleName;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}