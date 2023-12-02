package com.otogamidev.deidara.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class TestCalculate {

    final static int[] originalMessage = { 1,1,0,1,0,1,1,0,1,1 };
    final static int[] polynomial = { 1,0,0,1,1 };
    final static int[] result = { 0, 1, 1, 1, 0 };

    @BeforeEach
    void setUp() {

    }
    @Test
    private static void shouldCalculateCRC() {
        final Calculate calculate = new Calculate(originalMessage, polynomial);
        calculate.start();
        final int[] calculatedCRC = calculate.getLastRemainder();
        Assertions.assertArrayEquals(result, calculatedCRC);
    }

    public static void main(String[] args) {
        shouldCalculateCRC();
    }
}