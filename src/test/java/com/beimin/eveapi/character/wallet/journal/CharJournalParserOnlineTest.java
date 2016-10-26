package com.beimin.eveapi.character.wallet.journal;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.parser.pilot.CharWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;
import static org.junit.Assume.assumeTrue;

public class CharJournalParserOnlineTest extends AbstractOnlineTest {
    private final CharWalletJournalParser classToTest = new CharWalletJournalParser();

    @Before
    public void prepare() {
        super.before();
        addNullOk("getTaxReceiverID"); //No tax
        addNullOk("getTaxAmount"); //No tax
        addEmptyOK("getReason"); //No reason provided
        addEmptyOK("getArgID1"); //Zero is a valid value
        addEmptyOK("getArgName1"); //Empty is a valid value
        addEmptyOK("getOwnerID2"); //Zero is a valid value
        addEmptyOK("getOwnerName2"); //Empty is a valid value
        addElementMissingOK(JournalEntry.class, 1); //RefType (enum) field should not be counted
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final WalletJournalResponse response = classToTest.getResponse(getCharacter());

        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final WalletJournalResponse response = classToTest.getResponse(getCharacter(), 1000);

        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        assumeTrue("Test not completed", TestControl.runTestIncomplete());
        testFail("Journal walking not tested");
        final WalletJournalResponse response = classToTest.getResponse(getCharacter(), 0, 0L, 0);

        testResponse(response);
    }

}
