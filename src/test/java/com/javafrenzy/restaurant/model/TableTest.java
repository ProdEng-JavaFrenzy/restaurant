package com.javafrenzy.restaurant.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TableTest {

    @Test
    void test_GetId(){
        //Arrange
        Table myTable = new Table((short)3, (short)1);

        //Act

        //Assert
        Assertions.assertNull(myTable.getId());
    }

    @Test
    void test_SetId(){
        //Arrange
        Table myTable = new Table((short)3, (short)1);

        //Act
        myTable.setId("111");

        //Assert
        Assertions.assertSame("111", myTable.getId());
    }

    @Test
    void test_GetCapacity(){
        //Arrange
        Table myTable = new Table((short)3, (short)1);

        //Act

        //Assert
        Assertions.assertEquals((short)3, myTable.getCapacity());
    }

    @Test
    void test_SetCapacity(){
        //Arrange
        Table myTable = new Table((short)3, (short)1);

        //Act
        myTable.setCapacity((short)4);

        //Assert
        Assertions.assertEquals((short)4, myTable.getCapacity());
    }

    @Test
    void test_GetFloor(){
        //Arrange
        Table myTable = new Table((short)3, (short)1);

        //Act

        //Assert
        Assertions.assertEquals((short)1, myTable.getFloor());
    }

    @Test
    void test_SetFloor(){
        //Arrange
        Table myTable = new Table((short)3, (short)1);

        //Act
        myTable.setFloor((short)0);

        //Assert
        Assertions.assertEquals((short)0, myTable.getFloor());
    }
}
