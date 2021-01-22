package com.example.greenarrow.controller;

public interface ViewManager {
    void transferToView(String[] data);

    void notifyAboutTestFinish(int score, int maxScore);
}
