package de.telran;

@FunctionalInterface
public interface Moving {

    void move();

    default void doDefault() {
        System.out.println("Default");
    }

    private void doPrivate() {
        System.out.println("Private");
    }

    static void doStatic() {
        System.out.println("Static");
    }
}
