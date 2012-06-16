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

	public ApiSecurityRole getRole() {
		return new ApiSecurityRole(roleID, roleName);
	}

	public ApiSecurityTitle getTitle() {
		return new ApiSecurityTitle(titleID, titleName);
	}
}