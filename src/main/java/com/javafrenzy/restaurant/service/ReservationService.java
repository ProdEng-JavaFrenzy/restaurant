package com.javafrenzy.restaurant.service;

import com.javafrenzy.restaurant.exception.ReservationAlreadyAddedException;
import com.javafrenzy.restaurant.exception.ReservationNotFoundException;
import com.javafrenzy.restaurant.exception.TableAlreadyAddedException;
import com.javafrenzy.restaurant.exception.TableNotFoundException;
import com.javafrenzy.restaurant.model.Reservation;
import com.javafrenzy.restaurant.model.Table;
import com.javafrenzy.restaurant.repository.ReservationRepository;
import com.javafrenzy.restaurant.repository.TableRepository;
import com.javafrenzy.restaurant.utils.GenerateIdentifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private GenerateIdentifier generateIdentifier;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation checkReservation(String name) {
        return reservationRepository.findByName(name).orElseThrow(
                () -> new ReservationNotFoundException(name));
    }

    public Reservation deleteReservation(String name) {
        return reservationRepository.deleteByName(name).orElseThrow(
                () -> new ReservationNotFoundException(name));
    }

    public Reservation addReservation(Reservation reservation) {
        reservationRepository.findByName(reservation.getName()).ifPresent(s -> {
            throw new ReservationAlreadyAddedException(reservation.getName());
        });
        String identifier = generateIdentifier.getIdentifier();
        Reservation newReservation = new Reservation(identifier, reservation.getDate(), reservation.getName(),
                reservation.getCapacity());
        return reservationRepository.save(newReservation);
    }

    public Reservation updateReservation(Reservation reservation) {
        String identifier = generateIdentifier.getIdentifier();
        return reservationRepository.findByName(reservation.getName())
                .map(updateReservation -> {
                    updateReservation.setIdentifier(identifier);
                    updateReservation.setDate(reservation.getDate());
                    updateReservation.setName(reservation.getName());
                    updateReservation.setCapacity(reservation.getCapacity());
                    return reservationRepository.save(updateReservation);
                })
                .orElseThrow(() -> new ReservationNotFoundException(reservation.getName()));
    }

    public void addTableToReservation(String identifier, String tableId) {
        Reservation reservation = reservationRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new ReservationNotFoundException(identifier));
        Table table = tableRepository.findById(tableId).orElseThrow(() -> new TableNotFoundException(tableId));

        addTableToReservation(table, reservation);
        reservationRepository.save(reservation);
    }

    public void deleteTableFromReservation(String identifier, String tableId) {
        Reservation reservation = reservationRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new ReservationNotFoundException(identifier));
        tableRepository.findById(tableId).orElseThrow(() -> new TableNotFoundException(tableId));

        deleteTableFromReservation(tableId, reservation);
        reservationRepository.save(reservation);
    }

    private static void addTableToReservation(Table table, Reservation reservation) {
        if (reservation.getTables().stream().anyMatch(t -> t.getId().equals(table.getId()))) {
            throw new TableAlreadyAddedException(table.getId());
        }
        reservation.getTables().add(table);
    }

    private static void deleteTableFromReservation(String tableId, Reservation reservation) {
        Table table = reservation.getTables().stream()
                .filter(t -> t.getId().equals(tableId))
                .findFirst()
                .orElseThrow(() -> new TableNotFoundException(tableId));
        reservation.getTables().remove(table);
    }
}
