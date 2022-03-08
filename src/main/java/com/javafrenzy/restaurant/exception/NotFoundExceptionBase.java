package com.javafrenzy.restaurant.exception;

public abstract class NotFoundExceptionBase extends RuntimeException {
    public NotFoundExceptionBase(String entityName, String id) {
        super(entityName + " " + id + " does not exist.");
    }
}
