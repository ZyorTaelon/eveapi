package com.betterbe.eveapi.starbase;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.betterbe.eveapi.ApiResponse;

public class ListResponse extends ApiResponse {
	private final Collection<Starbase> starbases = new HashSet<Starbase>();

	public void addStarbase(Starbase starbase) {
		starbases.add(starbase);
	}

	public Collection<Starbase> getStarbases() {
		return starbases;
	}

	@Override
	public String toString() {
		// Caldari Control Tower Medium = 1
		// Amarr Control Tower Small = 2
		// Caldari Control Tower = 2
		// Domination Control Tower = 4
		// Gallente Control Tower = 4
		// Domination Control Tower Medium = 7
		// Minmatar Control Tower Small = 10
		// Minmatar Control Tower = 21

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

	private void addTypeId(int itemID, Map<Integer, Integer> typeIds) {
		int amount = 0;
		if (typeIds.containsKey(itemID)) {
			amount = typeIds.get(itemID);
			typeIds.remove(itemID);
		}
		typeIds.put(itemID, amount + 1);
	}
}
