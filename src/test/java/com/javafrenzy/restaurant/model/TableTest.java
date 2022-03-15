package com.javafrenzy.restaurant.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class TableTest {
    @Mock
    Table table = null;

    @Test
    void test_SetId(){
        Table myTable = table;
        myTable.setId("111");
        verify(table).setId("111");
    }

    @Test
    void test_GetId(){
        Table myTable = new Table((short)3, (short)1);
        myTable.setId("111");
        Assertions.assertSame("111", myTable.getId());
    }

    @Test
    void test_GetCapacity(){
        Table myTable = new Table((short)6, (short)1);
        Assertions.assertEquals((short)6, myTable.getCapacity());
    }

    @Test
    void test_SetCapacity(){
        Table myTable = table;
        myTable.setCapacity((short)4);
        verify(table).setCapacity((short)4);
    }

    @Test
    void test_GetFloor(){
        Table myTable = new Table((short)6, (short)1);
        Assertions.assertEquals((short)1, myTable.getFloor());
    }

    @Test
    void test_SetFloor(){
        Table myTable = table;
        myTable.setFloor((short)0);
        verify(table).setFloor((short)0);
    }
}
