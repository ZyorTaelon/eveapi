package com.beimin.eveapi.eve.character;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.parser.eve.CharacterInfoParser;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;
import static org.junit.Assume.assumeTrue;

public class CharacterInfoParserOnlineTest extends AbstractOnlineTest {
    private final CharacterInfoParser classToTest = new CharacterInfoParser();

    @Before
    public void prepare() {
        setUp();
        // Not in alliance
        addNullOk("getAllianceID");
        addNullOk("getAllianceDate");
        addNullOk("getAlliance");
        addEmptyOK("getSecurityStatus"); // Security Status can be zero
        addIgnoreElement("row");
        prepareParser(classToTest);
    }

    @Test
    public void getResponsePublic() throws Exception {
        assumeTrue("Bug: Missing fields", TestControl.runBug());
        // Private Info, not included
        addNullOk("getShipName");
        addNullOk("getAccountBalance");
        addNullOk("getLastKnownLocation");
        addNullOk("getShipTypeID");
        addNullOk("getSkillPoints");
        addNullOk("getShipTypeName");
        //allianceID, alliance, allianceDate, nextTrainingEnds, shipName,
        //accountBalance, lastKnownLocation, shipTypeID, skillPoints
        //shipTypeName
        addElementMissingOK(CharacterInfoResponse.class, 10); 
        final CharacterInfoResponse response = classToTest.getResponse(getCharacterID());

        testResponse(response);
    }

    @Test
    public void getResponseKeyFull() throws Exception {
        assumeTrue("Bug: Missing fields", TestControl.runBug());
        addElementMissingOK(CharacterInfoResponse.class, 4); //allianceID, alliance, allianceDate, nextTrainingEnds
        final CharacterInfoResponse response = classToTest.getResponse(getEve());

        testResponse(response);
    }

    @Test
    public void getResponseKeyLimited() throws Exception {
        assumeTrue("Test not completed", TestControl.runTestIncomplete());
        testFail("Limited Key is not tested");

        final CharacterInfoResponse response = classToTest.getResponse(getEve());

        testResponse(response);
    }

}
