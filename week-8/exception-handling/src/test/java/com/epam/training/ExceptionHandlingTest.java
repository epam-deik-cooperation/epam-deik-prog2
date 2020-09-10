package com.epam.training;

import org.junit.Test;

public class ExceptionHandlingTest {

    private final ExceptionHandling underTest = new ExceptionHandling();

    @Test
    public void testWhenInputIsFloat() {
        underTest.test(1F);
    }

    @Test
    public void testWhenInputIsString() {
        underTest.test("string");
    }

    @Test
    public void testWhenInputIsNull() {
        underTest.test(null);
    }

}
