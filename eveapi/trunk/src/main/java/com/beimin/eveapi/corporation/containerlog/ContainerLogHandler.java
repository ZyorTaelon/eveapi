package com.beimin.eveapi.corporation.containerlog;

import org.xml.sax.Attributes;

import com.beimin.eveapi.core.AbstractContentListHandler;

public class ContainerLogHandler extends AbstractContentListHandler<ContainerLogResponse, ApiContainerLog> {
	public ContainerLogHandler() {
		super(ContainerLogResponse.class);
	}

	@Override
	protected ApiContainerLog getItem(Attributes attrs) {
		ApiContainerLog log = new ApiContainerLog();
		log.setLogTime(getDate(attrs, "logTime"));
		log.setItemID(getLong(attrs, "itemID"));
		log.setItemTypeID(getInt(attrs, "itemTypeID"));
		log.setActorID(getLong(attrs, "actorID"));
		log.setActorName(getString(attrs, "actorName"));
		log.setFlag(getInt(attrs, "flag"));
		log.setLocationID(getInt(attrs, "locationID"));
		log.setAction(getString(attrs, "action"));
		log.setPasswordType(getPasswordType(attrs));
		log.setTypeID(getInt(attrs, "typeID"));
		log.setQuantity(getInt(attrs, "quantity"));
		log.setOldConfiguration(getInt(attrs, "oldConfiguration"));
		log.setNewConfiguration(getInt(attrs, "newConfiguration"));
		return log;
	}

	private PasswordType getPasswordType(Attributes attrs) {
		String string = getString(attrs, "passwordType");
		if (string.equals(""))
			return null;
		return PasswordType.valueOf(string.toUpperCase());
	}
}