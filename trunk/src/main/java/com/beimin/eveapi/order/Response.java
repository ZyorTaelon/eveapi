package com.beimin.eveapi.order;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<MarketOrder> marketOrders = new ArrayList<MarketOrder>();

	public void addMarketOrder(MarketOrder order) {
		marketOrders.add(order);
	}

	public Collection<MarketOrder> getMarketOrders() {
		return marketOrders;
	}
}
