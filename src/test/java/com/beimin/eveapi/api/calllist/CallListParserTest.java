package com.beimin.eveapi.api.calllist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

/**
 *
 * @author andrew
 */
public class CallListParserTest extends NoAuthParserTest {
    public CallListParserTest() {
        super(ApiPath.API, ApiPage.CALL_LIST);
    }

    @Test
    public void getResponse() throws ApiException {
        final CallListParser parser = new CallListParser();
        final CallListResponse response = parser.getResponse();
        assertNotNull(response);

        final List<CallGroup> callGroups = new ArrayList<CallGroup>(response.get().getCallGroups());
        assertFalse("There were no call groups", callGroups.isEmpty());
        Collections.sort(callGroups, new Comparator<CallGroup>() {
            @Override
            public int compare(final CallGroup o1, final CallGroup o2) {
                return o1.getGroupID() - o2.getGroupID();
            }
        });
        assertEquals(1, callGroups.get(0).getGroupID());
        assertEquals("Account and Market", callGroups.get(0).getName());

        final List<Call> calls = new ArrayList<Call>(response.get().getCalls());
        assertFalse("There were no calls", calls.isEmpty());
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

        assertEquals("AccountBalance", calls.get(0).getName());
        assertEquals(KeyType.CHARACTER, calls.get(0).getType());
        assertEquals(1, calls.get(0).getGroupID());
        assertEquals("Current balance of characters wallet.", calls.get(0).getDescription());
    }
}
