package com.example.greenarrow.model.questions;

public interface Processor {
    void processNextQuestion(Question question);

    void deactivate();

    boolean checkAnswer(int answer);

    boolean isQuestionInProcess();

    String getOptionA();

    String getOptionB();

    String getOptionC();

    String getOptionD();

    String getQuestionText();
}
