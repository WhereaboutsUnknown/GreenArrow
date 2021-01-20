package com.example.greenarrow.model.questions;

import com.example.greenarrow.model.questiondb.Category;

public interface Question {

    Category getCategory();

    String getOptionA();

    String getOptionB();

    String getOptionC();

    String getOptionD();

    String getQuestionText();

    int getCorrectAnswer();

    String getWrongAnswerInfo();
}
