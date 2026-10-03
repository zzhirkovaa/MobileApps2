package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.models.Observation;
import ru.mirea.zhirkova.wilddex.domain.repository.ObservationRepository;

public class SaveObservationUseCase {

    private final ObservationRepository observationRepository;

    public SaveObservationUseCase(
            ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public void execute(Observation observation) {
        observationRepository.saveObservation(observation);
    }
}