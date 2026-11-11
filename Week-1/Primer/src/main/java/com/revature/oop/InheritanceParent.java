package com.revature.oop;

/*
    A parent class can be used when you have shared attributes (fields), and possibly shared behaviors (methods) as well.
    The benefit of storing this information in a parent class as opposed to interface is you have flexibility in your
    implementation and access modifiers that don't come standard in an interface
 */
public class InheritanceParent {

    String myParentVariable;

    public InheritanceParent(String myParentVariable){
        this.myParentVariable = myParentVariable;
    }

}
