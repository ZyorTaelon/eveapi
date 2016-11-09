package com.beimin.eveapi.handler.corporation;

import org.xml.sax.Attributes;

import com.beimin.eveapi.handler.AbstractContentListHandler;
import com.beimin.eveapi.model.corporation.Shareholder;
import com.beimin.eveapi.response.corporation.ShareholdersResponse;

public class ShareholdersHandler extends AbstractContentListHandler<ShareholdersResponse, Shareholder> {
    public ShareholdersHandler() {
        super(new ShareholdersResponse());
    }

    @Override
    protected Shareholder getItem(final Attributes attrs) {
        final Shareholder item = new Shareholder();
        saveAttributes(Shareholder.class, attrs);
        item.setShareholderCorporationID(getLong(attrs, "shareholderCorporationID"));
        item.setShareholderCorporationName(getString(attrs, "shareholderCorporationName"));
        item.setShareholderID(getLong(attrs, "shareholderID"));
        item.setShareholderName(getString(attrs, "shareholderName"));
        item.setShares(getInt(attrs, "shares"));
        return item;
    }
}
