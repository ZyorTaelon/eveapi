package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.ContractBid;
import com.beimin.eveapi.response.shared.ContractBidsResponse;

public class ContractIBidsHandler extends AbstractContentListHandler<ContractBidsResponse, ContractBid> {
	public ContractIBidsHandler() {
		super(ContractBidsResponse.class);
	}

	@Override
	protected ContractBid getItem(Attributes attrs) {
		ContractBid contractItem = new ContractBid();
		contractItem.setBidID(getLong(attrs, "bidID"));
		contractItem.setContractID(getLong(attrs, "contractID"));
		contractItem.setBidderID(getLong(attrs, "bidderID"));
		contractItem.setDateBid(getDate(attrs, "dateBid"));
		contractItem.setAmount(getDouble(attrs, "amount"));
		return contractItem;
	}
}