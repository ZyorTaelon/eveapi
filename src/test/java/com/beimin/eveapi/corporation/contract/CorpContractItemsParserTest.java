package com.beimin.eveapi.corporation.contract;


import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.ContractItem;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.CorpContractItemsParser;
import com.beimin.eveapi.response.shared.ContractItemsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CorpContractItemsParserTest extends FullAuthParserTest {
    public CorpContractItemsParserTest() {
        super(ApiPath.CORPORATION, ApiPage.CONTRACT_ITEMS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CorpContractItemsParser parser = new CorpContractItemsParser();
        final long contractID = 1234L;
        final ContractItemsResponse response = parser.getResponse(auth, contractID);
        assertNotNull(response);
        final Collection<ContractItem> contracts = response.getAll();
        assertNotNull(contracts);
        assertEquals(2, contracts.size());
        boolean found = false;
        for (final ContractItem contract : contracts) {
            if (contract.getRecordID() == 854257304L) {
                found = true;
                assertEquals(3683, contract.getTypeID());
                assertEquals(10L, contract.getQuantity());
                assertFalse(contract.isSingleton());
                assertTrue(contract.isIncluded());
            }
        }
        assertTrue("test contract item wasn't found.", found);
    }
}

