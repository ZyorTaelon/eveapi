package com.beimin.eveapi.eve.errorlist;

public class ApiErrorListItem {
	private int errorCode; // ="100"
	private String errorText;

	// ="Expected before ref/trans ID = 0: wallet not previously loaded."
	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorText() {
		return errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}
}
