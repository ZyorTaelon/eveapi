package com.beimin.eveapi.model.corporation;

import com.beimin.eveapi.model.character.Role;

public class CorporationRole extends Role {
    private String roleDescription;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((roleDescription == null) ? 0 : roleDescription.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CorporationRole other = (CorporationRole) obj;
        if (roleDescription == null) {
            if (other.roleDescription != null)
                return false;
        } else if (!roleDescription.equals(other.roleDescription))
            return false;
        return true;
    }
}
