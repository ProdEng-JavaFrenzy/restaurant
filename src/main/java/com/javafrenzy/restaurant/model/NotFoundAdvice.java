package com.javafrenzy.restaurant.model;

import com.javafrenzy.restaurant.exception.NotFoundExceptionBase;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(NotFoundExceptionBase.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ReservationNotFoundHandler(NotFoundExceptionBase ex) {
        return ex.getMessage();
    }
}
