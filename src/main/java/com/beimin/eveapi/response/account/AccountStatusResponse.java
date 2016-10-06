package com.beimin.eveapi.response.account;

import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.response.ApiResponse;

public class AccountStatusResponse extends ApiResponse {
    private AccountStatus accountStatus;

    public AccountStatus get() {
        return accountStatus;
    }

    public void set(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}