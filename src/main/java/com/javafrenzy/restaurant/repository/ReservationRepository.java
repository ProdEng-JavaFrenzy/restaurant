package com.javafrenzy.restaurant.repository;

import java.util.List;
import java.util.Optional;

import com.javafrenzy.restaurant.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * No need to implement this interface.
 * Spring Data MongoDB automatically creates a class it implementing the interface when you run the application.
 */
@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    Optional<Reservation> findByIdentifier(String identifier);
    Optional<Reservation> deleteByIdentifier(String identifier);
}
