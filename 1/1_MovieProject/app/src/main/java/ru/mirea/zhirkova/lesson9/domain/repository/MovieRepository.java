package ru.mirea.zhirkova.lesson9.domain.repository;

import ru.mirea.zhirkova.lesson9.domain.models.Movie;

public interface MovieRepository {

    void saveMovie(Movie movie);

    Movie getFavoriteMovie();

}