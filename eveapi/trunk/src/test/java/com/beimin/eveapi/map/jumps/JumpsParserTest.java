package com.beimin.eveapi.map.jumps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.NoAuthParserTest;

public class JumpsParserTest extends NoAuthParserTest {
	public JumpsParserTest() {
		super(ApiPath.MAP, ApiPage.JUMPS);
	}

	@Test
	public void getResponse() throws ApiException {
		JumpsParser parser = new JumpsParser();
		JumpsResponse response = parser.getResponse();
		assertNotNull(response);
		Map<Integer, Integer> systemJumps = response.getSystemJumps();
		assertNotNull(systemJumps);
		assertEquals(4294L, systemJumps.size());
		assertEquals(1040L, systemJumps.get(30003504).longValue());
		assertEquals(13L, systemJumps.get(30003089).longValue());
		assertEquals(209L, systemJumps.get(30004978).longValue());
	}
}