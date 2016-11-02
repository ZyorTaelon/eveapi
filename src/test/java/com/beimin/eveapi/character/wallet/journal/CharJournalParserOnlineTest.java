package com.beimin.eveapi.character.wallet.journal;

import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.parser.character.CharWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class CharJournalParserOnlineTest extends AbstractOnlineTest {
    private final CharWalletJournalParser classToTest = new CharWalletJournalParser();

    @Before
    public void prepare() {
        setAlias(WalletJournalResponse.class, "transactions", "items");
        allowNull("getTaxReceiverID"); // No tax
        allowNull("getTaxAmount"); // No tax
        allowEmpty("getReason"); // No reason provided
        allowEmpty("getArgID1"); // Zero is a valid value
        allowEmpty("getArgName1"); // Empty is a valid value
        allowEmpty("getOwnerID2"); // Zero is a valid value
        allowEmpty("getOwnerName2"); // Empty is a valid value
        ignoreClassField(JournalEntry.class, "refType"); // RefType (enum) field should not be counted
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCharacter());

        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
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
