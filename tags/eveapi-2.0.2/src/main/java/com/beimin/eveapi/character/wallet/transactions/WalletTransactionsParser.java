package com.beimin.eveapi.character.wallet.transactions;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.shared.wallet.transactions.AbstractWalletTransactionsParser;
import com.beimin.eveapi.shared.wallet.transactions.WalletTransactionsResponse;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser{

	private WalletTransactionsParser() {
		super(Path.CHARACTER);
	}

	public static WalletTransactionsParser getInstance() {
		return new WalletTransactionsParser();
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth auth) throws IOException, SAXException {
		return getTransactionsResponse(auth, 1000);	
	}

	public WalletTransactionsResponse getTransactionsResponse(ApiAuth auth, long beforeTransID) throws IOException, SAXException {
			return getTransactionsResponse(auth, 1000, beforeTransID);	
	}
}