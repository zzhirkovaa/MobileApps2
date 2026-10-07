package ru.mirea.zhirkova.wilddex.presentation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.zhirkova.wilddex.R;
import ru.mirea.zhirkova.wilddex.data.repository.AuthRepositoryImpl;
import ru.mirea.zhirkova.wilddex.domain.models.User;
import ru.mirea.zhirkova.wilddex.domain.repository.AuthRepository;
import ru.mirea.zhirkova.wilddex.domain.usecases.LoginUseCase;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;

    private LoginUseCase loginUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        AuthRepository authRepository = new AuthRepositoryImpl();
        loginUseCase = new LoginUseCase(authRepository);

        btnLogin.setOnClickListener(v -> login());
    }

    private void login() {

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(
                    this,
                    "Введите email и пароль",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        loginUseCase.execute(
                email,
                password,
                new AuthRepository.AuthCallback() {

                    @Override
                    public void onSuccess(User user) {
                        Toast.makeText(
                                LoginActivity.this,
                                "Вход выполнен",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onError(String message) {
                        Toast.makeText(
                                LoginActivity.this,
                                "Ошибка: " + message,
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }
}