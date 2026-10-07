package ru.mirea.zhirkova.wilddex.data.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.zhirkova.wilddex.data.database.AppDatabase;
import ru.mirea.zhirkova.wilddex.data.database.ObservationDao;
import ru.mirea.zhirkova.wilddex.data.database.ObservationEntity;
import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.models.Observation;
import ru.mirea.zhirkova.wilddex.domain.repository.ObservationRepository;

public class ObservationRepositoryImpl
        implements ObservationRepository {

    private final ObservationDao observationDao;

    public ObservationRepositoryImpl(Context context) {
        observationDao = AppDatabase.getInstance(context).observationDao();
    }

    @Override
    public void saveObservation(Observation observation) {
        observationDao.insert(mapToEntity(observation));
    }

    @Override
    public List<Observation> getObservations(int userId) {

        List<Observation> result = new ArrayList<>();

        for (ObservationEntity entity : observationDao.getByUserId(userId)) {
            result.add(mapToDomain(entity));
        }

        return result;
    }

    @Override
    public void deleteObservation(int observationId) {

        observationDao.deleteById(observationId);
    }

    private ObservationEntity mapToEntity(Observation observation) {
        Animal animal = observation.getAnimal();

        return new ObservationEntity(
                observation.getId(),
                observation.getUserId(),
                animal.getId(),
                animal.getName(),
                animal.getScientificName(),
                animal.getImageUrl(),
                animal.getDescription(),
                observation.getDate()
        );
    }

    private Observation mapToDomain(ObservationEntity entity) {
        Animal animal = new Animal(
                entity.getAnimalId(),
                entity.getAnimalName(),
                entity.getAnimalScientificName(),
                entity.getAnimalImageUrl(),
                entity.getAnimalDescription()
        );

        return new Observation(
                entity.getId(),
                entity.getUserId(),
                animal,
                entity.getDate()
        );
    }
}
