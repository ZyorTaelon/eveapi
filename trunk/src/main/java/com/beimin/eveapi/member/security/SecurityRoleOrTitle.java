package com.beimin.eveapi.member.security;

public class SecurityRoleOrTitle {
	private int roleID;
	private String roleName;
	private int titleID;
	private String titleName;

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
		this.roleName = roleName.trim();
	}

	public int getTitleID() {
		return titleID;
	}

	public void setTitleID(int titleID) {
		this.titleID = titleID;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName.trim();
	}

	public SecurityRole getRole() {
		return new SecurityRole(roleID, roleName);
	}

	public SecurityTitle getTitle() {
		return new SecurityTitle(titleID, titleName);
	}
}