package ru.mirea.zhirkova.lesson9.data.storage;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.zhirkova.lesson9.data.storage.models.Movie;

public class SharedPrefMovieStorage implements MovieStorage {

    private static final String PREF_NAME = "movie_preferences";
    private static final String KEY_MOVIE_NAME = "favorite_movie";
    private static final String KEY_MOVIE_ID = "favorite_movie_id";
    private static final String KEY_MOVIE_DATE = "favorite_movie_date";

    private final SharedPreferences sharedPreferences;

    public SharedPrefMovieStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );
    }

    @Override
    public Movie get() {
        String movieName =
                sharedPreferences.getString(KEY_MOVIE_NAME, "");

        if (movieName.isEmpty()) {
            return null;
        }

        int movieId = sharedPreferences.getInt(KEY_MOVIE_ID, 1);
        String movieDate = sharedPreferences.getString(KEY_MOVIE_DATE, "");
        return new Movie(movieId, movieName, movieDate);
    }

    @Override
    public boolean save(Movie movie) {
        sharedPreferences.edit()
                .putString(KEY_MOVIE_NAME, movie.getName())
                .putInt(KEY_MOVIE_ID, movie.getId())
                .putString(KEY_MOVIE_DATE, movie.getLocalDate())
                .apply();

        return true;
    }
}
