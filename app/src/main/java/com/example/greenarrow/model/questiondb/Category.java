package com.example.greenarrow.model.questiondb;

import java.io.Serializable;

public enum Category implements Serializable {
    LIFESTYLE,
    SHOPPING,
    FOOD,
    TRAVELLING;

    private String[] nameList = {
            "Бытовые привычки",
            "Покупки",
            "Еда",
            "Путешествия и транспорт"
    };

    @Override
    public String toString() {
        return nameList[this.ordinal()];
    }
}
