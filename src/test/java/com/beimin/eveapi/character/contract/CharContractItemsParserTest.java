package com.beimin.eveapi.character.contract;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

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
        assertThat(response, notNullValue());
        final Collection<ContractItem> contracts = response.getAll();
        assertThat(contracts, notNullValue());
        assertThat(contracts.size(), equalTo(2));
        boolean foundOne = false;
        boolean foundTwo = false;
        for (final ContractItem contract : contracts) {
            if (contract.getRecordID() == 854257304L) {
                foundOne = true;
                assertThat(contract.getTypeID(), equalTo(3683));
                assertThat(contract.getQuantity(), equalTo(10L));
                assertThat(contract.getRawQuantity(), nullValue());
                assertThat(contract.isSingleton(), equalTo(false));
                assertThat(contract.isIncluded(), equalTo(true));
            } else if (contract.getRecordID() == 854257305L) {
                foundTwo = true;
                assertThat(contract.getTypeID(), equalTo(3683));
                assertThat(contract.getQuantity(), equalTo(10L));
                assertThat(contract.getRawQuantity().longValue(), equalTo(1L));
                assertThat(contract.isSingleton(), equalTo(false));
                assertThat(contract.isIncluded(), equalTo(false));
            }
        }
        assertThat("test contract item wasn't found.", foundOne, equalTo(true));
        assertThat("test contract item wasn't found.", foundTwo, equalTo(true));
    }
}
