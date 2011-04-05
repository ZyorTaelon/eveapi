package com.beimin.eveapi.corporation.member.security;

public class SecurityRoleOrTitle {
	private long roleID;
	private String roleName;
	private long titleID;
	private String titleName;

	public long getRoleID() {
		return roleID;
	}

	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName.trim();
	}

	public long getTitleID() {
		return titleID;
	}

	public void setTitleID(long titleID) {
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