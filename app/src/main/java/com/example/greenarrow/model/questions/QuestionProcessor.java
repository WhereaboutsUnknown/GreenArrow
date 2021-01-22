package com.example.greenarrow.model.questions;

import com.example.greenarrow.controller.ViewManager;
import com.example.greenarrow.model.questiondb.Database;
import com.example.greenarrow.model.questiondb.QuestionDatabase;

import java.math.BigInteger;
import java.util.Stack;

import static com.example.greenarrow.res_mvc.IntegerConstants.DATA_ARRAY_LENGTH;
import static com.example.greenarrow.res_mvc.IntegerConstants.OPTION_A_INDEX;
import static com.example.greenarrow.res_mvc.IntegerConstants.OPTION_B_INDEX;
import static com.example.greenarrow.res_mvc.IntegerConstants.OPTION_C_INDEX;
import static com.example.greenarrow.res_mvc.IntegerConstants.OPTION_D_INDEX;
import static com.example.greenarrow.res_mvc.IntegerConstants.QUESTION_TEXT_INDEX;

public final class QuestionProcessor implements Processor {
    private static Processor questionProcessor;

    private ViewManager viewManager;
    private Database questionDatabase;
    private Stack<Question> questionStack;
    private Question currentQuestion;
    private BigInteger score;
    private BigInteger maxScore;

    public static Processor getQuestionProcessor(ViewManager manager) {
        if (questionProcessor == null) {
            questionProcessor = new QuestionProcessor(manager);
        }
        return questionProcessor;
    }

    private QuestionProcessor(ViewManager manager) {
        questionDatabase = QuestionDatabase.getQuestionDatabase();
        viewManager = manager;
        //TODO
    }

    @Override
    public void processNextQuestion() {
        if (questionStack == null) {
            //TODO;
        }
        if (questionStack.isEmpty()) {
            deactivate();
        } else {
            currentQuestion = questionStack.pop();

            maxScore = maxScore.add(BigInteger.valueOf(1));

            String[] questionData = new String[DATA_ARRAY_LENGTH];
            questionData[QUESTION_TEXT_INDEX] = currentQuestion.getQuestionText();
            questionData[OPTION_A_INDEX] = currentQuestion.getOptionA();
            questionData[OPTION_B_INDEX] = currentQuestion.getOptionB();
            questionData[OPTION_C_INDEX] = currentQuestion.getOptionC();
            questionData[OPTION_D_INDEX] = currentQuestion.getOptionD();
            viewManager.transferToView(questionData);
        }
    }

    @Override
    public void reset(String request) {
        questionStack = questionDatabase.formQuestionStack(request);
        score = BigInteger.valueOf(0);
        maxScore = BigInteger.valueOf(0);
        processNextQuestion();
    }

    @Override
    public void deactivate() {
        currentQuestion = null;
        viewManager.notifyAboutTestFinish(score.intValue(), maxScore.intValue());
        //TODO
    }

    @Override
    public boolean approvesAnswer(int answer) {
        boolean isCorrect = answer == currentQuestion.getCorrectAnswer();
        if (isCorrect)
            score = score.add(BigInteger.valueOf(1));
        return isCorrect;
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

    @Override
    public String takeWrongAnswerInfo() {
        return currentQuestion.getWrongAnswerInfo();
    }
}
