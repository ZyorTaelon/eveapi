package com.beimin.eveapi.model.corporation;

import com.beimin.eveapi.model.pilot.Role;

public class CorporationRole extends Role {
    private String roleDescription;

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
