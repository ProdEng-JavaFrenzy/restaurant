package com.javafrenzy.restaurant.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String identifier) {
        super("Reservation " + identifier + " does not seem to exist!");
    }
}
