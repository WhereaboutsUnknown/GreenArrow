package com.example.greenarrow;

public interface BaseView {
    void showNewQuestionData(String[] data);

    void showAnswerAsCorrect(int optionNumber);

    void showAnswerAsWrong(int optionNumber, String wrongAnswerInfo);

    void enableOptionButtons();

    void enableContinueButton();

    void showFinalLayout();
}
