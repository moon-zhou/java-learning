package org.moonzhou.overrideoverwrite.base;

public abstract class Animal {
    public abstract String name();

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}