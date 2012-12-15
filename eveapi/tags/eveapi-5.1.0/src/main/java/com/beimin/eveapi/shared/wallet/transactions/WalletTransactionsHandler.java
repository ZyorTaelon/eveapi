package com.beimin.eveapi.shared.wallet.transactions;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class WalletTransactionsHandler extends
		AbstractContentListHandler<WalletTransactionsResponse, ApiWalletTransaction> {

	public WalletTransactionsHandler() {
		super(WalletTransactionsResponse.class);
	}

	@Override
	protected ApiWalletTransaction getItem(Attributes attrs) {
		ApiWalletTransaction item = new ApiWalletTransaction();
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