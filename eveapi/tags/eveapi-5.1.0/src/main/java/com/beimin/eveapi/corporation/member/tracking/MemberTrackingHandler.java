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
		member.setName(getString(attrs, "name"));
		member.setBase(getString(attrs, "base"));
		member.setBaseID(getInt(attrs, "baseID"));
		member.setTitle(getString(attrs, "title"));
		
		if( attrs.getValue("grantableRoles") != null )
			member.setGrantableRoles(getInt(attrs, "grantableRoles"));
		
		if( attrs.getValue("location") != null )
			member.setLocation(getString(attrs, "location"));
		
		if( attrs.getValue("locationID") != null )
			member.setLocationID(getInt(attrs, "locationID"));
		
		if( attrs.getValue("logoffDateTime") != null )
			member.setLogoffDateTime(getDate(attrs, "logoffDateTime"));
		
		if( attrs.getValue("logonDateTime") != null )
			member.setLogonDateTime(getDate(attrs, "logonDateTime"));
		
		if( attrs.getValue("startDateTime") != null )
			member.setStartDateTime(getDate(attrs, "startDateTime"));
		
		if( attrs.getValue("roles") != null )
			member.setRoles(getLong(attrs, "roles"));
		
		if( attrs.getValue("shipType") != null )
			member.setShipType(getString(attrs, "shipType"));
		
		if( attrs.getValue("shipTypeID") != null )
			member.setShipTypeID(getInt(attrs, "shipTypeID"));
		
		return member;
	}
}