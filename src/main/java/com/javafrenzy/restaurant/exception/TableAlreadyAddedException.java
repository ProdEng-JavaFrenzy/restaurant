package com.javafrenzy.restaurant.exception;

public class TableAlreadyAddedException extends AlreadyAddedExceptionBase {
    public TableAlreadyAddedException(String id) {
        super("Table", id);
    }
}
