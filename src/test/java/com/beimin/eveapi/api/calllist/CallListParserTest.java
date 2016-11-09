package com.beimin.eveapi.api.calllist;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.calllist.Call;
import com.beimin.eveapi.model.calllist.CallGroup;
import com.beimin.eveapi.model.shared.KeyType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.calllist.CallListParser;
import com.beimin.eveapi.response.calllist.CallListResponse;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class CallListParserTest extends NoAuthParserTest {
    public CallListParserTest() {
        super(ApiPath.API, ApiPage.CALL_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final CallListParser parser = new CallListParser();
        final CallListResponse response = parser.getResponse();
        assertThat(response, notNullValue());

        final List<CallGroup> callGroups = new ArrayList<CallGroup>(response.getCallGroups());
        assertThat("There were no call groups", callGroups.isEmpty(), equalTo(false));
        Collections.sort(callGroups, new Comparator<CallGroup>() {
            @Override
            public int compare(final CallGroup o1, final CallGroup o2) {
                return o1.getGroupID() - o2.getGroupID();
            }
        });
        assertThat(callGroups.get(0).getGroupID(), equalTo(1));
        assertThat(callGroups.get(0).getName(), equalTo("Account and Market"));

        final List<Call> calls = new ArrayList<Call>(response.getCalls());
        assertThat("There were no calls", calls.isEmpty(), equalTo(false));
        Collections.sort(calls, new Comparator<Call>() {
            @Override
            public int compare(final Call o1, final Call o2) {
                int ret = o1.getType().compareTo(o2.getType());
                if (ret == 0) {
                    ret = (int) (o1.getAccessMask() - o2.getAccessMask());
                }
                return ret;
            }
        });

        assertThat(calls.get(0).getName(), equalTo("AccountBalance"));
        assertThat(calls.get(0).getType(), equalTo(KeyType.CHARACTER));
        assertThat(calls.get(0).getGroupID(), equalTo(1));
        assertThat(calls.get(0).getDescription(), equalTo("Current balance of characters wallet."));
    }
}
