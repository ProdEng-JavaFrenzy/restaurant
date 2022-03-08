package com.javafrenzy.restaurant.model;

import com.javafrenzy.restaurant.exception.AlreadyAddedExceptionBase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AlreadyAddedAdvice {

    @ResponseBody
    @ExceptionHandler(AlreadyAddedExceptionBase.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String ReservationAlreadyAddedHandler(AlreadyAddedExceptionBase ex) {
        return ex.getMessage();
    }
}
