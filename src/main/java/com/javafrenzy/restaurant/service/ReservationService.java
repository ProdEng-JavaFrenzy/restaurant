package com.javafrenzy.restaurant.service;

import com.javafrenzy.restaurant.exception.ReservationNotFoundException;
import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation>  getAllReservations(){
        return reservationRepository.findAll();
    }
    public Reservation checkReservation(String identifier){
        return reservationRepository.findByIdentifier(identifier).orElseThrow(
                () -> new ReservationNotFoundException(identifier));
    }
    public Reservation deleteReservation(String identifier){
        return reservationRepository.deleteByIdentifier(identifier).orElseThrow(
                () -> new ReservationNotFoundException(identifier));
    }
}
