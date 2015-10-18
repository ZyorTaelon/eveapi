package com.beimin.eveapi.response.eve;

import com.beimin.eveapi.model.eve.CertificateCategory;
import com.beimin.eveapi.response.ApiListResponse;

public class CertificateTreeResponse extends ApiListResponse<CertificateCategory> {
	@Override
	public String toString() {
		String result = "";
		for (CertificateCategory certificateCategory : getAll())
			result += certificateCategory + "\n";
		return result;
	}
}