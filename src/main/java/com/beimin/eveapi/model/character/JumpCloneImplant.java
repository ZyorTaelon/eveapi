package com.beimin.eveapi.model.character;

public class JumpCloneImplant {
    private long jumpCloneID;
    private int typeID;
    private String typeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
