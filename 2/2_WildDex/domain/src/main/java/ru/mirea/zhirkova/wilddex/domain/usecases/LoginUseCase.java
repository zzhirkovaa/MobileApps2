package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class LoginUseCase {

    private final AuthRepository authRepository;

    public LoginUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(
            String email,
            String password,
            AuthRepository.AuthCallback callback
    ) {
        authRepository.login(email, password, callback);
    }
}