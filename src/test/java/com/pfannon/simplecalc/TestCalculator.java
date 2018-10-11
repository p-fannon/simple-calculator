package com.pfannon.simplecalc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

public class TestCalculator {
    Calculator c = null;

    @Before
    public void setUp() {
        c = new Calculator();
        System.out.println("Testing begins at " + Instant.now().toString());
    }

    @After
    public void coolDown() {
        c = null;
        System.out.println("Testing has concluded at " + Instant.now().toString());
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(5, c.add(2, 3));
    }
}