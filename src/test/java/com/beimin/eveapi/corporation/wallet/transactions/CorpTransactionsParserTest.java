package com.beimin.eveapi.corporation.wallet.transactions;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.WalletTransaction;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpWalletTransactionsParser;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CorpTransactionsParserTest extends FullAuthParserTest {
    public CorpTransactionsParserTest() {
        super(ApiPath.CORPORATION, ApiPage.WALLET_TRANSACTIONS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpWalletTransactionsParser parser = new CorpWalletTransactionsParser();
        final WalletTransactionsResponse response = parser.getResponse(auth, 1000);
        assertNotNull(response);
        final List<WalletTransaction> walletTransactions = response.getAll();
        assertEquals(4, walletTransactions.size());
        boolean found = false;
        for (final WalletTransaction walletTransaction : walletTransactions) {
            if (walletTransaction.getTransactionID() == 705664738) {
                found = true;
                assertDate(2008, 8, 4, 22, 1, 0, walletTransaction.getTransactionDateTime());
                assertEquals(50000, walletTransaction.getQuantity());
                assertEquals("Oxygen Isotopes", walletTransaction.getTypeName());
                assertEquals(17887, walletTransaction.getTypeID());
                assertEquals(250.01, walletTransaction.getPrice(), 0.00001);
                assertEquals(174312871, walletTransaction.getClientID());
                assertEquals("ACHAR", walletTransaction.getClientName());
                assertEquals(0, walletTransaction.getCharacterID().intValue());
                assertEquals("SELLER", walletTransaction.getCharacterName());
                assertEquals(60004375, walletTransaction.getStationID());
                assertEquals("SYSTEM IV - Moon 10 - Corporate Police Force Testing Facilities", walletTransaction.getStationName());
                assertEquals("buy", walletTransaction.getTransactionType());
                assertEquals("corporation", walletTransaction.getTransactionFor());
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
