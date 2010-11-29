package com.beimin.eveapi.character.mail.bodies;

import java.util.HashSet;
import java.util.Set;

import com.beimin.eveapi.ApiResponse;

public class MailBodiesResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	Set<ApiMailBody> mailBodies = new HashSet<ApiMailBody>();

	public void add(ApiMailBody member) {
		mailBodies.add(member);
	}

	public Set<ApiMailBody> getMailBodies() {
		return mailBodies;
	}
}