package com.javafrenzy.restaurant.exception;

public class ReservationNotFoundException extends NotFoundExceptionBase {
    public ReservationNotFoundException(String identifier) {
        super("Reservation", identifier);
    }
}
