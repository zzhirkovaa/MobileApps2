package ru.mirea.zhirkova.wilddex.data.repository;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.models.RecognitionResult;
import ru.mirea.zhirkova.wilddex.domain.repository.RecognitionRepository;

public class RecognitionRepositoryImpl
        implements RecognitionRepository {

    @Override
    public RecognitionResult recognizeAnimal(String imagePath) {

        Animal animal = new Animal(
                1,
                "Кошка",
                "Felis catus",
                "",
                "Домашнее животное семейства кошачьих."
        );

        return new RecognitionResult(animal, 0.92f);
    }
}