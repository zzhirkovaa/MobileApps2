package ru.mirea.zhirkova.wilddex.domain.usecases;

import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.repository.AnimalRepository;

public class SearchAnimalsUseCase {

    private final AnimalRepository animalRepository;

    public SearchAnimalsUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> execute(String query) {
        return animalRepository.searchAnimals(query);
    }
}