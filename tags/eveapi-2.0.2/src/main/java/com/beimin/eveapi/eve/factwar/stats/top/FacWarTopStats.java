package com.beimin.eveapi.eve.factwar.stats.top;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FacWarTopStats<K extends KillStat, VP extends VictoryPointsStat, E extends FacWarStat> {
	private final Map<String, StatsList<? extends E>> stats = new HashMap<String, StatsList<? extends E>>();

	public void addStatsList(StatsList<? extends E> statsList) {
		stats.put(statsList.getName(), statsList);
	}

	@SuppressWarnings("unchecked")
	public List<K> getKillsYesterday() {
		return (List<K>) stats.get("KillsYesterday");
	}

	@SuppressWarnings("unchecked")
	public List<K> getKillsLastWeek() {
		return (List<K>) stats.get("KillsLastWeek");
	}

	@SuppressWarnings("unchecked")
	public List<K> getKillsTotal() {
		return (List<K>) stats.get("KillsTotal");
	}

	@SuppressWarnings("unchecked")
	public List<VP> getVictoryPointsYesterday() {
		return (List<VP>) stats.get("VictoryPointsYesterday");
	}

	@SuppressWarnings("unchecked")
	public List<VP> getVictoryPointsLastWeek() {
		return (List<VP>) stats.get("VictoryPointsLastWeek");
	}

	@SuppressWarnings("unchecked")
	public List<VP> getVictoryPointsTotal() {
		return (List<VP>) stats.get("VictoryPointsTotal");
	}
}