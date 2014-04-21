package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.WalletTransaction;
import com.beimin.eveapi.response.shared.WalletTransactionsResponse;

public class WalletTransactionsHandler extends
		AbstractContentListHandler<WalletTransactionsResponse, WalletTransaction> {

	public WalletTransactionsHandler() {
		super(WalletTransactionsResponse.class);
	}

	@Override
	protected WalletTransaction getItem(Attributes attrs) {
		WalletTransaction item = new WalletTransaction();
		item.setTransactionDateTime(getDate(attrs, "transactionDateTime"));
		item.setTransactionID(getLong(attrs, "transactionID"));
		item.setQuantity(getInt(attrs, "quantity"));
		item.setTypeName(getString(attrs, "typeName"));
		item.setTypeID(getInt(attrs, "typeID"));
		item.setPrice(getDouble(attrs, "price"));
		item.setClientID(getLong(attrs, "clientID"));
		item.setClientName(getString(attrs, "clientName"));
		item.setCharacterID(getLong(attrs, "characterID"));
		item.setCharacterName(getString(attrs, "characterName"));
		item.setStationID(getInt(attrs, "stationID"));
		item.setStationName(getString(attrs, "stationName"));
		item.setTransactionType(getString(attrs, "transactionType"));
		item.setTransactionFor(getString(attrs, "transactionFor"));
		return item;
	}
}