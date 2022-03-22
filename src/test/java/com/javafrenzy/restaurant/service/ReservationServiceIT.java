package com.javafrenzy.restaurant.service;

import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.repository.ReservationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ReservationServiceIT {

    @Autowired
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

        // Act
        Reservation reservation1 = reservationService.addReservation(reservation);
        List<Reservation> reservations = reservationService.getAllReservations();


        // Assert

        Assertions.assertEquals("integration",reservations.get(reservations.size()-1).getName());
        Assertions.assertEquals(0,reservations.get(reservations.size()-1).getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservations.get(reservations.size()-1).getDate());
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

        // Act
        Reservation reservation1 = reservationService.addReservation(reservation);
        Reservation reservation2 = reservationService.checkReservation("integration1");


        // Assert

        Assertions.assertEquals("integration1",reservation2.getName());
        Assertions.assertEquals(0,reservation2.getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation2.getDate());
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

        // Act
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

        int newCapacity = 1;
        // Act

        Reservation reservation1 = reservationService.addReservation(reservation);
        reservation1.setCapacity(newCapacity);
        Reservation reservation2 = reservationService.updateReservation(reservation1);

        // Assert

        Assertions.assertEquals("integration3",reservation2.getName());
        Assertions.assertEquals(1,reservation2.getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation2.getDate());

    }
    @Test
    void test_buildReservations_deleteReservation() {
        // Arrange
        String name = "integration4";
        LocalDateTime date = LocalDateTime.of(2022, 8, 1, 9, 30);
        int capacity = 0;
        Reservation reservation =new Reservation();
        reservation.setName(name);
        reservation.setCapacity(capacity);
        reservation.setDate(date);

        // Act

        Reservation reservation1 = reservationService.addReservation(reservation);
        Reservation reservation2 = reservationService.deleteReservation("integration4");

        // Assert

        Assertions.assertEquals("integration4",reservation2.getName());
        Assertions.assertEquals(0,reservation2.getCapacity());
        Assertions.assertEquals(LocalDateTime.of(2022, 8, 1, 9, 30),reservation2.getDate());

    }
}
