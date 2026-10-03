package ru.mirea.zhirkova.wilddex.data.repository;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.Animal;
import ru.mirea.zhirkova.wilddex.domain.models.Observation;
import ru.mirea.zhirkova.wilddex.domain.repository.ObservationRepository;

public class ObservationRepositoryImpl
        implements ObservationRepository {

    private final List<Observation> observations =
            new ArrayList<>();

    public ObservationRepositoryImpl() {

        Animal cat = new Animal(
                1,
                "Кошка",
                "Felis catus",
                "",
                "Домашнее животное семейства кошачьих."
        );

        Animal dog = new Animal(
                2,
                "Собака",
                "Canis familiaris",
                "",
                "Домашнее животное семейства псовых."
        );

        observations.add(new Observation(
                1,
                1,
                cat,
                "20.09.2026"
        ));

        observations.add(new Observation(
                2,
                1,
                dog,
                "20.09.2026"
        ));

        observations.add(new Observation(
                3,
                1,
                cat,
                "20.09.2026"
        ));
    }

    @Override
    public void saveObservation(Observation observation) {
        observations.add(observation);
    }

    @Override
    public List<Observation> getObservations(int userId) {

        List<Observation> result = new ArrayList<>();

        for (Observation observation : observations) {

            if (observation.getUserId() == userId) {
                result.add(observation);
            }
        }

        return result;
    }

    @Override
    public void deleteObservation(int observationId) {

        for (int i = 0; i < observations.size(); i++) {

            if (observations.get(i).getId()
                    == observationId) {

                observations.remove(i);
                break;
            }
        }
    }
}