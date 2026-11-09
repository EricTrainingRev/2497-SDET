package com.revature.object;

import java.util.Objects;

public class ObjectExample {

    /*
        In Java, all classes have a shared parent: the base Object class. This class provides the core resources that
        are available to all other classes in Java. Some of the more common resources provided by Object that you will
        interact with are the toString method, equals method, and hashcode method
     */

    String myField;

    public ObjectExample(String myField) {
        this.myField = myField;
    }

    public static void main(String[] args) {
        var myObject = new ObjectExample("My String");
        System.out.println(myObject);
    }

    // toString is provided by the base Object class and can be overridden to provide a meaningful textual representation
    // of your object
    @Override
    public String toString() {
        return "ObjectExample{" +
                "myField='" + myField + '\'' +
                '}';
    }

    // equals is provided by the base Object class and is used to tell Java how to determine if two objects of your class
    // represent the same thing
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ObjectExample that = (ObjectExample) o;
        return Objects.equals(myField, that.myField);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(myField);
    }
}
