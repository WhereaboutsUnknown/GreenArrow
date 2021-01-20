package com.example.greenarrow.model.questiondb;

import com.example.greenarrow.model.questions.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import static com.example.greenarrow.res_mvc.IntegerConstants.EXPRESS_TEST_QUESTION_NUMBER;
import static com.example.greenarrow.res_mvc.StringConstants.EXPRESS_TEST_KEY;

public final class QuestionDatabase implements Database {
    private static Database questionDatabase;

    private boolean isActive;

    private ArrayList<Question> lifestyleCategoryQuestions;
    private ArrayList<Question> shoppingCategoryQuestions;
    private ArrayList<Question> foodCategoryQuestions;
    private ArrayList<Question> travellingCategoryQuestions;
    private ArrayList<Question> allQuestions;

    public static Database getQuestionDatabase() {
        if (questionDatabase == null) {
            questionDatabase = new QuestionDatabase();
        }
        return questionDatabase;
    }

    private QuestionDatabase() {
        isActive = fillCategoryLists();//TODO
    }

    @Override
    public Stack<Question> formQuestionStack(String request) {
        Stack<Question> stack = new Stack<Question>();
        switch (request) {
            case (EXPRESS_TEST_KEY):
                int questionNumber = EXPRESS_TEST_QUESTION_NUMBER;
                if (questionNumber > allQuestions.size()) {
                    questionNumber = allQuestions.size();
                }
                Collections.shuffle(allQuestions);
                for (int i = 0; i < questionNumber; i++) {
                    stack.push(allQuestions.get(i));
                }
        }
        return stack;//TODO
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void deactivate() {
        //TODO
    }

    private boolean fillCategoryLists() {
        return false;//TODO
    }

    private ArrayList<Question> createQuestionListFromFile(String path) {
        return null;//TODO
    }
}
