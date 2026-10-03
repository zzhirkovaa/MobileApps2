package ru.mirea.zhirkova.lesson9.presentation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.mirea.zhirkova.lesson9.R;
import ru.mirea.zhirkova.lesson9.data.repository.MovieRepositoryImpl;
import ru.mirea.zhirkova.lesson9.domain.models.Movie;
import ru.mirea.zhirkova.lesson9.domain.usecases.GetFavoriteMovieUseCase;
import ru.mirea.zhirkova.lesson9.domain.usecases.SaveMovieToFavoriteUseCase;


public class MainActivity extends AppCompatActivity {


    private EditText movieEditText;
    private TextView resultTextView;

    private SaveMovieToFavoriteUseCase saveMovieToFavoriteUseCase;
    private GetFavoriteMovieUseCase getFavoriteMovieUseCase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        movieEditText = findViewById(R.id.movieEditText);
        resultTextView = findViewById(R.id.resultTextView);

        Button saveButton = findViewById(R.id.saveButton);
        Button getButton = findViewById(R.id.getButton);


        MovieRepositoryImpl repository =
                new MovieRepositoryImpl(this);


        saveMovieToFavoriteUseCase =
                new SaveMovieToFavoriteUseCase(repository);


        getFavoriteMovieUseCase =
                new GetFavoriteMovieUseCase(repository);



        saveButton.setOnClickListener(v -> {

            String name = movieEditText.getText().toString();

            Movie movie = new Movie(1, name);

            saveMovieToFavoriteUseCase.execute(movie);

            resultTextView.setText("Фильм сохранён");

        });



        getButton.setOnClickListener(v -> {

            Movie movie = getFavoriteMovieUseCase.execute();


            if (movie != null) {

                resultTextView.setText(
                        movie.getName()
                );

            } else {

                resultTextView.setText(
                        "Фильм не найден"
                );

            }

        });

    }
}