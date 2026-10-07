package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.repository.ObservationRepository;

public class DeleteObservationUseCase {

    private final ObservationRepository observationRepository;

    public DeleteObservationUseCase(
            ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void execute(int observationId) {
        observationRepository.deleteObservation(observationId);
    }
}