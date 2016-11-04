package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.AccountBalance;
import com.beimin.eveapi.response.shared.AccountBalanceResponse;

public class AccountBalanceHandler extends AbstractContentListHandler<AccountBalanceResponse, AccountBalance> {

    public AccountBalanceHandler() {
        super(new AccountBalanceResponse());
    }

    @Override
    protected AccountBalance getItem(final Attributes attrs) {
        final AccountBalance accountBalance = new AccountBalance();
        saveAttributes(AccountBalance.class, attrs);
        accountBalance.setAccountID(getInt(attrs, "accountID"));
        accountBalance.setAccountKey(getInt(attrs, "accountKey"));
        accountBalance.setBalance(getDouble(attrs, "balance"));
        return accountBalance;
    }
}
