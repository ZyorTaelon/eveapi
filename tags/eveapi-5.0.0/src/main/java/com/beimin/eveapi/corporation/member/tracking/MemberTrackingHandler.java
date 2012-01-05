package com.beimin.eveapi.corporation.member.tracking;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class MemberTrackingHandler extends AbstractContentListHandler<MemberTrackingResponse, ApiMember> {

	public MemberTrackingHandler() {
		super(MemberTrackingResponse.class);
	}

	@Override
	protected ApiMember getItem(Attributes attrs) {
		ApiMember member = new ApiMember();
		member.setCharacterID(getLong(attrs, "characterID"));
		member.setBase(getString(attrs, "base"));
		member.setBaseID(getInt(attrs, "baseID"));
		member.setGrantableRoles(getInt(attrs, "grantableRoles"));
		member.setLocation(getString(attrs, "location"));
		member.setLocationID(getInt(attrs, "locationID"));
		member.setLogoffDateTime(getDate(attrs, "logoffDateTime"));
		member.setLogonDateTime(getDate(attrs, "logonDateTime"));
		member.setName(getString(attrs, "name"));
		member.setRoles(getLong(attrs, "roles"));
		member.setShipType(getString(attrs, "shipType"));
		member.setShipTypeID(getInt(attrs, "shipTypeID"));
		member.setTitle(getString(attrs, "title"));
		return member;
	}
}