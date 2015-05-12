package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.EveAccountBalance;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

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