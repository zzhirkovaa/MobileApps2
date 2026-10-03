
package ru.mirea.zhirkova.wilddex.domain.repository;

import ru.mirea.zhirkova.wilddex.domain.models.User;

public interface AuthRepository {

    User register(String username, String email, String password);

    User login(String email, String password);

    User getCurrentUser();

    void logout();
}