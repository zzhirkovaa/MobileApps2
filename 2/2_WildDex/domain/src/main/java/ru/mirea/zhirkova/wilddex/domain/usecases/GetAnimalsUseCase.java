
package ru.mirea.zhirkova.wilddex.domain.usecases;

import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.repository.AnimalRepository;

public class GetAnimalsUseCase {

    private final AnimalRepository animalRepository;

    public GetAnimalsUseCase(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> execute() {
        return animalRepository.getAnimals();
    }
}