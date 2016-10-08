package com.beimin.eveapi.model.calllist;

import com.beimin.eveapi.model.shared.KeyType;

public class Call {
    private long accessMask;
    private KeyType type;
    private String name;
    private int groupID;
    private String description;

    public long getAccessMask() {
        return accessMask;
    }

    public void setAccessMask(final long accessMask) {
        this.accessMask = accessMask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(final int groupID) {
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public KeyType getType() {
        return type;
    }

    public void setType(final KeyType type) {
        this.type = type;
    }
}
