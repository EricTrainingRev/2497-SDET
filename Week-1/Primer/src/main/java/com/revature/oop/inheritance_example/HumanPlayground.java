package com.revature.oop.inheritance_example;

public class HumanPlayground {

    public static void main(String[] args) {
        Human dad = new Adult("Billy", "45");
        dad.speak();
        dad.eat();
        Human kid = new Child("Sally", "6");
        kid.speak();
        kid.eat();
        // we can not make a Human object directly since it is abstract
//        Human doesNotWork = new Human("name", "age");

    }

}
