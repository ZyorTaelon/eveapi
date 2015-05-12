package com.beimin.eveapi.handler.shared;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.shared.JournalEntry;
import com.beimin.eveapi.response.shared.WalletJournalResponse;

public class WalletJournalHandler extends AbstractContentListHandler<WalletJournalResponse, JournalEntry> {
	public WalletJournalHandler() {
		super(WalletJournalResponse.class);
	}

	@Override
	protected JournalEntry getItem(Attributes attrs) {
		JournalEntry item = new JournalEntry();
		item.setDate(getDate(attrs, "date"));
		item.setRefID(getLong(attrs, "refID"));
		item.setRefTypeID(getInt(attrs, "refTypeID"));
		item.setOwnerName1(getString(attrs, "ownerName1"));
		item.setOwnerID1(getLong(attrs, "ownerID1"));
		item.setOwnerName2(getString(attrs, "ownerName2"));
		item.setOwnerID2(getLong(attrs, "ownerID2"));
		item.setArgName1(getString(attrs, "argName1"));
		item.setArgID1(getLong(attrs, "argID1"));
		item.setAmount(getDouble(attrs, "amount"));
		item.setBalance(getDouble(attrs, "balance"));
		item.setReason(getString(attrs, "reason"));
		item.setTaxReceiverID(getLong(attrs, "taxReceiverID"));
		item.setTaxAmount(getDouble(attrs, "taxAmount"));
		return item;
	}
}