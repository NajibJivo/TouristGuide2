package com.example.touristguide2.model;

public enum TouristTowns {
    KOBENHAVN("København"),
    AARHUS("Aarhus"),
    ODENSE("Odense"),
    AALBORG("Aalborg");

    private final String displayName;

    TouristTowns(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

