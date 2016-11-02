package com.beimin.eveapi.model.shared;

public class KillVictim extends KillCharacter {
    private long damageTaken; // ="1415"
    private long shipTypeID; // ="587"
    private double positionX;
    private double positionY;
    private double positionZ;

    public long getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(final long damageTaken) {
        this.damageTaken = damageTaken;
    }

    public long getShipTypeID() {
        return shipTypeID;
    }

    public void setShipTypeID(final long shipTypeID) {
        this.shipTypeID = shipTypeID;
    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(final double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(final double positionY) {
        this.positionY = positionY;
    }

    public double getPositionZ() {
        return positionZ;
    }

    public void setPositionZ(final double positionZ) {
        this.positionZ = positionZ;
    }
}
