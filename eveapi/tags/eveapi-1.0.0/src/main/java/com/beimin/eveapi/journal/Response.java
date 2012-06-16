package com.beimin.eveapi.journal;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<ApiJournalEntry> journalEntries = new ArrayList<ApiJournalEntry>();

	public void addJournalEntry(ApiJournalEntry entry) {
		journalEntries.add(entry);
	}

	public Collection<ApiJournalEntry> getJournalEntries() {
		return journalEntries;
	}
}