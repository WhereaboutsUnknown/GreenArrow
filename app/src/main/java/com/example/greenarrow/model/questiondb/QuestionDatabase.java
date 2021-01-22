package com.example.greenarrow.model.questiondb;

import com.example.greenarrow.model.questiondb.temporary_data.TempDataBank;
import com.example.greenarrow.model.questions.Question;
import com.example.greenarrow.model.questions.ConcreteQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import static com.example.greenarrow.model.questiondb.temporary_data.TempDataBank.*;
import static com.example.greenarrow.res_mvc.IntegerConstants.*;
import static com.example.greenarrow.res_mvc.StringConstants.*;

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
        isActive = fillQuestionLists();//TODO
    }

    @Override
    public Stack<Question> formQuestionStack(String request) {
        Stack<Question> stack = new Stack<>();
        switch (request) {
            case EXPRESS_TEST_KEY:
                fillQuestionStack(EXPRESS_TEST_QUESTION_NUMBER, allQuestions, stack);
                break;
            case EXAM_KEY:
                fillQuestionStack(EXAM_LIFESTYLE_QUESTION_NUMBER, lifestyleCategoryQuestions, stack);
                fillQuestionStack(EXAM_SHOPPING_QUESTION_NUMBER, shoppingCategoryQuestions, stack);
                fillQuestionStack(EXAM_FOOD_QUESTION_NUMBER, foodCategoryQuestions, stack);
                fillQuestionStack(EXAM_TRAVELLING_QUESTION_NUMBER, travellingCategoryQuestions, stack);
                break;
            case LIFESTYLE_TEST_KEY:
                fillQuestionStack(CATEGORY_TEST_QUESTION_NUMBER, lifestyleCategoryQuestions, stack);
                break;
            case SHOPPING_TEST_KEY:
                fillQuestionStack(CATEGORY_TEST_QUESTION_NUMBER, shoppingCategoryQuestions, stack);
                break;
            case FOOD_TEST_KEY:
                fillQuestionStack(CATEGORY_TEST_QUESTION_NUMBER, foodCategoryQuestions, stack);
                break;
            case TRAVELLING_TEST_KEY:
                fillQuestionStack(CATEGORY_TEST_QUESTION_NUMBER, travellingCategoryQuestions, stack);
                break;
        }
        return stack;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void deactivate() {
        //TODO
    }

    private void fillQuestionStack(int questionNumber, ArrayList<Question> questionList, Stack<Question> stack) {
        if (questionNumber > questionList.size()) {
            questionNumber = questionList.size();
        }
        Collections.shuffle(questionList);
        for (int i = 0; i < questionNumber; i++) {
            stack.push(questionList.get(i));
        }
    }

    private boolean fillQuestionLists() {
        lifestyleCategoryQuestions = createQuestionListFromDataBank(TempDataBank.LIFESTYLE_DATA_TEMP, Category.LIFESTYLE);//createQuestionListFromFile(LIFESTYLE_CATEGORY_PATH);
        shoppingCategoryQuestions = createQuestionListFromDataBank(TempDataBank.SHOPPING_DATA_TEMP, Category.SHOPPING);//createQuestionListFromFile(SHOPPING_CATEGORY_PATH);
        foodCategoryQuestions = createQuestionListFromDataBank(TempDataBank.FOOD_DATA_TEMP, Category.FOOD);//createQuestionListFromFile(FOOD_CATEGORY_PATH);
        travellingCategoryQuestions = createQuestionListFromDataBank(TempDataBank.TRAVELLING_DATA_TEMP, Category.TRAVELLING);//createQuestionListFromFile(TRAVELLING_CATEGORY_PATH);

        allQuestions = new ArrayList<>();

        allQuestions.addAll(lifestyleCategoryQuestions);
        allQuestions.addAll(shoppingCategoryQuestions);
        allQuestions.addAll(foodCategoryQuestions);
        allQuestions.addAll(travellingCategoryQuestions);
        return true;//TODO: use reading from JSON instead of separate data arrays;
    }

    private ArrayList<Question> createQuestionListFromFile(String path) {
        ArrayList<Question> questionList = new ArrayList<>();

        return questionList;//TODO: use reading from JSON instead of separate data arrays;
    }

    /*TODO:Following code is nonsense and should be removed as soon as possible, and replaced with fully functional object creating from JSON files*/

    private ArrayList<Question> createQuestionListFromDataBank(String[][] dataBank, Category category) {
        ArrayList<Question> tempList = new ArrayList<>();
        if (dataBank == null)
            return tempList;
        if (dataBank.length == 0)
            return tempList;
        for (String[] data : dataBank) {
            if (data.length != TEMP_DATA_LENGTH)
                return tempList;
            String A = data[DATA_OPTION_A_ID];
            String B = data[DATA_OPTION_B_ID];
            String C = data[DATA_OPTION_C_ID];
            String D = data[DATA_OPTION_D_ID];
            String question = data[DATA_QUESTION_ID];
            int answer = Integer.parseInt(data[DATA_ANSWER_ID]);
            String info = data[DATA_INFO_ID];

            tempList.add( new ConcreteQuestion(category, A, B, C, D, question, answer, info));
        }
        return tempList;
    }
}
