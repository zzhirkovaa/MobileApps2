
package ru.mirea.zhirkova.wilddex.domain.repository;

import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Observation;

public interface ObservationRepository {

    void saveObservation(Observation observation);

    List<Observation> getObservations(int userId);

    void deleteObservation(int observationId);
}