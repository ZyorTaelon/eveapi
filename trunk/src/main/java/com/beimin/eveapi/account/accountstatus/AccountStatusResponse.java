package com.beimin.eveapi.account.accountstatus;

import com.beimin.eveapi.core.ApiResponse;

public class AccountStatusResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private EveAccountStatus accountStatus;

	public EveAccountStatus get() {
		return accountStatus;
	}

	public void set(EveAccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
}