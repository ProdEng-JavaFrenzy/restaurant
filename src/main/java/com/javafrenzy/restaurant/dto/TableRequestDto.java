package com.javafrenzy.restaurant.dto;

public class TableRequestDto {
    private short capacity;
    private short floor;

    public TableRequestDto(short capacity, short floor) {
        this.capacity = capacity;
        this.floor = floor;
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
}
