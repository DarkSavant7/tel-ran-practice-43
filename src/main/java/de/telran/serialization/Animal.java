package de.telran.serialization;

import java.io.Serializable;

public class Animal implements Serializable {

    public Animal(String name) {
        System.out.println("Animal born");
    }
}
