package com.beimin.eveapi.model.pilot;


public class JumpClone {
    private long jumpCloneID;
    private int typeID;
    private long locationID;
    private String cloneName;

    public long getJumpCloneID() {
        return jumpCloneID;
    }

    public void setJumpCloneID(long jumpCloneID) {
        this.jumpCloneID = jumpCloneID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }
}
