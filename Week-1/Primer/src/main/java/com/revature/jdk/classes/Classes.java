package com.revature.jdk.classes;

public class Classes {

    /*
        Java is an Object-Oriented Language: this means all your code is going to be facilitated through the use of
        Class blueprints and Object implementations.

        Classes can have attributes (fields) and behaviors (methods). Fields are used to store references to data, and
        methods are used to perform repeatable actions that belong to the class
     */

    public static void main(String[] args) {
        var billy = new Person("Billy", 34);
        billy.greet();
    }

}
