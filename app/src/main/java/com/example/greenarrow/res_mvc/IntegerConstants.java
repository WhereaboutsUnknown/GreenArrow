package com.example.greenarrow.res_mvc;

public final class IntegerConstants {

    public static final int EXAM_TEST_MULTIPLIER = 5;
    public static final int OVER_25_PERCENT_PRIZE = 25;
    public static final int OVER_50_PERCENT_PRIZE = 50;
    public static final int OVER_75_PERCENT_PRIZE = 75;
    public static final int OVER_100_PERCENT_PRIZE = 100;

    /**QUESTION NUMBER CONSTANTS**/

    public static final int EXPRESS_TEST_QUESTION_NUMBER = 5;
    public static final int CATEGORY_TEST_QUESTION_NUMBER = 5;

    /*Total number of exam questions is the sum of following four constants: */

    public static final int EXAM_LIFESTYLE_QUESTION_NUMBER = 4;
    public static final int EXAM_SHOPPING_QUESTION_NUMBER = 2;
    public static final int EXAM_FOOD_QUESTION_NUMBER = 2;
    public static final int EXAM_TRAVELLING_QUESTION_NUMBER = 2;


    /**DATA ORDER CONSTANTS**/
    /*Do not forget to check the order of elements of the data in model.questions.QuestionProcessor class code, method processNextQuestion()!*/

    public static final int QUESTION_TEXT_INDEX = 0;
    public static final int OPTION_A_INDEX = 1;
    public static final int OPTION_B_INDEX = 2;
    public static final int OPTION_C_INDEX = 3;
    public static final int OPTION_D_INDEX = 4;

    public static final int DATA_ARRAY_LENGTH = 5;
}
