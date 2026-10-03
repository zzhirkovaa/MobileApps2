package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.repository.AnimalRepository;

public class GetAnimalDetailsUseCase {

    private final AnimalRepository animalRepository;

    public GetAnimalDetailsUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal execute(int animalId) {
        return animalRepository.getAnimalById(animalId);
    }
}