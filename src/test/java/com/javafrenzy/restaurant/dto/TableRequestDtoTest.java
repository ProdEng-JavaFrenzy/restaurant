package com.javafrenzy.restaurant.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TableRequestDtoTest {
    TableRequestDto tableDto = new TableRequestDto((short) 1, (short) 3);

    @Test
    void test_capacity() {
        assertEquals(1, tableDto.getCapacity());
    }

    @Test
    void test_floor() {
        assertEquals(3, tableDto.getFloor());
    }
}
