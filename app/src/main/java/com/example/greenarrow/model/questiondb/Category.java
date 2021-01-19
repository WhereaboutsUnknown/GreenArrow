package com.example.greenarrow.model.questiondb;

public enum Category {
    DUMMY;
    //TODO

    private String[] nameList = {
            "Тестовая категория"
    };

    @Override
    public String toString() {
        return nameList[this.ordinal()];
    }
}
