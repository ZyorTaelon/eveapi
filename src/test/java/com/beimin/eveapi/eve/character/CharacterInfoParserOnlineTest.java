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
        setAlias(CharacterInfoResponse.class, "employmentHistory", "employment");
        // Not in alliance
        allowNull("getAllianceID");
        allowNull("getAllianceDate");
        allowNull("getAlliance");
        allowNull("getNextTrainingEnds"); //No skill in training
        allowEmpty("getSecurityStatus"); // Security Status can be zero
        ignoreClassField(CharacterInfoResponse.class, "allianceID"); //test char have not in alliance
        ignoreClassField(CharacterInfoResponse.class, "alliance"); //test char have not in alliance
        ignoreClassField(CharacterInfoResponse.class, "allianceDate"); //test char have not in alliance
        prepareParser(classToTest);
    }

    @Test
    public void getResponsePublic() throws Exception {
        // Private Info, not included
        allowNull("getShipName");
        allowNull("getAccountBalance");
        allowNull("getLastKnownLocation");
        allowNull("getShipTypeID");
        allowNull("getSkillPoints");
        allowNull("getShipTypeName");
        ignoreClassField(CharacterInfoResponse.class, "nextTrainingEnds"); //nextTrainingEnds - test char have nothing in training
        //Private info not included in public result
        ignoreClassField(CharacterInfoResponse.class, "shipName");
        ignoreClassField(CharacterInfoResponse.class, "accountBalance");
        ignoreClassField(CharacterInfoResponse.class, "lastKnownLocation");
        ignoreClassField(CharacterInfoResponse.class, "shipTypeID");
        ignoreClassField(CharacterInfoResponse.class, "skillPoints");
        ignoreClassField(CharacterInfoResponse.class, "shipTypeName");
        final CharacterInfoResponse response = classToTest.getResponse(getCharacterID());

        testResponse(response);
    }

    @Test
    public void getResponseKeyFull() throws Exception {
        ignoreClassField(CharacterInfoResponse.class, "nextTrainingEnds"); //nextTrainingEnds - test char have nothing in training
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
