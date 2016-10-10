package com.beimin.eveapi.character.wallet.transactions;


import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.WalletTransaction;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static com.beimin.eveapi.utils.Assert.assertDate;

public class CharTransactionsParserTest extends FullAuthParserTest {
    public CharTransactionsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.WALLET_TRANSACTIONS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharWalletTransactionsParser parser = new CharWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(auth, 1000);
        assertNotNull(response);
        final Set<WalletTransaction> walletTransactions = response.getAll();
        assertEquals(25, walletTransactions.size());
        boolean found = false;
        for (final WalletTransaction walletTransaction : walletTransactions) {
            if (walletTransaction.getTransactionID() == 1364611263) {
                found = true;
                assertDate(2010, 3, 24, 19, 58, 0, walletTransaction.getTransactionDateTime());
                assertEquals(1000, walletTransaction.getQuantity());
                assertEquals("Tungsten Charge M", walletTransaction.getTypeName());
                assertEquals(224, walletTransaction.getTypeID());
                assertEquals(25.11, walletTransaction.getPrice(), 0.00001);
                assertEquals(696416951L, walletTransaction.getClientID());
                assertEquals("OMG Junior", walletTransaction.getClientName());
                assertEquals(60012667, walletTransaction.getStationID());
                assertEquals("Osmon II - Moon 1 - Sisters of EVE Bureau", walletTransaction.getStationName());
                assertEquals("buy", walletTransaction.getTransactionType());
                assertEquals("personal", walletTransaction.getTransactionFor());
            }
        }
        assertTrue("test order wasn't found.", found);
    }

    @Override
    public void extraAsserts(final Map<String, String> req) {
        super.extraAsserts(req);
        assertEquals("1000", req.get("accountKey"));
    }
}

