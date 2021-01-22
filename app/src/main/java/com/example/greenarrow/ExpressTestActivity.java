package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.greenarrow.controller.ConcreteGameManager;
import com.example.greenarrow.controller.GameManager;
import com.example.greenarrow.res_mvc.Gradients;

import java.util.Locale;

import static com.example.greenarrow.res_mvc.ColorConstants.COLOR_ACCENT_DARK;
import static com.example.greenarrow.res_mvc.ColorConstants.COLOR_GRAY;

import static com.example.greenarrow.res_mvc.IntegerConstants.*;
import static com.example.greenarrow.res_mvc.StringConstants.*;

public class ExpressTestActivity extends AppCompatActivity implements BaseView {

    GameManager gameManager;

    String testTypeKey;

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;
    Button continueButton;
    TextView questionTextView;

    private View.OnClickListener mOnAClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            disableOptionButtons();
            gameManager.onChosenOption(OPTION_A_INDEX);
        }
    };
    private View.OnClickListener mOnBClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            disableOptionButtons();
            gameManager.onChosenOption(OPTION_B_INDEX);
        }
    };
    private View.OnClickListener mOnCClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            disableOptionButtons();
            gameManager.onChosenOption(OPTION_C_INDEX);
        }
    };
    private View.OnClickListener mOnDClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            disableOptionButtons();
            gameManager.onChosenOption(OPTION_D_INDEX);
        }
    };
    private View.OnClickListener mOnContinueClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            disableContinueButton();
            gameManager.onContinue();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_test_question_layout);

        testTypeKey = getIntent().getStringExtra("key");

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        continueButton = findViewById(R.id.continue_button);
        questionTextView = findViewById(R.id.question_output);

        optionA.setOnClickListener(mOnAClickListener);
        optionB.setOnClickListener(mOnBClickListener);
        optionC.setOnClickListener(mOnCClickListener);
        optionD.setOnClickListener(mOnDClickListener);
        continueButton.setOnClickListener(mOnContinueClickListener);

        disableContinueButton();
        disableOptionButtons();

        gameManager = ConcreteGameManager.getGameManager();
        gameManager.start(this, testTypeKey);
    }

    private void disableOptionButtons() {
        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);
    }

    private void disableContinueButton() {
        continueButton.setEnabled(false);
        continueButton.setBackground(Gradients.GRADIENT_TRANSPARENT);
    }

    private void changeOptionsColor(int color) {
        optionA.setBackgroundColor(color);
        optionB.setBackgroundColor(color);
        optionC.setBackgroundColor(color);
        optionD.setBackgroundColor(color);
    }

    @Override
    public void showNewQuestionData(String[] data) {
        changeOptionsColor(COLOR_ACCENT_DARK);

        questionTextView.setText(data[QUESTION_TEXT_INDEX]);
        optionA.setText(data[OPTION_A_INDEX]);
        optionB.setText(data[OPTION_B_INDEX]);
        optionC.setText(data[OPTION_C_INDEX]);
        optionD.setText(data[OPTION_D_INDEX]);

        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
    }

    @Override
    public void showAnswerAsCorrect(int optionNumber) {
        changeOptionsColor(COLOR_GRAY);
        switch (optionNumber) {
            case OPTION_A_INDEX:
                optionA.setBackground(Gradients.GRADIENT_MAIN);
                break;
            case OPTION_B_INDEX:
                optionB.setBackground(Gradients.GRADIENT_MAIN);
                break;
            case OPTION_C_INDEX:
                optionC.setBackground(Gradients.GRADIENT_MAIN);
                break;
            case OPTION_D_INDEX:
                optionD.setBackground(Gradients.GRADIENT_MAIN);
                break;
        }
        //TODO
    }

    @Override
    public void showAnswerAsWrong(int optionNumber, String wrongAnswerInfo) {
        changeOptionsColor(COLOR_GRAY);
        switch (optionNumber) {
            case OPTION_A_INDEX:
                optionA.setBackground(Gradients.GRADIENT_ORANGE);
                break;
            case OPTION_B_INDEX:
                optionB.setBackground(Gradients.GRADIENT_ORANGE);
                break;
            case OPTION_C_INDEX:
                optionC.setBackground(Gradients.GRADIENT_ORANGE);
                break;
            case OPTION_D_INDEX:
                optionD.setBackground(Gradients.GRADIENT_ORANGE);
                break;
        }
        questionTextView.setText(wrongAnswerInfo);
        //TODO
    }

    @Override
    public void enableContinueButton() {
        continueButton.setBackground(Gradients.GRADIENT_MAIN);
        continueButton.setEnabled(true);
        //TODO
    }

    @Override
    public void showFinalLayout(int score, int maxScore) {
        int rating = (int) ((score * 100.0) / maxScore);

        SharedPreferences sharedPreferences = getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE);
        int totalScores = sharedPreferences.getInt(SP_TOTAL_SCORES, 0);
        int scorePlus = score;
        switch (testTypeKey) {
            case EXPRESS_TEST_KEY:
                break;
            case EXAM_KEY:
                scorePlus *= EXAM_TEST_MULTIPLIER;
                if (sharedPreferences.getInt(SP_EXAM_RATING, 0) < rating)
                    getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE).edit().putInt(SP_EXAM_RATING, rating).apply();
                break;
            case LIFESTYLE_TEST_KEY:
                if (sharedPreferences.getInt(SP_LIFESTYLE_RATING, 0) < rating)
                    getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE).edit().putInt(SP_LIFESTYLE_RATING, rating).apply();
                break;
            case SHOPPING_TEST_KEY:
                if (sharedPreferences.getInt(SP_SHOPPING_RATING, 0) < rating)
                    getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE).edit().putInt(SP_SHOPPING_RATING, rating).apply();
                break;
            case FOOD_TEST_KEY:
                if (sharedPreferences.getInt(SP_FOOD_RATING, 0) < rating)
                    getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE).edit().putInt(SP_FOOD_RATING, rating).apply();
                break;
            case TRAVELLING_TEST_KEY:
                if (sharedPreferences.getInt(SP_TRAVELLING_RATING, 0) < rating)
                    getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE).edit().putInt(SP_TRAVELLING_RATING, rating).apply();
                break;
        }
        totalScores += scorePlus;

        getSharedPreferences(SP_SETTINGS_FILE_NAME, MODE_PRIVATE).edit().putInt(SP_TOTAL_SCORES, totalScores).apply();
        setContentView(R.layout.activity_express_test);

        Button endButton = findViewById(R.id.end_button);
        TextView textView = findViewById(R.id.test_rating_indicator);

        textView.setText(String.format(Locale.US, FINAL_RATING, rating));
        endButton.setText(String.format(Locale.US, FINAL_SCORES, score, maxScore));
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExpressTestActivity.this, MainActivity.class));
                finishAffinity();
            }
        });
        //TODO: prize for category rating upgrade
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ExpressTestActivity.this, MainActivity.class));
        finishAffinity();
    }

    //TODO: activity logic, fragments, disableOptionButtons, enableOptionButtons
}