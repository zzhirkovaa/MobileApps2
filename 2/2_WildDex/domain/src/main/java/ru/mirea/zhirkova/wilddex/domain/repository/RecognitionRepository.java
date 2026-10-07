
package ru.mirea.zhirkova.wilddex.domain.repository;

import ru.mirea.zhirkova.wilddex.domain.models.RecognitionResult;

public interface RecognitionRepository {

    RecognitionResult recognizeAnimal(String imagePath);

}