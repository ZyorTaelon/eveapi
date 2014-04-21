package com.beimin.eveapi.response.calllist;

import com.beimin.eveapi.model.calllist.CallList;
import com.beimin.eveapi.response.ApiResponse;

public class CallListResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	CallList callList;

	public CallList get() {
		return callList;
	}

	public void set(CallList callList) {
		this.callList = callList;
	}
}