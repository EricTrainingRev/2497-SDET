package com.revature.oop;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism extends PolymorphismParent{

    /*
        Polymorphism is the ability to take on many shapes. In OOP, Java specifically, Polymorphism is the ability for
        methods to take on "many shapes". Java supports "run time" polymorphism and "compile time" polymorphism.

        Compile time polymorphism is overloading: this is where you take a method and create multiple version of it,
        these different version are distinguished by the unique method signatures, typically the changes to the listed
        parameters. See the constructors below: there are two constructors declared, but only one of them declares a
        parameter. When we create a Polymorphism object the version of the constructor used depends on wheter or not
        we provide the String parameter. If we don't the no-args version of the constructor is used. If we provide one,
        the single arg version of the constructor is used. This pattern/rule applies for all methods we create

        Run time polymorphism is overriding: this is where a class inherits a behavior from a parent resource and changes
        the implementation, quite literally "overriding" the inherited resource.
     */

    public Polymorphism(){
        System.out.println("We called the no-args constructor");
    }

    public Polymorphism(String message){
        System.out.println(message);
    }

    @Override
    public void parentMethod() {
        System.out.println("This is the child version of the method");
    }

    public static void main(String[] args) {
        new Polymorphism();
        new Polymorphism("This is my custom message");
        // if you look at your Intellisense for the List below you will see the "add" method is overloaded:
        // you can pass just the object to append it to the list, or provide an index position alongside the object
        // to specify where in the list it should go. Same method, overloaded implementations
        List<Polymorphism> polymorphismsHolder = new ArrayList<>();
        var parent = new PolymorphismParent();
        // original parentMethod used here
        parent.parentMethod();
        var child = new Polymorphism();
        // overridden parentMethod used here
        child.parentMethod();

    }

}
