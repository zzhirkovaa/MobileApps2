package ru.mirea.zhirkova.lesson9.data.storage;

import android.content.Context;
import android.content.SharedPreferences;

public class MovieStorage {

    private static final String PREF_NAME = "movie_preferences";
    private static final String KEY_MOVIE_NAME = "favorite_movie";

    private final SharedPreferences sharedPreferences;

    public MovieStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );
    }

    public void saveMovie(String movieName) {
        sharedPreferences.edit()
                .putString(KEY_MOVIE_NAME, movieName)
                .apply();
    }

    public String getMovie() {
        return sharedPreferences.getString(KEY_MOVIE_NAME, "");
    }
}
