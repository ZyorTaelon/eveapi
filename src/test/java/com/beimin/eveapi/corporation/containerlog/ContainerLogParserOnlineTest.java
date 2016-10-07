package com.beimin.eveapi.corporation.containerlog;


import com.beimin.eveapi.AbstractOnlineTest;

import org.junit.Test;

import com.beimin.eveapi.parser.corporation.ContainerLogParser;
import com.beimin.eveapi.response.corporation.ContainerLogResponse;

public class ContainerLogParserOnlineTest extends AbstractOnlineTest {

	@Test
	public void getResponse() throws Exception {
		ContainerLogParser parser = new ContainerLogParser();
		ContainerLogResponse response = parser.getResponse(getCorp());
		testResponse(response);
	}

}