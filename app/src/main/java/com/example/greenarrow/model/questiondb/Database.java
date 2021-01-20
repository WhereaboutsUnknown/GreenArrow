package com.example.greenarrow.model.questiondb;

import com.example.greenarrow.model.questions.Question;

import java.util.Stack;

public interface Database {

    Stack<Question> formQuestionStack(String request);

    boolean isActive();

    void deactivate();
}
