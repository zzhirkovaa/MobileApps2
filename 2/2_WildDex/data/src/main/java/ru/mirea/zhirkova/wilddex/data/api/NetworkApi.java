package ru.mirea.zhirkova.wilddex.data.api;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;

public class NetworkApi {

    public List<Animal> getAnimals() {

        List<Animal> animals = new ArrayList<>();

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

        return animals;
    }
}