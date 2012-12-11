package com.beimin.eveapi.shared.contract.items;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ContractItemsHandler extends AbstractContentListHandler<ContractItemsResponse, EveContractItem> {
	public ContractItemsHandler() {
		super(ContractItemsResponse.class);
	}

	@Override
	protected EveContractItem getItem(Attributes attrs) {
		EveContractItem contractItem = new EveContractItem();
		contractItem.setRecordID(getLong(attrs, "recordID"));
		contractItem.setTypeID(getInt(attrs, "typeID"));
		contractItem.setQuantity(getLong(attrs, "quantity"));
		contractItem.setSingleton(getBoolean(attrs, "singleton"));
		contractItem.setIncluded(getBoolean(attrs, "included"));
		return contractItem;
	}
}