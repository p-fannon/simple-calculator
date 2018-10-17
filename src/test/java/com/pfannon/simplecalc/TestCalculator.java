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

    @Test
    public void testSubtractSingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(4, c.subtract(7, 3));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSubtractDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(-11, c.subtract(30, 41));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSubtractTriple() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(555, c.subtract(999, 444));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSubtractPerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.subtract(15, 7)).thenReturn(8);
        assertEquals(120, c.performSubtract(15, 7));
        verify(service).subtract(15, 7);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testMultiplySingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(4, c.multiply(2, 2));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testMultiplyDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(825, c.multiply(25, 33));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testMultiplyTriple() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(20000, c.multiply(100, 200));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testMultiplyPerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.multiply(1111, 42)).thenReturn(46662);
        assertEquals(45551, c.performMultiply(1111, 42));
        verify(service).multiply(1111, 42);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testDivideSingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(3.0, c.divide(9.0, 3.0), 0);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testDivideDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(3.333333333, c.divide(40, 12), 1e-9);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testDivideTriple() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(4.0, c.divide(888, 222), 1e-15);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testDividePerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.divide(1000.0, 2.5)).thenReturn(400.0);
        assertEquals(1400.0, c.performDivide(1000.0, 2.5), 0);
        verify(service).divide(1000.0, 2.5);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSquareRootSingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(3.0, c.squareRoot(9.0), 0);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSquareRootDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(9.0, c.squareRoot(81.0), 0);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSquareRootTriple() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(11.0, c.squareRoot(121.0), 0);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testSquareRootPerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.squareRoot(1000000.0)).thenReturn(1000.0);
        assertEquals(-499000, c.performSquareRoot(1000000.0), 0);
        verify(service).squareRoot(1000000.0);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testPowerSingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(19683L, c.powerOf(3, 9));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testPowerDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(100000000000L, c.powerOf(10, 11));
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testPowerPerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.powerOf(2, 50)).thenReturn(1125899906842624L);
        assertEquals(1125899906842574L, c.performPowerOf(2, 50));
        verify(service).powerOf(2, 50);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testFactorialSingle() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(c.factorial(3), 6L);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testFactorialDouble() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        assertEquals(c.factorial(11), 39916800L);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testFactorialPerform() {
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        when(service.factorial(20)).thenReturn(2432902008176640000L);
        assertEquals(2432902008176639980L, c.performFactorial(20));
        verify(service).factorial(20);
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }
}