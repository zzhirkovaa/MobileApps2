package ru.mirea.zhirkova.wilddex.data.repository;

import ru.mirea.zhirkova.wilddex.data.storage.UserStorage;
import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private final UserStorage userStorage;

    public UserRepositoryImpl(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public boolean saveUser(User user) {
        return userStorage.save(user);
    }

    @Override
    public User getUser() {
        return userStorage.get();
    }
}