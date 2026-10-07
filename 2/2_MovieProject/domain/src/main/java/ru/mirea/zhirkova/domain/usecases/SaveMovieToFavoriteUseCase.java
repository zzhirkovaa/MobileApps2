package ru.mirea.zhirkova.domain.usecases;

import ru.mirea.zhirkova.domain.models.Movie;
import ru.mirea.zhirkova.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {

    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void execute(Movie movie) {
        movieRepository.saveMovie(movie);
    }
}