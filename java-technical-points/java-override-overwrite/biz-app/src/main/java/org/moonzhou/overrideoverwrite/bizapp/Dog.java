package org.moonzhou.overrideoverwrite.bizapp;

import org.moonzhou.overrideoverwrite.base.Animal;

class Dog extends Animal {

    @Override
    public String name() {
        System.out.println("Dog");
        return "Dog";
    }

    // 重写 makeSound 方法
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}