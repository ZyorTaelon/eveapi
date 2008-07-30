package com.beimin.eveapi;

import java.io.UnsupportedEncodingException;

public interface ApiAuth {

	public abstract int getUserID();

	public abstract int getCharacterID();

	public abstract String getApiKey();

	public abstract String getUrlParams() throws UnsupportedEncodingException;

}