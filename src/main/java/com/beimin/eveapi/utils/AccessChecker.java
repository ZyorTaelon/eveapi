package com.beimin.eveapi.utils;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.response.account.ApiKeyInfoResponse;
import com.beimin.eveapi.response.calllist.CallListResponse;

public class AccessChecker {
    public static List<Call> getCalls(final ApiKeyInfoResponse apiKeyInfo, final CallListResponse callList) {
        final List<Call> result = new ArrayList<>();
        for (final Call call : callList.getCalls()) {
            final long cam = call.getAccessMask();
            if (((apiKeyInfo.getAccessMask() & cam) == cam) && (apiKeyInfo.getType() == call.getType())) {
                result.add(call);
            }
        }
        return result;
    }
}
