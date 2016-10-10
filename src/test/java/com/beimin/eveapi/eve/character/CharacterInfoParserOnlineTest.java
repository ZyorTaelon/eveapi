package com.beimin.eveapi.eve.character;

import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.parser.eve.CharacterInfoParser;
import com.beimin.eveapi.response.eve.CharacterInfoResponse;
import org.junit.Ignore;

public class CharacterInfoParserOnlineTest extends AbstractOnlineTest {

    @Test @Ignore("New fields test not working")
    public void getResponsePublic() throws Exception {
        // Not in alliance
        addNullOk("getAllianceID");
        addNullOk("getAllianceDate");
        addNullOk("getAlliance");
        // Private Info, not included
        addNullOk("getShipName");
        addNullOk("getAccountBalance");
        addNullOk("getLastKnownLocation");
        addNullOk("getShipTypeID");
        addNullOk("getSkillPoints");
        addNullOk("getShipTypeName");
        addEmptyOK("getSecurityStatus"); // Security Status can be zero
        final CharacterInfoParser parser = new CharacterInfoParser();
        final CharacterInfoResponse response = parser.getResponse(getCharacterID());
        testResponse(response);
    }

    @Test @Ignore("Some empty data")
    public void getResponseKeyFull() throws Exception {
        // Not in alliance
        addNullOk("getAllianceID");
        addNullOk("getAllianceDate");
        addNullOk("getAlliance");
        final CharacterInfoParser parser = new CharacterInfoParser();
        final CharacterInfoResponse response = parser.getResponse(getEve());
        testResponse(response);
    }

    @Test @Ignore("Test not complated")
    public void getResponseKeyLimited() throws Exception {
        testFail("Limited Key is not tested");
        // Not in alliance
        addNullOk("getAllianceID");
        addNullOk("getAllianceDate");
        addNullOk("getAlliance");
        final CharacterInfoParser parser = new CharacterInfoParser();
        final CharacterInfoResponse response = parser.getResponse(getEve());
        testResponse(response);
    }

}
