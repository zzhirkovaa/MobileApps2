package ru.mirea.zhirkova.lesson9.data.repository;

import ru.mirea.zhirkova.lesson9.data.storage.MovieStorage;
import ru.mirea.zhirkova.domain.models.Movie;
import ru.mirea.zhirkova.domain.repository.MovieRepository;

import java.time.LocalDate;

public class MovieRepositoryImpl implements MovieRepository {

    private final MovieStorage movieStorage;

    public MovieRepositoryImpl(MovieStorage movieStorage) {
        this.movieStorage = movieStorage;
    }

    @Override
    public void saveMovie(Movie movie) {

        ru.mirea.zhirkova.lesson9.data.storage.models.Movie storageMovie =
                new ru.mirea.zhirkova.lesson9.data.storage.models.Movie(
                        movie.getId(),
                        movie.getName(),
                        LocalDate.now().toString()
                );

        movieStorage.save(storageMovie);
    }

    @Override
    public Movie getFavoriteMovie() {

        ru.mirea.zhirkova.lesson9.data.storage.models.Movie storageMovie =
                movieStorage.get();

        if (storageMovie == null) {
            return null;
        }

        return new Movie(
                storageMovie.getId(),
                storageMovie.getName()
        );
    }
}
