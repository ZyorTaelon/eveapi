package com.beimin.eveapi.response.account;

import com.beimin.eveapi.model.account.ApiKeyInfo;
import com.beimin.eveapi.response.ApiResponse;

public class ApiKeyInfoResponse extends ApiResponse {
    private ApiKeyInfo apiKeyInfo;

    public ApiKeyInfo getApiKeyInfo() {
        return apiKeyInfo;
    }

    public void set(final ApiKeyInfo apiKeyInfo) {
        this.apiKeyInfo = apiKeyInfo;
    }
}

