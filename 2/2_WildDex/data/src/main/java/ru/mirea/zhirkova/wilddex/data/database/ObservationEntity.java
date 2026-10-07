package ru.mirea.zhirkova.wilddex.data.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "observations")
public class ObservationEntity {

    @PrimaryKey
    private int id;

    private int userId;
    private int animalId;
    private String animalName;
    private String animalScientificName;
    private String animalImageUrl;
    private String animalDescription;
    private String date;

    public ObservationEntity(int id, int userId, int animalId,
                             String animalName, String animalScientificName,
                             String animalImageUrl, String animalDescription,
                             String date) {
        this.id = id;
        this.userId = userId;
        this.animalId = animalId;
        this.animalName = animalName;
        this.animalScientificName = animalScientificName;
        this.animalImageUrl = animalImageUrl;
        this.animalDescription = animalDescription;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalScientificName() {
        return animalScientificName;
    }

    public String getAnimalImageUrl() {
        return animalImageUrl;
    }

    public String getAnimalDescription() {
        return animalDescription;
    }

    public String getDate() {
        return date;
    }
}
