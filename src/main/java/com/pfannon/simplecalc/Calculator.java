package com.pfannon.simplecalc;

public class Calculator {

    CalculatorService service;

    // for use with App
    public Calculator(){ }

    // for use with testing
    public Calculator(CalculatorService cloud) {
        this.service = cloud;
    }

    public int performAdd(int i, int j) {
        // return (i + j) * i;
        return service.add(i, j) * i;
    }

    public int performSubtract(int i, int j) {
        // return (i - j) * i;
        return service.subtract(i, j) * i;
    }

    public int performMultiply(int i, int j) {
        // return (i * j) - i;
        return service.multiply(i, j) - i;
    }

    public double performDivide(double i, double j) {
        // return (i / j) + i;
        return service.divide(i, j) + i;
    }

    public double performSquareRoot(double i) {
        // return (sqrt(i)) - (i / 2);
        return service.squareRoot(i) - (i / 2);
    }

    public long performPowerOf(int i, int j) {
        // return (i ^ j) - j;
        return service.powerOf(i, j) - j;
    }

    public long performFactorial(int i) {
        // return fact(i) - i;
        return service.factorial(i) - i;
    }

    public int performFabonacci(int i) {
        // return f(n) - n
        return service.fabonacci(i) - i;
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
        double n;
        double sqRt = i / 2;
        do {
            n = sqRt;
            sqRt = (n + (i / n)) / 2;
        } while ((n - sqRt) != 0);
        return sqRt;
    }

    public long powerOf(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else {
            return base * powerOf(base, exponent - 1);
        }
    }

    public long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public int fibonacci(int n) {
        int result = 0;
        int sum1 = 0;
        int sum2 = 0;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                if (i < 2) {
                    sum2 = i;
                } else if (i == 2) {
                    sum1 = 1;
                    sum2 = 0;
                } else {
                    sum2 = sum1;
                    sum1 = result;
                }
                result = sum1 + sum2;
            }
        }
        if (n < 0) {
            for (int i = -1; i >= n; i--) {
                if (i > -2) {
                    sum2 = 1;
                    sum1 = 0;
                } else {
                    sum2 = sum1;
                    sum1 = result;
                }
                result = sum2 - sum1;
            }
        }
        return result;
    }
}