package com.beimin.eveapi.handler.shared;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class AssetListHandler extends AbstractContentHandler<AssetListResponse> {
    private Asset currentAsset;
    private final Stack<Asset> stack = new Stack<Asset>();

    @Override
    public void startDocument() throws SAXException {
        setResponse(new AssetListResponse());
    }

    @Override
    protected void elementStart(final String uri, final String localName, final String qName, final Attributes attrs) throws SAXException {
        if ((currentAsset != null) && ELEMENT_ROWSET.equals(qName)) {
            stack.add(currentAsset);
            currentAsset = null;
        }
        if (ELEMENT_ROW.equals(qName)) {
            currentAsset = new Asset();
            saveFieldsCount(Asset.class, attrs);
            currentAsset.setItemID(getLong(attrs, "itemID"));
            currentAsset.setLocationID(getLong(attrs, "locationID"));
            currentAsset.setTypeID(getInt(attrs, "typeID"));
            currentAsset.setQuantity(getInt(attrs, "quantity"));
            currentAsset.setFlag(getInt(attrs, "flag"));
            currentAsset.setSingleton(getBoolean(attrs, "singleton"));
            currentAsset.setRawQuantity(getInt(attrs, "rawQuantity"));
            if (!stack.isEmpty()) {
                final Asset peek = stack.peek();
                peek.addAsset(currentAsset);
            }
        }
    }

    @Override
    protected void elementEnd(final String uri, final String localName, final String qName) throws SAXException {
        final AssetListResponse response = getResponse();
        if (ELEMENT_ROWSET.equals(qName) && !stack.isEmpty()) {
            final Asset asset = stack.pop();
            if (stack.isEmpty()) {
                response.add(asset);
                currentAsset = null;
            }
        }
        if ((currentAsset != null) && stack.isEmpty() && ELEMENT_ROW.equals(qName)) {
            response.add(currentAsset);
            currentAsset = null;
        }
    }
}
