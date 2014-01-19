package com.beimin.eveapi.shared.contract.bids;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ContractIBidsHandler extends AbstractContentListHandler<ContractBidsResponse, EveContractBid> {
	public ContractIBidsHandler() {
		super(ContractBidsResponse.class);
	}

	@Override
	protected EveContractBid getItem(Attributes attrs) {
		EveContractBid contractItem = new EveContractBid();
		contractItem.setBidID(getLong(attrs, "bidID"));
		contractItem.setContractID(getLong(attrs, "contractID"));
		contractItem.setBidderID(getLong(attrs, "bidderID"));
		contractItem.setDateBid(getDate(attrs, "dateBid"));
		contractItem.setAmount(getDouble(attrs, "amount"));
		return contractItem;
	}
}