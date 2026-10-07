package ru.mirea.zhirkova.wilddex.domain.repository;

import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;

public interface AnimalRepository {

    List<Animal> getAnimals();

    List<Animal> searchAnimals(String query);

    Animal getAnimalById(int id);
}