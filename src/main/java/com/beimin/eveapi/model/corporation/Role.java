package com.beimin.eveapi.model.corporation;

public class Role {
    private long roleID;
    private String roleName;
    private String roleDescription;

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(final long roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
