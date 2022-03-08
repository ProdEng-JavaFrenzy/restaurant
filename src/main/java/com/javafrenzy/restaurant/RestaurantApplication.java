package com.javafrenzy.restaurant;

import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.repository.ReservationRepository;
import com.javafrenzy.restaurant.utils.GenerateIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class RestaurantApplication {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private GenerateIdentifier generateIdentifier;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }

    @PostConstruct
    public void runAfterObjectCreated() {

        String identifier = generateIdentifier.getIdentifier();
        reservationRepository.deleteAll();
        reservationRepository.save(new Reservation(identifier, LocalDateTime.of(2022, 8, 1, 9, 30), "Tudor", 5));
        reservationRepository.save(new Reservation("TESTTES", LocalDateTime.of(2022, 8, 1, 9, 30), "test", 0));
    }
}
