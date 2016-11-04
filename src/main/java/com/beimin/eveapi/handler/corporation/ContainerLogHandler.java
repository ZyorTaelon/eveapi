package com.beimin.eveapi.handler.corporation;

import java.util.Locale;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.ContainerLog;
import com.beimin.eveapi.model.corporation.PasswordType;
import com.beimin.eveapi.response.corporation.ContainerLogResponse;

public class ContainerLogHandler extends AbstractContentListHandler<ContainerLogResponse, ContainerLog> {
    public ContainerLogHandler() {
        super(new ContainerLogResponse());
    }

    @Override
    protected ContainerLog getItem(final Attributes attrs) {
        final ContainerLog log = new ContainerLog();
        saveAttributes(ContainerLog.class, attrs);
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

    private PasswordType getPasswordType(final Attributes attrs) {
        final String string = getString(attrs, "passwordType");
        if (string.isEmpty()) {
            return null;
        }
        return PasswordType.valueOf(string.toUpperCase(Locale.ENGLISH));
    }
}
