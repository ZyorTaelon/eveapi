package com.beimin.eveapi.model.pilot;

public abstract class AttributeEnhancer {
    private String augmentatorName;
    private int augmentatorValue;

    public String getAugmentatorName() {
        return augmentatorName;
    }

    public void setAugmentatorName(final String augmentatorName) {
        this.augmentatorName = augmentatorName;
    }

    public int getAugmentatorValue() {
        return augmentatorValue;
    }

    public void setAugmentatorValue(final int augmentatorValue) {
        this.augmentatorValue = augmentatorValue;
    }

    abstract public String getAttribute();
}
