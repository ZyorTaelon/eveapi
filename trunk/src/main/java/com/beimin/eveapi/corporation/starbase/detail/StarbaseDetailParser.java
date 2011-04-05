package com.beimin.eveapi.corporation.starbase.detail;


import org.apache.commons.digester.Digester;

import com.beimin.eveapi.core.AbstractApiParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public class StarbaseDetailParser extends AbstractApiParser<StarbaseDetailResponse> {
	public StarbaseDetailParser() {
		super(StarbaseDetailResponse.class, 2, ApiPath.CORPORATION, ApiPage.STARBASE_DETAIL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addBeanPropertySetter("eveapi/result/generalSettings/usageFlags");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/deployFlags");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/allowCorporationMembers");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/allowAllianceMembers");
		digester.addBeanPropertySetter("eveapi/result/generalSettings/claimSovereignty");

		digester.addObjectCreate("eveapi/result/combatSettings/onStandingDrop", ApiCombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onStandingDrop");
		digester.addSetNext("eveapi/result/combatSettings/onStandingDrop", "setOnStandingDrop");

		digester.addObjectCreate("eveapi/result/combatSettings/onStatusDrop", ApiCombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onStatusDrop");
		digester.addSetNext("eveapi/result/combatSettings/onStatusDrop", "setOnStatusDrop");

		digester.addObjectCreate("eveapi/result/combatSettings/onAggression", ApiCombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onAggression");
		digester.addSetNext("eveapi/result/combatSettings/onAggression", "setOnAggression");

		digester.addObjectCreate("eveapi/result/combatSettings/onCorporationWar", ApiCombatSetting.class);
		digester.addSetProperties("eveapi/result/combatSettings/onCorporationWar");
		digester.addSetNext("eveapi/result/combatSettings/onCorporationWar", "setOnCorporationWar");

		digester.addObjectCreate("eveapi/result/rowset/row", FuelLevel.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addFuelLevel");
		return digester;
	}

	public static StarbaseDetailParser getInstance() {
		return new StarbaseDetailParser();
	}

	public StarbaseDetailResponse getResponse(ApiAuth<?> auth, long itemID) throws ApiException {
		return super.getResponse(auth, "itemID", Long.toString(itemID));
	}
}
