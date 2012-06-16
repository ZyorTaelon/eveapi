package com.beimin.eveapi.character.wallet.journal;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.shared.wallet.journal.AbstractWalletJournalParser;
import com.beimin.eveapi.shared.wallet.journal.WalletJournalResponse;

public class WalletJournalParser extends AbstractWalletJournalParser{

	private WalletJournalParser() {
		super(Path.CHARACTER);
	}

	public static WalletJournalParser getInstance() {
		return new WalletJournalParser();
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth auth) throws IOException, SAXException {
		return getWalletJournalResponse(auth, 1000);	
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth auth, long beforeRefID) throws IOException, SAXException {
		return getWalletJournalResponse(auth, 1000, beforeRefID);
	}
}
