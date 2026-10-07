package ru.mirea.zhirkova.wilddex.domain.usecases;

import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Observation;
import ru.mirea.zhirkova.wilddex.domain.repository.ObservationRepository;

public class GetStatisticsUseCase {

    private final ObservationRepository observationRepository;

    public GetStatisticsUseCase(
            ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    public int execute(int userId) {
        List<Observation> observations =
                observationRepository.getObservations(userId);

        return observations.size();
    }
}