package com.example.touristguide2.model;

public class TouristAttraction {
    private int id;
    private String name;
    private String description;
    private String location;
    private int categoryId;

    // 🟢 Default constructor kræves af Jackson for at kunne deserialisere JSON
    public TouristAttraction() {
    }

    // Konstruktør inkl. ID (bruges ved hentning fra databasen - findAll)
    public TouristAttraction(int id,String name, String description, String location, int categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.categoryId = categoryId;
    }

    // Konstruktør uden ID (bruges ved oprettelse af nye attraktioner)
    public TouristAttraction(String name, String description, String location, int categoryId) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
