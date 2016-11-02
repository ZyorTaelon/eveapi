package com.beimin.eveapi.character.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.ContractItem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.CharContractItemsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharContractItemsParserTest extends FullAuthParserTest {
    public CharContractItemsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CONTRACT_ITEMS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharContractItemsParser parser = new CharContractItemsParser();
        final long contractID = 1234L;
        final ContractItemsResponse response = parser.getResponse(auth, contractID);
        assertNotNull(response);
        final Collection<ContractItem> contracts = response.getAll();
        assertNotNull(contracts);
        assertEquals(2, contracts.size());
        boolean foundOne = false;
        boolean foundTwo = false;
        for (final ContractItem contract : contracts) {
            if (contract.getRecordID() == 854257304L) {
                foundOne = true;
                assertEquals(3683, contract.getTypeID());
                assertEquals(10L, contract.getQuantity());
                assertNull(contract.getRawQuantity());
                assertFalse(contract.isSingleton());
                assertTrue(contract.isIncluded());
            } else if (contract.getRecordID() == 854257305L) {
                foundTwo = true;
                assertEquals(3683, contract.getTypeID());
                assertEquals(10L, contract.getQuantity());
                assertEquals(1L, contract.getRawQuantity().longValue());
                assertFalse(contract.isSingleton());
                assertFalse(contract.isIncluded());
            }
        }
        assertTrue("test contract item wasn't found.", foundOne);
        assertTrue("test contract item wasn't found.", foundTwo);
    }
}
