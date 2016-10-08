package com.beimin.eveapi.model.shared;

public class KillAttacker extends KillPilot {
    private double securityStatus; // ="-3.72675620703378"
    private int damageDone; // ="1415"
    private boolean finalBlow; // ="1"
    private int weaponTypeID; // ="2897"
    private int shipTypeID; // ="11999"

    public double getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(final double securityStatus) {
        this.securityStatus = securityStatus;
    }

    public int getDamageDone() {
        return damageDone;
    }

    public void setDamageDone(final int damageDone) {
        this.damageDone = damageDone;
    }

    public boolean isFinalBlow() {
        return finalBlow;
    }

    public void setFinalBlow(final boolean finalBlow) {
        this.finalBlow = finalBlow;
    }

    public int getWeaponTypeID() {
        return weaponTypeID;
    }

    public void setWeaponTypeID(final int weaponTypeID) {
        this.weaponTypeID = weaponTypeID;
    }

    public int getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(final int shipTypeID) {
        this.shipTypeID = shipTypeID;
    }
}
