package com.beimin.eveapi.response.eve;

import com.beimin.eveapi.model.eve.CertificateCategory;
import com.beimin.eveapi.response.ApiListResponse;

public class CertificateTreeResponse extends ApiListResponse<CertificateCategory> {
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (final CertificateCategory certificateCategory : getAll()) {
            result.append(certificateCategory).append("\n");
        }
        return result.toString();
    }
}

