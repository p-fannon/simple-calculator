package com.pfannon.simplecalc;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.Instant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class TestCalculator {
    Calculator c = null;
    @Mock
    CalculatorService service;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        c = new Calculator(service);
        System.out.println("Testing begins at " + Instant.now().toString());
    }

    @After
    public void coolDown() {
        Calculator c = null;
        System.out.println("Testing has concluded at " + Instant.now().toString());
    }

    @Test
    public void testAdd() {
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testPerform() {
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.perform(2, 3));
        verify(service).add(2,3);
    }
}