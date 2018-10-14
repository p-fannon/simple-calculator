package com.pfannon.simplecalc;

import java.util.Scanner;

import static org.mockito.Mockito.mock;

public class App {
    private static String[] functions = {"1. Addition", "2. Subtraction", "3. Multiplication", "4. Division", "5. Square Root", "6. Power", "7. Factorial"};
    public static void main(String[] args) {
        System.out.println("Hello world! Let's start calculating!");
        Scanner in = new Scanner(System.in);
        boolean run = true;
        CalculatorService service = mock(CalculatorService.class);
        Calculator c = new Calculator(service);
        int choose;
        while (run) {
            System.out.println("Choose your function: ");
            for (String entry : functions) {
                System.out.println(entry);
            }
            choose = in.nextInt();
            if (choose < 1 || choose > 7) {
                System.out.println("Nope!");
            } else {
                int first;
                int second;
                double decimal;
                switch (choose) {
                    case 1:
                        System.out.println("Pick your first integer: ");
                        first = in.nextInt();
                        System.out.println("Pick your second integer: ");
                        second = in.nextInt();
                        System.out.println("Result is " + c.add(first, second));
                        break;
                    case 2:
                        System.out.println("Pick your first integer: ");
                        first = in.nextInt();
                        System.out.println("Pick your second integer: ");
                        second = in.nextInt();
                        System.out.println("Result is " + c.subtract(first, second));
                        break;
                    case 3:
                        System.out.println("Pick your first integer: ");
                        first = in.nextInt();
                        System.out.println("Pick your second integer: ");
                        second = in.nextInt();
                        System.out.println("Result is " + c.multiply(first, second));
                        break;
                    case 4:
                        System.out.println("Pick your first integer: ");
                        first = in.nextInt();
                        System.out.println("Pick your second integer: ");
                        second = in.nextInt();
                        System.out.println("Result is " + c.divide(first, second));
                        break;
                    case 5:
                        System.out.println("Pick your whole or decimal number: ");
                        decimal = in.nextDouble();
                        System.out.println("Result is " + c.squareRoot(decimal));
                        break;
                    case 6:
                        System.out.println("Pick your base integer: ");
                        first = in.nextInt();
                        System.out.println("Pick your exponent integer: ");
                        second = in.nextInt();
                        System.out.println("Result is " + c.powerOf(first, second));
                        break;
                    case 7:
                        System.out.println("Pick your integer: ");
                        first = in.nextInt();
                        System.out.println("Result is " + c.factorial(first));
                        break;
                }
                boolean valid = true;
                do {
                    System.out.println("Calculate again? (y/n) ");
                    String input = in.nextLine();
                    if (input.equals("y")) {
                        System.out.println("Mathematical!");
                        valid = true;
                        run = true;
                    } else if (input.equals("n")) {
                        System.out.println("Goodbye!");
                        valid = true;
                        run = false;
                    } else {
                        System.out.println("Not a valid answer!");
                        valid = false;
                    }
                } while (!valid);
            }
        }
    }
}
