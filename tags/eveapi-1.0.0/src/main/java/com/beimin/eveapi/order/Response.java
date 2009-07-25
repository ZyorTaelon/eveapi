package com.beimin.eveapi.order;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiMarketOrder> marketOrders = new ArrayList<ApiMarketOrder>();

	public void addMarketOrder(ApiMarketOrder order) {
		marketOrders.add(order);
	}

	public Collection<ApiMarketOrder> getMarketOrders() {
		return marketOrders;
	}
}
