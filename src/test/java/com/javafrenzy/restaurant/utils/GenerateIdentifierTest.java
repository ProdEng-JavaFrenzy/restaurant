package com.javafrenzy.restaurant.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenerateIdentifierTest {

    @Test
    void test_GenerateIdentifier(){
        //Arrange
        GenerateIdentifier generateIdentifier = new GenerateIdentifier();

        //Act
        String identifier = generateIdentifier.getIdentifier();

        //Assert
        Assertions.assertNotNull(identifier);
    }
}
