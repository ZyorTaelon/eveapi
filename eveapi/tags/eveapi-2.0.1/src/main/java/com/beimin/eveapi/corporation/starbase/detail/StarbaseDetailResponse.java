package com.beimin.eveapi.corporation.starbase.detail;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.beimin.eveapi.ApiResponse;

public class StarbaseDetailResponse extends ApiResponse {
	// general settings
	private int usageFlags;
	private int deployFlags;
	private boolean allowCorporationMembers;
	private boolean allowAllianceMembers;
	private boolean claimSovereignty;

	// combat settings
	private ApiCombatSetting onStandingDrop;
	private ApiCombatSetting onStatusDrop;
	private ApiCombatSetting onAggression;
	private ApiCombatSetting onCorporationWar;
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

	public ApiCombatSetting getOnStandingDrop() {
		return onStandingDrop;
	}

	public void setOnStandingDrop(ApiCombatSetting onStandingDrop) {
		this.onStandingDrop = onStandingDrop;
	}

	public ApiCombatSetting getOnStatusDrop() {
		return onStatusDrop;
	}

	public void setOnStatusDrop(ApiCombatSetting onStatusDrop) {
		this.onStatusDrop = onStatusDrop;
	}

	public ApiCombatSetting getOnAggression() {
		return onAggression;
	}

	public void setOnAggression(ApiCombatSetting onAggression) {
		this.onAggression = onAggression;
	}

	public ApiCombatSetting getOnCorporationWar() {
		return onCorporationWar;
	}

	public void setOnCorporationWar(ApiCombatSetting onCorporationWar) {
		this.onCorporationWar = onCorporationWar;
	}

	public void addFuelLevel(FuelLevel fuelLevel) {
		fuelMap.put(fuelLevel.getTypeID(), fuelLevel.getQuantity());
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
