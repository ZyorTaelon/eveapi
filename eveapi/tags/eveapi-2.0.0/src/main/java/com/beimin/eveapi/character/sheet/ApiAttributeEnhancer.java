package com.beimin.eveapi.character.sheet;

public abstract class ApiAttributeEnhancer {
	private String augmentatorName;
	private int augmentatorValue;

	public String getAugmentatorName() {
		return augmentatorName;
	}

	public void setAugmentatorName(String augmentatorName) {
		this.augmentatorName = augmentatorName;
	}

	public int getAugmentatorValue() {
		return augmentatorValue;
	}

	public void setAugmentatorValue(int augmentatorValue) {
		this.augmentatorValue = augmentatorValue;
	}

	abstract public String getAttribute();
}