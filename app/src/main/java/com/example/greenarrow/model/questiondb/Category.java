package com.example.greenarrow.model.questiondb;

public enum Category {
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
