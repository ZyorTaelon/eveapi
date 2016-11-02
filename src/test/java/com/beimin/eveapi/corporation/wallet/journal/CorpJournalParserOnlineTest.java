package com.beimin.eveapi.corporation.wallet.journal;

import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.parser.corporation.CorpWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class CorpJournalParserOnlineTest extends AbstractOnlineTest {
    private final CorpWalletJournalParser classToTest = new CorpWalletJournalParser();

    @Before
    public void prepare() {
        setAlias(WalletJournalResponse.class, "entries", "items");
        allowNull("getTaxReceiverID"); // no tax
        allowNull("getTaxAmount"); // no tax
        allowEmpty("getReason"); // zero is a valid value
        ignoreClassField(JournalEntry.class, "refType"); // RefType (enum) field should not be counted
        ignoreClassField(JournalEntry.class, "taxReceiverID"); // taxReceiverID not included in corporation result
        ignoreClassField(JournalEntry.class, "taxAmount"); // taxAmount not included in corporation result
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCorp());
        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
        final WalletJournalResponse response = classToTest.getResponse(getCorp(), 1000);
        testResponse(response);
    }

    @Test
    public void getResponseWalking() throws Exception {
        assumeTrue("Test not completed", TestControl.runTestIncomplete());
        testFail("Journal walking not tested");
        final WalletJournalResponse response = classToTest.getResponse(getCorp(), 0, 0L, 0);
        testResponse(response);
    }

}
