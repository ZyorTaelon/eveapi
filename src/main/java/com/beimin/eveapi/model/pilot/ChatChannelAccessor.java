package com.beimin.eveapi.model.pilot;

public class ChatChannelAccessor {
    private long accessorID;
    private String accessorName;

    public long getAccessorID() {
        return accessorID;
    }

    public void setAccessorID(long accessorID) {
        this.accessorID = accessorID;
    }

    public String getAccessorName() {
        return accessorName;
    }

    public void setAccessorName(String accessorName) {
        this.accessorName = accessorName;
    }

    @Override
    public String toString() {
        return "ChatChannelAccessor [accessorID=" + accessorID + ", accessorName=" + accessorName + "]";
    }
}
