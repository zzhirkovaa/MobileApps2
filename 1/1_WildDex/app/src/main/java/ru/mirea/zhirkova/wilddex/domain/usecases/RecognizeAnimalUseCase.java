package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.models.RecognitionResult;
import ru.mirea.zhirkova.wilddex.domain.repository.RecognitionRepository;

public class RecognizeAnimalUseCase {

    private final RecognitionRepository recognitionRepository;

    public RecognizeAnimalUseCase(
            RecognitionRepository recognitionRepository) {
        this.recognitionRepository = recognitionRepository;
    }

    public RecognitionResult execute(String imagePath) {
        return recognitionRepository.recognizeAnimal(imagePath);
    }
}