package com.konstantine.pizzamenu;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomTests {
    @Test
    void testTest(){
        System.out.println("Test");
        assertEquals(8, 8);

    }
}
