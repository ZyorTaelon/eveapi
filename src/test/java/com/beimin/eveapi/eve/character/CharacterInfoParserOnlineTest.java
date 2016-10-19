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
		addNullOk("getNextTrainingEnds"); //No skill in training
        addEmptyOK("getSecurityStatus"); // Security Status can be zero
		addElementMissingOK(CharacterInfoResponse.class, 3); //allianceID, alliance, allianceDate - test char have not in alliance
        addIgnoreElement("row");
        prepareParser(classToTest);
    }

    @Test
    public void getResponsePublic() throws Exception {
        // Private Info, not included
        addNullOk("getShipName");
        addNullOk("getAccountBalance");
        addNullOk("getLastKnownLocation");
        addNullOk("getShipTypeID");
        addNullOk("getSkillPoints");
        addNullOk("getShipTypeName");
		addElementMissingOK(CharacterInfoResponse.class, 1); //nextTrainingEnds - test char have nothing in training
        //shipName, accountBalance, lastKnownLocation, shipTypeID, skillPoints, shipTypeName
        addElementMissingOK(CharacterInfoResponse.class, 6);  //Private info not included in public result
        final CharacterInfoResponse response = classToTest.getResponse(getCharacterID());

        testResponse(response);
    }

    @Test
    public void getResponseKeyFull() throws Exception {
		addElementMissingOK(CharacterInfoResponse.class, 1); //nextTrainingEnds - test char have nothing in training
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
