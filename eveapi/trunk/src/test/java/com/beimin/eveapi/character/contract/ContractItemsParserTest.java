package com.beimin.eveapi.character.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;
import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.shared.contract.items.ContractItemsResponse;
import com.beimin.eveapi.shared.contract.items.EveContractItem;
import com.beimin.eveapi.utils.FullAuthParserTest;

public class ContractItemsParserTest extends FullAuthParserTest {
	public ContractItemsParserTest() {
		super(ApiPath.CHARACTER, ApiPage.CONTRACT_ITEMS);
	}

	@Test
	public void getResponse() throws ApiException {
		CharacterContractItemsParser parser = new CharacterContractItemsParser();
		long contractID = 1234L;
		ContractItemsResponse response = parser.getResponse(auth, contractID); 
		assertNotNull(response);
		Collection<EveContractItem> contracts = response.getAll();
		assertNotNull(contracts);
		assertEquals(2, contracts.size());
		boolean foundOne = false;
		boolean foundTwo = false;
		for (EveContractItem contract : contracts) {
			if(contract.getRecordID()==854257304L) {
				foundOne = true;
				assertEquals(3683, contract.getTypeID());
				assertEquals(10L, contract.getQuantity());
				assertNull(contract.getRawQuantity());
				assertFalse(contract.isSingleton());
				assertTrue(contract.isIncluded());
			} else if(contract.getRecordID()==854257305L) {
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