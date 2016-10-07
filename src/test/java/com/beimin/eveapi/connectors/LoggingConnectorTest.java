package com.beimin.eveapi.connectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.beimin.eveapi.EveApi;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.SkillQueueParser;
import com.beimin.eveapi.response.pilot.SkillQueueResponse;
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
        final PrintStream defaultStdout = System.out;
        final ByteArrayOutputStream temp = new ByteArrayOutputStream();
        final PrintStream printStream = new PrintStream(temp);
        System.setOut(printStream);

        final SkillQueueParser parser = new SkillQueueParser();
        final SkillQueueResponse response = parser.getResponse(auth);
        assertNotNull(response);
        printStream.flush();
        printStream.close();
        temp.flush();
        temp.close();
        final String result = temp.toString();
        System.setOut(defaultStdout);
        final String[] lines = result.split("\n");
        assertTrue(lines[0].contains("INFO  [main] com.beimin.eveapi.connectors.LoggingConnector.execute:"));
        assertEquals("Request:", lines[1]);
        assertEquals("Path: /char", lines[2]);
        assertEquals("Page: SkillQueue", lines[3]);
        assertEquals("Version: 2", lines[4]);
        assertEquals("Auth: keyID: 123, characterID: 456", lines[5]);
        assertTrue(lines[7].contains("INFO  [main] com.beimin.eveapi.connectors.LoggingConnector.getApiResponse:"));
        assertEquals("Response:", lines[8]);
        assertEquals("<?xml version='1.0' encoding='UTF-8'?>", lines[9].trim());
        assertEquals("<eveapi version=\"2\">", lines[10].trim());
        assertEquals("<currentTime>2010-04-03 16:33:20</currentTime>", lines[11].trim());
        assertEquals("<result>", lines[12].trim());
        assertEquals("<rowset name=\"skillqueue\" key=\"queuePosition\" columns=\"queuePosition,typeID,level,startSP,endSP,startTime,endTime\">", lines[13].trim());
        assertEquals("<row queuePosition=\"0\" typeID=\"25739\" level=\"5\" startSP=\"362039\" endSP=\"2048000\" startTime=\"2010-03-28 11:00:01\" endTime=\"2010-04-30 04:59:46\" />", lines[14].trim());
        assertEquals("<row queuePosition=\"1\" typeID=\"20533\" level=\"4\" startSP=\"112000\" endSP=\"633542\" startTime=\"2010-04-30 04:59:46\" endTime=\"2010-05-12 15:19:21\" />", lines[15].trim());
        assertEquals("</rowset>", lines[16].trim());
        assertEquals("</result>", lines[17].trim());
        assertEquals("<cachedUntil>2010-04-03 16:48:20</cachedUntil>", lines[18].trim());
    }
}