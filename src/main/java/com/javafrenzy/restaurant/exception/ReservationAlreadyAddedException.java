package com.javafrenzy.restaurant.exception;

public class ReservationAlreadyAddedException extends AlreadyAddedExceptionBase {
    public ReservationAlreadyAddedException(String name) {
        super("Reservation", name);
    }
}
