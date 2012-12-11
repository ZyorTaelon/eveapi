package com.beimin.eveapi.character.contract;

import static com.beimin.eveapi.utils.Assert.assertDate;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.contract.ContractAvailability;
import com.beimin.eveapi.shared.contract.ContractStatus;
import com.beimin.eveapi.shared.contract.ContractType;
import com.beimin.eveapi.shared.contract.ContractsResponse;
import com.beimin.eveapi.shared.contract.EveContract;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContractsParserTest extends FullAuthParserTest {
	public ContractsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CONTRACTS);
	}

	@Test
	public void getResponse() throws ApiException {
		ContractsParser parser = ContractsParser.getInstance();
		ContractsResponse response = parser.getResponse(auth); 
		assertNotNull(response);
		Collection<EveContract> contracts = response.getAll();
		assertNotNull(contracts);
		assertEquals(3, contracts.size());
		boolean found = false;
		for (EveContract contract : contracts) {
			if(contract.getContractID()==62158129L) {
				found = true;
				assertEquals(987623974L, contract.getIssuerID());
				assertEquals(917701062L, contract.getIssuerCorpID());
				assertEquals(987623974L, contract.getIssuerID());
				assertEquals(1683690353L, contract.getAssigneeID());
				assertEquals(0L, contract.getAcceptorID());
				assertEquals(60014818, contract.getStartStationID());
				assertEquals(60003493, contract.getEndStationID());
				assertEquals(ContractType.COURIER, contract.getType());
				assertEquals(ContractStatus.OUTSTANDING, contract.getStatus());
				assertEquals("Courier", contract.getTitle());
				assertEquals(false, contract.isForCorp());
				assertEquals(ContractAvailability.PRIVATE, contract.getAvailability());
				assertDate(2012,12,11,10,48,15, contract.getDateIssued());
				assertDate(2012,12,11,10,48,15, contract.getDateIssued());
				assertDate(2012,12,25,10,48,15, contract.getDateExpired());
				assertNull(contract.getDateAccepted());
				assertNull(contract.getDateCompleted());
				assertEquals(2, contract.getNumDays());
				assertEquals(0.0, contract.getPrice(), 0.01);
				assertEquals(10.0, contract.getReward(), 0.01);
				assertEquals(1000000.0, contract.getCollateral(), 0.01);
				assertEquals(0.0, contract.getBuyout(),0.01);
				assertEquals(3.8, contract.getVolume(),0.01);
			}
		}
		assertTrue("test contract wasn't found.", found);
	}
}