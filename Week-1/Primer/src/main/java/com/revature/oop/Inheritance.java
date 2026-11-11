package com.revature.oop;

public class Inheritance extends InheritanceParent implements InheritanceInterface {
    /*
        Inheritance is the ability for classes to receive attributes and behaviors from parent resources. Java supports
        single inheritance for classes, but it supports implementing multiple interfaces. Generally speaking, use
        Interfaces when classes have shared behaviors (methods), and use classes when the attributes (fields) are shared.
     */

    // we have a parent constructor that sets a field inherited by all classes that inherit from the parent
    public Inheritance(String myParentVariable) {
        super(myParentVariable);
    }
    // this method comes from the interface and must be implemented here
    @Override
    public String shareMessage(String message) {
        return "This method comes from the interface and must be implemented in the implementing class";
    }

}
