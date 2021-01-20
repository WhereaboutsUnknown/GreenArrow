package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExamActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
    }

    @Override
    public void showNewQuestionData(String[] data) {
        //TODO
    }

    @Override
    public void showAnswerAsCorrect(int optionNumber) {

    }

    @Override
    public void showAnswerAsWrong(int optionNumber, String wrongAnswerInfo) {

    }

    @Override
    public void enableOptionButtons() {

    }

    @Override
    public void enableContinueButton() {

    }

    @Override
    public void showFinalLayout() {

    }

    //TODO: activity logic, fragments
}