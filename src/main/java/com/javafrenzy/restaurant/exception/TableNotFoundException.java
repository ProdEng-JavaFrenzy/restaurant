package com.javafrenzy.restaurant.exception;

public class TableNotFoundException extends NotFoundExceptionBase {
    public TableNotFoundException(String id) {
        super("Table", id);
    }
}
