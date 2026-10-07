package ru.mirea.zhirkova.wilddex.data.repository;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;
import android.util.Log;

public class AuthRepositoryImpl implements AuthRepository {

    private final FirebaseAuth firebaseAuth;

    public AuthRepositoryImpl() {
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void login(
            String email,
            String password,
            AuthCallback callback
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = authResult.getUser();

                    if (firebaseUser != null) {
                        User user = new User(
                                0,
                                firebaseUser.getDisplayName(),
                                firebaseUser.getEmail()
                        );

                        callback.onSuccess(user);
                    } else {
                        callback.onError("Не удалось получить пользователя");
                    }
                })
                .addOnFailureListener(exception ->
                        callback.onError(exception.getMessage())
                );
    }

    @Override
    public void register(
            String username,
            String email,
            String password,
            AuthCallback callback
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener(authResult -> {
                    FirebaseUser firebaseUser = authResult.getUser();

                    if (firebaseUser != null) {
                        User user = new User(
                                0,
                                username,
                                firebaseUser.getEmail()
                        );

                        callback.onSuccess(user);
                    } else {
                        callback.onError("Не удалось создать пользователя");
                    }
                })
                .addOnFailureListener(exception ->
                        callback.onError(exception.getMessage())
                );
    }

    @Override
    public User getCurrentUser() {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser == null) {
            return null;
        }

        return new User(
                0,
                firebaseUser.getDisplayName(),
                firebaseUser.getEmail()
        );
    }

    @Override
    public void logout() {
        firebaseAuth.signOut();
    }
}