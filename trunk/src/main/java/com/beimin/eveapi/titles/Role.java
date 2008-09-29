package com.beimin.eveapi.titles;

public class Role {
	private int roleID; // ="8192"
	private String roleName; // ="roleHangarCanTake1"
	private String roleDescription;

	// ="Can take items from this divisions hangar"
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

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
}