package com.example.greenarrow.controller;

import com.example.greenarrow.BaseView;
import com.example.greenarrow.model.questiondb.Category;

public interface GameManager {
    void onChosenCategory(Category category);

    void start(BaseView context, String key);

    void onChosenOption(int optionNumber);

    void onContinue();
}
