package com.example.guiproject.enums;

public enum OperationEnum {
    SUM("+"),
    SUB("-"),
    MULT("*"),
    DIV("/");

    private final String operation;

    OperationEnum(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return this.operation;
    }
}
