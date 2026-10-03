package ru.mirea.zhirkova.lesson9.data.repository;

import android.content.Context;

import ru.mirea.zhirkova.lesson9.data.storage.MovieStorage;
import ru.mirea.zhirkova.lesson9.domain.models.Movie;
import ru.mirea.zhirkova.lesson9.domain.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

    private final MovieStorage movieStorage;

    public MovieRepositoryImpl(Context context) {
        movieStorage = new MovieStorage(context);
    }

    @Override
    public void saveMovie(Movie movie) {
        movieStorage.saveMovie(movie.getName());
    }

    @Override
    public Movie getFavoriteMovie() {
        String name = movieStorage.getMovie();

        if (name.isEmpty()) {
            return null;
        }

        return new Movie(1, name);
    }
}