package com.example.touristguide2.model;

public enum TouristTowns {
    KOBENHAVN("København"),
    AARHUS("Aarhus"),
    ODENSE("Odense"),
    AALBORG("Aalborg"),
    ESBJERG("Esbjerg"),
    RANDERS("Randers"),
    KOLDING("Kolding"),
    HORSENS("Horsens"),
    VEJLE("Vejle"),
    ROSKILDE("Roskilde"),
    BORNHOLM("Bornholm"),
    HERNING("Herning"),
    HELSINGOR("Helsingør"),
    NAESTVED("Næstved"),
    SILKEBORG("Silkeborg"),
    FREDERICIA("Fredericia"),
    SØNDERBORG("Sønderborg");

    private final String displayName;

    TouristTowns(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

