package com.beimin.eveapi.mail;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class Response extends ApiResponse {
	Set<ApiMail> mails = new HashSet<ApiMail>();

	public void addApiMail(ApiMail member) {
		mails.add(member);
	}

	public Set<ApiMail> getApiMails() {
		return mails;
	}
}