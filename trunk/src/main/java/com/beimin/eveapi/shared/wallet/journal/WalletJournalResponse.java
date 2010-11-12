package com.beimin.eveapi.shared.wallet.journal;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.ApiResponse;

public class WalletJournalResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final List<ApiJournalEntry> journalEntries = new ArrayList<ApiJournalEntry>();

	public void addJournalEntry(ApiJournalEntry entry) {
		journalEntries.add(entry);
	}

	public List<ApiJournalEntry> getJournalEntries() {
		return journalEntries;
	}
}