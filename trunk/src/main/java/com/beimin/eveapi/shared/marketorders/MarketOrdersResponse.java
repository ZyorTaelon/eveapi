package com.beimin.eveapi.shared.marketorders;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class MarketOrdersResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiMarketOrder> marketOrders = new ArrayList<ApiMarketOrder>();

	public void addMarketOrder(ApiMarketOrder order) {
		marketOrders.add(order);
	}

	public Collection<ApiMarketOrder> getMarketOrders() {
		return marketOrders;
	}
}
