package com.beimin.eveapi.response.calllist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.model.calllist.CallGroup;
import com.beimin.eveapi.response.ApiResponse;

public class CallListResponse extends ApiResponse {
    private List<CallGroup> callGroups = new ArrayList<CallGroup>();
    private List<Call> calls = new ArrayList<Call>();

    public List<CallGroup> getCallGroups() {
        return Collections.unmodifiableList(callGroups);
    }

    public void setCallGroups(final List<CallGroup> callGroups) {
        this.callGroups = callGroups;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public void setCalls(final List<Call> calls) {
        this.calls = calls;
    }

    public void add(final CallGroup callGroup) {
        callGroups.add(callGroup);
    }

    public void add(final Call call) {
        calls.add(call);
        for (final CallGroup callGroup : callGroups) {
            if (call.getGroupID() == callGroup.getGroupID()) {
                callGroup.addCall(call);
                return;
            }
        }
    }
}
