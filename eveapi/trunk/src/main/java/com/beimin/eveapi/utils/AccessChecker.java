package com.beimin.eveapi.utils;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.account.ApiKeyInfo;
import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.model.calllist.CallList;

public class AccessChecker {
	public static Set<Call> getCalls(ApiKeyInfo apiKeyInfo, CallList callList) {
		Set<Call> result = new HashSet<Call>();
		for (Call call : callList.getCalls()) {
			long cam = call.getAccessMask();
			if((apiKeyInfo.getAccessMask() & cam) == cam && apiKeyInfo.getType() == call.getType())
				result.add(call);
		}
		return result;
	}
}