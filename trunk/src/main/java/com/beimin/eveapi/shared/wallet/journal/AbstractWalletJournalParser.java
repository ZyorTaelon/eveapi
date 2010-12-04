package com.beimin.eveapi.shared.wallet.journal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

import com.beimin.eveapi.AbstractApiParser;
import com.beimin.eveapi.ApiAuth;
import com.beimin.eveapi.ApiPage;
import com.beimin.eveapi.ApiPath;

public abstract class AbstractWalletJournalParser extends AbstractApiParser<WalletJournalResponse> {
	public AbstractWalletJournalParser(ApiPath path) {
		super(WalletJournalResponse.class, 2, path, ApiPage.WALLET_JOURNAL);
	}

	@Override
	protected Digester getDigester() {
		Digester digester = super.getDigester();
		digester.addObjectCreate("eveapi/result/rowset/row", ApiJournalEntry.class);
		digester.addSetProperties("eveapi/result/rowset/row");
		digester.addSetNext("eveapi/result/rowset/row", "addJournalEntry");
		return digester;
	}

	public WalletJournalResponse getResponse(ApiAuth auth, int accountKey) throws IOException, SAXException {
		return getResponse(auth, "accountKey", Integer.toString(accountKey));
	}

	public WalletJournalResponse getResponse(ApiAuth auth, int accountKey, long beforeRefID) throws IOException, SAXException {
		Map<String, String> extraParams = new HashMap<String, String>();
		extraParams.put("accountKey", Integer.toString(accountKey));
		extraParams.put("beforeRefID", Long.toString(beforeRefID));
		return getResponse(auth, extraParams);
	}
}