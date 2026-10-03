package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class LoginUseCase {

    private final AuthRepository authRepository;

    public LoginUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public User execute(String email, String password) {
        return authRepository.login(email, password);
    }
}