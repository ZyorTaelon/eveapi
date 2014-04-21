package com.beimin.eveapi.response.corporation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.beimin.eveapi.model.corporation.CombatSetting;
import com.beimin.eveapi.response.ApiResponse;

public class StarbaseDetailResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	// general settings
	private int usageFlags;
	private int deployFlags;
	private boolean allowCorporationMembers;
	private boolean allowAllianceMembers;
	private boolean claimSovereignty;

	// combat settings
	private CombatSetting onStandingDrop;
	private CombatSetting onStatusDrop;
	private CombatSetting onAggression;
	private CombatSetting onCorporationWar;
	Map<Integer, Integer> fuelMap = new HashMap<Integer, Integer>();

	public int getUsageFlags() {
		return usageFlags;
	}

	public void setUsageFlags(int usageFlags) {
		this.usageFlags = usageFlags;
	}

	public int getDeployFlags() {
		return deployFlags;
	}

	public void setDeployFlags(int deployFlags) {
		this.deployFlags = deployFlags;
	}

	public boolean isAllowCorporationMembers() {
		return allowCorporationMembers;
	}

	public void setAllowCorporationMembers(boolean allowCorporationMembers) {
		this.allowCorporationMembers = allowCorporationMembers;
	}

	public boolean isAllowAllianceMembers() {
		return allowAllianceMembers;
	}

	public void setAllowAllianceMembers(boolean allowAllianceMembers) {
		this.allowAllianceMembers = allowAllianceMembers;
	}

	public boolean isClaimSovereignty() {
		return claimSovereignty;
	}

	public void setClaimSovereignty(boolean claimSovereignty) {
		this.claimSovereignty = claimSovereignty;
	}

	public CombatSetting getOnStandingDrop() {
		return onStandingDrop;
	}

	public void setOnStandingDrop(CombatSetting onStandingDrop) {
		this.onStandingDrop = onStandingDrop;
	}

	public CombatSetting getOnStatusDrop() {
		return onStatusDrop;
	}

	public void setOnStatusDrop(CombatSetting onStatusDrop) {
		this.onStatusDrop = onStatusDrop;
	}

	public CombatSetting getOnAggression() {
		return onAggression;
	}

	public void setOnAggression(CombatSetting onAggression) {
		this.onAggression = onAggression;
	}

	public CombatSetting getOnCorporationWar() {
		return onCorporationWar;
	}

	public void setOnCorporationWar(CombatSetting onCorporationWar) {
		this.onCorporationWar = onCorporationWar;
	}

	public void addFuelLevel(int typeID, int quantity) {
		fuelMap.put(typeID, quantity);
	}

	@Override
	public String toString() {
		String result = "";
		result += "usageFlags: " + usageFlags + "\n";
		result += "deployFlags: " + deployFlags + "\n";
		result += "allowCorporationMembers: " + allowCorporationMembers + "\n";
		result += "allowAllianceMembers: " + allowAllianceMembers + "\n";
		result += "claimSovereignty: " + claimSovereignty + "\n";
		result += "\n";
		result += "Fuel Levels:\n";
		for (Entry<Integer, Integer> entry : fuelMap.entrySet()) {
			result += "\t" + entry.getKey() + ": " + entry.getValue() + "\n";
		}
		return result;
	}

	public Map<Integer, Integer> getFuelMap() {
		return fuelMap;
	}
}
