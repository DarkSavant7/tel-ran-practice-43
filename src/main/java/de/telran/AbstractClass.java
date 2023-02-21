package de.telran;

import java.io.Serializable;

public abstract class AbstractClass implements Serializable, Cloneable {
    private String field;

    public abstract void doSomethingAbstract();

    public void someMethod() {
        System.out.println("Some method");
    }
}
