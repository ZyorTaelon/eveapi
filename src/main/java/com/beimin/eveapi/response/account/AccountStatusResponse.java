package com.beimin.eveapi.response.account;

import com.beimin.eveapi.model.account.AccountStatus;
import com.beimin.eveapi.response.ApiResponse;

public class AccountStatusResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private AccountStatus accountStatus;

	public AccountStatus get() {
		return accountStatus;
	}

	public void set(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
}