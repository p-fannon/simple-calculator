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
        testLogger.info("Beginning of unit testing starts at " + Instant.now().toString());
        c = new Calculator(service);
    }

    @After
    public void coolDown() {
        c = null;
        testLogger.info("Ending of unit testing concludes at " + Instant.now().toString());
    }

    @Test
    public void testAddSingle() {
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testAddDouble() {
        assertEquals(50, c.add(21, 29));
    }

    @Test
    public void testAddTriple() {
        assertEquals(501, c.add(240, 261));
    }

    @Test
    public void testAddPerform() {
        when(service.add(2,3)).thenReturn(5);
        assertEquals(10, c.performAdd(2, 3));
        verify(service).add(2,3);

    }

    @Test
    public void testSubtractSingle() {
        assertEquals(4, c.subtract(7, 3));
    }

    @Test
    public void testSubtractDouble() {
        assertEquals(-11, c.subtract(30, 41));
    }

    @Test
    public void testSubtractTriple() {
        assertEquals(555, c.subtract(999, 444));
    }

    @Test
    public void testSubtractPerform() {
        when(service.subtract(15, 7)).thenReturn(8);
        assertEquals(120, c.performSubtract(15, 7));
        verify(service).subtract(15, 7);
    }

    @Test
    public void testMultiplySingle() {
        assertEquals(4, c.multiply(2, 2));
    }

    @Test
    public void testMultiplyDouble() {
        assertEquals(825, c.multiply(25, 33));
    }

    @Test
    public void testMultiplyTriple() {
        assertEquals(20000, c.multiply(100, 200));
    }

    @Test
    public void testMultiplyPerform() {
        when(service.multiply(1111, 42)).thenReturn(46662);
        assertEquals(45551, c.performMultiply(1111, 42));
        verify(service).multiply(1111, 42);
    }

    @Test
    public void testDivideSingle() {
        assertEquals(3.0, c.divide(9.0, 3.0), 0);
    }

    @Test
    public void testDivideDouble() {
        assertEquals(3.333333333, c.divide(40, 12), 1e-9);
    }

    @Test
    public void testDivideTriple() {
        assertEquals(4.0, c.divide(888, 222), 1e-15);
    }

    @Test
    public void testDividePerform() {
        when(service.divide(1000.0, 2.5)).thenReturn(400.0);
        assertEquals(1400.0, c.performDivide(1000.0, 2.5), 0);
        verify(service).divide(1000.0, 2.5);
    }

    @Test
    public void testSquareRootSingle() {
        assertEquals(3.0, c.squareRoot(9.0), 0);
    }

    @Test
    public void testSquareRootDouble() {
        assertEquals(9.0, c.squareRoot(81.0), 0);
    }

    @Test
    public void testSquareRootTriple() {
        assertEquals(11.0, c.squareRoot(121.0), 0);
    }

    @Test
    public void testSquareRootPerform() {
        when(service.squareRoot(1000000.0)).thenReturn(1000.0);
        assertEquals(-499000, c.performSquareRoot(1000000.0), 0);
        verify(service).squareRoot(1000000.0);
    }

    @Test
    public void testPowerSingle() {
        assertEquals(19683L, c.powerOf(3, 9));
    }

    @Test
    public void testPowerDouble() {
        assertEquals(100000000000L, c.powerOf(10, 11));
    }

    @Test
    public void testPowerPerform() {
        when(service.powerOf(2, 50)).thenReturn(1125899906842624L);
        assertEquals(1125899906842574L, c.performPowerOf(2, 50));
        verify(service).powerOf(2, 50);
    }

    @Test
    public void testFactorialSingle() {
        assertEquals(c.factorial(3), 6L);
    }

    @Test
    public void testFactorialDouble() {
        assertEquals(c.factorial(11), 39916800L);
    }

    @Test
    public void testFactorialPerform() {
        when(service.factorial(20)).thenReturn(2432902008176640000L);
        assertEquals(2432902008176639980L, c.performFactorial(20));
        verify(service).factorial(20);
    }

    @Test
    public void testFibonacciZero() {
        assertEquals(c.fibonacci(0), 0);
    }

    @Test
    public void testFibonacciOne() {
        assertEquals(c.fibonacci(1), 1);
    }

    @Test
    public void testFibonacciTwo() {
        assertEquals(c.fibonacci(2), 1);
    }

    @Test
    public void testFibonacciThree() {
        assertEquals(c.fibonacci(3), 2);
    }

    @Test
    public void testFibonacciFour() {
        assertEquals(c.fibonacci(4), 3);
    }

    @Test
    public void testFibonacciFive() {
        assertEquals(c.fibonacci(5), 5);
    }

    @Test
    public void testFibonacciTen() {
        assertEquals(c.fibonacci(10), 55);
    }

    @Test
    public void testFibonacciFifteen() {
        assertEquals(c.fibonacci(15), 610);
    }

    @Test
    public void testFibonacciTwenty() {
        assertEquals(c.fibonacci(20), 6765);
    }

    @Test
    public void testFibonacciNegOne() {
        assertEquals(c.fibonacci(-1), 1);
    }

    @Test
    public void testFibonacciNegTwo() {
        assertEquals(c.fibonacci(-2), -1);
    }

    @Test
    public void testFibonacciNegThree() {
        assertEquals(c.fibonacci(-3), 2);
    }

    @Test
    public void testFibonacciNegFive() {
        assertEquals(c.fibonacci(-5), 5);
    }

    @Test
    public void testFibonacciNegEight() {
        assertEquals(c.fibonacci(-8), -21);
    }

    @Test
    public void testFibonacciPosPerform() {
        when(service.fabonacci(18)).thenReturn(2584);
        assertEquals(c.performFabonacci(18), 2566);
        verify(service).fabonacci(18);
    }

    @Test
    public void testFibonacciNegPerform() {
        when(service.fabonacci(-7)).thenReturn(13);
        assertEquals(c.performFabonacci(-7), 20);
        verify(service).fabonacci(-7);
    }
}