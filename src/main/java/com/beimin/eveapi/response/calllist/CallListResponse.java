package com.beimin.eveapi.response.calllist;

import com.beimin.eveapi.model.calllist.CallList;
import com.beimin.eveapi.response.ApiResponse;

public class CallListResponse extends ApiResponse {
    private CallList callList;

    public CallList get() {
        return callList;
    }

    public void set(final CallList callList) {
        this.callList = callList;
    }
}