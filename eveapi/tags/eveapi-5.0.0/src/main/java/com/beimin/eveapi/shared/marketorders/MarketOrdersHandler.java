package com.beimin.eveapi.shared.marketorders;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MarketOrdersHandler extends AbstractContentListHandler<MarketOrdersResponse, ApiMarketOrder> {

	public MarketOrdersHandler() {
		super(MarketOrdersResponse.class);
	}

	@Override
	protected ApiMarketOrder getItem(Attributes attrs) {
		ApiMarketOrder order = new ApiMarketOrder();
		order.setOrderID(getLong(attrs, "orderID"));
		order.setAccountKey(getInt(attrs, "accountKey"));
		order.setBid(getInt(attrs, "bid"));
		order.setCharID(getLong(attrs, "charID"));
		order.setDuration(getInt(attrs, "duration"));
		order.setEscrow(getDouble(attrs, "escrow"));
		order.setIssued(getDate(attrs, "issued"));
		order.setMinVolume(getInt(attrs, "minVolume"));
		order.setOrderState(getInt(attrs, "orderState"));
		order.setPrice(getDouble(attrs, "price"));
		order.setRange(getInt(attrs, "range"));
		order.setStationID(getLong(attrs, "stationID"));
		order.setTypeID(getInt(attrs, "typeID"));
		order.setVolEntered(getInt(attrs, "volEntered"));
		order.setVolRemaining(getInt(attrs, "volRemaining"));
		return order;
	}
}