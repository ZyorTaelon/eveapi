package com.beimin.eveapi.api.calllist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author andrew
 */
public class CallList {
	private List<CallGroup> callGroups = new ArrayList<CallGroup>();
	private List<Call> calls = new ArrayList<Call>();

	public List<CallGroup> getCallGroups() {
		return Collections.unmodifiableList(callGroups);
	}

	public void setCallGroups(List<CallGroup> callGroups) {
		this.callGroups = callGroups;
	}

	public List<Call> getCalls() {
		return Collections.unmodifiableList(calls);
	}

	public void setCalls(List<Call> calls) {
		this.calls = calls;
	}
	
	public void add(CallGroup callGroup) {
		callGroups.add(callGroup);
	}
	
	public void add(Call call) {
		calls.add(call);
	}
}