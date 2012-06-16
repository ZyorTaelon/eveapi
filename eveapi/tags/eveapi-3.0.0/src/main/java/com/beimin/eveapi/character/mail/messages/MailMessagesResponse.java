package com.beimin.eveapi.character.mail.messages;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.core.ApiResponse;

public class MailMessagesResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	Set<ApiMailMessage> mails = new HashSet<ApiMailMessage>();

	public void addApiMail(ApiMailMessage member) {
		mails.add(member);
	}

	public Set<ApiMailMessage> getApiMails() {
		return mails;
	}
}