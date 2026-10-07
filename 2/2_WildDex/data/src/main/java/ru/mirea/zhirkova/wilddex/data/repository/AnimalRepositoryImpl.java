package ru.mirea.zhirkova.wilddex.data.repository;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.zhirkova.wilddex.data.api.NetworkApi;
import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.repository.AnimalRepository;

public class AnimalRepositoryImpl implements AnimalRepository {

    private final NetworkApi networkApi;

    public AnimalRepositoryImpl() {
        networkApi = new NetworkApi();
    }

    @Override
    public List<Animal> getAnimals() {
        return networkApi.getAnimals();
    }

    @Override
    public List<Animal> searchAnimals(String query) {

        List<Animal> result = new ArrayList<>();

        for (Animal animal : networkApi.getAnimals()) {
            if (animal.getName().toLowerCase()
                    .contains(query.toLowerCase())) {
                result.add(animal);
            }
        }

        return result;
    }

    @Override
    public Animal getAnimalById(int id) {

        for (Animal animal : networkApi.getAnimals()) {
            if (animal.getId() == id) {
                return animal;
            }
        }

        return null;
    }
}