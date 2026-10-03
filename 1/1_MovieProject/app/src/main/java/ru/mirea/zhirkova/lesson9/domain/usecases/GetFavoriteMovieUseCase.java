package ru.mirea.zhirkova.lesson9.domain.usecases;

import ru.mirea.zhirkova.lesson9.domain.models.Movie;
import ru.mirea.zhirkova.lesson9.domain.repository.MovieRepository;

public class GetFavoriteMovieUseCase {

    private MovieRepository movieRepository;

    public GetFavoriteMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute() {
        return movieRepository.getFavoriteMovie();
    }
}