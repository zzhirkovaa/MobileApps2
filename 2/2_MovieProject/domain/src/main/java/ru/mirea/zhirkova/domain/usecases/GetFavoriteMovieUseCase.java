package ru.mirea.zhirkova.domain.usecases;

import ru.mirea.zhirkova.domain.models.Movie;
import ru.mirea.zhirkova.domain.repository.MovieRepository;

public class GetFavoriteMovieUseCase {

    private MovieRepository movieRepository;

    public GetFavoriteMovieUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie execute() {
        return movieRepository.getFavoriteMovie();
    }
}