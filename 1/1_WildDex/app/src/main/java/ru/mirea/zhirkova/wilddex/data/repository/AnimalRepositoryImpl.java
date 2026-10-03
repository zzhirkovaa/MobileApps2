package ru.mirea.zhirkova.wilddex.data.repository;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.repository.AnimalRepository;

public class AnimalRepositoryImpl implements AnimalRepository {

    private final List<Animal> animals = new ArrayList<>();

    public AnimalRepositoryImpl() {

        animals.add(new Animal(
                1,
                "Кошка",
                "Felis catus",
                "",
                "Домашнее животное семейства кошачьих."
        ));

        animals.add(new Animal(
                2,
                "Собака",
                "Canis familiaris",
                "",
                "Домашнее животное семейства псовых."
        ));

        animals.add(new Animal(
                3,
                "Лисица",
                "Vulpes vulpes",
                "",
                "Дикое животное семейства псовых."
        ));

        animals.add(new Animal(
                4,
                "Белка",
                "Sciurus vulgaris",
                "",
                "Небольшое млекопитающее семейства беличьих."
        ));
    }

    @Override
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    @Override
    public List<Animal> searchAnimals(String query) {

        List<Animal> result = new ArrayList<>();

        for (Animal animal : animals) {

            if (animal.getName().toLowerCase()
                    .contains(query.toLowerCase())) {

                result.add(animal);
            }
        }

        return result;
    }

    @Override
    public Animal getAnimalById(int id) {

        for (Animal animal : animals) {

            if (animal.getId() == id) {
                return animal;
            }
        }

        return null;
    }
}