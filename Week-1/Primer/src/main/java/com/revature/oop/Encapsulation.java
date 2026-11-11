package com.revature.oop;

import com.revature.oop.encapsulation_example.Human;

public class Encapsulation {
    /*
        Encapsulation is all about controlling access to your data. OOP is itself a form of encapsulation, because you
        "encapsulate" data in classes and then get access to that data by creating objects of those classes. In Java,
        encapsulation typically takes the form of "setter" and "getter" methods for accessing object attributes
     */

    public static void main(String[] args) {
        Human billy = new Human("Billy", 32);
        // here we can see encapsulation in action through the requirement of using the public getter method to access
        // the name field instead of going through it directly
        System.out.println(billy.getName());
    }
}
