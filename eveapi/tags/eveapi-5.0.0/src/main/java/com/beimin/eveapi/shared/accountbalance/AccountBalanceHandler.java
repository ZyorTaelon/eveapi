package com.beimin.eveapi.shared.accountbalance;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class AccountBalanceHandler extends AbstractContentListHandler<AccountBalanceResponse, EveAccountBalance> {

	public AccountBalanceHandler() {
		super(AccountBalanceResponse.class);
	}

	@Override
	protected EveAccountBalance getItem(Attributes attrs) {
		EveAccountBalance eveAccountBalance = new EveAccountBalance();
		eveAccountBalance.setAccountID(getInt(attrs, "accountID"));
		eveAccountBalance.setAccountKey(getInt(attrs, "accountKey"));
		eveAccountBalance.setBalance(getDouble(attrs, "balance"));
		return eveAccountBalance;
	}
}