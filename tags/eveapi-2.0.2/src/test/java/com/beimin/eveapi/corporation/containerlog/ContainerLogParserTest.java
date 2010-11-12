package com.beimin.eveapi.corporation.containerlog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ContainerLogParserTest {

	@Test
	public void containerLogParser() throws IOException, SAXException, ParseException {
		ContainerLogParser parser = ContainerLogParser.getInstance();
		InputStream input = ContainerLogParserTest.class.getResourceAsStream("/corporation/ContainerLog.xml");
		ContainerLogResponse response = parser.getResponse(input);
		assertNotNull(response);
		List<ApiContainerLog> containerLogs = response.getContainerLogs();
		assertNotNull(containerLogs);
		assertEquals(23, containerLogs.size());
	}
}