package com.beimin.eveapi.starbase;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.beimin.eveapi.ApiResponse;

public class ListResponse extends ApiResponse {
	private final Collection<Starbase> starbases = new HashSet<Starbase>();

	public void addStarbase(Starbase starbase) {
		starbases.add(starbase);
	}

	public Collection<Starbase> getStarbases() {
		return starbases;
	}

	private void addTypeId(int itemID, Map<Integer, Integer> typeIds) {
		int amount = 0;
		if (typeIds.containsKey(itemID)) {
			amount = typeIds.get(itemID);
			typeIds.remove(itemID);
		}
		typeIds.put(itemID, amount + 1);
	}

	@Override
	public String toString() {
		String result = "Current time: " + getCurrentTime() + "\nCached Untill: " + getCachedUntil() + "\nWe currently have " + starbases.size()
				+ " starbases in space\n\n";
		Map<Integer, Integer> typeIds = new HashMap<Integer, Integer>();
		for (Starbase starbase : starbases) {
			addTypeId(starbase.getTypeID(), typeIds);
			result += starbase + "\n";
		}
		result += "\n";
		for (Entry<Integer, Integer> entry : typeIds.entrySet()) {
			result += entry.getKey() + " = " + entry.getValue() + "\n";
		}
		return result;
	}
}
