package com.revature.oop.inheritance_example;

public class Child extends Human{

    public Child(String name, String age) {
        super(name, age);
    }

    // Here we make the abstract speak method appropriate for a child
    @Override
    public void speak() {
        System.out.println("I no speak good yet");
    }
}
