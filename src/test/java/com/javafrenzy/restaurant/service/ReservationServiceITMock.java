package com.javafrenzy.restaurant.service;

import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.repository.ReservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReservationServiceITMock {

    @MockBean
    ReservationRepository reservationRepository;

    @Autowired
    ReservationService reservationService;

    @Test
    void test_buildReservations_returnsReservations() {
        // Arrange
        String name = "integration";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);
        when(reservationRepository.findAll()).thenReturn(reservations);
        // Act
        List<Reservation> reservations1 = reservationService.getAllReservations();


        // Assert

        Assertions.assertEquals("integration",reservations1.get(reservations1.size()-1).getName());
        Assertions.assertEquals(0,reservations1.get(reservations1.size()-1).getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservations1.get(reservations1.size()-1).getDate());
    }
    @Test
    void test_buildReservations_checkReservation() {
        // Arrange
        String name = "integration1";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);
        when(reservationRepository.findByName(name)).thenReturn(Optional.of(reservation));

        // Act
        Reservation reservation1 = reservationService.checkReservation("integration1");


        // Assert

        Assertions.assertEquals("integration1",reservation1.getName());
        Assertions.assertEquals(0,reservation1.getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation1.getDate());
    }
    @Test
    void test_buildReservations_addReservation() {
        // Arrange
        String name = "integration2";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);

        when(reservationRepository.save(any())).thenReturn(reservation);


        Reservation reservation1 = reservationService.addReservation(reservation);


        // Assert

        Assertions.assertEquals("integration2",reservation1.getName());
        Assertions.assertEquals(0,reservation1.getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation1.getDate());
    }
    @Test
    void test_buildReservations_updateReservation() {
        // Arrange
        String name = "integration3";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);
        int newCapacity=1;

        // Act
        when(reservationRepository.findByName(name)).thenReturn(Optional.of(reservation));
        when(reservationRepository.save(any())).thenReturn(reservation);

        reservation.setCapacity(newCapacity);
        Reservation reservation2 = reservationService.updateReservation(reservation);

        // Assert

        Assertions.assertEquals("integration3",reservation2.getName());
        Assertions.assertEquals(1,reservation2.getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation2.getDate());

    }

}
