package com.beimin.eveapi.shared.assetlist;

import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.beimin.eveapi.core.AbstractContentHandler;

public class AssetListHandler extends AbstractContentHandler {
	private AssetListResponse response;
	private EveAsset<EveAsset<?>> currentAsset;
	private Stack<EveAsset<EveAsset<?>>> stack = new Stack<EveAsset<EveAsset<?>>>();

	@Override
	public void startDocument() throws SAXException {
		response = new AssetListResponse();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		if (qName.equals("rowset")) {
			if (currentAsset != null) {
				stack.add(currentAsset);
				currentAsset = null;
			}
		}
		if (qName.equals("row")) {
			currentAsset = new EveAsset<EveAsset<?>>();
			currentAsset.setItemID(getLong(attrs, "itemID"));
			currentAsset.setLocationID(getLong(attrs, "locationID"));
			currentAsset.setTypeID(getInt(attrs, "typeID"));
			currentAsset.setQuantity(getInt(attrs, "quantity"));
			currentAsset.setFlag(getInt(attrs, "flag"));
			currentAsset.setSingleton(getBoolean(attrs, "singleton"));
			currentAsset.setRawQuantity(getInt(attrs, "rawQuantity"));
			if (!stack.isEmpty()) {
				EveAsset<EveAsset<?>> peek = stack.peek();
				peek.addAsset(currentAsset);
			}
		}
		super.startElement(uri, localName, qName, attrs);
		accumulator.setLength(0);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("rowset") && !stack.isEmpty()) {
			EveAsset<EveAsset<?>> asset = stack.pop();
			if (stack.isEmpty()) {
				response.add(asset);
				currentAsset = null;
			}
		}
		if (qName.equals("row") && stack.isEmpty() && currentAsset != null) {
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