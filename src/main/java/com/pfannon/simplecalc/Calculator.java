package com.pfannon.simplecalc;

public class Calculator {

    CalculatorService service;

    public Calculator(CalculatorService cloud) {
        this.service = cloud;
    }

    public int perform (int i, int j){
        // return (i + j) * i;
        return service.add(i, j)*i;
    }

    public int add(int i, int j)  {
        return (i + j);
    }

    public int subtract(int i, int j) {
        return (i - j);
    }

    public int multiply(int i, int j) {
        return (i * j);
    }

    public double divide(double i, double j) {
        return (i / j);
    }

    public double squareRoot(double i) {
        return Math.sqrt(i);
    }

    public int powerOf(int base, int exponent) {
        if (exponent == 1) {
            return 1;
        } else {
            return base * powerOf(base, exponent - 1);
        }
    }

    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}