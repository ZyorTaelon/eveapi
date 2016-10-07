package com.beimin.eveapi.model.shared;

public abstract class AbstractMedal {
    private int medalID;
    private String title;
    private String description;

    public int getMedalID() {
        return medalID;
    }

    public void setMedalID(final int medalID) {
        this.medalID = medalID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }
}