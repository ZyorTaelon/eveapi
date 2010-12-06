package com.beimin.eveapi.connector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.character.skill.queue.SkillQueueParser;
import com.beimin.eveapi.character.skill.queue.SkillQueueResponse;
import com.beimin.eveapi.connectors.ApiConnector;
import com.beimin.eveapi.connectors.LoggingConnector;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.utils.FullAuthParserTest;
import com.beimin.eveapi.utils.MockApi;

public class LoggingConnectorTest extends FullAuthParserTest {
	public LoggingConnectorTest() {
		super(ApiPath.CHARACTER, ApiPage.SKILL_QUEUE);
	}

	@Override
	public void setup() throws Exception {
		super.setup();
		EveApi.setConnector(new LoggingConnector(new ApiConnector(MockApi.URL)));
	}

	@Test
	public void getResponse() throws ApiException, IOException {
		PrintStream backup = System.out;
		ByteArrayOutputStream temp = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(temp);
		System.setOut(printStream);

		SkillQueueParser parser = SkillQueueParser.getInstance();
		SkillQueueResponse response = parser.getResponse(auth);
		assertNotNull(response);
		printStream.flush();
		printStream.close();
		temp.flush();
		temp.close();
		String result = temp.toString();
		System.setOut(backup);
		String expected = "INFO  [main] com.beimin.eveapi.connectors.ApiConnector.execute:31 - \nRequest:\nPath: /char\nPage: SkillQueue\nVersion: 2\nAuth: userID: 123, characterID: 456\n";
		assertTrue(result.contains(expected));
		expected = "INFO  [main] com.beimin.eveapi.connectors.ApiConnector.getApiResponse:49 - \nResponse:\n<?xml version='1.0' encoding='UTF-8'?>\n<eveapi version=\"2\">\n  <currentTime>2010-04-03 16:33:20</currentTime>\n  <result>\n    <rowset name=\"skillqueue\" key=\"queuePosition\" columns=\"queuePosition,typeID,level,startSP,endSP,startTime,endTime\">\n      <row queuePosition=\"0\" typeID=\"25739\" level=\"5\" startSP=\"362039\" endSP=\"2048000\" startTime=\"2010-03-28 11:00:01\" endTime=\"2010-04-30 04:59:46\" />\n      <row queuePosition=\"1\" typeID=\"20533\" level=\"4\" startSP=\"112000\" endSP=\"633542\" startTime=\"2010-04-30 04:59:46\" endTime=\"2010-05-12 15:19:21\" />\n    </rowset>\n  </result>\n  <cachedUntil>2010-04-03 16:48:20</cachedUntil>\n</eveapi>";
		assertTrue(result.contains(expected));
	}
}