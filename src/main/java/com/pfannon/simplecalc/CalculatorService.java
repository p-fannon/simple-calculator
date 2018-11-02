package com.pfannon.simplecalc;

public interface CalculatorService {
    int add(int i, int j);
    int subtract(int i, int j);
    int multiply(int i, int j);
    double divide(double i, double j);
    double squareRoot(double i);
    long powerOf(int i, int j);
    long factorial(int i);
    int fabonacci(int i);
}
