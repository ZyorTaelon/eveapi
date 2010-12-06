package com.beimin.eveapi.eve.reftypes;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.core.ApiResponse;

public class RefTypesResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiRefType> refTypes = new ArrayList<ApiRefType>();

	public void addRefType(ApiRefType refType) {
		refTypes.add(refType);
	}

	public Collection<ApiRefType> getRefTypes() {
		return refTypes;
	}
}