package com.javafrenzy.restaurant.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;
import java.time.LocalDateTime;

@SpringBootTest
class ReservationTest {
    @Mock
    Reservation reservation = null;

    @Test
    void test_GetIdentifier(){
        String time = "2022-09-10T10:30:00";
        LocalDateTime resTime = LocalDateTime.parse(time);
        Reservation myReservation = new Reservation("1234", resTime, "Alex", 5);
        Assertions.assertSame("1234", myReservation.getIdentifier());
    }


    @Test
    void test_SetIdentifier(){
        Reservation myReservation = reservation;
        myReservation.setIdentifier("111");
        verify(reservation).setIdentifier("111");
    }


    @Test
    void test_GetName(){
        String time = "2022-09-10T10:30:00";
        LocalDateTime resTime = LocalDateTime.parse(time);
        Reservation myReservation = new Reservation("1234", resTime, "Alex", 5);
        Assertions.assertSame("Alex", myReservation.getName());
    }


    @Test
    void test_SetName(){
        Reservation myReservation = reservation;
        myReservation.setName("Tudor");
        verify(reservation).setName("Tudor");
    }


    @Test
    void test_GetDate(){
        String time = "2022-09-10T10:30:00";
        LocalDateTime resTime = LocalDateTime.parse(time);
        Reservation myReservation = new Reservation("1234", resTime, "Alex", 5);
        Assertions.assertSame(resTime, myReservation.getDate());
    }


    @Test
    void test_SetDate(){
        Reservation myReservation = reservation;
        String test_time = "2022-09-11T10:30:00";
        LocalDateTime resTest_Time = LocalDateTime.parse(test_time);
        myReservation.setDate(resTest_Time);
        verify(reservation).setDate(resTest_Time);
    }


    @Test
    void test_GetCapacity(){
        String time = "2022-09-10T10:30:00";
        LocalDateTime resTime = LocalDateTime.parse(time);
        Reservation myReservation = new Reservation("1234", resTime, "Alex", 5);
        Assertions.assertEquals(5, myReservation.getCapacity());
    }


    @Test
    void test_SetCapacity(){
        Reservation myReservation = reservation;
        myReservation.setCapacity(3);
        verify(reservation).setCapacity(3);
    }
    
}
