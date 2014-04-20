package com.beimin.eveapi.corporation.containerlog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContainerLogParserTest extends FullAuthParserTest {
	public ContainerLogParserTest() {
		super(ApiPath.CORPORATION, ApiPage.CONTAINER_LOG);
	}

	@Test
	public void getResponse() throws ApiException {
		ContainerLogParser parser = new ContainerLogParser();
		ContainerLogResponse response = parser.getResponse(auth);
		assertNotNull(response);
		Set<ApiContainerLog> containerLogs = response.getAll();
		assertNotNull(containerLogs);
		assertEquals(23, containerLogs.size());
	}
}