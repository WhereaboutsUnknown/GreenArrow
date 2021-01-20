package com.example.greenarrow.model.questions;

public interface Processor {
    void processNextQuestion();

    void reset(String request);

    void deactivate();

    boolean approvesAnswer(int answer);

    boolean isQuestionInProcess();

    String getOptionA();

    String getOptionB();

    String getOptionC();

    String getOptionD();

    String getQuestionText();

    String takeWrongAnswerInfo();
}
