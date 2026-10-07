package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class RegisterUseCase {

    private final AuthRepository authRepository;

    public RegisterUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute(
            String username,
            String email,
            String password,
            AuthRepository.AuthCallback callback
    ) {
        authRepository.register(username, email, password, callback);
    }
}