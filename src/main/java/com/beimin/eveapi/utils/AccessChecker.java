package com.beimin.eveapi.utils;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;
import com.beimin.eveapi.response.calllist.CallListResponse;

public class AccessChecker {
    public static Set<Call> getCalls(final ApiKeyInfoResponse apiKeyInfo, final CallListResponse callList) {
        final Set<Call> result = new HashSet<Call>();
        for (final Call call : callList.getCalls()) {
            final long cam = call.getAccessMask();
            if (((apiKeyInfo.getAccessMask() & cam) == cam) && (apiKeyInfo.getType() == call.getType())) {
                result.add(call);
            }
        }
        return result;
    }
}
