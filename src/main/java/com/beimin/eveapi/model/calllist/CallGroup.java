package com.beimin.eveapi.model.calllist;

import java.util.ArrayList;
import java.util.List;

public class CallGroup {
    private final List<Call> calls = new ArrayList<Call>();
    private int groupID;
    private String name;
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void addCall(final Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }
}

