package com.javafrenzy.restaurant.exception;

public abstract class AlreadyAddedExceptionBase extends RuntimeException {
    public AlreadyAddedExceptionBase(String entityName, String name) {
        super(entityName + " " + name + " already has a reservation.");
    }
}
