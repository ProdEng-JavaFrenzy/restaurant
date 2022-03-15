package com.javafrenzy.restaurant.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafrenzy.restaurant.exception.ReservationNotFoundException;
import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.repository.ReservationRepository;
import com.javafrenzy.restaurant.service.ReservationService;
import com.javafrenzy.restaurant.utils.GenerateIdentifier;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReservationServiceTest {

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    @Autowired
    ReservationService reservationService = new ReservationService();


    @Test
    void test_returnsReservations(){
        String name = "Tudor";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);

        when(reservationRepository.findAll()).thenReturn(reservations);

        Assertions.assertEquals("Tudor", reservations.get(0).getName());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservations.get(0).getDate());
        Assertions.assertEquals(0, reservations.get(0).getCapacity());

    }

    @Test
    void test_addReservationWhenNameNull_throwsReservationNotFoundException_whenNameNull(){
        String name = null;
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);


        when(reservationRepository.findByName(name)).thenReturn(null);

        try {
            // Act
            Reservation reservation1 = reservationService.addReservation(reservation);
        } catch (Exception ex) {
            // Assert
            Assertions.assertEquals(ex.getClass(), ReservationNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Reservation null does not exist.");
        }

    }

    @Test
    void test_addReservationFromName_returnsReservationWithName(){
        String name = "java";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);


        when(reservationRepository.findByName(name)).thenReturn(Optional.of(reservation));
        Reservation reservation1 = reservationService.addReservation(reservation);
        Assertions.assertEquals("java", reservation1.getName());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation1.getDate());
        Assertions.assertEquals(0, reservation1.getCapacity());

    }

    @Test
    void test_checkReservationWithName(){
        String name = "test";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);


        when(reservationRepository.findByName(name)).thenReturn(Optional.of(reservation));
        Reservation reservation1 = reservationService.checkReservation(reservation.getName());
        Assertions.assertEquals("test", reservation1.getName());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation1.getDate());
        Assertions.assertEquals(0, reservation1.getCapacity());

    }

    @Test
    void test_checkReservationWithName_throwsReservationNotFoundException_whenNameNull(){
        String name = null;


        when(reservationRepository.findByName(name)).thenReturn(null);

        try {
            // Act
            Reservation reservation1 = reservationService.checkReservation(null);
        } catch (Exception ex) {
            // Assert
            Assertions.assertEquals(ex.getClass(), ReservationNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Reservation null does not exist.");
        }

    }

    @Test
    void test_updateReservationWithName(){
        String name = "test";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);


        when(reservationRepository.findByName(name)).thenReturn(Optional.of(reservation));
        Reservation reservation1 = reservationService.updateReservation(reservation);
        Assertions.assertEquals("test", reservation1.getName());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation1.getDate());
        Assertions.assertEquals(0, reservation1.getCapacity());

    }

    @Test
    void test_updateReservationWithName_throwsReservationNotFoundException_whenNameNull(){
        String name = null;
        Reservation reservation =new Reservation();
        reservation.setName(name);

        when(reservationRepository.findByName(name)).thenReturn(null);

        try {
            // Act
            Reservation reservation1 = reservationService.updateReservation(reservation);
        } catch (Exception ex) {
            // Assert
            Assertions.assertEquals(ex.getClass(), ReservationNotFoundException.class);
            Assertions.assertEquals(ex.getMessage(), "Reservation null does not exist.");
        }
    }

}

