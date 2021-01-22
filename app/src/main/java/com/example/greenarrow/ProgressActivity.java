package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

import static com.example.greenarrow.res_mvc.StringConstants.PROGRESS_EXAM;
import static com.example.greenarrow.res_mvc.StringConstants.PROGRESS_FOOD;
import static com.example.greenarrow.res_mvc.StringConstants.PROGRESS_LIFESTYLE;
import static com.example.greenarrow.res_mvc.StringConstants.PROGRESS_SCORES;
import static com.example.greenarrow.res_mvc.StringConstants.PROGRESS_SHOPPING;
import static com.example.greenarrow.res_mvc.StringConstants.PROGRESS_TRAVELLING;
import static com.example.greenarrow.res_mvc.StringConstants.SP_EXAM_RATING;
import static com.example.greenarrow.res_mvc.StringConstants.SP_FOOD_RATING;
import static com.example.greenarrow.res_mvc.StringConstants.SP_LIFESTYLE_RATING;
import static com.example.greenarrow.res_mvc.StringConstants.SP_SETTINGS_FILE_NAME;
import static com.example.greenarrow.res_mvc.StringConstants.SP_SHOPPING_RATING;
import static com.example.greenarrow.res_mvc.StringConstants.SP_TOTAL_SCORES;
import static com.example.greenarrow.res_mvc.StringConstants.SP_TRAVELLING_RATING;

public class ProgressActivity extends AppCompatActivity {
    TextView totalScores;
    TextView examRating;
    TextView lifestyleRating;
    TextView shoppingRating;
    TextView foodRating;
    TextView travellingRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        totalScores = findViewById(R.id.total_progress);
        examRating = findViewById(R.id.progress_exam);
        lifestyleRating = findViewById(R.id.progress_lifestyle);
        shoppingRating = findViewById(R.id.progress_shopping);
        foodRating = findViewById(R.id.progress_food);
        travellingRating = findViewById(R.id.progress_travelling);

        SharedPreferences sharedPreferences = getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE);

        int totalScoresValue = sharedPreferences.getInt(SP_TOTAL_SCORES, 0);
        int examRatingValue = sharedPreferences.getInt(SP_EXAM_RATING, 0);
        int lifestyleRatingValue = sharedPreferences.getInt(SP_LIFESTYLE_RATING, 0);
        int shoppingRatingValue = sharedPreferences.getInt(SP_SHOPPING_RATING, 0);
        int foodRatingValue = sharedPreferences.getInt(SP_FOOD_RATING, 0);
        int travellingRatingValue = sharedPreferences.getInt(SP_TRAVELLING_RATING, 0);

        totalScores.setText(String.format(Locale.US, PROGRESS_SCORES, totalScoresValue));
        examRating.setText(String.format(Locale.US, PROGRESS_EXAM, examRatingValue));
        lifestyleRating.setText(String.format(Locale.US, PROGRESS_LIFESTYLE, lifestyleRatingValue));
        shoppingRating.setText(String.format(Locale.US, PROGRESS_SHOPPING, shoppingRatingValue));
        foodRating.setText(String.format(Locale.US, PROGRESS_FOOD, foodRatingValue));
        travellingRating.setText(String.format(Locale.US, PROGRESS_TRAVELLING, travellingRatingValue));
    }
}