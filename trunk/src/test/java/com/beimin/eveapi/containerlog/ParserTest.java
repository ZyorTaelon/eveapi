package com.beimin.eveapi.containerlog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.xml.sax.SAXException;

public class ParserTest {

	@Test
	public void testAccountBalanceParser() throws IOException, SAXException, ParseException {
		Parser parser = Parser.getInstance();
		InputStream input = ParserTest.class.getResourceAsStream("/ContainerLog.xml");
		Response response = parser.getResponse(input);
		assertNotNull(response);
		List<ApiContainerLog> containerLogs = response.getContainerLogs();
		assertNotNull(containerLogs);
		assertEquals(23, containerLogs.size());
	}
}