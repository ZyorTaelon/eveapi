package com.beimin.eveapi.shared.killlog;

import com.beimin.eveapi.core.AbstractListParser;
import com.beimin.eveapi.core.ApiAuth;
import com.beimin.eveapi.core.ApiException;
import com.beimin.eveapi.core.ApiPage;
import com.beimin.eveapi.core.ApiPath;

public abstract class AbstractKillLogParser extends AbstractListParser<KillLogHandler, KillLogResponse, ApiKill> {
	protected AbstractKillLogParser(ApiPath path) {
		super(KillLogResponse.class, 1, path, ApiPage.KILL_LOG, KillLogHandler.class);
	}

	@Override
	public KillLogResponse getResponse(ApiAuth<?> auth) throws ApiException {
		return super.getResponse(auth);
	}
}