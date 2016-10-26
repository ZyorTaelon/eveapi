package com.beimin.eveapi.corporation.wallet.journal;

import org.junit.Before;
import org.junit.Test;

import com.beimin.eveapi.AbstractOnlineTest;
import com.beimin.eveapi.TestControl;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.parser.corporation.CorpWalletJournalParser;
import com.beimin.eveapi.response.shared.WalletJournalResponse;
import static org.junit.Assume.assumeTrue;

public class CorpJournalParserOnlineTest extends AbstractOnlineTest {
    private final CorpWalletJournalParser classToTest = new CorpWalletJournalParser();

    @Before
    public void prepare() {
        before();
        addIgnoreElement("row");
        addNullOk("getTaxReceiverID"); //no tax
        addNullOk("getTaxAmount"); //no tax
        addEmptyOK("getReason"); //zero is a valid value
        addElementMissingOK(JournalEntry.class, 1); //RefType (enum) field should not be counted
        addElementMissingOK(JournalEntry.class, 1); //taxReceiverID not included in corporation result
        addElementMissingOK(JournalEntry.class, 1); //taxAmount not included in corporation result
        prepareParser(classToTest);
    }

    @Test
    public void getResponse() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
        final WalletJournalResponse response = classToTest.getResponse(getCorp());
        testResponse(response);
    }

    @Test
    public void getResponseKey() throws Exception {
        assumeTrue("No data returned by the API", TestControl.runNoData());
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
