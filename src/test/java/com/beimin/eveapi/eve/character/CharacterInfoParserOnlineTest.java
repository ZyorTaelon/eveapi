package com.beimin.eveapi.eve.character;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CharacterInfoParser;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;

public class CharacterInfoParserOnlineTest extends AbstractOnlineTest {
    private CharacterInfoParser classToTest = new CharacterInfoParser();

    @Before
    public void prepare() {
        setUp();
        // Not in alliance
        addNullOk("getAllianceID");
        addNullOk("getAllianceDate");
        addNullOk("getAlliance");
        prepareParser(classToTest);
    }

    @Test
    @Ignore("New fields test not working")
    public void getResponsePublic() throws Exception {
        // Private Info, not included
        addNullOk("getShipName");
        addNullOk("getAccountBalance");
        addNullOk("getLastKnownLocation");
        addNullOk("getShipTypeID");
        addNullOk("getSkillPoints");
        addNullOk("getShipTypeName");
        addEmptyOK("getSecurityStatus"); // Security Status can be zero

        final CharacterInfoResponse response = classToTest.getResponse(getCharacterID());

        testResponse(response);
    }

    @Test @Ignore("Some empty data")
    public void getResponseKeyFull() throws Exception {
        final CharacterInfoResponse response = classToTest.getResponse(getEve());

        testResponse(response);
    }

    @Test @Ignore("Test not complated")
    public void getResponseKeyLimited() throws Exception {
        testFail("Limited Key is not tested");

        final CharacterInfoResponse response = classToTest.getResponse(getEve());

        testResponse(response);
    }

}
