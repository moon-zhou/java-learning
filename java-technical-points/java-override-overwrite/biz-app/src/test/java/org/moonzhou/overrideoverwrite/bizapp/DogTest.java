package org.moonzhou.overrideoverwrite.bizapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class DogTest {

    @Test
    public void  test() {
        Dog dog = new Dog();
        System.out.println(dog.name());
    }
}
