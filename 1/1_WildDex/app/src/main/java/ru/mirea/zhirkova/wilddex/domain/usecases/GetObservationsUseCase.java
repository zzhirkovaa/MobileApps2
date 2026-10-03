package ru.mirea.zhirkova.wilddex.domain.usecases;

import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Observation;
import ru.mirea.zhirkova.wilddex.domain.repository.ObservationRepository;

public class GetObservationsUseCase {

    private final ObservationRepository observationRepository;

    public GetObservationsUseCase(
            ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public List<Observation> execute(int userId) {
        return observationRepository.getObservations(userId);
    }
}