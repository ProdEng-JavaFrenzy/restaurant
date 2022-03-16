package com.javafrenzy.restaurant.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    @Id
    private String id;
    private String identifier;
    private LocalDateTime date;
    private String name;
    private int capacity;

    @DBRef
    private List<Table> tables = new ArrayList<>();

    public Reservation(String identifier, LocalDateTime date, String name, int capacity) {

        this.identifier = identifier;
        this.date = date;
        this.name = name;
        this.capacity = capacity;
    }
    public Reservation(){

    }
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Table> getTables() {
        return tables;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id + '\'' +
                ", identifier='" + identifier + '\'' +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
