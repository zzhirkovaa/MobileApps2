package ru.mirea.zhirkova.wilddex.domain.repository;

import ru.mirea.zhirkova.wilddex.domain.models.User;

public interface AuthRepository {

    interface AuthCallback {
        void onSuccess(User user);
        void onError(String message);
    }

    void register(
            String username,
            String email,
            String password,
            AuthCallback callback
    );

    void login(
            String email,
            String password,
            AuthCallback callback
    );

    User getCurrentUser();

    void logout();
}