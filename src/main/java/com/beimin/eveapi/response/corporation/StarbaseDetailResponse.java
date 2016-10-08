package com.beimin.eveapi.response.corporation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.beimin.eveapi.model.corporation.CombatSetting;
import com.beimin.eveapi.response.ApiResponse;

public class StarbaseDetailResponse extends ApiResponse {
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
    private final Map<Integer, Integer> fuelMap = new HashMap<>();

    public int getUsageFlags() {
        return usageFlags;
    }

    public void setUsageFlags(final int usageFlags) {
        this.usageFlags = usageFlags;
    }

    public int getDeployFlags() {
        return deployFlags;
    }

    public void setDeployFlags(final int deployFlags) {
        this.deployFlags = deployFlags;
    }

    public boolean isAllowCorporationMembers() {
        return allowCorporationMembers;
    }

    public void setAllowCorporationMembers(final boolean allowCorporationMembers) {
        this.allowCorporationMembers = allowCorporationMembers;
    }

    public boolean isAllowAllianceMembers() {
        return allowAllianceMembers;
    }

    public void setAllowAllianceMembers(final boolean allowAllianceMembers) {
        this.allowAllianceMembers = allowAllianceMembers;
    }

    public boolean isClaimSovereignty() {
        return claimSovereignty;
    }

    public void setClaimSovereignty(final boolean claimSovereignty) {
        this.claimSovereignty = claimSovereignty;
    }

    public CombatSetting getOnStandingDrop() {
        return onStandingDrop;
    }

    public void setOnStandingDrop(final CombatSetting onStandingDrop) {
        this.onStandingDrop = onStandingDrop;
    }

    public CombatSetting getOnStatusDrop() {
        return onStatusDrop;
    }

    public void setOnStatusDrop(final CombatSetting onStatusDrop) {
        this.onStatusDrop = onStatusDrop;
    }

    public CombatSetting getOnAggression() {
        return onAggression;
    }

    public void setOnAggression(final CombatSetting onAggression) {
        this.onAggression = onAggression;
    }

    public CombatSetting getOnCorporationWar() {
        return onCorporationWar;
    }

    public void setOnCorporationWar(final CombatSetting onCorporationWar) {
        this.onCorporationWar = onCorporationWar;
    }

    public void addFuelLevel(final int typeID, final int quantity) {
        fuelMap.put(typeID, quantity);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("usageFlags: ").append(usageFlags).append('\n').append("deployFlags: ").append(deployFlags).append('\n').append("allowCorporationMembers: ").append(allowCorporationMembers).append('\n').append("allowAllianceMembers: ").append(allowAllianceMembers)
                .append('\n').append("claimSovereignty: ").append(claimSovereignty).append("\n\n").append("Fuel Levels:\n");
        for (final Entry<Integer, Integer> entry : fuelMap.entrySet()) {
            result.append('\t').append(entry.getKey()).append(": ").append(entry.getValue()).append('\n');
        }
        return result.toString();
    }

    public Map<Integer, Integer> getFuelMap() {
        return fuelMap;
    }
}
