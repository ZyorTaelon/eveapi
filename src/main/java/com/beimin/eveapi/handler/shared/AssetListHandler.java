package com.beimin.eveapi.handler.shared;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.handler.AbstractContentHandler;
import com.beimin.eveapi.model.shared.Asset;
import com.beimin.eveapi.response.shared.AssetListResponse;

public class AssetListHandler extends AbstractContentHandler {
    private AssetListResponse response;
    private Asset currentAsset;
    private Stack<Asset> stack = new Stack<Asset>();

    @Override
    public void startDocument() throws SAXException {
        response = new AssetListResponse();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (currentAsset != null && qName.equals("rowset")) {
            stack.add(currentAsset);
            currentAsset = null;
        }
        if (qName.equals("row")) {
            currentAsset = new Asset();
            currentAsset.setItemID(getLong(attrs, "itemID"));
            currentAsset.setLocationID(getLong(attrs, "locationID"));
            currentAsset.setTypeID(getInt(attrs, "typeID"));
            currentAsset.setQuantity(getInt(attrs, "quantity"));
            currentAsset.setFlag(getInt(attrs, "flag"));
            currentAsset.setSingleton(getBoolean(attrs, "singleton"));
            currentAsset.setRawQuantity(getInt(attrs, "rawQuantity"));
            if (!stack.isEmpty()) {
                Asset peek = stack.peek();
                peek.addAsset(currentAsset);
            }
        }
        super.startElement(uri, localName, qName, attrs);
        accumulator.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("rowset") && !stack.isEmpty()) {
            Asset asset = stack.pop();
            if (stack.isEmpty()) {
                response.add(asset);
                currentAsset = null;
            }
        }
        if (currentAsset != null && stack.isEmpty() && qName.equals("row")) {
            response.add(currentAsset);
            currentAsset = null;
        }
        super.endElement(uri, localName, qName);
    }

    @Override
    public AssetListResponse getResponse() {
        return response;
    }
}