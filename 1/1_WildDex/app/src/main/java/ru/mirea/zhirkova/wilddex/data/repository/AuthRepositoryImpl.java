
package ru.mirea.zhirkova.wilddex.data.repository;

import java.util.ArrayList;
import java.util.List;

import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class AuthRepositoryImpl implements AuthRepository {

    private final List<User> users = new ArrayList<>();

    private User currentUser;

    private int nextUserId = 2;

    public AuthRepositoryImpl() {

        User testUser = new User(
                1,
                "TestUser",
                "test@example.com"
        );

        users.add(testUser);
        currentUser = testUser;
    }

    @Override
    public User register(
            String username,
            String email,
            String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {
                return null;
            }
        }

        User newUser = new User(
                nextUserId++,
                username,
                email
        );

        users.add(newUser);
        currentUser = newUser;

        return newUser;
    }

    @Override
    public User login(String email, String password) {

        for (User user : users) {

            if (user.getEmail().equalsIgnoreCase(email)) {

                currentUser = user;
                return user;
            }
        }

        return null;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void logout() {
        currentUser = null;
    }
}