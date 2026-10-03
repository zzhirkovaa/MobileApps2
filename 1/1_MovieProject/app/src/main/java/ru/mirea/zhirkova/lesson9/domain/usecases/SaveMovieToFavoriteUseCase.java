package ru.mirea.zhirkova.lesson9.domain.usecases;

import ru.mirea.zhirkova.lesson9.domain.models.Movie;
import ru.mirea.zhirkova.lesson9.domain.repository.MovieRepository;

public class SaveMovieToFavoriteUseCase {

    private MovieRepository movieRepository;

    public SaveMovieToFavoriteUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void execute(Movie movie) {
        movieRepository.saveMovie(movie);
    }
}