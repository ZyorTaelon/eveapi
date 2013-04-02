package com.beimin.eveapi.shared.contract;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ContractsHandler extends AbstractContentListHandler<ContractsResponse, EveContract> {
	public ContractsHandler() {
		super(ContractsResponse.class);
	}

	@Override
	protected EveContract getItem(Attributes attrs) {
		EveContract contract = new EveContract();
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