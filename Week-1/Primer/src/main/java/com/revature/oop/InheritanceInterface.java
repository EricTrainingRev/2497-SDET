package com.revature.oop;

/*
    Any shared methods you want multiple classes to have access to can have those methods defined in an interface. A
    common pattern for this is to declare the methods in the interface, and then have the implementing classes actually
    implement those methods. The benefit of this is you can create a "contract" via the interface that tells you what
    behaviors your classes should have, and then your Intellisense and compiler will force you to actually implement
    those behaviors
 */
public interface InheritanceInterface {

    /*
        Note the syntax: I only put a return type, method name, and parameters. By default, an interface method
        is public and abstract. This means the method can be used anywhere, which is necessary for inheritance purposes, but
        it is also "abstract", meaning the implementation MUST be provided by any class that implements this interface
     */
    String shareMessage(String message);

}
