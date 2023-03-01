package de.telran.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsExample {

    public static void main(String[] args) {
        runtimeExceptionsExample();
//        tryWithResourcesExample();
//        throwExample();
//        whileLoopWithExceptionExample();
//        div2(10, 0);
    }

    private static void whileLoopWithExceptionExample() {
        int i = 0;

        while (true) {
            i++;
            System.out.print(i + " ");

            try {
                if (i == 20) throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.println("Exception");
            }

            if (i > 40) break;
        }
    }

    private static void throwExample() {
//        MyCustomException exception = new MyCustomException();
//        throw exception;
        throw new MyCustomException();
    }

    private static void tryWithResourcesExample() {
        try (Scanner scanner = new Scanner(new File("files/some.txt"))) {
            int counter = 1;
            while (scanner.hasNext()) {
                System.out.println("Line " + counter++);
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


//        System.out.println(scanner.nextLine());

        System.out.println("THE END");
    }

    private static void runtimeExceptionsExample() {
        System.out.println("BEFORE DELETING MAIN");
        divideByZero();
        System.out.println("AFTER DELETING MAIN");
    }


    private static void divideByZero() {
        try {
            div2(10, 0);
        } catch (IndexOutOfBoundsException | NullPointerException | UnsupportedOperationException exception) {
            System.out.println("Index out of bounds");
        } catch (ArithmeticException e) {
            System.out.println("Don't divide by zero");
            e.printStackTrace();
//            System.exit(1);
        } catch (NumberFormatException ex) {
            System.out.println("Number format");
        } catch (RuntimeException e) {
            System.out.println("RUNTIME");
        } finally {
            System.out.println("FINALLY");
        }
    }

    private static int div2(int a, int b) {
        return div1(a, b);
    }

    private static int div1(int a, int b) {
        return div0(a, b);
    }

    private static int div0(int a, int b) {
//        if (b == 0) {
//            return 0;
//        }
        return a / b;
    }
}
