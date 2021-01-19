package com.example.greenarrow.model.questions;

public class QuestionProcessor implements Processor {
    private static Processor questionProcessor;

    private Question currentQuestion;

    public static Processor getQuestionProcessor() {
        if (questionProcessor == null) {
            questionProcessor = new QuestionProcessor();
        }
        return questionProcessor;
    }

    private QuestionProcessor() {
        //TODO
    }

    @Override
    public void processNextQuestion(Question question) {
        currentQuestion = question;
        //TODO
    }

    @Override
    public void deactivate() {
        //TODO
    }

    @Override
    public boolean checkAnswer(int answer) {
        return answer == currentQuestion.getCorrectAnswer();
        //TODO
    }

    @Override
    public boolean isQuestionInProcess() {
        return currentQuestion != null;
    }

    @Override
    public String getOptionA() {
        return currentQuestion.getOptionA();
    }

    @Override
    public String getOptionB() {
        return currentQuestion.getOptionB();
    }

    @Override
    public String getOptionC() {
        return currentQuestion.getOptionC();
    }

    @Override
    public String getOptionD() {
        return currentQuestion.getOptionD();
    }

    @Override
    public String getQuestionText() {
        return currentQuestion.getQuestionText();
    }
}
