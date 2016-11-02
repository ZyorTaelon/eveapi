package com.beimin.eveapi.connectors;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.SkillQueueParser;
import com.beimin.eveapi.parser.shared.AbstractApiParser;
import com.beimin.eveapi.response.character.SkillQueueResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import com.beimin.eveapi.utils.MockApi;

public class LoggingConnectorTest extends FullAuthParserTest {
    public LoggingConnectorTest() {
        super(ApiPath.CHARACTER, ApiPage.SKILL_QUEUE);
    }

    @Override
    public void setup() throws Exception {
        super.setup();
        AbstractApiParser.setConnector(new LoggingConnector(new ApiConnector(MockApi.URL)));
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
        assertThat(lines[0], containsString("INFO  [main] com.beimin.eveapi.connectors.LoggingConnector.execute:"));
        assertThat(lines[1], equalTo("Request:"));
        assertThat(lines[2], equalTo("Path: /char"));
        assertThat(lines[3], equalTo("Page: SkillQueue"));
        assertThat(lines[4], equalTo("Version: 2"));
        assertThat(lines[5], equalTo("Auth: keyID: 123, characterID: 456"));
        assertThat(lines[7], containsString("INFO  [main] com.beimin.eveapi.connectors.LoggingConnector.execute:"));
        assertThat(lines[8], equalTo("URL: http://localhost:12344/api/char/SkillQueue.xml.aspx"));
        assertThat(lines[10], containsString("INFO  [main] com.beimin.eveapi.connectors.LoggingConnector.getApiResponse:"));
        assertThat(lines[11], equalTo("Response:"));
        assertThat(lines[12].trim(), equalTo("<?xml version='1.0' encoding='UTF-8'?>"));
        assertThat(lines[13].trim(), equalTo("<eveapi version=\"2\">"));
        assertThat(lines[14].trim(), equalTo("<currentTime>2010-04-03 16:33:20</currentTime>"));
        assertThat(lines[15].trim(), equalTo("<result>"));
        assertThat(lines[16].trim(), equalTo("<rowset name=\"skillqueue\" key=\"queuePosition\" columns=\"queuePosition,typeID,level,startSP,endSP,startTime,endTime\">"));
        assertThat(lines[17].trim(), equalTo("<row queuePosition=\"0\" typeID=\"25739\" level=\"5\" startSP=\"362039\" endSP=\"2048000\" startTime=\"2010-03-28 11:00:01\" endTime=\"2010-04-30 04:59:46\" />"));
        assertThat(lines[18].trim(), equalTo("<row queuePosition=\"1\" typeID=\"20533\" level=\"4\" startSP=\"112000\" endSP=\"633542\" startTime=\"2010-04-30 04:59:46\" endTime=\"2010-05-12 15:19:21\" />"));
        assertThat(lines[19].trim(), equalTo("</rowset>"));
        assertThat(lines[20].trim(), equalTo("</result>"));
        assertThat(lines[21].trim(), equalTo("<cachedUntil>2010-04-03 16:48:20</cachedUntil>"));
    }
}
