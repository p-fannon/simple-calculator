package com.pfannon.simplecalc;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.Instant;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestCalculator {
    Calculator c = null;
    private static final Logger testLogger = Logger.getLogger(TestCalculator.class.getName());
    @Mock
    CalculatorService service;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        c = new Calculator(service);
    }

    @After
    public void coolDown() {
        c = null;
    }

    @Test
    public void testAddSingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(5, c.add(2, 3));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testAddDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(50, c.add(21, 29));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testAddTriple() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(501, c.add(240, 261));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testAddPerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.performAdd(2, 3));
        verify(service).add(2,3);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());

    }
}