package ru.mirea.zhirkova.wilddex.domain.usecases;

import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;

public class GetProfileUseCase {

    private final AuthRepository authRepository;

    public GetProfileUseCase(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public User execute() {
        return authRepository.getCurrentUser();
    }
}