package com.javafrenzy.restaurant.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    @ResponseBody
    public List<Reservation> showReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/checkReservation/{identifier}")
    @ResponseBody
    public Reservation checkReservation(@PathVariable String identifier) {
        return reservationService.checkReservation(identifier);
    }

    @DeleteMapping("/reservation/{identifier}")
    @ResponseBody
    public Reservation deleteUser(@PathVariable String identifier) {
        return reservationService.deleteReservation(identifier);
    }

}
