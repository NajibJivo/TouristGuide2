package com.example.touristguide2.model;

    public enum TouristTags {
        FORLYSTELSER("Forlystelser"),
        HISTORIE("Historie"),
        UNDERHOLDNING("Underholdning"),
        GUIDED_TUR("Guidet tur"),
        KULTUR("Kultur"),
        SEJLTUR("Sejltur"),
        STATUE("Statue"),
        MILJOE_VENLIG("Miljø venlig"),
        BYVANDRING("Byvandring"),
        HAVN("Havneområde"),
        ALTERNATIV("Alternativ"),
        KREATIV("Kreativ"),
        SAMFUND("Samfund"),
        KONGELIG("Kongelig"),
        MUSEUM("Museum"),
        SLOT("Slot"),
        CAFÉER("Caféer");




        private final String displayName;

        TouristTags(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
