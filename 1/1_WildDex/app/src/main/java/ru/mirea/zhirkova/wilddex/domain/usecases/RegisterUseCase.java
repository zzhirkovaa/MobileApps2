package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class RegisterUseCase {

    private final AuthRepository authRepository;

    public RegisterUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public User execute(String username, String email, String password) {
        return authRepository.register(username, email, password);
    }
}