package com.beimin.eveapi.model.corporation;

public class CombatSetting {
    private boolean enabled;
    private int standing;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public int getStanding() {
        return standing;
    }

    public void setStanding(final int standing) {
        this.standing = standing;
    }
}
