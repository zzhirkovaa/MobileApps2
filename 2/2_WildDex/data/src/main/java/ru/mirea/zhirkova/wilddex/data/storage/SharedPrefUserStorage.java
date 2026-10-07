package ru.mirea.zhirkova.wilddex.data.storage;

import android.content.Context;
import android.content.SharedPreferences;

import ru.mirea.zhirkova.wilddex.domain.models.User;

public class SharedPrefUserStorage implements UserStorage {

    private static final String PREF_NAME = "user_preferences";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";

    private final SharedPreferences sharedPreferences;

    public SharedPrefUserStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(
                PREF_NAME,
                Context.MODE_PRIVATE
        );
    }

    @Override
    public User get() {
        int id = sharedPreferences.getInt(KEY_USER_ID, 0);
        String name = sharedPreferences.getString(KEY_USER_NAME, "");
        String email = sharedPreferences.getString(KEY_USER_EMAIL, "");

        return new User(id, name, email);
    }

    @Override
    public boolean save(User user) {
        sharedPreferences.edit()
                .putInt(KEY_USER_ID, user.getId())
                .putString(KEY_USER_NAME, user.getUsername())
                .putString(KEY_USER_EMAIL, user.getEmail())
                .apply();

        return true;
    }
}