package com.swagger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Home {

    Cal cal = new Cal();
    @Test
    void addTwoNumbers() {
        assertEquals(45, cal.add(23, 22));
    }

    class Cal{
        int add(int a, int b) {
            return a+b;
        }
    }
}
