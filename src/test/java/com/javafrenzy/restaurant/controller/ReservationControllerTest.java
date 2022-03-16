package com.javafrenzy.restaurant.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.service.ReservationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReservationControllerTest {

    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void test_reservations() throws Exception {

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation("TESTTES", LocalDateTime.of(2022, 8, 1, 9, 30), "test", 0));
        when(reservationService.getAllReservations()).thenReturn(reservations);

        MvcResult result = mockMvc.perform(get("/reservations")
                .content(objectMapper.writeValueAsString(reservations))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(reservations));
    }

    @Test
    void test_checkReservation() throws Exception{

        Reservation reservation = new Reservation("TESTTES", LocalDateTime.of(2022, 8, 1, 9, 30), "test", 0);
        when(reservationService.checkReservation(any())).thenReturn(reservation);
        MvcResult result = mockMvc.perform(get("/checkReservation/test")
                .content(objectMapper.writeValueAsString(reservation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(reservation));

    }

    @Test
    void test_addReservation() throws Exception{

        Reservation reservation = new Reservation();
        reservation.setDate(LocalDateTime.of(2022, 8, 1, 9, 30));
        reservation.setName("JavaFrenzy");
        reservation.setCapacity(3);
        when(reservationService.addReservation(any())).thenReturn(reservation);
        MvcResult result = mockMvc.perform(post("/addReservation")
                .content(objectMapper.writeValueAsString(reservation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(reservation));

    }
    @Test
    void test_updateReservation() throws Exception{

        Reservation reservation = new Reservation();
        reservation.setDate(LocalDateTime.of(2022, 8, 1, 9, 30));
        reservation.setName("JavaFrenzy");
        reservation.setCapacity(5);
        when(reservationService.updateReservation(any())).thenReturn(reservation);
        MvcResult result = mockMvc.perform(put("/updateReservation")
                .content(objectMapper.writeValueAsString(reservation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(reservation));

    }
    @Test
    void test_deleteReservation() throws Exception{

        Reservation reservation = new Reservation("TESTTES", LocalDateTime.of(2022, 8, 1, 9, 30), "test", 0);
        when(reservationService.deleteReservation(any())).thenReturn(reservation);
        MvcResult result = mockMvc.perform(delete("/deleteReservation/test")
                .content(objectMapper.writeValueAsString(reservation))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(), objectMapper.writeValueAsString(reservation));

    }

}
