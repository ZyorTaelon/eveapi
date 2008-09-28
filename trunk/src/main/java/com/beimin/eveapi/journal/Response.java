package com.beimin.eveapi.journal;

import java.util.ArrayList;
import java.util.Collection;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	private final Collection<JournalEntry> journalEntries = new ArrayList<JournalEntry>();

	public void addJournalEntry(JournalEntry entry) {
		journalEntries.add(entry);
	}

	public Collection<JournalEntry> getJournalEntries() {
		return journalEntries;
	}
}