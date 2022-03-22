package com.javafrenzy.restaurant.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@SpringBootTest
class ReservationTest {

    @Test
    void test_GetIdentifier(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act

        //Assert
        Assertions.assertSame("1234", myReservation.getIdentifier());
    }


    @Test
    void test_SetIdentifier(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act
        myReservation.setIdentifier("111");

        //Assert
        Assertions.assertSame("111", myReservation.getIdentifier());
    }


    @Test
    void test_GetName(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act

        //Assert
        Assertions.assertSame("Alex", myReservation.getName());
    }


    @Test
    void test_SetName(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act
        myReservation.setName("Tudor");

        //Assert
        Assertions.assertSame("Tudor", myReservation.getName());
    }


    @Test
    void test_GetDate(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act

        //Assert
        Assertions.assertSame(time, myReservation.getDate());
    }


    @Test
    void test_SetDate(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        LocalDateTime test_time = LocalDateTime.of(2022, 9, 11, 10, 30, 9);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act
        myReservation.setDate(test_time);

        //Assert
        Assertions.assertSame(test_time, myReservation.getDate());
    }


    @Test
    void test_GetCapacity(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act

        //Assert
        Assertions.assertEquals(5, myReservation.getCapacity());
    }


    @Test
    void test_SetCapacity(){
        //Arrange
        LocalDateTime time = LocalDateTime.of(2022, 9, 10, 10, 30, 0);
        Reservation myReservation = new Reservation("1234", time, "Alex", 5);

        //Act
        myReservation.setCapacity(4);

        //Assert
        Assertions.assertEquals(4, myReservation.getCapacity());
    }

}
