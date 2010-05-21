package com.beimin.eveapi.character.mailmessages;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class EveMaiResponse extends ApiResponse {
	Set<ApiEveMai> mails = new HashSet<ApiEveMai>();

	public void addApiMail(ApiEveMai member) {
		mails.add(member);
	}

	public Set<ApiEveMai> getApiMails() {
		return mails;
	}
}