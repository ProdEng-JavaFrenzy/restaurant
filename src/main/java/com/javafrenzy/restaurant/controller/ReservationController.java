package com.javafrenzy.restaurant.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/reservations")
    @ResponseBody
    public List<Reservation> showReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/checkReservation/{name}")
    @ResponseBody
    public Reservation checkReservation(@PathVariable String name) {
        return reservationService.checkReservation(name);
    }

    @DeleteMapping("/deleteReservation/{name}")
    @ResponseBody
    public Reservation deleteReservation(@PathVariable String name) {
        return reservationService.deleteReservation(name);
    }

    @PostMapping("/addReservation")
    @ResponseBody
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/updateReservation")
    @ResponseBody
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation((reservation));
    }
}
