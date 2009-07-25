package com.beimin.eveapi.member.security;

public class ApiSecurityRole {
	private int roleID;
	private String roleName;

	public ApiSecurityRole() {
		// default constructor needed for Digester
	}

	public ApiSecurityRole(int roleID, String roleName) {
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