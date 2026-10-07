package ru.mirea.zhirkova.domain.repository;

import ru.mirea.zhirkova.domain.models.Movie;

public interface MovieRepository {

    void saveMovie(Movie movie);

    Movie getFavoriteMovie();
}