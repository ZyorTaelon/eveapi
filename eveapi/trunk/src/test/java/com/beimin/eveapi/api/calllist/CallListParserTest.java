package com.beimin.eveapi.api.calllist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.KeyType;
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
		CallListParser parser = CallListParser.getInstance();
		CallListResponse response = parser.getResponse();
		assertNotNull(response);
		
		List<CallGroup> callGroups = new ArrayList<CallGroup>(response.get().getCallGroups());
		assertFalse("There were no call groups", callGroups.isEmpty());
		Collections.sort(callGroups, new Comparator<CallGroup>() {
			public int compare(CallGroup o1, CallGroup o2) {
				return o1.getGroupID() - o2.getGroupID();
			}
		});
		assertEquals(1, callGroups.get(0).getGroupID());
		assertEquals("Account and Market", callGroups.get(0).getName());
		
		List<Call> calls = new ArrayList<Call>(response.get().getCalls());
		assertFalse("There were no calls", calls.isEmpty());
		Collections.sort(calls, new Comparator<Call>() {
			public int compare(Call o1, Call o2) {
				int ret = o1.getType().compareTo(o2.getType());
				if (ret == 0) {
					ret = (int)(o1.getAccessMask() - o2.getAccessMask());
				}
				return ret;
			}
		});

		assertEquals("AccountBalance", calls.get(0).getName());
		assertEquals(KeyType.Character, calls.get(0).getType());
		assertEquals(1, calls.get(0).getGroupID());
	}
}
