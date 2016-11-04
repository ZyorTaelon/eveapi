package com.beimin.eveapi.character.contract;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Collection;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractAvailability;
import com.beimin.eveapi.model.shared.ContractStatus;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.parser.character.CharContractsParser;
import com.beimin.eveapi.response.shared.ContractsResponse;
import com.beimin.eveapi.utils.FullAuthParserTest;
import com.beimin.eveapi.utils.GMTConverter;

public class CharContractsParserTest extends FullAuthParserTest {
    public CharContractsParserTest() {
        super(ApiPath.CHARACTER, ApiPage.CONTRACTS);
    }

    @Test
    public void getResponse() throws ApiException {
        final CharContractsParser parser = new CharContractsParser();
        final ContractsResponse response = parser.getResponse(auth);
        assertThat(response, notNullValue());
        final Collection<Contract> contracts = response.getAll();
        assertThat(contracts, notNullValue());
        assertThat(contracts.size(), equalTo(3));
        boolean found = false;
        Calendar calendar = Calendar.getInstance(GMTConverter.DEFAULT_TIMEZONE);
        for (final Contract contract : contracts) {
            if (contract.getContractID() == 62158129L) {
                found = true;
                assertThat(contract.getIssuerID(), equalTo(987623974L));
                assertThat(contract.getIssuerCorpID(), equalTo(917701062L));
                assertThat(contract.getIssuerID(), equalTo(987623974L));
                assertThat(contract.getAssigneeID(), equalTo(1683690353L));
                assertThat(contract.getAcceptorID(), equalTo(0L));
                assertThat(contract.getStartStationID(), equalTo(60014818L));
                assertThat(contract.getEndStationID(), equalTo(60003493L));
                assertThat(contract.getType(), equalTo(ContractType.COURIER));
                assertThat(contract.getStatus(), equalTo(ContractStatus.OUTSTANDING));
                assertThat(contract.getTitle(), equalTo("Courier"));
                assertThat(contract.isForCorp(), equalTo(false));
                assertThat(contract.getAvailability(), equalTo(ContractAvailability.PRIVATE));
                calendar.set(2012, 11, 11, 10, 48, 15);
                calendar.set(Calendar.MILLISECOND, 0);
                assertThat(contract.getDateIssued(), equalTo(calendar.getTime()));
                calendar.set(Calendar.DATE, 25);
                assertThat(contract.getDateExpired(), equalTo(calendar.getTime()));
                assertThat(contract.getDateAccepted(), nullValue());
                assertThat(contract.getDateCompleted(), nullValue());
                assertThat(contract.getNumDays(), equalTo(2));
                assertThat(contract.getPrice(), equalTo(0.0));
                assertThat(contract.getReward(), equalTo(10.0));
                assertThat(contract.getCollateral(), equalTo(1000000.0));
                assertThat(contract.getBuyout(), equalTo(0.0));
                assertThat(contract.getVolume(), equalTo(3.8));
            }
        }
        assertThat("test contract wasn't found.", found, equalTo(true));
    }
}
