package com.javafrenzy.restaurant.model;

import org.springframework.data.annotation.Id;

public class Table {
    @Id
    private String id;
    private short capacity;
    private short floor;

    public Table(short capacity, short floor) {
        this.capacity = capacity;
        this.floor = floor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public short getCapacity() {
        return capacity;
    }

    public void setCapacity(short capacity) {
        this.capacity = capacity;
    }

    public short getFloor() {
        return floor;
    }

    public void setFloor(short floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Table { " +
                "id = '" + id + "\'" +
                ", capacity = " + capacity +
                ", floor = '" + floor + "\'" +
                "}";
    }
}
