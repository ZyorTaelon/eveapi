package com.beimin.eveapi.response.eve;

import com.beimin.eveapi.model.eve.CertificateCategory;
import com.beimin.eveapi.response.ApiListResponse;

public class CertificateTreeResponse extends ApiListResponse<CertificateCategory> {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CertificateCategory certificateCategory : getAll())
            result.append(certificateCategory).append("\n");
        return result.toString();
    }
}