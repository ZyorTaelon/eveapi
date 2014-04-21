package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.Contract;
import com.beimin.eveapi.model.shared.ContractAvailability;
import com.beimin.eveapi.model.shared.ContractStatus;
import com.beimin.eveapi.model.shared.ContractType;
import com.beimin.eveapi.response.shared.ContractsResponse;

public class ContractsHandler extends AbstractContentListHandler<ContractsResponse, Contract> {
	public ContractsHandler() {
		super(ContractsResponse.class);
	}

	@Override
	protected Contract getItem(Attributes attrs) {
		Contract contract = new Contract();
		contract.setContractID(getLong(attrs, "contractID"));
		contract.setIssuerID(getLong(attrs, "issuerID"));
		contract.setIssuerCorpID(getLong(attrs, "issuerCorpID"));
		contract.setAssigneeID(getLong(attrs, "assigneeID"));
		contract.setAcceptorID(getLong(attrs, "acceptorID"));
		contract.setStartStationID(getInt(attrs, "startStationID"));
		contract.setEndStationID(getInt(attrs, "endStationID"));
		contract.setType(ContractType.valueOf(getString(attrs, "type").toUpperCase()));
		contract.setStatus(ContractStatus.valueOf(getString(attrs, "status").toUpperCase()));
		contract.setTitle(getString(attrs, "title"));
		contract.setForCorp(getBoolean(attrs, "forCorp"));
		contract.setAvailability(ContractAvailability.valueOf(getString(attrs, "availability").toUpperCase()));
		contract.setDateIssued(getDate(attrs, "dateIssued"));
		contract.setDateExpired(getDate(attrs, "dateExpired"));
		contract.setDateAccepted(getDate(attrs, "dateAccepted"));
		contract.setDateCompleted(getDate(attrs, "dateCompleted"));
		contract.setNumDays(getInt(attrs, "numDays"));
		contract.setPrice(getDouble(attrs, "price"));
		contract.setReward(getDouble(attrs, "reward"));
		contract.setCollateral(getDouble(attrs, "collateral"));
		contract.setBuyout(getDouble(attrs, "buyout"));
		contract.setVolume(getDouble(attrs, "volume"));
		return contract;
	}
}