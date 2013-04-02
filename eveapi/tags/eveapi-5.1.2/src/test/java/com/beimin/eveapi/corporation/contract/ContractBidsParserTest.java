package com.beimin.eveapi.corporation.contract;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.contract.bids.ContractBidsResponse;
import com.beimin.eveapi.shared.contract.bids.EveContractBid;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContractBidsParserTest extends FullAuthParserTest {
	public ContractBidsParserTest() {
		super(ApiPath.CORPORATION, ApiPage.CONTRACT_BIDS);
	}

	@Test
	public void getResponse() throws ApiException {
		ContractBidsParser parser = ContractBidsParser.getInstance();
		ContractBidsResponse response = parser.getResponse(auth); 
		assertNotNull(response);
		Collection<EveContractBid> contracts = response.getAll();
		assertNotNull(contracts);
		assertEquals(2, contracts.size());
		boolean found = false;
		for (EveContractBid contract : contracts) {
			if(contract.getBidID()==4091381L) {
				found = true;
				assertEquals(62276261L, contract.getContractID());
				assertEquals(1652509239L, contract.getBidderID());
				assertDate("2012-12-14 22:30:54", contract.getDateBid());
				assertEquals(1000000.0, contract.getAmount(), 0.01);
			}
		}
		assertTrue("test contract item wasn't found.", found);
	}
}