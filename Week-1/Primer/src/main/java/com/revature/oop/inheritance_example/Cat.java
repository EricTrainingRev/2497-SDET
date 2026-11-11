package com.revature.oop.inheritance_example;

public class Cat extends Animal implements Speaks{

    public Cat(String name, int age){
        super(name, age);
    }

    @Override
    public String speak() {
        return "Meow!";
    }
}
