package com.beimin.eveapi.model.character;

public class Role {
    private long roleID;
    private String roleName;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.roleID ^ (this.roleID >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        if (this.roleID != other.roleID) {
            return false;
        }
        return true;
    }
}
