package com.example.touristguide2.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private List<TouristTags> tags;
    private TouristTowns town;
    private String image;

    public TouristAttraction(String name, String description, TouristTowns town, List<TouristTags> tags) {
        this.name = name;
        this.description = description;
        this.town = town;
        this.tags = (tags != null) ? tags : new ArrayList<>();



    }

    public TouristAttraction() {
        this.tags = new ArrayList<>();
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

    public List<TouristTags> getTags() {
        return tags;
    }

    public void setTags(List<TouristTags> tags) {
        this.tags = tags;
    }

    public TouristTowns getTown() {
        return town;
    }

    public void setTown(TouristTowns town) {
        this.town = town;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
