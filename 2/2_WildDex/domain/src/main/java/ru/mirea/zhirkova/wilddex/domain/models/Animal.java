package ru.mirea.zhirkova.wilddex.domain.models;

public class Animal {

    private int id;
    private String name;
    private String scientificName;
    private String imageUrl;
    private String description;

    public Animal(int id, String name, String scientificName,
                  String imageUrl, String description) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}