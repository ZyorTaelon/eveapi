package com.beimin.eveapi.parser.shared;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.KillLogHandler;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.KillLogResponse;

public abstract class AbstractKillLogParser extends AbstractListParser<KillLogHandler, KillLogResponse, Kill> {
	protected AbstractKillLogParser(ApiPath path) {
		super(KillLogResponse.class, 1, path, ApiPage.KILL_LOG, KillLogHandler.class);
	}

	@Override
	public KillLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}