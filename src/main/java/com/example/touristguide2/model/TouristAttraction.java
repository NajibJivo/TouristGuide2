package com.example.touristguide2.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;
    private static int idCounter = 0;
    private List<String> tags;
    private String city;

    public TouristAttraction(String name, String description, String city, List<String> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = (tags != null) ? tags : new ArrayList<>();
        this.id = ++idCounter;


    }

    public TouristAttraction() {
        this.tags = (tags != null) ? tags : new ArrayList<>(); //  Hvis tags er null, initialiseres en tom liste
        this.id = ++idCounter; // Tildeler et unikt ID ved hver instansoprettelse,
        // sikrer, at alle objekter, som tilføjes, får et unikt ID uden at skulle manuelt sætte dem i repository'et.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public String getDescription() {
            return description;
    }

    public void setDescription(String description) {
            this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
