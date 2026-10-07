package ru.mirea.zhirkova.wilddex.domain.repository;

import ru.mirea.zhirkova.wilddex.domain.models.User;

public interface UserRepository {

    boolean saveUser(User user);

    User getUser();
}