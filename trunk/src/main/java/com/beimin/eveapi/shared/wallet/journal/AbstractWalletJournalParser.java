package com.beimin.eveapi.shared.wallet.journal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;

public abstract class AbstractWalletJournalParser extends AbstractApiParser<WalletJournalResponse> {
	protected static final String JOURNAL_URL = "/WalletJournal";
	protected final Path path;

	public AbstractWalletJournalParser(Path path) {
		super(WalletJournalResponse.class, 2, JOURNAL_URL);
		this.path = path;
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiJournalEntry.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addJournalEntry");
		return digester;
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth auth, int accountKey) throws IOException, SAXException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		return getResponse(auth, path, extraParams);	
	}

	public WalletJournalResponse getWalletJournalResponse(ApiAuth auth, int accountKey, long beforeRefID) throws IOException, SAXException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		extraParams.put("beforeRefID", Long.toString(beforeRefID));
		return getResponse(auth, path, extraParams);	
	}
}