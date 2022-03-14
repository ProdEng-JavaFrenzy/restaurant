package com.javafrenzy.restaurant;

import com.javafrenzy.restaurant.model.*;
import com.javafrenzy.restaurant.repository.*;
import com.javafrenzy.restaurant.controller.*;
import com.javafrenzy.restaurant.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@SpringBootTest
class RestaurantApplicationTests {
    String time = "2022-09-10T10:30:00";
    LocalDateTime resTime = LocalDateTime.parse(time);
    Reservation myReservation = new Reservation("1234", resTime, "Alex", 5);
    Table myTable = new Table((short)6, (short)1);

    /*
    @InjectMocks
    ReservationController reservationController;

    @Mock
    ReservationService reservationService;

    @Test
    void test_AddReservation(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(reservationService.addReservation(any(Reservation.class))).thenReturn(myReservation);

        Reservation reservation = new Reservation("123", resTime, "Marian", 3);
        Reservation responseEntity = reservationController.addReservation(reservation);

    }

     */

    /*
    @Test
    void test_GetIdentifier(){
        Assertions.assertSame("1234", myReservation.getIdentifier());
    }
    */

    @Test
    void test_SetGetReservationIdentifier(){
        myReservation.setIdentifier("12345");
        Assertions.assertSame("12345", myReservation.getIdentifier());
    }

    /*
    @Test
    void test_GetName(){
        Assertions.assertSame("Alex", myReservation.getName());
    }
    */

    @Test
    void test_SetGetReservationName(){
        myReservation.setName("Maria");
        Assertions.assertSame("Maria", myReservation.getName());
    }

    /*
    @Test
    void test_GetDate(){
        Assertions.assertSame(resTime, myReservation.getDate());
    }
    */

    @Test
    void test_SetGetReservationDate(){
        String test_time = "2022-09-11T10:30:00";
        LocalDateTime resTest_Time = LocalDateTime.parse(test_time);
        myReservation.setDate(resTest_Time);
        Assertions.assertSame(resTest_Time, myReservation.getDate());
    }

    /*
    @Test
    void test_GetCapacity(){
        Assertions.assertEquals(5, myReservation.getCapacity());
    }
    */

    @Test
    void test_SetGetReservationCapacity(){
        myReservation.setCapacity(3);
        Assertions.assertEquals(3, myReservation.getCapacity());
    }

    @Test
    void test_SetGetTableId(){
        myTable.setId("111");
        Assertions.assertSame("111", myTable.getId());
    }

    @Test
    void test_SetGetTableCapacity(){
        myTable.setCapacity((short)3);
        Assertions.assertEquals((short)3, myTable.getCapacity());
    }

    @Test
    void test_SetGetTableFloor(){
        myTable.setFloor((short)0);
        Assertions.assertEquals((short)0, myTable.getFloor());
    }

    @Test
    void test_ReservationAddTable(){
        Table temp = new Table((short)7, (short)2);
        myReservation.addTable(temp);
    }

    @Test
    void test_ReservationDeleteTable(){
        Table temp = new Table((short)7, (short)2);
        temp.setId("222");
        myReservation.addTable(temp);
        myReservation.removeTableById("222");
    }

    /*
    @Test
    void test_ReservationService(){
        Assertions.assertSame("Alex", reservationService.checkReservation("Alex").getName());
    }

     */
}
