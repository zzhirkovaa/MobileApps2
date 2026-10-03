package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class LogoutUseCase {

    private final AuthRepository authRepository;

    public LogoutUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public void execute() {
        authRepository.logout();
    }
}