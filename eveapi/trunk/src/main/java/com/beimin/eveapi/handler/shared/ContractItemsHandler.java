package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.ContractItem;
import com.beimin.eveapi.response.shared.ContractItemsResponse;

public class ContractItemsHandler extends AbstractContentListHandler<ContractItemsResponse, ContractItem> {
	public ContractItemsHandler() {
		super(ContractItemsResponse.class);
	}

	@Override
	protected ContractItem getItem(Attributes attrs) {
		ContractItem contractItem = new ContractItem();
		contractItem.setRecordID(getLong(attrs, "recordID"));
		contractItem.setTypeID(getInt(attrs, "typeID"));
		contractItem.setQuantity(getLong(attrs, "quantity"));
		contractItem.setRawQuantity(getLong(attrs, "rawQuantity"));
		contractItem.setSingleton(getBoolean(attrs, "singleton"));
		contractItem.setIncluded(getBoolean(attrs, "included"));
		return contractItem;
	}
}