package com.revature.jdk.classes;

public class Person {

    // These are the attributes (fields) of the class. They should represent data that is meaningful to the class and its
    // behaviors (methods
    String name;
    int age;

    // constructors are special methods that create objects of the class. They are the standard way of creating and
    // initializing the starting data for an object
    public Person(String name, int age){
        // "this" is a reference to the object being created by the constructor. In this example it provides us with a
        // way of distinguishing between the "name" field of the object and the "name" parameter that holds the value
        // the field is going to be set to. Same with age
        this.name = name;
        this.age = age;
    }

    // this is the behavior (method) of the class. Note how it makes use of the fields of the class in order to facilitate
    // its action
    void greet(){
        System.out.println("I am " + name + " and I am " + age + " years old");
    }

}
