package com.beimin.eveapi.parser.shared;

import java.util.HashMap;
import java.util.Map;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.handler.shared.KillMailHandler;
import com.beimin.eveapi.model.shared.Kill;
import com.beimin.eveapi.parser.ApiAuth;
import com.beimin.eveapi.parser.ApiPage;
import com.beimin.eveapi.parser.ApiPath;
import com.beimin.eveapi.response.shared.KillMailResponse;

public abstract class AbstractKillMailParser extends AbstractListParser<KillMailHandler, KillMailResponse, Kill> {
	protected AbstractKillMailParser(ApiPath path) {
		super(KillMailResponse.class, 2, path, ApiPage.KILL_MAIL, KillMailHandler.class);
	}

	@Override
	public KillMailResponse getResponse(ApiAuth auth) throws ApiException {
		return super.getResponse(auth);
	}

	/**
	 * @param auth
	 * @param fromID Optional kill ID to show data after
	 * @param rowCount Optional number to control the number of returned items (default 25, max 2560)
	 * @return
	 * @throws ApiException
	 */
	public KillMailResponse getResponse(final ApiAuth auth, Long fromID, Integer rowCount) throws ApiException {
		Map<String, String> extraParams = new HashMap<String, String>();
		if (fromID != null) {
			extraParams.put("fromID", Long.toString(fromID));
		}
		if (rowCount != null) {
			extraParams.put("rowCount", Integer.toString(rowCount));
		}
		return getResponse(auth, extraParams);
	}
}
