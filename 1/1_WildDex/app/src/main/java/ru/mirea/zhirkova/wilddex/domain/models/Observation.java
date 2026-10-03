package ru.mirea.zhirkova.wilddex.domain.models;

public class Observation {

    private int id;
    private int userId;
    private Animal animal;
    private String date;

    public Observation(int id, int userId, Animal animal,
                       String date) {
        this.id = id;
        this.userId = userId;
        this.animal = animal;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public Animal getAnimal() {
        return animal;
    }

    public String getDate() {
        return date;
    }
}