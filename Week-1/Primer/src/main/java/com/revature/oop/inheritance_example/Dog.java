package com.revature.oop.inheritance_example;

public class Dog extends Animal implements Speaks{

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String speak() {
        return "Bark!";
    }
}
