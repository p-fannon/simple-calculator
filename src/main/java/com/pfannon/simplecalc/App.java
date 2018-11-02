package com.pfannon.simplecalc;

import java.util.Scanner;

public class App {
    private static String[] functions = {"1. Addition", "2. Subtraction", "3. Multiplication", "4. Division",
            "5. Square Root", "6. Power", "7. Factorial", "8. Fibonacci Sequence"};
    public static void main(String[] args) {
        System.out.println("Hello world! Let's start calculating!");
        Scanner in = new Scanner(System.in);
        boolean run = true;
        Calculator c = new Calculator();
        int choose;
        while (run) {
            System.out.println("Choose your function: ");
            for (String entry : functions) {
                System.out.println(entry);
            }
            choose = in.nextInt();
            if (choose < 1 || choose > 8) {
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
                        System.out.println("Pick your base number: ");
                        first = in.nextInt();
                        System.out.println("Pick your exponent number: ");
                        second = in.nextInt();
                        System.out.println("Result is " + c.powerOf(first, second));
                        break;
                    case 7:
                        System.out.println("Pick your number: ");
                        first = in.nextInt();
                        System.out.println("Result is " + c.factorial(first));
                        break;
                    case 8:
                        System.out.println("How many times do you want to repeat the Fibonacci Sequence? (You can go forwards or backwards)");
                        first = in.nextInt();
                        System.out.println("Result is " + c.fibonacci(first));
                        break;
                }
                boolean valid = false;
                in.nextLine();
                while (!valid) {
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
                        System.out.println("Not a valid answer!\n");
                    }
                }
            }
        }
    }
}
