package com.beimin.eveapi.handler.eve;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.ErrorListItem;
import com.beimin.eveapi.response.eve.ErrorListResponse;

public class ErrorListHandler extends AbstractContentListHandler<ErrorListResponse, ErrorListItem> {
	public ErrorListHandler() {
		super(ErrorListResponse.class);
	}

	@Override
	protected ErrorListItem getItem(Attributes attrs) {
		ErrorListItem item = new ErrorListItem();
		item.setErrorText(getString(attrs, "errorText"));
		item.setErrorCode(getInt(attrs, "errorCode"));
		return item;
	}
}