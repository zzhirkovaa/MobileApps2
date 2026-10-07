package ru.mirea.zhirkova.wilddex.domain.models;

public class RecognitionResult {

    private Animal animal;
    private float confidence;

    public RecognitionResult(Animal animal, float confidence) {
        this.animal = animal;
        this.confidence = confidence;
    }

    public Animal getAnimal() {
        return animal;
    }

    public float getConfidence() {
        return confidence;
    }
}