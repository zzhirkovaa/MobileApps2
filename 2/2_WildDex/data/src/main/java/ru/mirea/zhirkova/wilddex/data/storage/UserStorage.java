package ru.mirea.zhirkova.wilddex.data.storage;

import ru.mirea.zhirkova.wilddex.domain.models.User;

public interface UserStorage {

    User get();

    boolean save(User user);
}