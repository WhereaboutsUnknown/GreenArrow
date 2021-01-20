package com.example.greenarrow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExpressTestActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_test);
    }

    @Override
    public void showNewQuestionData(String[] data) {
        //TODO
    }

    @Override
    public void showAnswerAsCorrect(int optionNumber) {
        //TODO
    }

    @Override
    public void showAnswerAsWrong(int optionNumber, String wrongAnswerInfo) {
        //TODO
    }

    @Override
    public void enableOptionButtons() {
        //TODO
    }

    @Override
    public void enableContinueButton() {
        //TODO
    }

    @Override
    public void showFinalLayout() {
        //TODO
    }

    //TODO: activity logic, fragments, disableOptionButtons, enableOptionButtons
}