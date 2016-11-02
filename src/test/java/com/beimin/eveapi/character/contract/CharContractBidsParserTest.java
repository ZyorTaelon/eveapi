package com.beimin.eveapi.character.contract;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.ContractBid;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.pilot.CharContractBidsParser;
import com.beimin.eveapi.response.shared.ContractBidsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class CharContractBidsParserTest extends FullAuthParserTest {
    public CharContractBidsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CONTRACT_BIDS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharContractBidsParser parser = new CharContractBidsParser();
        final ContractBidsResponse response = parser.getResponse(auth);
        assertNotNull(response);
        final Collection<ContractBid> contracts = response.getAll();
        assertNotNull(contracts);
        assertEquals(2, contracts.size());
        boolean found = false;
        for (final ContractBid contract : contracts) {
            if (contract.getBidID() == 4091381L) {
                found = true;
                assertEquals(62276260L, contract.getContractID());
                assertEquals(1652509239L, contract.getBidderID());
                assertDate("2012-12-14 22:30:54", contract.getDateBid());
                assertEquals(1000000.0, contract.getAmount(), 0.01);
            }
        }
        assertTrue("test contract item wasn't found.", found);
    }
}
