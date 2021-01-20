package com.example.greenarrow.controller;

import com.example.greenarrow.BaseView;
import com.example.greenarrow.model.questiondb.Category;
import com.example.greenarrow.model.questions.Processor;
import com.example.greenarrow.model.questions.QuestionProcessor;

public final class ConcreteGameManager implements GameManager, ViewManager {
    private static GameManager gameManager;

    private BaseView view;
    private Processor questionProcessor;

    public static GameManager getGameManager() {
        if (gameManager == null) {
            gameManager = new ConcreteGameManager();
        }
        return gameManager;
    }

    private ConcreteGameManager() {
        questionProcessor = QuestionProcessor.getQuestionProcessor(this);
    }

    /**GameManager interface implementation: provides interaction with QuestionProcessor, methods are called from BaseView**/

    @Override
    public void onChosenCategory(Category category) {

    }

    @Override
    public void start(BaseView context, String key) {
        view = context;
        questionProcessor.reset(key);
        //TODO
    }

    @Override
    public void onChosenOption(int optionNumber) {
        if (questionProcessor.approvesAnswer(optionNumber)) {
            view.showAnswerAsCorrect(optionNumber);
            //TODO: change scores etc.
        } else {
            view.showAnswerAsWrong(optionNumber, questionProcessor.takeWrongAnswerInfo());
            //TODO
        }
        view.enableContinueButton();
    }

    @Override
    public void onContinue() {
        questionProcessor.processNextQuestion();
        //TODO
    }

    /**ViewManager interface implementation: provides interaction with BaseView, methods are called from QuestionProcessor**/

    @Override
    public void transferToView(String[] data) {
        view.showNewQuestionData(data);
    }

    @Override
    public void notifyAboutTestFinish() {
        view.showFinalLayout();
        //TODO
    }
}
