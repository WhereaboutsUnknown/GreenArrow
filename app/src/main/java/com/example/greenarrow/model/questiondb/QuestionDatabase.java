package com.example.greenarrow.model.questiondb;

import com.example.greenarrow.model.questions.Question;

import java.util.ArrayList;
import java.util.Stack;

public class QuestionDatabase implements Database {
    private static Database questionDatabase;

    private ArrayList<Question> dummyCategoryQuestions;

    public static Database getQuestionDatabase() {
        if (questionDatabase == null) {
            questionDatabase = new QuestionDatabase();
        }
        return questionDatabase;
    }

    private QuestionDatabase() {
        //TODO
    }

    @Override
    public Stack<Question> formQuestionStack(String request) {
        return null;//TODO
    }

    @Override
    public void deactivate() {
        //TODO
    }
}
