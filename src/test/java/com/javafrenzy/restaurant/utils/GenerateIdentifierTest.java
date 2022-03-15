package com.javafrenzy.restaurant.utils;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;

@SpringBootTest
class GenerateIdentifierTest {

    @Mock
    GenerateIdentifier generateIdentifier;

    @Test
    void test_GenerateIdentifier(){
        GenerateIdentifier myIdentifier = generateIdentifier;
        myIdentifier.getIdentifier();
        verify(generateIdentifier).getIdentifier();
    }
}
