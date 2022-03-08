package com.javafrenzy.restaurant.exception;

public class ReservationAlreadyAddedException extends RuntimeException{
    public ReservationAlreadyAddedException(String name){
        super(name + " already has a reservation!. Try updating it!");
    }
}
