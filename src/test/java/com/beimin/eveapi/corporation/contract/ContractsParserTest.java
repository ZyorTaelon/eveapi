package com.beimin.eveapi.corporation.contract;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractAvailability;
import com.beimin.eveapi.model.shared.ContractStatus;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.corporation.ContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContractsParserTest extends FullAuthParserTest {
	public ContractsParserTest() {
		super(ApiPath.CORPORATION, ApiPage.CONTRACTS);
	}

	@Test
	public void getResponse() throws ApiException {
		ContractsParser parser = new ContractsParser();
		ContractsResponse response = parser.getResponse(auth); 
		assertNotNull(response);
		Collection<Contract> contracts = response.getAll();
		assertNotNull(contracts);
		assertEquals(6, contracts.size());
		boolean found = false;
		for (Contract contract : contracts) {
			if(contract.getContractID()==62276415L) {
				found = true;
				assertEquals(1683690353L, contract.getIssuerID());
				assertEquals(1020386980L, contract.getIssuerCorpID());
				assertEquals(1020386980L, contract.getAssigneeID());
				assertEquals(0L, contract.getAcceptorID());
				assertEquals(60010600, contract.getStartStationID());
				assertEquals(60010600, contract.getEndStationID());
				assertEquals(ContractType.ITEMEXCHANGE, contract.getType());
				assertEquals(ContractStatus.OUTSTANDING, contract.getStatus());
				assertEquals("From corp to corp (Item exchange)", contract.getTitle());
				assertTrue(contract.isForCorp());
				assertEquals(ContractAvailability.PRIVATE, contract.getAvailability());
				assertDate("2012-12-14 21:49:13", contract.getDateIssued());
				assertDate("2012-12-28 21:49:13", contract.getDateExpired());
				assertNull(contract.getDateAccepted());
				assertNull(contract.getDateCompleted());
				assertEquals(2, contract.getNumDays());
				assertEquals(1000000.00, contract.getPrice(), 0.01);
				assertEquals(0.0, contract.getReward(), 0.01);
				assertEquals(0.0, contract.getCollateral(), 0.01);
				assertEquals(0.0, contract.getBuyout(),0.01);
				assertEquals(0.1, contract.getVolume(),0.01);
			}
		}
		assertTrue("test contract wasn't found.", found);
	}
}