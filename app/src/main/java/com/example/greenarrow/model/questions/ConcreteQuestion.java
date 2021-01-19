package com.example.greenarrow.model.questions;

import com.example.greenarrow.model.questiondb.Category;

public class ConcreteQuestion implements Question {

    public Category getCategory() {
        return category;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    private Category category;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String questionText;
    private int correctAnswer;

    public ConcreteQuestion(Category category, String optionA, String optionB, String optionC, String optionD,
                            String questionText, int correctAnswer) {
        this.category = category;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }
}
