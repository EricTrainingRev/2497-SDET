package com.revature.oop.inheritance_example;

public class Adult extends Human {

    public Adult(String name, String age) {
        super(name, age);
    }

    // because speak is an abstract method in the parent class it MUST be implemented for Adult objects here
    @Override
    public void speak() {
        System.out.println("I am adult so I can use full sentences that make sens");
    }
}
